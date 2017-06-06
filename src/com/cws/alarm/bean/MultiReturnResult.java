package com.cws.alarm.bean;

import com.alibaba.fastjson.JSONObject;
import com.cws.alarm.constant.AjaxConstant;
import com.cws.alarm.util.JsonResultKit;

import java.io.Serializable;

/**
 * 多值返回结果
 * Created by Administrator on 2016/6/12.
 */
public class MultiReturnResult implements Serializable {
    private static MultiReturnResult successObj = null;
    private AjaxConstant.STATUS errorCode = AjaxConstant.STATUS.success;
    private String errMsg = AjaxConstant.STATUS.success.msg();
    private Object object1;
    private Object object2;
    private Object object3;
    private Object object4;
    private boolean evalSuccess = true;
    private MultiReturnResult() {
    }
    public MultiReturnResult(AjaxConstant.STATUS errorCode, String errMsg) {
        this.setError(errorCode, errMsg);
    }

    public static MultiReturnResult success() {
        if (successObj == null) successObj = new MultiReturnResult();
        return successObj;
    }

    public void setError(AjaxConstant.STATUS errorCode, String errMsg) {
        this.setErrorCode(errorCode);
        this.setErrMsg(errMsg);
    }

    public AjaxConstant.STATUS getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(AjaxConstant.STATUS errorCode) {
        this.errorCode = errorCode;
        this.evalSuccess = AjaxConstant.STATUS.success.value() == errorCode.value();
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public boolean isEvalSuccess() {
        return evalSuccess;
    }

    public <T> T getObject1() {
        return (T) object1;
    }

    public void setObject1(Object object1) {
        this.object1 = object1;
    }

    public <T> T getObject2() {
        return (T) object2;
    }

    public void setObject2(Object object2) {
        this.object2 = object2;
    }

    public <T> T getObject3() {
        return (T) object3;
    }

    public void setObject3(Object object3) {
        this.object3 = object3;
    }

    public <T> T getObject4() {
        return (T) object4;
    }

    public void setObject4(Object object4) {
        this.object4 = object4;
    }

    @Override
    public String toString() {
        JSONObject root = toJsonObject();
        return root.toJSONString();
    }

    public JSONObject toJsonObject(){
        JSONObject root = JsonResultKit.getJSONObject(errorCode,errMsg);
        if(object1 != null){
            root.put("object1",object1);
        }
        if(object2 != null){
            root.put("object2",object2);
        }
        if(object3 != null){
            root.put("object3",object3);
        }
        if(object4 != null){
            root.put("object4",object4);
        }
        return root;
    }
}
