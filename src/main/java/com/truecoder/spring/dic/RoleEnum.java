package com.truecoder.spring.dic;

import com.truecoder.spring.pojo.RoleTypeDTO;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public enum RoleEnum {
    ROLE_STUDENT(1, "ROLE_STUDENT"),
    ROLE_TEACHER(2, "ROLE_TEACHER"),
    ROLE_ADMIN(3, "ROLE_ADMIN");
    private final int type;
    private final String roleName;

    RoleEnum(int type, String roleName) {
        this.type = type;
        this.roleName = roleName;
    }

    public static List<RoleTypeDTO> getAllRoleEnum() {
        List<RoleTypeDTO> list = new ArrayList<>();
        list.add(new RoleTypeDTO(ROLE_STUDENT.getType(), ROLE_STUDENT.getRoleName()));
        list.add(new RoleTypeDTO(ROLE_TEACHER.getType(), ROLE_TEACHER.getRoleName()));
        list.add(new RoleTypeDTO(ROLE_ADMIN.getType(), ROLE_ADMIN.getRoleName()));
        return list;
    }

}
