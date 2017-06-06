package com.cws.alarm.common.enums;

/**
 * **************************************************************************
 *
 * @说明:
 * @项目名称:
 * @author: tangweibin
 * @创建时间: 2017/6/6.
 * <p>
 * **************************************************************************
 */
public enum ResponsePacketType {
    DataLenError((byte)0x01),
    CrcError((byte)0x02),
    Success((byte)0xa0) ;
    private byte value;

    ResponsePacketType(byte value) {
        this.value = value;
    }


}
