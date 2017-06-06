package com.cws.alarm.common.uitls;

import com.cws.alarm.common.bean.*;
import com.cws.alarm.common.interf.ResultCallback;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 数据装换工具类
 * Created by 601042 on 2017/5/31.
 */
public class DataAnalysisUitl {

    private static final byte VERSION_CWS = 0x01;


    public static void test(){
        //TODO 测试方法 例子

        //周期性上次的OBD数据
//        String data = "5E 41 31 32 33 34 35 00 00 00 00 00 00 00 00 00 00 01 A0 00 63 11 05 13 0D 0F 14 04 EC 03 E8 03 E9 03 EA 03 EB 64 65 66 67 64 03 E8 04 4C 04 B0 05 14 00 00 07 D0 32 02 00 02 00 03 01 53 79 93 68 01 61 19 ad 06 c1 41 0b 06 c1 81 a0 01 00 0D 3C 05 09  02 00 10 00 51 FC 1F 00 00 00 3F 00 00 00 04 00 00 ff E9 FC 18 00 08 00 35 00 00 00 54 00 00 00 25 00 00 FF C2 56 6A 5E ".replace(" ","");
        //应答包
//        String data = "5E 41 31 32 33 34 35 00 00 00 00 00 00 00 00 00 00 01 21 00 01 A0 E7 67 5E".replace(" ","");
        //上传本次行程信息
//        String data ="5E 41 31 32 33 34 35 00 00 00 00 00 00 00 00 00 00 01 A1 00 33 11 05 13 0D 0F 14 11 05 14 0D 0F 14 00 00 00 16 00 00 03 E8 00 00 03 20 03 E9 65 64 01 DA E8 00 07 3C E9 F3 01 DC 8D 02 07 3C E9 F4 05 02 03 03 F4 03 F5 0D 49 5E".replace(" ","");
        //三急事件
        String data = "5E 41 31 32 33 34 35 00 00 00 00 00 00 00 00 00 00 01 A2 00 44 11 05 13 0D 0F 14 01 02 01 53 79 93 68 01 61 19 ad 06 c1 41 0b 06 c1 81 a0 01 00 0D 3C 05 09  02 00 10 00 51 FC 1F 00 00 00 3F 00 00 00 04 00 00 ff E9 FC 18 00 08 00 35 00 00 00 54 00 00 00 25 00 00 FF C2 C8 66 5E".replace(" ","");
        //碰撞事件
//        String data = "5E 41 31 32 33 34 35 00 00 00 00 00 00 00 00 00 00 01 B0 00 43 11 05 13 0D 0F 14 02 01 53 79 93 68 01 61 19 ad 06 c1 41 0b 06 c1 81 a0 01 00 0D 3C 05 09  02 00 10 00 51 FC 1F 00 00 00 3F 00 00 00 04 00 00 ff E9 FC 18 00 08 00 35 00 00 00 54 00 00 00 25 00 00 FF C2 E3 0C 5E".replace(" ","");
        //ADAS报警事件
//        String data = "5E 41 31 32 33 34 35 00 00 00 00 00 00 00 00 00 00 01 B1 00 12 11 05 13 0D 0F 14 0E 0A 00 64 00 03 e8 04 4C 0E 00 64 81 AF 5E".replace(" ","");
        //请求周期配置
//        String data = "5E 41 31 32 33 34 35 00 00 00 00 00 00 00 00 00 00 01 A3 00 00 C1 9D 5E".replace(" ","");




        analysis( CodeUtil.stringToByte(data), new ResultCallback() {
            @Override
            public void onFailure(int errorCode, Exception e) {
                System.out.println("解析发生错误:"+errorCode);

            }

            @Override
            public void onResponse(byte key, Object response) {
                switch (key){
                    case ADASTCPkey.RESPONSEPACKET:
                        //收到应答包
                        ResponsePacketData responsePacketData = new ResponsePacketData();
                        System.out.println("收到应答包:"+responsePacketData.getResult());
                        break;

                    case ADASTCPkey.OBDVALUE_PERIODICALLY:
                        //周期性上传的OBD数据
                        OBDValue obdvalue = (OBDValue)response;
                        System.out.println("收到OBD周期性上传的数据");
                        break;

                    case ADASTCPkey.TRIP_THIS:
                        //OBD上传本次行程数据
                        TripData tripdata = (TripData)response;
                        System.out.println("收到OBD上传本次行程数据");
                        break;
                    case ADASTCPkey.EMERGENCY_THREE:
                        //三急事件
                        EmergencyData emergencydata = (EmergencyData)response;
                        System.out.println("收到三急事件的数据");

                        break;
                    case ADASTCPkey.COLLISION:
                        //碰撞事件
                        CollisionData collisionData = (CollisionData)response;
                        System.out.println("收到碰撞事件的数据");
                        break;
                    case ADASTCPkey.ADASALARMEVENT:
                        //ADAS报警
                        ADASAlarmData adasAlarmData = (ADASAlarmData)response;
                        System.out.println("收到ADAS报警的数据");
                        break;
                    case ADASTCPkey.REQUSET_CONFIG:
                        //设备请求周期配置表
                        RequsetConfigData requsetConfigData = (RequsetConfigData)response;
                        System.out.println("收到请求配置信息的请求");

                        break;
                }
            }
        });
    }

