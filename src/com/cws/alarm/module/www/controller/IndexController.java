package com.cws.alarm.module.www.controller;

import com.jfinal.core.Controller;

/**
 * Created by PC on 2017/5/17.
 */
public class IndexController extends Controller {
    public void index() {
       renderText("你好");
    }
}
