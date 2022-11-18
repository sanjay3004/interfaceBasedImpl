package com.example.interfacebasedimpl.exception;

public class Response {

    int status;
    String msg;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Response(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