    public static  void analysis(byte[] data,ResultCallback callback){
        //TODO 开始数据解析
        if(verifyDataValidity(data,callback)){
            byte protocolVersion = data[17];                                           //第17个byte就是协议的版本号
            switch (protocolVersion){
                case VERSION_CWS:
                    //车卫士版本的协议
                    parseDataByCWS(data, callback);
                    break;
            }
        }
    }

    private static void parseDataByCWS(byte[] data,ResultCallback callback){
        //TODO 解析车卫士版本协议

        byte[] deviceId = CodeUtil.subBytes(data,1,16);                            //第2个byte开始取16个byte就是设备的ID
        byte protocolVersion = data[17];                                           //第17个byte就是协议的版本号
        byte key = data[18];                                                       //第18个byte就是命令
        byte[] content = CodeUtil.subBytes(data,19,(data.length-(19+3)));          //从第19个到倒数第3个就是数据的内容了(数据长度+数据内容)
        int content_length = CodeUtil.byteToshort(CodeUtil.subBytes(content, 0, 2));//数据长度
        byte[] content_data = CodeUtil.subBytes(content, 2, content.length-2);     //数据内容
        byte[] parityCheckCodes = CodeUtil.subBytes(data,data.length-4,2);         //倒数第二三个byte就是CRC校验码

        //根据命令来进行对应的解析
        switch (key){
            case ADASTCPkey.RESPONSEPACKET:
                //收到应答包
                parseResponsePacket(content_data,content_length,callback);
                break;

            case ADASTCPkey.OBDVALUE_PERIODICALLY:
                //周期性上次的OBD数据
                if(content_length > 0){
                    obdvalue(content_data,callback);
                }
                break;

            case ADASTCPkey.TRIP_THIS:
                //OBD上传本次行程数据
                if(content_length > 0){
                    thisTrip(content_data,callback);
                }
                break;
            case ADASTCPkey.EMERGENCY_THREE:
                //三急事件
                if(content_length > 0){
                    emergency(content_data,callback);
                }
                break;
            case ADASTCPkey.COLLISION:
                //碰撞事件
                if(content_length > 0){
                    collision(content_data,callback);
                }
                break;
            case ADASTCPkey.ADASALARMEVENT:
                //ADAS报警
                if(content_length > 0){
                    adasAlarm(content_data,callback);
                }
                break;
            case ADASTCPkey.REQUSET_CONFIG:
                //设备请求周期配置表
                parseRequsetConfig(content_data,callback);
                break;
        }
    }

