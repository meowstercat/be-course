package com.truecoder.spring.entity;

import com.truecoder.spring.constant.DBKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = DBKey.PERMISSION_TABLE)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Permission {
    @Id
    @Column(name = DBKey.PERMISSION.ID)
    private Integer id;

    @Column(name = DBKey.PERMISSION.NAME)
    private String name;

    @Column(name = DBKey.PERMISSION.DESCRIPTION)
    private String description;

    @ManyToOne
    @JoinColumn(name = DBKey.ROLE.ID)
    private Role role;
}
