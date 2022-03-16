package com.truecoder.spring.dto;

import lombok.Data;

@Data
public class SingleResponseDTO<T> extends BaseResponse {
    private T data;

    public SingleResponseDTO() {
        super();
    }

    public SingleResponseDTO(T data) {
        super();
        this.data = data;
    }

    public SingleResponseDTO(String message, T data) {
        super(message);
        this.data = data;
    }
}