    private static void parseRequsetConfig(byte[] content_data, ResultCallback callback){
        RequsetConfigData requsetConfigdata = new RequsetConfigData();
        if(callback != null){
            callback.onResponse(ADASTCPkey.REQUSET_CONFIG,requsetConfigdata);
        }
    }
    private static void parseResponsePacket(byte[] content_data,int content_length, ResultCallback callback) {
        byte responseResult = content_data[0];
        byte responseDatalength = (byte) 0xff;
        byte[] dataconntent = null;
        if(content_length > 1){
            responseDatalength = content_data[1];
            dataconntent = CodeUtil.subBytes(content_data,2,responseDatalength);
        }
        ResponsePacketData responsePacketData = new ResponsePacketData();
        if(callback != null){
            callback.onResponse(ADASTCPkey.RESPONSEPACKET,responsePacketData);
        }
//        switch (responseResult){
//            case 0x01:
//                Log.e(TAG,"数据长度错");
//                break;
//            case 0x02:
//                Log.e(TAG,"校验错");
//                break;
//            case (byte) 0xa0:
//                Log.e(TAG,"成功并退出");
//                break;
//        }
    }

    public static byte[] responsePacket(byte[] deviceId,byte[] content){
        //TODO 打包应答包

        //校验设备ID的长度是否正确
        if(deviceId.length != 16){
            return null;
        }
        //校验内容长度是否合法
        if(content == null || content.length < 1){
            return null;
        }
        ArrayList<Byte> data = new ArrayList<>();
        //包头
        data.add((byte) 0x5e);
        //设备ID
        for(byte b :deviceId){
            data.add(b);
        }
        //协议版本号
        data.add((byte) 0x01);
        //命令
        data.add(ADASTCPkey.RESPONSEPACKET);
        //数据长度
        for(byte b :CodeUtil.intToBb(content.length)){
            data.add(b);
        }
        //数据内容
        for(byte b :content){
            data.add(b);
        }
        //CRC校验码
        List<Byte> temp = data.subList(1,data.size());
        byte[] temp_srcbyte = new byte[temp.size()];
        for(int i = 0;i < temp.size(); i ++ ){
            temp_srcbyte[i] = temp.get(i);
        }
        byte[] crscpde = CodeUtil.generateCrc16(temp_srcbyte);
        for(byte b : crscpde){
            data.add(b);
        }
        //包尾
        data.add((byte) 0x5e);
        //转成数组
        byte[] responseDta = new byte[data.size()];
        for(int i = 0;i < data.size(); i ++ ){
            responseDta[i] = data.get(i);
        }
        return responseDta;
    }


    public static void adasAlarm(byte[] content_data,ResultCallback callback){
        //TODO 解析ADAS报警包

        try {
            ADASAlarmData adasAlarmData = new ADASAlarmData();
            String m_Date = "20"+content_data[0]+"-"+content_data[1]+"-"+content_data[2]+" "+content_data[3]+":"+content_data[4]+":"+content_data[5];
            adasAlarmData.setM_Date(parseDate(m_Date));

            byte m_FCWEvent = content_data[6];
            adasAlarmData.setM_FCWEvent(m_FCWEvent);

            byte m_HMWTime = content_data[7];
            adasAlarmData.setM_HMWTime((m_HMWTime==0xff)?-1:(m_HMWTime/10));

            int m_VDistance = CodeUtil.byteToshort(CodeUtil.subBytes(content_data, 8, 2));
            adasAlarmData.setM_VDistance(m_VDistance/10);

            byte m_LDWEvent = content_data[10];
            adasAlarmData.setM_LDWEvent(m_LDWEvent);

            int m_LLDistance = CodeUtil.byteToshort(CodeUtil.subBytes(content_data, 11, 2));
            adasAlarmData.setM_LLDistance(m_LLDistance);

            int m_RLDistance = CodeUtil.byteToshort(CodeUtil.subBytes(content_data, 13, 2));
            adasAlarmData.setM_RLDistance(m_RLDistance);

            byte m_PDWEvent = content_data[15];
            adasAlarmData.setM_PDWEvent(m_PDWEvent);

            int m_PDistance =  CodeUtil.byteToshort(CodeUtil.subBytes(content_data,16,2));
            adasAlarmData.setM_PDistance(m_PDistance);

            if(callback != null){
                callback .onResponse(ADASTCPkey.ADASALARMEVENT, adasAlarmData);
            }
        }catch (Exception e){
            e.printStackTrace();
            if(callback != null){
                callback .onFailure(ADASTCPkey.ADASALARMEVENT,e);
            }
        }

    }
    public static void collision(byte[] content_data,ResultCallback callback){
        //TODO 解析碰撞数据包

        try{
            CollisionData collisionData = new CollisionData();

//            String m_Date = content_data[0]+"年"+content_data[1]+"月"+content_data[2]+"日"+content_data[3]+"时"+content_data[4]+"分"+content_data[5]+"秒";
            String m_Date = "20"+content_data[0]+"-"+content_data[1]+"-"+content_data[2]+" "+content_data[3]+":"+content_data[4]+":"+content_data[5];
            collisionData.setM_Date(parseDate(m_Date));

            byte EventTime = content_data[6];
            collisionData.setEventTime(EventTime);

            byte GPSDataCount = content_data[7];
            collisionData.setGPSDataCount(GPSDataCount);

            if(GPSDataCount > 0){
                byte[] GPSData = CodeUtil.subBytes(content_data,8,GPSDataCount*22);
                collisionData.setGPSDatas(parseGps(GPSData));
            }

            byte SenserCount = content_data[8+(GPSDataCount*22)];
            collisionData.setSenserCount(SenserCount);

            if(SenserCount > 0){
                byte[] SenserData = CodeUtil.subBytes(content_data,9+(GPSDataCount*22),SenserCount*18);
                collisionData.setSenserDatas(parseSenserDtata(SenserData));
            }

            if(callback != null){
                callback.onResponse(ADASTCPkey.COLLISION, collisionData);
            }
        }catch (Exception e){
            e.printStackTrace();
            if(callback != null){
                callback.onFailure(ADASTCPkey.COLLISION, e);
            }
        }
    }

