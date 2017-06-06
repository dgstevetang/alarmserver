package com.cws.alarm.util;

import com.easyj.core.common.kit.KeyLabel;
import com.easyj.core.util.PropertiesUtils;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 数据库常量工具类
 * Created by Can on 2015/9/15.
 */
public abstract class DatabaseConstantsKit {
    private final static String keyValueSeparator = "`";
    private final static String itemSeparator = "\\|";

    private final static String cacheName = "database-constants.properties";
    private final static File configFile = new File(DatabaseConstantsKit.class.getResource("/").getPath(), cacheName);

    private static Map<String, String> getDataMap() {
        return PropertiesUtils.getPropertyMap(configFile, cacheName);
    }

    /**
     * 获取订单处理状态键值列表
     *
     * @return
     */
    public static Map<String, KeyLabel> getQoodOrderProcessStatus() {
        String value = getDataMap().get("qoodOrder.processStatus");
        String[] sp = value.split(itemSeparator);
        Map<String, KeyLabel> keyMap = new LinkedHashMap<String, KeyLabel>();
        for (String s : sp) {
            String[] keyValue = s.split(keyValueSeparator);
            KeyLabel keyLabel = new KeyLabel(keyValue[0], keyValue[1]);
            keyMap.put(keyValue[0], keyLabel);
        }
        return keyMap;
    }

}