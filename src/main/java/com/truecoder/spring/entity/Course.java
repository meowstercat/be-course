package com.truecoder.spring.entity;

import com.truecoder.spring.constant.DBKey;
import com.truecoder.spring.dic.LevelEnum;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

@Table(name = DBKey.COURSE_TABLE)
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course extends BaseEntity {
    @Id
    @Column(name = DBKey.COURSE.ID)
    private String id;

    @Column(name = DBKey.COURSE.COURSE_CODE)
    private String courseCode;

    @Column(name = DBKey.COURSE.NAME)
    private String name;

    @Column(name = DBKey.COURSE.PRICE_TAG)
    private String priceTag;

    @Column(name = DBKey.COURSE.IMAGE_PATH)
    private String imagePath;

    @Column(name = DBKey.COURSE.TOTAL_LESSONS)
    private Integer totalLessons;

    @Column(name = DBKey.COURSE.TOTAL_TIME)
    private Integer totalTime;

    @Column(name = DBKey.COURSE.DESCRIPTION)
    @Type(type = "text")
    private String description;

    @Column(name = DBKey.COURSE.VIEWS)
    private Integer viewers;

    @Enumerated(EnumType.STRING)
    private LevelEnum level;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = DBKey.COURSE.ID)
    private List<Lesson> lessonList;

}