    private static Date parseDate(String time){
        try {
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//小写的mm表示的是分钟
            Date date=sdf.parse(time);
            return date;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }


    }

    public static void emergency(byte[] content_data,ResultCallback callback){
        //TODO 解析三急数据包

        try {
            EmergencyData emergencydata = new EmergencyData();


            String m_Date = "20"+content_data[0]+"-"+content_data[1]+"-"+content_data[2]+" "+content_data[3]+":"+content_data[4]+":"+content_data[5];
            emergencydata.setM_Date(parseDate(m_Date));


            byte EventType = content_data[6];
            emergencydata.setEventType(EventType);

            byte EventTime = content_data[7];
            emergencydata.setEventTime(EventTime);

            byte GPSDataCount = content_data[8];
            emergencydata.setGPSDataCount(GPSDataCount);

            if(GPSDataCount > 0){
                byte[] GPSData = CodeUtil.subBytes(content_data,9,GPSDataCount*22);
                emergencydata.setGPSData(parseGps(GPSData));
            }
            byte SenserCount = content_data[(GPSDataCount*22)+9];
            emergencydata.setSenserCount(SenserCount);

            if(SenserCount > 0){
                byte[] SenserData = CodeUtil.subBytes(content_data,(GPSDataCount*22)+10,SenserCount*18);
                emergencydata.setSenserData(parseSenserDtata(SenserData));
            }

            if(callback != null){
                callback.onResponse(ADASTCPkey.EMERGENCY_THREE,emergencydata);
            }
        }catch (Exception e){
            e.printStackTrace();
            if(callback != null){
                callback.onResponse(ADASTCPkey.EMERGENCY_THREE,e);
            }
        }






    }

