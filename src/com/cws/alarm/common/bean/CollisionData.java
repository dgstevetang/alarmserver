package com.cws.alarm.common.bean;

import java.util.Date;

/**
 * 碰撞事件
 * Created by 601042 on 2017/6/2.
 */
public class CollisionData {
    Date m_Date;                //时间日期
    int EventTime;                //事件持续时间      秒
    int GPSDataCount;             //GPS数据记录数
    GpsData[] GPSDatas;           //GPS数据
    int SenserCount;              //传感器数据记录数
    SenserData[] SenserDatas;     //传感器数据

    public Date getM_Date() {
        return m_Date;
    }

    public void setM_Date(Date m_Date) {
        this.m_Date = m_Date;
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

    public GpsData[] getGPSDatas() {
        return GPSDatas;
    }

    public void setGPSDatas(GpsData[] GPSDatas) {
        this.GPSDatas = GPSDatas;
    }

    public int getSenserCount() {
        return SenserCount;
    }

    public void setSenserCount(int senserCount) {
        SenserCount = senserCount;
    }

    public SenserData[] getSenserDatas() {
        return SenserDatas;
    }

    public void setSenserDatas(SenserData[] senserDatas) {
        SenserDatas = senserDatas;
    }
}
