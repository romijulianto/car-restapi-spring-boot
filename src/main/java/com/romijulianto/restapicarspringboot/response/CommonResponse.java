package com.romijulianto.restapicarspringboot.response;

/* common response from Car Management */
public class CommonResponse<T> {
    private String status;
    private String message;
    private T datas;

    /* generate contructor */

    public CommonResponse() {
    }

    public CommonResponse(String status, String message, T datas) {
        this.status = status;
        this.message = message;
        this.datas = datas;
    }

    /*generate Getter and Setter to set Status */

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDatas() {
        return datas;
    }

    public void setDatas(T datas) {
        this.datas = datas;
    }
}
