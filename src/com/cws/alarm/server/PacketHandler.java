package com.cws.alarm.server;

import com.cws.alarm.common.bean.*;
import com.cws.alarm.model.*;
import com.jfinal.plugin.activerecord.Db;
import com.xiaoleilu.hutool.date.DateUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * **************************************************************************
 *
 * @说明:处理数据包
 * @项目名称:
 * @author: tangweibin
 * @创建时间: 2017/6/2.
 * <p>
 * **************************************************************************
 */
public class PacketHandler {

    public static void saveADASAlarmData(String deviceSn, ADASAlarmData adasAlarmData) {
        AdasAlarm adasAlarm = new AdasAlarm();
        adasAlarm.setDeviceSn(deviceSn);
        adasAlarm.setEventid(UUID.randomUUID().toString());
        adasAlarm.setOccurtime(adasAlarmData.getM_Date());
        adasAlarm.setFCWEvent(adasAlarmData.getM_FCWEvent());
        adasAlarm.setHMWTime(adasAlarmData.getM_HMWTime());
        adasAlarm.setLLDistance(adasAlarmData.getM_LLDistance());
        adasAlarm.setPDistance(adasAlarmData.getM_PDistance());
        adasAlarm.setPDWEvent(adasAlarmData.getM_PDistance());
        adasAlarm.setRLDistance(adasAlarmData.getM_RLDistance());
        adasAlarm.setVDistance(adasAlarmData.getM_VDistance());
        adasAlarm.save();

    }

