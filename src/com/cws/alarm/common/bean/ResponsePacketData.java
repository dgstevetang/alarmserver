package com.cws.alarm.common.bean;

/**
 * 应答包  （暂时只返回结果）
 * Created by 601042 on 2017/6/2.
 */
public class ResponsePacketData {
    int result;  //结果

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public static final byte SUCCESS = (byte) 0xa0;         //成功
    public static final byte LENGTHERROR = 0x01;            //长度错误
    public static final byte PARITYCHECKCODESERROR = 0x02;  //校验错误
    public static final byte HEADORTAILERROR = 0x03;        //包头或包尾错误
    public static final byte HASEXCEPTION = 0x04;           //有异常


}
