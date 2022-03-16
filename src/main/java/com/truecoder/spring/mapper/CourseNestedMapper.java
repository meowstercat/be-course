package com.truecoder.spring.mapper;

import com.truecoder.spring.dto.CourseDTO;
import com.truecoder.spring.dto.CourseNestedDTO;
import com.truecoder.spring.entity.Course;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {CommonMapper.class, LessonMapper.class}, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public abstract class CourseNestedMapper implements BaseMapper<CourseNestedDTO, Course> {

    @InheritConfiguration
    @Mappings({
            @Mapping(source = "level", target = "level", qualifiedByName = "CONVERT_STRING_TO_ENUM"),
            @Mapping(source = "lessonDTOList", target = "lessonList")
    })
    @Named("CourseNestedToEntity")
    public abstract Course toEntity(CourseNestedDTO dto);

    @InheritConfiguration
    @Named("CourseNestedToDTO")
    @Mappings({
            @Mapping(source = "createdDate", target = "createdAt", qualifiedByName = "CONVERT_LOCAL_DATE_TIME_TO_LONG"),
            @Mapping(source = "lastModifiedDate", target = "updateAt", qualifiedByName = "CONVERT_LOCAL_DATE_TIME_TO_LONG"),
            @Mapping(source = "level", target = "level", qualifiedByName = "CONVERT_ENUM_TO_STRING"),
            @Mapping(source = "lessonList", target = "lessonDTOList")
    })
    public abstract CourseNestedDTO toDTO(Course entity);

    @IterableMapping(qualifiedByName = "CourseNestedToEntity")
    public abstract List<Course> toListEntity(List<CourseNestedDTO> dtoList);

    @IterableMapping(qualifiedByName = "CourseNestedToDTO")
    public abstract List<CourseNestedDTO> toListDTO(List<Course> entityList);

}
