package com.truecoder.spring.mapper;

import com.truecoder.spring.dto.LessonDTO;
import com.truecoder.spring.entity.Lesson;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring",
        uses = {CommonMapper.class},
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public abstract class LessonMapper implements BaseMapper<LessonDTO, Lesson> {

    @InheritConfiguration

    @Named("LessonToEntity")
    public abstract Lesson toEntity(LessonDTO dto);

    @InheritConfiguration
    @Mappings({
            @Mapping(source = "createdDate", target = "createdAt", qualifiedByName = "CONVERT_LOCAL_DATE_TIME_TO_LONG"),
            @Mapping(source = "lastModifiedDate", target = "updateAt", qualifiedByName = "CONVERT_LOCAL_DATE_TIME_TO_LONG")
    })
    @Named("LessonToDTO")
    public abstract LessonDTO toDTO(Lesson entity);

    @IterableMapping(qualifiedByName = "LessonToEntity")
    public abstract List<Lesson> toListEntity(List<LessonDTO> dtoList);

    @IterableMapping(qualifiedByName = "LessonToDTO")
    public abstract List<LessonDTO> toListDTO(List<Lesson> entityList);
}
