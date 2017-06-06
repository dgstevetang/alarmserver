package com.cws.alarm.common.bean;

import java.util.Date;

/**
 * ADAS报警事件
 * Created by 601042 on 2017/6/2.
 */
public class ADASAlarmData {
    Date m_Date;         //时间日期
    int m_FCWEvent;        //FCW报警事件       0x00:前方没车   0x0E:前方有车，安全    0x0F:前方有车，车距近，已经报过警，不需要再发报警声    0x06:HMW，前方有车，车距近,报警   0X05: FCW，前方有车，快撞上,报警  0x0a:FPW，前车溜车提醒    0x0b:FVSM，前车启动提醒  0x10:撤除报警
    int m_HMWTime;         //自车与前车时间，单位：0.1S。0XFF表示无效
    int m_VDistance;       //自车与前车距离，单位0.1m。0XFFFF表示无效。
    int m_LDWEvent;        //LDW报警事件       0x00:无LDW报警    0x01:左虚线报警   0x02:左实线报警   0x03:右虚线报警  0x04:右实线报警
    int m_LLDistance;      //左轮与左车道线距离，单位：mm。0XFFFF表示没有道线。
    int m_RLDistance;      //右轮与右车道线距离，单位：mm 0XFFFF表示没有道线。
    int m_PDWEvent;        //PDW报警事件       0x00:前方没有行人  0x0e:前方有人，安全   0x08:前方有人，注意    0x07:前方有人，危险
    int m_PDistance;       //自车与前方行人距离，单位0.1m。0XFFFF表示无效。

    public Date getM_Date() {
        return m_Date;
    }

    public void setM_Date(Date m_Date) {
        this.m_Date = m_Date;
    }

    public int getM_FCWEvent() {
        return m_FCWEvent;
    }

    public void setM_FCWEvent(int m_FCWEvent) {
        this.m_FCWEvent = m_FCWEvent;
    }

    public int getM_HMWTime() {
        return m_HMWTime;
    }

    public void setM_HMWTime(int m_HMWTime) {
        this.m_HMWTime = m_HMWTime;
    }

    public int getM_VDistance() {
        return m_VDistance;
    }

    public void setM_VDistance(int m_VDistance) {
        this.m_VDistance = m_VDistance;
    }

    public int getM_LDWEvent() {
        return m_LDWEvent;
    }

    public void setM_LDWEvent(int m_LDWEvent) {
        this.m_LDWEvent = m_LDWEvent;
    }

    public int getM_LLDistance() {
        return m_LLDistance;
    }

    public void setM_LLDistance(int m_LLDistance) {
        this.m_LLDistance = m_LLDistance;
    }

    public int getM_RLDistance() {
        return m_RLDistance;
    }

    public void setM_RLDistance(int m_RLDistance) {
        this.m_RLDistance = m_RLDistance;
    }

    public int getM_PDWEvent() {
        return m_PDWEvent;
    }

    public void setM_PDWEvent(int m_PDWEvent) {
        this.m_PDWEvent = m_PDWEvent;
    }

    public int getM_PDistance() {
        return m_PDistance;
    }

    public void setM_PDistance(int m_PDistance) {
        this.m_PDistance = m_PDistance;
    }


}
