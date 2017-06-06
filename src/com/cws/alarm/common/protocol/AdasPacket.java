package com.cws.alarm.common.protocol;

import org.tio.core.intf.Packet;

/**
 * 
 * @author tanyaowu 
 *
 */
public class AdasPacket extends Packet
{
	public static final byte SOP_LENGHT = 1;//消息头的长度
	public static final byte EOP_LENGHT = 1;//消息尾的长度
	public static final byte EOP = 0x5E;
	public static final byte DEVICE_LENGHT =16;
	public static final int HEADER_LENGHT = 20;//消息头的长度
	public static final int TAILER_LENGHT = 3;//消息尾的长度
	public static final String CHARSET = "utf-8";
	private byte[] body;

	public byte[] getDeviceSn() {
		return deviceSn;
	}

	public void setDeviceSn(byte[] deviceSn) {
		this.deviceSn = deviceSn;
	}

	private byte[] deviceSn;

	/**
	 * @return the body
	 */
	public byte[] getBody()
	{
		return body;
	}

	/**
	 * @param body the body to set
	 */
	public void setBody(byte[] body)
	{
		this.body = body;
	}
}