    /**
     * 保存碰撞数据
     * @param deviceSn
     * @param collisionData
     */
    public static void saveCollisionData(String deviceSn, CollisionData collisionData) {
        AdasCollide adasCollide = new AdasCollide();
        adasCollide.setDeviceSn(deviceSn);
        adasCollide.setEventid(UUID.randomUUID().toString());
        adasCollide.setEventtime(collisionData.getEventTime());
        adasCollide.setOccurdate(collisionData.getM_Date());
        adasCollide.setSenserCount(collisionData.getSenserCount());
        adasCollide.setGPSDataCount(collisionData.getGPSDataCount());
        adasCollide.save();
        long id = adasCollide.getId();
        GpsData[] gpsDatas = collisionData.getGPSDatas();
        for (int i = 0; i < gpsDatas.length; i++) {
            GpsData gpsData = gpsDatas[i];
            AdasCollideGps adasCollideGps = new AdasCollideGps();
            adasCollideGps.setDeviceSn(deviceSn);
            Long m_time = Long.valueOf(gpsData.getM_Time()) * 1000;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String d = format.format(m_time);
            Date date = null;
            try {
                date = format.parse(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            adasCollideGps.setEventid(id);
            adasCollideGps.setOccurtime(date);
            adasCollideGps.setLatitude(BigDecimal.valueOf(gpsData.getM_Latitude()));
            adasCollideGps.setLongitude(BigDecimal.valueOf(gpsData.getM_Longitude()));
            adasCollideGps.setAltitude(BigDecimal.valueOf(gpsData.getM_Altitude()));
            adasCollideGps.setDirect(gpsData.getM_Direct());
            adasCollideGps.setSpeed(gpsData.getM_Speed());
            adasCollideGps.setStatus(gpsData.getM_Status());
            adasCollideGps.setStarNum(gpsData.getM_StarNum());
            adasCollideGps.setStarInViewNum(gpsData.getM_StarInViewNum());
            adasCollideGps.save();
        }
        SenserData[] senserDatas = collisionData.getSenserDatas();
        for (int i = 0; i < senserDatas.length; i++) {
            SenserData senserData = senserDatas[i];
            AdasCollideSenser adasCollideSenser = new AdasCollideSenser();
            adasCollideSenser.setEventid(id);
            adasCollideSenser.setOccurtime(new Date());
            adasCollideSenser.setDeviceSn(deviceSn);
            adasCollideSenser.setAccelerationX(senserData.getmAccelerationX());
            adasCollideSenser.setAccelerationY(senserData.getmAccelerationY());
            adasCollideSenser.setAccelerationZ(senserData.getmAccelerationZ());
            adasCollideSenser.setGyroscopeX((long)senserData.getmGyroscopeX());
            adasCollideSenser.setGyroscopeY((long) senserData.getmGyroscopeY());
            adasCollideSenser.setGyroscopeZ((long) senserData.getmGyroscopeZ());
            adasCollideSenser.save();
        }

    }

    public static void saveEmergencyData(String deviceSn, EmergencyData emergencyData) {
        AdasEmergency adasEmergency = new AdasEmergency();
        adasEmergency.setDeviceSn(deviceSn);
        adasEmergency.setEventtime(emergencyData.getEventTime());
        adasEmergency.setEventtype(emergencyData.getEventType());
        adasEmergency.setGPSDataCount(emergencyData.getGPSDataCount());
        adasEmergency.setSenserCount(emergencyData.getSenserCount());
        adasEmergency.save();
        Long id = adasEmergency.getId();
        GpsData[] gpsDatas = emergencyData.getGPSData();
        for (int i = 0; i < gpsDatas.length; i++) {
            GpsData gpsData = gpsDatas[i];
            AdasEmergencyGps adasEmergencyGps = new AdasEmergencyGps();
            adasEmergencyGps.setDeviceSn(deviceSn);
            Long m_time = Long.valueOf(gpsData.getM_Time()) * 1000;
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String d = format.format(m_time);
            Date date = null;
            try {
                date = format.parse(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            adasEmergencyGps.setEventid(id);
            adasEmergencyGps.setOccurtime(date);
            adasEmergencyGps.setLatitude(BigDecimal.valueOf(gpsData.getM_Latitude()));
            adasEmergencyGps.setLongitude(BigDecimal.valueOf(gpsData.getM_Longitude()));
            adasEmergencyGps.setAltitude(BigDecimal.valueOf(gpsData.getM_Altitude()));
            adasEmergencyGps.setDirect(gpsData.getM_Direct());
            adasEmergencyGps.setSpeed(gpsData.getM_Speed());
            adasEmergencyGps.setStatus(gpsData.getM_Status());
            adasEmergencyGps.setStarNum(gpsData.getM_StarNum());
            adasEmergencyGps.setStarInViewNum(gpsData.getM_StarInViewNum());
            adasEmergencyGps.save();
        }
        SenserData[] senserDatas = emergencyData.getSenserData();
        for (int i = 0; i < senserDatas.length; i++) {
            SenserData senserData = senserDatas[i];
            AdasEmergencySenser adasEmergencySenser = new AdasEmergencySenser();
            adasEmergencySenser.setEventid(id);
            adasEmergencySenser.setOccurtime(new Date());
            adasEmergencySenser.setDeviceSn(deviceSn);
            adasEmergencySenser.setAccelerationX(senserData.getmAccelerationX());
            adasEmergencySenser.setAccelerationY(senserData.getmAccelerationY());
            adasEmergencySenser.setAccelerationZ(senserData.getmAccelerationZ());
            adasEmergencySenser.setGyroscopeX((long)senserData.getmGyroscopeX());
            adasEmergencySenser.setGyroscopeY((long) senserData.getmGyroscopeY());
            adasEmergencySenser.setGyroscopeZ((long) senserData.getmGyroscopeZ());
            adasEmergencySenser.save();
        }
    }

    /**
     * 保存行程数据
     * @param deviceSn
     * @param tripdata
     */
    public static void saveTripData(String deviceSn, TripData tripdata) {
        AdasTrips adasTrips = new AdasTrips();
        adasTrips.setDeviceSn(deviceSn);
        String uuid = UUID.randomUUID().toString();
        adasTrips.setTripId(uuid);
        adasTrips.setAverageSpeed(tripdata.getAverageSpeed());
        adasTrips.setHighestSpeed(tripdata.getCurMaxSpeed());
        adasTrips.setHighestRate(tripdata.getCurMaxRate());
        adasTrips.setLatitudeBegin(BigDecimal.valueOf(tripdata.getPoint_trip_lat_begin()));
        adasTrips.setLatitudeEnd(BigDecimal.valueOf(tripdata.getPoint_trip_latitude_end()));
        adasTrips.setLongtitueBegin(BigDecimal.valueOf(tripdata.getPoint_trip_lon_begin()));
        adasTrips.setLongtitueEnd(BigDecimal.valueOf(tripdata.getPoint_trip_lon_end()));
        adasTrips.setMileage(tripdata.getCurODO());
        adasTrips.setSuddenAccelerationCount(tripdata.getSuddenAccelerationCount());
        adasTrips.setSuddenBrakeCount(tripdata.getSuddenBrakeCount());
        adasTrips.setSuddenTurningCount(tripdata.getSudden_turning_count());

        adasTrips.setTimeTripBegin(DateUtil.parse(tripdata.getTimeTripBegin(),"yyyy-MM-dd HH:mm:ss"));
        adasTrips.setTimeTripEnd(DateUtil.parse(tripdata.getTimeTripEnd(),"yyyy-MM-dd HH:mm:ss"));
        adasTrips.setTotalFuelEconomy(BigDecimal.valueOf(tripdata.getAverage_fuel_economy()));
        adasTrips.setTotalFuel(BigDecimal.valueOf(tripdata.getTotal_fuel()));
        adasTrips.setIdleTime(tripdata.getCurIdleTime());
        adasTrips.setDriveTime(tripdata.getCurDriveTime());
        adasTrips.save();



    }

    public static void saveOBDValue(String deviceSn, OBDValue obdValue) {
        AdasCycledata adasCycledata = new AdasCycledata();
        adasCycledata.setDeviceSn(deviceSn);
        adasCycledata.setRate1(obdValue.getRate1());
        adasCycledata.setRate2(obdValue.getRate2());
        adasCycledata.setRate3(obdValue.getRate3());
        adasCycledata.setRate4(obdValue.getRate4());
        adasCycledata.setSpeed1(obdValue.getSpeed1());
        adasCycledata.setSpeed2(obdValue.getSpeed2());
        adasCycledata.setSpeed3(obdValue.getSpeed3());
        adasCycledata.setSpeed4(obdValue.getSpeed4());
        adasCycledata.setLpk1(BigDecimal.valueOf(obdValue.getLPK1()));
        adasCycledata.setLpk2(BigDecimal.valueOf(obdValue.getLPK2()));
        adasCycledata.setLpk3(BigDecimal.valueOf(obdValue.getLPK3()));
        adasCycledata.setLpk4(BigDecimal.valueOf(obdValue.getLPK4()));
        adasCycledata.setTemperater(obdValue.getTemperater());
        adasCycledata.setTotalODO(obdValue.getTotalODO());
        adasCycledata.setLeftOil(obdValue.getLeftOil());
        int[] errorCodes = obdValue.getErrorCodes();
        String errorCodesStr = "";
        for (int i = 0; i < errorCodes.length; i++) {
            int errorCode = errorCodes[i];
            errorCodesStr = errorCodesStr +',' + errorCode;
        }

        adasCycledata.setErrorCodes(errorCodesStr.substring(1));
        adasCycledata.setErrorCount(obdValue.getErrorCount());
        adasCycledata.setGPSDataCount(obdValue.getGPSDataCount());
        adasCycledata.setValtage(BigDecimal.valueOf(obdValue.getValtage()));
        //保存传感器数据
        adasCycledata.setSenserDataCount(obdValue.getSenserDataCount());
        adasCycledata.setOccurtime(obdValue.getM_Date());
        //adasCycledata.setOccurtime(DateUtil.parse(obdValue.getM_Date(),"yyyy-MM-dd HH:mm:ss"));
        adasCycledata.save();
        Long id = adasCycledata.getId();

        //adasCycledata.setGPSDatas(str1);
        //保存GPS数据
        GpsData[] gpsDatas = obdValue.getGPSDatas();
        for (int i = 0; i < gpsDatas.length; i++) {
            GpsData gpsData = gpsDatas[i];
            AdasGpsdata adasGpsdata = new AdasGpsdata();
            adasGpsdata.setDeviceSn(deviceSn);
            Long m_time = Long.valueOf(gpsData.getM_Time())*1000;
            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String d = format.format(m_time);
            Date date= null;
            try {
                date = format.parse(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            adasGpsdata.setEventid(id);
            adasGpsdata.setOccurtime(date);
            adasGpsdata.setLatitude(BigDecimal.valueOf(gpsData.getM_Latitude()));
            adasGpsdata.setLongitude(BigDecimal.valueOf(gpsData.getM_Longitude()));
            adasGpsdata.setAltitude(BigDecimal.valueOf(gpsData.getM_Altitude()));
            adasGpsdata.setDirect(gpsData.getM_Direct());
            adasGpsdata.setSpeed(gpsData.getM_Speed());
            adasGpsdata.setStatus(gpsData.getM_Status());
            adasGpsdata.setStarNum(gpsData.getM_StarNum());
            adasGpsdata.setStarInViewNum(gpsData.getM_StarInViewNum());
            adasGpsdata.save();
        }


        SenserData[] senserDatas = obdValue.getSenserDatas();
        for (int i = 0; i < senserDatas.length; i++) {
            SenserData senserData = senserDatas[i];
            AdasSenserdata adasSenserdata = new AdasSenserdata();
            adasSenserdata.setEventid(id);
            adasSenserdata.setOccurtime(new Date());
            adasSenserdata.setDeviceSn(deviceSn);
            adasSenserdata.setAccelerationX(senserData.getmAccelerationX());
            adasSenserdata.setAccelerationY(senserData.getmAccelerationY());
            adasSenserdata.setAccelerationZ(senserData.getmAccelerationZ());
            adasSenserdata.setGyroscopeX((long)senserData.getmGyroscopeX());
            adasSenserdata.setGyroscopeY((long) senserData.getmGyroscopeY());
            adasSenserdata.setGyroscopeZ((long) senserData.getmGyroscopeZ());
            adasSenserdata.save();
        }
    }
    public static boolean saveOBDData(String deviceSn,OBDValue obdValue) {

        //保存GPS数据
        GpsData[] gpsDatas = obdValue.getGPSDatas();
        for (int i = 0; i < gpsDatas.length; i++) {
            GpsData gpsData = gpsDatas[i];
            Long m_time = Long.valueOf(gpsData.getM_Time())*1000;
            SimpleDateFormat format =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String d = format.format(m_time);
            Date date= null;
            try {
                date = format.parse(d);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Db.update("INSERT into adas_gpsdata(deviceSn,occurtime,latitude,longitude,altitude,speed) values(?,?,?,?,?,?)",
                    deviceSn,
                    date,
                    BigDecimal.valueOf(gpsData.getM_Latitude()),
                    BigDecimal.valueOf(gpsData.getM_Longitude()),
                    BigDecimal.valueOf(gpsData.getM_Latitude()),
                    gpsData.getM_Speed());
        }
        return true;
    }
}
