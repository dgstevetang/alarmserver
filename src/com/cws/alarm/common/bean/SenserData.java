package com.cws.alarm.common.bean;

/**
 * 传感器数据
 * Created by 601042 on 2017/6/1.
 */
public class SenserData {
    int		mAccelerationX; 	// X轴加速度 mg
    int 	mAccelerationY; 	// y轴加速度 mg
    int 	mAccelerationZ;	// z轴加速度     mg
    int	    mGyroscopeX; 	//陀螺仪 X轴角速度 mdps 0x0 0x0 0x0 0x3f
    int		mGyroscopeY; 	//陀螺仪Y轴角速度 4mdps 0x0 0x0 0x0 0x4
    int		mGyroscopeZ; 	//陀螺仪Z轴角速度 -23mdps 0x0 0x0 0xff 0xe9

    public int getmAccelerationX() {
        return mAccelerationX;
    }

    public void setmAccelerationX(int mAccelerationX) {
        this.mAccelerationX = mAccelerationX;
    }

    public int getmAccelerationY() {
        return mAccelerationY;
    }

    public void setmAccelerationY(int mAccelerationY) {
        this.mAccelerationY = mAccelerationY;
    }

    public int getmAccelerationZ() {
        return mAccelerationZ;
    }

    public void setmAccelerationZ(int mAccelerationZ) {
        this.mAccelerationZ = mAccelerationZ;
    }

    public int getmGyroscopeX() {
        return mGyroscopeX;
    }

    public void setmGyroscopeX(int mGyroscopeX) {
        this.mGyroscopeX = mGyroscopeX;
    }

    public int getmGyroscopeY() {
        return mGyroscopeY;
    }

    public void setmGyroscopeY(int mGyroscopeY) {
        this.mGyroscopeY = mGyroscopeY;
    }

    public int getmGyroscopeZ() {
        return mGyroscopeZ;
    }

    public void setmGyroscopeZ(int mGyroscopeZ) {
        this.mGyroscopeZ = mGyroscopeZ;
    }
}
