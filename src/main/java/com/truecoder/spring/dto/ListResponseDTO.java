package com.truecoder.spring.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ListResponseDTO<T> extends BaseResponse{
    private List<T> data;

    public ListResponseDTO(List<T> data) {
        super();
        this.data = data;
    }
}
