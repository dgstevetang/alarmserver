package com.cws.alarm.common.bean;

/**
 * GPS数据
 * Created by 601042 on 2017/6/1.
 */
public class GpsData {
    int m_Time;			    //定位点时间  秒
    double m_Latitude; 		//纬度
    double	m_Longitude; 	//经度
    double	m_Altitude;		//海拨
    int		m_Status; 		//定位状态    0=无效，1=有效，2=有效且行程开始，3=有效且行程结束
    int 	m_Direct; 		//方向:正北=0；单位：度。顺时针方向
    int		m_Speed; 		//车速 60km/h
    int		m_StarNum; 		//使用卫星数
    int		m_StarInViewNum;//可视卫星数

    public int getM_Time() {
        return m_Time;
    }

    public void setM_Time(int m_Time) {
        this.m_Time = m_Time;
    }

    public double getM_Latitude() {
        return m_Latitude;
    }

    public void setM_Latitude(double m_Latitude) {
        this.m_Latitude = m_Latitude;
    }

    public double getM_Longitude() {
        return m_Longitude;
    }

    public void setM_Longitude(double m_Longitude) {
        this.m_Longitude = m_Longitude;
    }

    public double getM_Altitude() {
        return m_Altitude;
    }

    public void setM_Altitude(double m_Altitude) {
        this.m_Altitude = m_Altitude;
    }

    public int getM_Status() {
        return m_Status;
    }

    public void setM_Status(int m_Status) {
        this.m_Status = m_Status;
    }

    public int getM_Direct() {
        return m_Direct;
    }

    public void setM_Direct(int m_Direct) {
        this.m_Direct = m_Direct;
    }

    public int getM_Speed() {
        return m_Speed;
    }

    public void setM_Speed(int m_Speed) {
        this.m_Speed = m_Speed;
    }

    public int getM_StarNum() {
        return m_StarNum;
    }

    public void setM_StarNum(int m_StarNum) {
        this.m_StarNum = m_StarNum;
    }

    public int getM_StarInViewNum() {
        return m_StarInViewNum;
    }

    public void setM_StarInViewNum(int m_StarInViewNum) {
        this.m_StarInViewNum = m_StarInViewNum;
    }
}
