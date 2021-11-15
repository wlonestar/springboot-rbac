package com.wjl.rbac.common.constants;

import com.wjl.rbac.common.enums.ReturnCode;

import java.util.Objects;

/**
 * @author: wjl
 * @date: 2021/11/15 20:42
 * @version: v1.0
 */
public class Result<T> {

    private int code;
    private String msg;
    private T data;

    public static <T> Result<T> success(T data) {
        Result<T> Result = new Result<>();
        Result.setCode(ReturnCode.OK.getCode());
        Result.setMsg(ReturnCode.OK.getMsg());
        Result.setData(data);
        return Result;
    }

    public static <T> Result<T> success(String msg) {
        Result<T> Result = new Result<>();
        Result.setCode(ReturnCode.OK.getCode());
        Result.setMsg(msg);
        return Result;
    }

    public static <T> Result<T> fail(int code, String msg) {
        Result<T> Result = new Result<>();
        Result.setCode(code);
        Result.setMsg(msg);
        return Result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result<?> result)) return false;
        return getCode() == result.getCode() && Objects.equals(getMsg(), result.getMsg())
                && Objects.equals(getData(), result.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getMsg(), getData());
    }

}
