package com.truecoder.spring.entity;

import com.truecoder.spring.constant.DBKey;
import com.truecoder.spring.dic.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = DBKey.ROLE_TABLE)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @Column(name = DBKey.ROLE.ID)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private RoleEnum name;


    @OneToMany(mappedBy = DBKey.ROLE_TABLE)
    private List<Permission> permissionList = new ArrayList<>();
}
