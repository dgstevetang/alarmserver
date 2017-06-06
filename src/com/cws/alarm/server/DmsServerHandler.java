package com.cws.alarm.server;

/**
 * **************************************************************************
 *
 * @说明:
 * @项目名称:
 * @author: tangweibin
 * @创建时间: 2017/6/2.
 * <p>
 * **************************************************************************
 */

import com.cws.alarm.common.bean.*;
import com.cws.alarm.common.interf.ResultCallback;
import com.cws.alarm.common.uitls.CodeUtil;
import com.cws.alarm.common.uitls.DataAnalysisUitl;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.apache.log4j.Logger;

import static com.cws.alarm.common.uitls.DataAnalysisUitl.analysis;
import static com.cws.alarm.common.uitls.ResponsePacketUtil.SendResponePacketPareseError;
import static com.cws.alarm.common.uitls.ResponsePacketUtil.SendResponePacketSuccess;
import static com.cws.alarm.server.PacketHandler.*;

/**
 * **************************************************************************
 *
 * @说明:
 * @项目名称:
 * @author: tangweibin
 * @创建时间: 2017/6/1.
 * <p>
 * **************************************************************************
 */
public class DmsServerHandler  extends SimpleChannelInboundHandler<ByteBuf> {
    private static final Logger log = Logger.getLogger(DmsServerHandler.class);
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf byteBuf) throws Exception {
        //String datastr = ByteBufUtil.hexDump(byteBuf.readBytes(byteBuf.readableBytes()));
        byte[] data =ByteBufUtil.getBytes(byteBuf);
        byte[] deviceId = CodeUtil.subBytes(data,1,16);                            //第2个byte开始取16个byte就是设备的ID

        String deviceSn = com.cws.alarm.common.uitls.StringUtil.trimnull(CodeUtil.ascii2String(deviceId));
        byte protocolVersion = data[17];                                           //第17个byte就是协议的版本号
        byte key = data[18];                                                       //第18个byte就是命令
        byte[] content = CodeUtil.subBytes(data,19,(data.length-(19+3)));          //从第19个到倒数第3个就是数据的内容了(数据长度+数据内容)
        int content_length = CodeUtil.byteToshort(CodeUtil.subBytes(content, 0, 2));//数据长度
        byte[] content_data = CodeUtil.subBytes(content, 2, content.length-2);     //数据内容
        byte[] parityCheckCodes = CodeUtil.subBytes(data,data.length-4,2);         //倒数第二三个byte就是CRC校验码
        analysis(data, new ResultCallback() {
        //analysis(data, new ResultCallback() {
            @Override
            public void onFailure(int errorCode, Exception e) {
                log.error("解析发生错误:"+errorCode);
                SendResponePacketPareseError(deviceId, ctx);
            }

            @Override
            public void onResponse(byte key, Object response) {
                switch (key){
                    case DataAnalysisUitl.ADASTCPkey.RESPONSEPACKET:
                        //收到应答包
                        ResponsePacketData responsePacketData = new ResponsePacketData();
                        log.error("收到应答包:"+responsePacketData.getResult());

                        break;

                    case DataAnalysisUitl.ADASTCPkey.OBDVALUE_PERIODICALLY:
                        //周期性上传的OBD数据
                        OBDValue obdvalue = (OBDValue)response;
                        saveOBDValue(deviceSn,obdvalue);
                        log.error("收到OBD周期性上传的数据");
                        SendResponePacketSuccess(deviceId, ctx);
                        break;

                    case DataAnalysisUitl.ADASTCPkey.TRIP_THIS:
                        //OBD上传本次行程数据
                        TripData tripdata = (TripData)response;
                        saveTripData(deviceSn,tripdata);
                        SendResponePacketSuccess(deviceId, ctx);

                        log.error("收到OBD上传本次行程数据");
                        break;
                    case DataAnalysisUitl.ADASTCPkey.EMERGENCY_THREE:
                        //三急事件
                        EmergencyData emergencydata = (EmergencyData)response;
                        saveEmergencyData(deviceSn,emergencydata);
                        log.error("收到三急事件的数据");
                        SendResponePacketSuccess(deviceId, ctx);

                        break;
                    case DataAnalysisUitl.ADASTCPkey.COLLISION:
                        //碰撞事件
                        CollisionData collisionData = (CollisionData)response;
                        log.error("收到碰撞事件的数据");
                        SendResponePacketSuccess(deviceId, ctx);

                        break;
                    case DataAnalysisUitl.ADASTCPkey.ADASALARMEVENT:
                        //ADAS报警
                        ADASAlarmData adasAlarmData = (ADASAlarmData)response;
                        log.error("收到ADAS报警的数据");
                        SendResponePacketSuccess(deviceId, ctx);
                        break;
                    case DataAnalysisUitl.ADASTCPkey.REQUSET_CONFIG:
                        //设备请求周期配置表
                        RequsetConfigData requsetConfigData = (RequsetConfigData)response;
                        log.error("收到请求配置信息的请求");

                        break;
                }
            }
        });



    }



}

