package com.truecoder.spring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CourseNestedDTO extends CourseDTO{

    @JsonProperty("lesson_list")
    private List<LessonDTO> lessonDTOList;
}
