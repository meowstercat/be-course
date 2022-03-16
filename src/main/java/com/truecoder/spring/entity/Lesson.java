package com.truecoder.spring.entity;

import com.truecoder.spring.constant.DBKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = DBKey.LESSON_TABLE)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Lesson extends BaseEntity {
    @Id
    @Column(name = DBKey.LESSON.ID)
    private String id;

    @Column(name = DBKey.LESSON.CODE)
    private String lessonCode;

    @Column(name = DBKey.LESSON.NAME)
    private String lessonName;

    @Column(name = DBKey.LESSON.VIDEO_FILENAME)
    private String videoFilename;

    @Column(name = DBKey.LESSON.DOCUMENTATION)
    private String documentation;

    @Column(name = DBKey.LESSON.SCORE)
    private Integer score;

    @ManyToOne
    @JoinColumn(name = DBKey.COURSE.ID)
    private Course course;

}
