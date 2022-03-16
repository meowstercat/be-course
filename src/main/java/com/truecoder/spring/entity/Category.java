package com.truecoder.spring.entity;

import com.truecoder.spring.constant.DBKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = DBKey.CATEGORY_TABLE)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @Column(name = DBKey.CATEGORY.ID)
    private Integer id;

    @Column(name = DBKey.CATEGORY.CATEGORY)
    private String category;

    @OneToMany(mappedBy = DBKey.CATEGORY_TABLE)
    private List<Post> postList = new ArrayList<>();
}
