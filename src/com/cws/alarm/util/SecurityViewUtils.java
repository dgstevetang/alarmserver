package com.cws.alarm.util;

import com.jfinal.kit.StrKit;

/**
 * 安全工具类
 * Created by Can on 2015/7/16.
 */
public class SecurityViewUtils {
    /**
     * 显示手机号
     *
     * @param mobile
     * @return
     */
    public static String showMobile(String mobile) {
        if (StrKit.isBlank(mobile)) return "";
        if (mobile.length() != 11) return mobile;
        StringBuffer sb = new StringBuffer();
        sb.append(mobile.substring(0, 3)).append("xxxx")
                .append(mobile.substring(7));
        return sb.toString();
    }
}
