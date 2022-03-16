package com.truecoder.spring.pojo;

import lombok.Data;

@Data
public class RoleTypeDTO {
    private int type;
    private String roleName;

    public RoleTypeDTO(int type, String roleName) {
        this.type = type;
        this.roleName = roleName;
    }
}