    public static void thisTrip(byte[] content_data,ResultCallback callback){
        //TODO 解析本次行程数据包

        try{
            TripData tripdata = new TripData();

            //String timeTripBegin = content_data[0]+"年"+content_data[1]+"月"+content_data[2]+"日"+content_data[3]+"时"+content_data[4]+"分"+content_data[5]+"秒";
            String timeTripBegin = "20"+content_data[0]+"-"+content_data[1]+"-"+content_data[2]+" "+content_data[3]+":"+content_data[4]+":"+content_data[5];
            tripdata.setTimeTripBegin(timeTripBegin);

            //String timeTripEnd = content_data[6]+"年"+content_data[7]+"月"+content_data[8]+"日"+content_data[9]+"时"+content_data[10]+"分"+content_data[11]+"秒";
            String timeTripEnd = "20"+content_data[6]+"-"+content_data[7]+"-"+content_data[8]+" "+content_data[9]+":"+content_data[10]+":"+content_data[11];
            tripdata.setTimeTripEnd(timeTripEnd);

            int curIdleTime = CodeUtil.bbbbToint(CodeUtil.subBytes(content_data, 12, 4));
            tripdata.setCurIdleTime(curIdleTime);
            int curDriveTime = CodeUtil.bbbbToint(CodeUtil.subBytes(content_data, 16, 4));
            tripdata.setCurDriveTime(curDriveTime);

            int curODO = CodeUtil.bbbbToint(CodeUtil.subBytes(content_data, 20, 4));
            tripdata.setCurODO(curODO*1000);

            int curMaxRate = CodeUtil.bbToInt(CodeUtil.subBytes(content_data, 24, 2));
            tripdata.setCurMaxRate(curMaxRate);

            int curMaxSpeed = content_data[26];
            tripdata.setCurMaxSpeed(curMaxSpeed);

            int averageSpeed = content_data[27];
            tripdata.setAverageSpeed(averageSpeed);

            int point_trip_lat_begin = CodeUtil.bbbbToint(CodeUtil.subBytes(content_data, 28, 4));
            tripdata.setPoint_trip_lat_begin(point_trip_lat_begin / (double) 1000000);

            int point_trip_lon_begin = CodeUtil.bbbbToint(CodeUtil.subBytes(content_data, 32, 4));
            tripdata.setPoint_trip_lon_begin(point_trip_lon_begin / (double) 1000000);

            int point_trip_latitude_end = CodeUtil.bbbbToint(CodeUtil.subBytes(content_data, 36, 4));
            tripdata.setPoint_trip_latitude_end(point_trip_latitude_end / (double) 1000000);

            int point_trip_lon_end = CodeUtil.bbbbToint(CodeUtil.subBytes(content_data, 40, 4));
            tripdata.setPoint_trip_lon_end(point_trip_lon_end / (double) 1000000);

            int suddenAccelerationCount = content_data[44];
            tripdata.setSuddenAccelerationCount(suddenAccelerationCount);

            int suddenBrakeCount = content_data[45];
            tripdata.setSuddenBrakeCount(suddenBrakeCount);

            int sudden_turning_count = content_data[46];
            tripdata.setSudden_turning_count(sudden_turning_count);

            int total_fuel = CodeUtil.bbToInt(CodeUtil.subBytes(content_data, 47, 2));
            tripdata.setTotal_fuel(total_fuel / (float) 100);
            int average_fuel_economy = CodeUtil.bbToInt(CodeUtil.subBytes(content_data, 49, 2));
            tripdata.setAverage_fuel_economy(average_fuel_economy / (float)100);
            if(callback != null){
                callback.onResponse(ADASTCPkey.TRIP_THIS,tripdata);
            }
        }catch (Exception e){
            e.printStackTrace();
            if(callback != null){
                callback.onFailure(ADASTCPkey.TRIP_THIS, e);
            }
        }

    }
    public static void obdvalue(byte[] content_data,ResultCallback callback){
        //TODO 解析周期性上传的OBD数据

        try {
            OBDValue obdvalue = new OBDValue();

            String m_Date = "20"+content_data[0]+"-"+content_data[1]+"-"+content_data[2]+" "+content_data[3]+":"+content_data[4]+":"+content_data[5];
            obdvalue.setM_Date(parseDate(m_Date));

            int Valtage = CodeUtil.bbToInt(CodeUtil.subBytes(content_data, 6, 2));
            obdvalue.setValtage(Valtage/(float)100);

            int Rate1 = CodeUtil.bbToInt(CodeUtil.subBytes(content_data,8,2));
            obdvalue.setRate1(Rate1);

            int Rate2 = CodeUtil.bbToInt(CodeUtil.subBytes(content_data,10,2));
            obdvalue.setRate2(Rate2);

            int Rate3 = CodeUtil.bbToInt(CodeUtil.subBytes(content_data,12,2));
            obdvalue.setRate3(Rate3);

            int Rate4 = CodeUtil.bbToInt(CodeUtil.subBytes(content_data,14,2));
            obdvalue.setRate4(Rate4);

            int Speed1 = content_data[16];
            obdvalue.setSpeed1(Speed1);

            int Speed2 = content_data[17];
            obdvalue.setSpeed2(Speed2);

            int Speed3 = content_data[18];
            obdvalue.setSpeed3(Speed3);

            int Speed4 = content_data[19];
            obdvalue.setSpeed4(Speed4);

            int Temperater = content_data[20];
            obdvalue.setTemperater(Temperater);

            int LPK1 =  CodeUtil.bbToInt(CodeUtil.subBytes(content_data,21,2));
            obdvalue.setLPK1(LPK1/(float)100);

            int LPK2 =  CodeUtil.bbToInt(CodeUtil.subBytes(content_data,23,2));
            obdvalue.setLPK2(LPK2/(float)100);

            int LPK3 =  CodeUtil.bbToInt(CodeUtil.subBytes(content_data,25,2));
            obdvalue.setLPK3(LPK3/(float)100);

            int LPK4 =  CodeUtil.bbToInt(CodeUtil.subBytes(content_data, 27, 2));
            obdvalue.setLPK4(LPK4/(float)100);

            int TotalODO = CodeUtil.bbbbToint(CodeUtil.subBytes(content_data, 29, 4));
            obdvalue.setTotalODO(TotalODO);

            int LeftOil = content_data[33];
            obdvalue.setLeftOil(LeftOil);

            int ErrorCount = content_data[34];
            obdvalue.setErrorCount(ErrorCount);

            if(ErrorCount > 0){
                byte[] errorCodes = CodeUtil.subBytes(content_data, 35, ErrorCount * 2);
                int[] errorCodes_temp = new int[ErrorCount];
                for(int i = 0;i < ErrorCount; i ++){
                    errorCodes_temp[i] = CodeUtil.bbToInt(CodeUtil.subBytes(errorCodes,i*2,2));
                }
                obdvalue.setErrorCodes(errorCodes_temp);
            }

            int GPSDataCount = content_data[35+(ErrorCount * 2)];
            obdvalue.setGPSDataCount(GPSDataCount);

            if(GPSDataCount > 0){
                byte[] GPSData = CodeUtil.subBytes(content_data, (35 + (ErrorCount * 2)) + 1, GPSDataCount * 22);
                obdvalue.setGPSDatas(parseGps(GPSData));
            }

            int SenserDataCount = content_data[((35 + (ErrorCount * 2)) + 1)+(GPSDataCount * 22)];
            obdvalue.setSenserDataCount(SenserDataCount);

            if(SenserDataCount > 0){
                byte[] SenserData = CodeUtil.subBytes(content_data, (36 + (ErrorCount * 2)) + (GPSDataCount * 22)+1 , SenserDataCount * 18);
                obdvalue.setSenserDatas(parseSenserDtata(SenserData));
            }

            if(callback != null){
                callback.onResponse(ADASTCPkey.OBDVALUE_PERIODICALLY,obdvalue);
            }

        }catch (Exception e){
            e.printStackTrace();
            if(callback != null){
                callback.onFailure(ADASTCPkey.OBDVALUE_PERIODICALLY, e);
            }
        }

    }

