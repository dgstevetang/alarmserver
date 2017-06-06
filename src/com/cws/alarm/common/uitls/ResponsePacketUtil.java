package com.cws.alarm.common.uitls;

import com.cws.alarm.common.bean.ResponsePacketData;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;

import static com.cws.alarm.common.uitls.DataAnalysisUitl.responsePacket;

/**
 * **************************************************************************
 *
 * @说明:
 * @项目名称:
 * @author: tangweibin
 * @创建时间: 2017/6/6.
 * <p>
 * **************************************************************************
 */
public class ResponsePacketUtil {
    public static void SendResponePacketSuccess(byte[] deviceId, ChannelHandlerContext ctx) {

        byte[] resbytes = responsePacket(deviceId, new byte[]{(byte) 0xa0});
        ByteBuf buf = ctx.alloc().buffer(resbytes.length);
        buf.writeBytes(resbytes);
        ctx.writeAndFlush(buf);
    }

    public static void SendResponePacketCrcError(byte[] deviceId, ChannelHandlerContext ctx) {

        byte[] resbytes = responsePacket(deviceId, new byte[]{ResponsePacketData.PARITYCHECKCODESERROR});
        ByteBuf buf = ctx.alloc().buffer(resbytes.length);
        buf.writeBytes(resbytes);
        ctx.writeAndFlush(buf);
    }

    public static void SendResponePacketLengthError(byte[] deviceId, ChannelHandlerContext ctx) {

        byte[] resbytes = responsePacket(deviceId, new byte[]{ResponsePacketData.LENGTHERROR});
        ByteBuf buf = ctx.alloc().buffer(resbytes.length);
        buf.writeBytes(resbytes);
        ctx.writeAndFlush(buf);
    }

    public static void SendResponePacketPareseError(byte[] deviceId, ChannelHandlerContext ctx) {

        byte[] resbytes = responsePacket(deviceId, new byte[]{ResponsePacketData.HASEXCEPTION});
        ByteBuf buf = ctx.alloc().buffer(resbytes.length);
        buf.writeBytes(resbytes);
        ctx.writeAndFlush(buf);
    }


}
