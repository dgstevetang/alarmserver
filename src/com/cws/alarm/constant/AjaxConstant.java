package com.cws.alarm.constant;

/**
 * AJAX请求常量
 * Created by Can on 2015/5/28.
 */
public interface AjaxConstant {
    /**
     * 错误状态KEY
     */
    String errorCodeKey = "errorCode";
    /**
     * 错误信息KEY
     */
    String errorMsgKey = "errMsg";

    /**
     * 请求状态
     */
    enum STATUS {
        success(1, "ok"),
        error(-1, "系统正忙，请稍候再试！"),
        illegalOperation(-2, "Illegal operation,request Limit."),
        notLogin(-3, "未登录！"),
        loginFailure(-4, "登录失败！"),
        weixinTimeout(-5, "页面已超时！");
        private int s;
        private String label;

        private STATUS(int s, String label) {
            this.s = s;
            this.label = label;
        }

        public int value() {
            return s;
        }

        public String msg() {
            return label;
        }
    }
}
