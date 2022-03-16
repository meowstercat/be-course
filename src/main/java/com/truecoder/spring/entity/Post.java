package com.truecoder.spring.entity;

import com.truecoder.spring.constant.DBKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = DBKey.POST_TABLE)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @Column(name = DBKey.POST.ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = DBKey.POST.CONTENT)
    private String content;

    @ManyToOne
    @JoinColumn(name = DBKey.CLAZZ.ID)
    private Clazz clazz;

    @ManyToOne
    @JoinColumn(name = DBKey.CATEGORY.ID)
    private Category category;
}
