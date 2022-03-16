package com.truecoder.spring.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class CourseDTO {
    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("course_code")
    private String courseCode;

    @JsonProperty("image_path")
    private String imagePath;

    @JsonProperty("price_tag")
    private String priceTag;

    @JsonProperty("total_lessons")
    private int totalLessons;

    @JsonProperty("total_time")
    private int totalTime;

    @JsonProperty("level")
    private String level;

    @JsonProperty("description")
    private String description;

    @JsonProperty("viewers")
    private int viewers;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty("update_at")
    private long updateAt;

}
