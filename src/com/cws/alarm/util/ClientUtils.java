package com.cws.alarm.util;

import com.easyj.core.util.StrUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * 客户端工具类
 * Created by Can on 2015/6/26.
 */
public class ClientUtils {

    /**
     * 是否微信
     *
     * @param request
     * @return
     */
    public static boolean isWeixin(HttpServletRequest request) {
        String ua = request.getHeader("user-agent");
        if (ua == null) return false;
        if (ua.toLowerCase().indexOf("micromessenger") != -1) {// 是微信浏览器
            return true;
        }
        return false;
    }

    /**
     * 是否在Qood中运行
     * @param request
     * @return
     */
    public static boolean isInQood(HttpServletRequest request) {
        if (request == null) return false;
        String ua = request.getHeader("user-agent");
        if (StrUtils.ignoreCaseIndexOf(ua, "QOOD/") != -1) {
            return true;
        }
        return false;
    }

    /**
     * 是否爱车保客户端
     * @param request
     * @return
     */
    public static boolean isICheBaoClient(HttpServletRequest request){
        if (request == null) return false;
        String ua = request.getHeader("user-agent");
        if (StrUtils.ignoreCaseIndexOf(ua, "ICHEBAO/") != -1) {
            return true;
        }
        return false;
    }

    /**
     * 是否内嵌到android
     *
     * @param request
     * @return
     */
    public static boolean isAndroidEmbed(HttpServletRequest request) {
        if (request == null) return false;
        String ua = request.getHeader("user-agent");
        if (StrUtils.ignoreCaseIndexOf(ua, "android-embed") != -1) return true;
        return false;
    }

    /**
     * 是否内嵌到iphone
     *
     * @return
     */
    public static boolean isIphoneEmbed(HttpServletRequest request) {
        if (request == null) return false;
        String ua = request.getHeader("user-agent");
        if (StrUtils.ignoreCaseIndexOf(ua, "iphone-embed") != -1) return true;
        return false;
    }
}
