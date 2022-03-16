package com.truecoder.spring.mapper;

import com.truecoder.spring.dto.CourseDTO;
import com.truecoder.spring.entity.Course;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {CommonMapper.class,LessonMapper.class}, unmappedSourcePolicy = ReportingPolicy.IGNORE)
public abstract class CourseMapper implements BaseMapper<CourseDTO, Course> {

    @InheritConfiguration
    @Mapping(source = "level",target = "level" ,qualifiedByName = "CONVERT_STRING_TO_ENUM")
    @Named("CourseToEntity")
    public abstract Course toEntity(CourseDTO dto);

    @InheritConfiguration
    @Named("CourseToDTO")
    @Mappings({
            @Mapping(source = "createdDate", target = "createdAt", qualifiedByName = "CONVERT_LOCAL_DATE_TIME_TO_LONG"),
            @Mapping(source = "lastModifiedDate", target = "updateAt", qualifiedByName = "CONVERT_LOCAL_DATE_TIME_TO_LONG"),
            @Mapping(source = "level",target = "level" ,qualifiedByName = "CONVERT_ENUM_TO_STRING")
    })
    public abstract CourseDTO toDTO(Course entity);

    @IterableMapping(qualifiedByName = "CourseToEntity")
    public abstract List<Course> toListEntity(List<CourseDTO> dtoList);

    @IterableMapping(qualifiedByName = "CourseToDTO")
    public abstract List<CourseDTO> toListDTO(List<Course> entityList);
}
