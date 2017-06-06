package com.cws.alarm.common.uitls;

/**
 * **************************************************************************
 *
 * @说明:
 * @项目名称:
 * @author: tangweibin
 * @创建时间: 2017/5/27.
 * <p>
 * **************************************************************************
 */
public class CrcUtil {/**
 * 用于CRC校验（CRC校验计算由命令字开始到数据字结束，不包括起始字节、结束字和CRC校验字节）
 *
 * @param byteArray
 * @param intLength
 * @return
 */
public static final byte[] generateCrc16(byte[] byteArray, int intLength) {

    int crc = 0xFFFF;
    for (int i = 0; i < intLength; i++) {
        crc ^= (byteArray[i] & 0xFF);
        crc = crc & 0xFFFF;
        // System.out.println(crc);
        for (int j = 0; j < 8; j++) {
            if ((crc & 0x0001) != 0) {
                crc = (crc >> 1) ^ 0x8408;
            } else {
                crc = (crc >> 1);
            }
            crc = crc & 0xFFFF;
            // System.out.println(crc);
        }
    }
    // System.out.println("crc=" + crc);
    return intToByteArray(crc);
}

    private static byte[] intToByteArray(int i) {
        byte[] result = new byte[2];
        // result[0] = (byte) ((i >> 24) & 0xFF);
        // result[1] = (byte) ((i >> 16) & 0xFF);
        result[0] = (byte) ((i >> 8) & 0xFF);
        result[1] = (byte) (i & 0xFF);
        return result;
    }
}
