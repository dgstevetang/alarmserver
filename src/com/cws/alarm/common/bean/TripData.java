package com.cws.alarm.common.bean;

/**
 * 本次行程数据
 * Created by 601042 on 2017/6/1.
 */
public class TripData {
    String timeTripBegin;             //行程开始时间
    String timeTripEnd;               //行程结束时间
    int curIdleTime;                  //本次怠速时长  Min
    int curDriveTime;	              //本次行驶时间  Min
    int curODO;                       //本次行驶里程  M        (协议层单位是KM 现在由JAVA转为M)
    int curMaxRate;                   //本次最高转速  RPM
    int curMaxSpeed;                  //本次最高车速  KM/H
    int averageSpeed;                 // 平均速度     KM/H
    double point_trip_lat_begin;      //行程开始纬度  0.000001度
    double point_trip_lon_begin;      //行程开始经度  0.000001度
    double point_trip_latitude_end;   //行程结束纬度  0.000001度
    double point_trip_lon_end;        //行程结束经度  0.000001度
    int suddenAccelerationCount;      //急加速次数
    int suddenBrakeCount;             //急刹车次数
    int sudden_turning_count;         //急转弯次数
    float total_fuel;                 //行程油耗      0.01L
    float average_fuel_economy;       //百公里油耗    0.01L

    public int getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(int averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public String getTimeTripBegin() {
        return timeTripBegin;
    }

    public void setTimeTripBegin(String timeTripBegin) {
        this.timeTripBegin = timeTripBegin;
    }

    public String getTimeTripEnd() {
        return timeTripEnd;
    }

    public void setTimeTripEnd(String timeTripEnd) {
        this.timeTripEnd = timeTripEnd;
    }

    public int getCurIdleTime() {
        return curIdleTime;
    }

    public void setCurIdleTime(int curIdleTime) {
        this.curIdleTime = curIdleTime;
    }

    public int getCurDriveTime() {
        return curDriveTime;
    }

    public void setCurDriveTime(int curDriveTime) {
        this.curDriveTime = curDriveTime;
    }

    public int getCurODO() {
        return curODO;
    }

    public void setCurODO(int curODO) {
        this.curODO = curODO;
    }

    public int getCurMaxRate() {
        return curMaxRate;
    }

    public void setCurMaxRate(int curMaxRate) {
        this.curMaxRate = curMaxRate;
    }

    public int getCurMaxSpeed() {
        return curMaxSpeed;
    }

    public void setCurMaxSpeed(int curMaxSpeed) {
        this.curMaxSpeed = curMaxSpeed;
    }

    public double getPoint_trip_lat_begin() {
        return point_trip_lat_begin;
    }

    public void setPoint_trip_lat_begin(double point_trip_lat_begin) {
        this.point_trip_lat_begin = point_trip_lat_begin;
    }

    public double getPoint_trip_lon_begin() {
        return point_trip_lon_begin;
    }

    public void setPoint_trip_lon_begin(double point_trip_lon_begin) {
        this.point_trip_lon_begin = point_trip_lon_begin;
    }

    public double getPoint_trip_latitude_end() {
        return point_trip_latitude_end;
    }

    public void setPoint_trip_latitude_end(double point_trip_latitude_end) {
        this.point_trip_latitude_end = point_trip_latitude_end;
    }

    public double getPoint_trip_lon_end() {
        return point_trip_lon_end;
    }

    public void setPoint_trip_lon_end(double point_trip_lon_end) {
        this.point_trip_lon_end = point_trip_lon_end;
    }

    public int getSuddenAccelerationCount() {
        return suddenAccelerationCount;
    }

    public void setSuddenAccelerationCount(int suddenAccelerationCount) {
        this.suddenAccelerationCount = suddenAccelerationCount;
    }

    public int getSuddenBrakeCount() {
        return suddenBrakeCount;
    }

    public void setSuddenBrakeCount(int suddenBrakeCount) {
        this.suddenBrakeCount = suddenBrakeCount;
    }

    public int getSudden_turning_count() {
        return sudden_turning_count;
    }

    public void setSudden_turning_count(int sudden_turning_count) {
        this.sudden_turning_count = sudden_turning_count;
    }

    public float getTotal_fuel() {
        return total_fuel;
    }

    public void setTotal_fuel(float total_fuel) {
        this.total_fuel = total_fuel;
    }

    public float getAverage_fuel_economy() {
        return average_fuel_economy;
    }

    public void setAverage_fuel_economy(float average_fuel_economy) {
        this.average_fuel_economy = average_fuel_economy;
    }
}
