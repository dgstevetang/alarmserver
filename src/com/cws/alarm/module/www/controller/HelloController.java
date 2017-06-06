package com.cws.alarm.module.www.controller;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

/**
 * Created by PC on 2017/5/17.
 */
public class HelloController extends Controller {
    public void index() {
        List<Record> records = Db.find("select * from hdx_vehicles_trips");
        int size = records.size();
        renderText("Hello JFinal World." + size +"条记录");
    }
}
