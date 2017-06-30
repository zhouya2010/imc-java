package com.yundian.imc.common.base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by dell on 2016/12/22.
 */
public class BaseResponse {

    private int Ret = 0;
    private Object Data;
    private String Msg;
    private String Sig;

    public BaseResponse(){

    }

    public BaseResponse(int ret, String msg) {
        Ret = ret;
        Msg = msg;
    }

    public BaseResponse(int ret, Object data, String msg) {
        Ret = ret;
        Data = data;
        Msg = msg;
    }

    public BaseResponse(int ret, Object data, String msg, String sig) {
        Ret = ret;
        Data = data;
        Msg = msg;
        Sig = sig;
    }

    public int getRet() {
        return Ret;
    }

    public void setRet(int ret) {
        Ret = ret;
    }

    public Object getData() {
        return Data;
    }

    public void setData(Object data) {
        Data = data;
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public String getSig() {
        return Sig;
    }

    public void setSig(String sig) {
        Sig = sig;
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}