    private static SenserData[] parseSenserDtata(byte[] SenserData) {
        //TODO 解析封装传感器数据
        SenserData[] senserdata_temp = new SenserData[SenserData.length/18];
        for(int i = 0;i < (SenserData.length/18); i ++){
            byte[] senser_temp_b = CodeUtil.subBytes(SenserData,i*18,18);
            SenserData temp = new SenserData();
            temp.setmAccelerationX(CodeUtil.byteToshort(CodeUtil.subBytes(senser_temp_b, 0, 2)));
            temp.setmAccelerationY(CodeUtil.byteToshort(CodeUtil.subBytes(senser_temp_b, 2, 2)));
            temp.setmAccelerationZ(CodeUtil.byteToshort(CodeUtil.subBytes(senser_temp_b, 4, 2)));
            temp.setmGyroscopeX(CodeUtil.bbbbToint(CodeUtil.subBytes(senser_temp_b, 6, 4)));
            temp.setmGyroscopeY(CodeUtil.bbbbToint(CodeUtil.subBytes(senser_temp_b, 10, 4)));
            temp.setmGyroscopeZ(CodeUtil.bbbbToint(CodeUtil.subBytes(senser_temp_b, 14, 4)));
            senserdata_temp[i] = temp;
        }
        return senserdata_temp;
    }


