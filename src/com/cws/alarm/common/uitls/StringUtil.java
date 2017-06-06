package com.cws.alarm.common.uitls;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * **************************************************************************
 *
 * @说明:
 * @项目名称:
 * @author: tangweibin
 * @创建时间: 2017/6/5.
 * <p>
 * **************************************************************************
 */
public class StringUtil {

     /* @param string
     * @return
             * @throws UnsupportedEncodingException
     */
    public static String trimnull(String string) throws UnsupportedEncodingException
    {
        ArrayList<Byte> list = new ArrayList<Byte>();
        byte[] bytes = string.getBytes("UTF-8");
        for(int i=0;bytes!=null&&i<bytes.length;i++){
            if(0!=bytes[i]){
                list.add(bytes[i]);
            }
        }
        byte[] newbytes = new byte[list.size()];
        for(int i = 0 ; i<list.size();i++){
            newbytes[i]=(Byte) list.get(i);
        }
        String str = new String(newbytes,"UTF-8");
        return str;
    }
}
