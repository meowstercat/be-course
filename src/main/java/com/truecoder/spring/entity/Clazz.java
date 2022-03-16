package com.truecoder.spring.entity;

import com.truecoder.spring.constant.DBKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = DBKey.CLAZZ_TABLE)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clazz extends BaseEntity {
    @Id
    @Column(name = DBKey.CLAZZ.ID)
    private Integer id;

    @Column(name = DBKey.CLAZZ.NAME)
    private String name;

    @OneToMany(mappedBy = DBKey.CLAZZ_TABLE)
    private List<User> userList = new ArrayList<>();

    @OneToMany(mappedBy = DBKey.CLAZZ_TABLE)
    private List<Post> postList = new ArrayList<>();
}
