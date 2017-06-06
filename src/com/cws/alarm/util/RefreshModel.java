package com.cws.alarm.util;

import com.cws.alarm.config.AppConfig;
import com.easyj.core.bean.Application;
import com.easyj.core.codegenerate.CreatedEntityProperty;
import com.easyj.core.common.kit.JFinalKit;
import com.easyj.core.model.BaseModel;
import com.jfinal.plugin.activerecord.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Can on 2016/3/9.
 */
public class RefreshModel extends Application {
    public static void main(String[] args) {
        init(new AppConfig());
        Map<Class<? extends Model<?>>, Class<? extends BaseModel>> baseModelMap =
                new HashMap<Class<? extends Model<?>>, Class<? extends BaseModel>>();
        CreatedEntityProperty.me().created(JFinalKit.getTableModels(),
                "src/", "com.driving.model.base", baseModelMap, null);
        System.exit(0);
    }
}
