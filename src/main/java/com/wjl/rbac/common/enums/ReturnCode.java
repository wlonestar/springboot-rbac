package com.wjl.rbac.common.enums;

/**
 * @author: wjl
 * @date: 2021/11/15 20:41
 * @version: v1.0
 */
public enum ReturnCode {

    OK(200, "success"),
    Failed(400, "fail");

    private final int code;
    private final String msg;

    ReturnCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
