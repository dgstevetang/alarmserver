package com.cws.alarm.common.bean;

import java.util.Date;

/**
 * 周期性上传的OBD数据
 * Created by 601042 on 2017/6/1.
 */
public class OBDValue {
    Date m_Date;    //时间日期
    float Valtage ;     //电瓶电压    0.01V
    int Rate1 ;       //转速        RPM
    int Rate2 ;       //转速        RPM
    int Rate3 ;       //转速        RPM
    int Rate4 ;       //转速        RPM
    int Speed1 ;      //车速        KM/H
    int Speed2 ;      //车速        KM/H
    int Speed3 ;      //车速        KM/H
    int Speed4 ;      //车速        KM/H
    int Temperater ;  //冷却液温度  ℃
    float LPK1 ;        //瞬时油耗    0.01L
    float LPK2 ;        //瞬时油耗    0.01L
    float LPK3 ;        //瞬时油耗    0.01L
    float LPK4 ;        //瞬时油耗    0.01L
    int TotalODO ;   // 总里程      Km
    int LeftOil ;     //剩余油量    %
    int ErrorCount ;  //故障码数量  0.01L
    int[] errorCodes;// 故障码
    int GPSDataCount; //GPS数据包数量
    GpsData[] GPSDatas;//GPS数据
    int SenserDataCount;//传感器数据包数量
    SenserData[] SenserDatas;//Senser数据

    public Date getM_Date() {
        return m_Date;
    }

    public void setM_Date(Date m_Date) {
        this.m_Date = m_Date;
    }

    public float getValtage() {
        return Valtage;
    }

    public void setValtage(float valtage) {
        Valtage = valtage;
    }

    public int getRate1() {
        return Rate1;
    }

    public void setRate1(int rate1) {
        Rate1 = rate1;
    }

    public int getRate2() {
        return Rate2;
    }

    public void setRate2(int rate2) {
        Rate2 = rate2;
    }

    public int getRate3() {
        return Rate3;
    }

    public void setRate3(int rate3) {
        Rate3 = rate3;
    }

    public int getRate4() {
        return Rate4;
    }

    public void setRate4(int rate4) {
        Rate4 = rate4;
    }

    public int getSpeed1() {
        return Speed1;
    }

    public void setSpeed1(int speed1) {
        Speed1 = speed1;
    }

    public int getSpeed2() {
        return Speed2;
    }

    public void setSpeed2(int speed2) {
        Speed2 = speed2;
    }

    public int getSpeed3() {
        return Speed3;
    }

    public void setSpeed3(int speed3) {
        Speed3 = speed3;
    }

    public int getSpeed4() {
        return Speed4;
    }

    public void setSpeed4(int speed4) {
        Speed4 = speed4;
    }

    public int getTemperater() {
        return Temperater;
    }

    public void setTemperater(int temperater) {
        Temperater = temperater;
    }

    public float getLPK1() {
        return LPK1;
    }

    public void setLPK1(float LPK1) {
        this.LPK1 = LPK1;
    }

    public float getLPK2() {
        return LPK2;
    }

    public void setLPK2(float LPK2) {
        this.LPK2 = LPK2;
    }

    public float getLPK3() {
        return LPK3;
    }

    public void setLPK3(float LPK3) {
        this.LPK3 = LPK3;
    }

    public float getLPK4() {
        return LPK4;
    }

    public void setLPK4(float LPK4) {
        this.LPK4 = LPK4;
    }

    public int getTotalODO() {
        return TotalODO;
    }

    public void setTotalODO(int totalODO) {
        TotalODO = totalODO;
    }

    public int getLeftOil() {
        return LeftOil;
    }

    public void setLeftOil(int leftOil) {
        LeftOil = leftOil;
    }

    public int getErrorCount() {
        return ErrorCount;
    }

    public void setErrorCount(int errorCount) {
        ErrorCount = errorCount;
    }

    public int[] getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(int[] errorCodes) {
        this.errorCodes = errorCodes;
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

    public int getSenserDataCount() {
        return SenserDataCount;
    }

    public void setSenserDataCount(int senserDataCount) {
        SenserDataCount = senserDataCount;
    }

    public SenserData[] getSenserDatas() {
        return SenserDatas;
    }

    public void setSenserDatas(SenserData[] senserDatas) {
        SenserDatas = senserDatas;
    }
}