    private static GpsData[]  parseGps(byte[] GPSData) {
        //TODO 解析封装GPS数据

        GpsData[] gpsdatas_temp = new GpsData[GPSData.length/22];
        for(int i = 0;i < (GPSData.length/22); i ++){
            byte[] gps_temp_b = CodeUtil.subBytes(GPSData,i*22,22);
            GpsData temp = new GpsData();
            temp.setM_Time(CodeUtil.bbbbToint(CodeUtil.subBytes(gps_temp_b, 0, 4)));
            temp.setM_Latitude(CodeUtil.bbbbToint(CodeUtil.subBytes(gps_temp_b, 4, 4)) / (double) 1000000);
            temp.setM_Longitude(CodeUtil.bbbbToint(CodeUtil.subBytes(gps_temp_b, 8, 4)) / (double) 1000000);
            temp.setM_Altitude(CodeUtil.bbbbToint(CodeUtil.subBytes(gps_temp_b, 12, 4)) /(double)1000000);
            temp.setM_Status(gps_temp_b[16]);
            temp.setM_Direct(CodeUtil.bbToInt(CodeUtil.subBytes(gps_temp_b, 17, 2)));
            temp.setM_Speed(gps_temp_b[19]);
            temp.setM_StarNum(gps_temp_b[20]);
            temp.setM_StarInViewNum(gps_temp_b[21]);
            gpsdatas_temp[i] = temp;
        }
        return gpsdatas_temp;
    }


    public static boolean verifyDataValidity(byte[] data,ResultCallback callback){
        //TODO 验证数据包是否正确

        //先判断包头包尾是否齐全
        if(data[0] != 0x5e || data[data.length-1] != 0x5e){
            if(callback != null){
                callback.onFailure(ResponsePacketData.HEADORTAILERROR,null);
            }
            return false;
        }
        //判断数据是否正确
        byte[] content = CodeUtil.subBytes(data,19,(data.length-(19+3)));
        int content_length = CodeUtil.byteToshort(CodeUtil.subBytes(content, 0, 2));//数据长度
        byte[] content_data = CodeUtil.subBytes(content, 2, content.length-2);     //数据内容
        if(content_data.length != content_length){
            if(callback != null){
                callback.onFailure(ResponsePacketData.LENGTHERROR,null);
            }
            return false;
        }


        //判断CRC校验码是否正确
        byte[] parityCheckCodes = CodeUtil.subBytes(data,data.length-3,2);
        byte[] mcrc = CodeUtil.generateCrc16(CodeUtil.subBytes(data,1,data.length-4));
        if(CodeUtil.bbToInt(parityCheckCodes) != CodeUtil.bbToInt(mcrc)){
            if(callback != null){
                callback.onFailure(ResponsePacketData.PARITYCHECKCODESERROR,null);
            }
            return false;
        }
        return true;

    }

    public static class ADASTCPkey{
        public final static byte RESPONSEPACKET = 0x21;                                             //应答包
        public final static byte OBDVALUE_PERIODICALLY = (byte) 0xA0;                               //OBD上传周期数据
        public final static byte TRIP_THIS = (byte)0xA1;                                            //OBD上传本次行程数据
        public final static byte EMERGENCY_THREE = (byte)0xA2;                                      //三急事件
        public final static byte REQUSET_CONFIG = (byte)0xA3;                                    //获取周期配置
        public final static byte COLLISION = (byte)0xB0;                                            //碰撞事件
        public final static byte ADASALARMEVENT = (byte)0xB1;                                       //ADAS报警事件
    }

}
