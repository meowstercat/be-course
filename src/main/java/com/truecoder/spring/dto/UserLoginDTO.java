package com.truecoder.spring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.truecoder.spring.constant.ParamKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginDTO {
    @JsonProperty(ParamKey.EMAIL)
    private String email;

    @JsonProperty(ParamKey.PASSWORD)
    private String password;
}
