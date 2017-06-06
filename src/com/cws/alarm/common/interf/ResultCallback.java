package com.cws.alarm.common.interf;

/**
 * 回调接口
 * Created by 601042 on 2017/6/1.
 */
public abstract class ResultCallback<T> {

    /**
     * 请求的响应结果为失败时调用
     * @param errorCode 错误码
     * @param e         异常
     */
    public abstract void onFailure(int errorCode, Exception e);

    /**
     * 请求的响应结果为成功时调用
     *
     * @param response 返回的数据
     * @param key       命令
     */
    public abstract void onResponse(byte key,T response);

}