package com.cws.alarm.util;

import com.alibaba.fastjson.JSONObject;
import com.cws.alarm.constant.AjaxConstant;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;

/**
 * JSON结果集工具类
 * Created by Can on 2015/8/17.
 */
public class JsonResultKit {

    private final static String JSONP_KEY = "jsonpcallback";

    /**
     * 获取JSONObject
     *
     * @param status
     * @param msg
     * @return
     */
    public static JSONObject getJSONObject(AjaxConstant.STATUS status, String msg) {
        JSONObject root = new JSONObject();
        root.put(AjaxConstant.errorCodeKey, status.value());
        root.put(AjaxConstant.errorMsgKey, StrKit.isBlank(msg) ? status.msg() : msg);
        return root;
    }

    public static JSONObject getJSONObject(AjaxConstant.STATUS status) {
        return getJSONObject(status, null);
    }

    public static void renderJson(Controller c, String jsonText) {
        String jsonpKey = c.getPara(JSONP_KEY, "");
        if (StrKit.isBlank(jsonpKey)) {
            c.renderJson(jsonText);
        } else {
            c.renderText(jsonpKey + "(" + jsonText + ")");
        }
    }
}
