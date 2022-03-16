package com.truecoder.spring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.truecoder.spring.constant.DBKey;
import com.truecoder.spring.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;

@Data
public class LessonDTO {

    private String id;

    @JsonProperty("lesson_code")
    private String lessonCode;

    @JsonProperty("lesson_name")
    private String lessonName;

    @JsonProperty("video_path")
    private String videoPath;

    @JsonProperty("documentation")
    private String documentation;

    @JsonProperty("score")
    private Integer score;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty("update_at")
    private long updateAt;
}
