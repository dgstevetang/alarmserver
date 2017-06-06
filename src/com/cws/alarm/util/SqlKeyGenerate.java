package com.cws.alarm.util;

import com.cws.alarm.config.AppConfig;
import com.easyj.core.common.kit.JFinalKit;
import com.jfinal.core.JFinal;
import com.jfinal.plugin.IPlugin;

/**
 * 自动生成SQL
 * Created by Can on 2015/5/11.
 */
public class SqlKeyGenerate {
    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        config.configConstant(JFinal.me().getConstants());
        config.configPlugin(JFinalKit.getPlugins());
        for (IPlugin p : JFinalKit.getPlugins().getPluginList()) {
            p.start();
        }
        com.easyj.core.codegenerate.SqlKeyGenerate.me().generateSql("resource/", "sql");
        System.exit(0);
    }

}
