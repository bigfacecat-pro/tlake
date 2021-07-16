package com.the.pojo;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private String result;
    private String message;
    private T data;

    public Result(String result, String message,T data) {
        this.result = result;
        this.message = message;
        this.data=data;
    }



    public static <T> Result<T> error(Exception e) {
        return new Result<>(e);
    }

    public String getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    private Result(Exception e) {
        this.result = "fail";
        this.message =e.getMessage();
        this.data= (T) "nothing";
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }
    @Override
    public String toString() {
        return super.toString();
    }
}
