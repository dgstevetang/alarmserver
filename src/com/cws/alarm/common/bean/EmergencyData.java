package com.cws.alarm.common.bean;

import java.util.Date;

/**
 * 三急事件
 * Created by 601042 on 2017/6/1.
 */
public class EmergencyData {
    Date m_Date;            //时间日期
    int EventType;            //事件类型  (0:急加速    1:急减速    2:急转弯)
    int EventTime;            //事件持续时间       单位：秒
    int GPSDataCount;         //GPS数据记录数
    GpsData[] GPSData;        //GPS数据
    int SenserCount;          //传感器数据记录数
    com.cws.alarm.common.bean.SenserData[] SenserData;  //传感器数据

    public Date getM_Date() {
        return m_Date;
    }

    public void setM_Date(Date m_Date) {
        this.m_Date = m_Date;
    }

    public int getEventType() {
        return EventType;
    }

    public void setEventType(int eventType) {
        EventType = eventType;
    }

    public int getEventTime() {
        return EventTime;
    }

    public void setEventTime(int eventTime) {
        EventTime = eventTime;
    }

    public int getGPSDataCount() {
        return GPSDataCount;
    }

    public void setGPSDataCount(int GPSDataCount) {
        this.GPSDataCount = GPSDataCount;
    }

    public GpsData[] getGPSData() {
        return GPSData;
    }

    public void setGPSData(GpsData[] GPSData) {
        this.GPSData = GPSData;
    }

    public int getSenserCount() {
        return SenserCount;
    }

    public void setSenserCount(int senserCount) {
        SenserCount = senserCount;
    }

    public com.cws.alarm.common.bean.SenserData[] getSenserData() {
        return SenserData;
    }

    public void setSenserData(com.cws.alarm.common.bean.SenserData[] senserData) {
        SenserData = senserData;
    }
}
