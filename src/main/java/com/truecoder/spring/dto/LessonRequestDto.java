package com.truecoder.spring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LessonRequestDto {

    private String id;

    @JsonProperty("lessonCode")
    private String lessonCode;

    @JsonProperty("lessonName")
    private String lessonName;

    @JsonProperty("videoPath")
    private String videoPath;

    @JsonProperty("course_id")
    private String courseId;

}
