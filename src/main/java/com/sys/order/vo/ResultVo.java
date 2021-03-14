package com.sys.order.vo;

public class ResultVo<T> {
    private boolean success; // 成功标识

    private int code; // 返回码

    private T data; // 返回数据

    private String message; // 返回信息

    /**
     * 成功返回
     * @param <T>
     * @return
     */
    public static <T> ResultVo<T> success() {
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setCode(400);
        resultVo.setSuccess(true);
        return resultVo;
    }

    public static <T> ResultVo<T> success(String message) {
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setCode(400);
        resultVo.setSuccess(true);
        resultVo.setMessage(message);
        return resultVo;
    }

    public static <T> ResultVo<T> success(String message, T data) {
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setCode(400);
        resultVo.setSuccess(true);
        resultVo.setMessage(message);
        resultVo.setData(data);
        return resultVo;
    }

    public static <T> ResultVo<T> success(T data) {
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setCode(400);
        resultVo.setSuccess(true);
        resultVo.setData(data);
        return resultVo;
    }

    /**
     * 失败返回
     * @param <T>
     * @return
     */
    public static <T> ResultVo<T> failure() {
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setCode(500);
        resultVo.setSuccess(false);
        return resultVo;
    }

    public static <T> ResultVo<T> failure(String message) {
        ResultVo<T> resultVo = new ResultVo<>();
        resultVo.setCode(500);
        resultVo.setSuccess(false);
        resultVo.setMessage(message);
        return resultVo;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
