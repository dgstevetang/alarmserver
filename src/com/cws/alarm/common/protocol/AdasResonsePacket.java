package com.cws.alarm.common.protocol;

import org.tio.core.intf.Packet;

/**
 * **************************************************************************
 *
 * @说明:
 * @项目名称:
 * @author: tangweibin
 * @创建时间: 2017/5/31.
 * <p>
 * **************************************************************************
 */
public class AdasResonsePacket extends Packet {
    public static final int HEADER_LENGHT = 3;//消息头的长度
    public static final int COMMAND_LENGHT = 1;//消息头的长度
    private byte command;
    private short packetLen;
    private byte result;
    private byte bodylen;
    private byte[] body;
}
