package com.romijulianto.restapicarspringboot.response;


import org.springframework.stereotype.Component;

@Component // to indicate component where can call in other class
/* Generator to return data, set T */
public class CommonResponseGenerator<T> {

    /* mehthod succesresponse */
    public <T> CommonResponse<T> successResponse(T datas, String message) {
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setStatus("200");
        commonResponse.setMessage(message);
        commonResponse.setDatas(datas);

        return commonResponse;
    }

    /* mehthod failedresponse */
    public <T> CommonResponse<T> failedResponse(String message) {
        CommonResponse commonResponse = new CommonResponse<>();
        commonResponse.setStatus("500");
        commonResponse.setMessage(message);

        return  commonResponse;
    }

}
