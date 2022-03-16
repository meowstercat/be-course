package com.truecoder.spring.entity;

import com.truecoder.spring.constant.DBKey;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Table(name = DBKey.USER_TABLE)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User extends BaseEntity {
    @Id
    @Column(name = DBKey.USER.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = DBKey.USER.USERNAME)
    private String username;

    @Column(name = DBKey.USER.EMAIL)
    private String email;

    @Column(name = DBKey.USER.PASSWORD)
    private String password;

    @Column(name = DBKey.USER.ACTIVE)
    private Integer active;

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = DBKey.CLAZZ.ID)
    private Clazz clazz;
}
