package com.truecoder.spring.dto;

import lombok.Data;

@Data
public class BaseResponse {
    private String message;

    public BaseResponse() {
        this.message = "";
    }

    public BaseResponse(String message) {
        this.message = message;
    }
}
