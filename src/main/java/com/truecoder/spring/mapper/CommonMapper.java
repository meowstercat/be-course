package com.truecoder.spring.mapper;

import com.truecoder.spring.dic.LevelEnum;
import com.truecoder.spring.utils.IdGenerator;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public abstract class CommonMapper {

    @Named("CONVERT_LOCAL_DATE_TIME_TO_LONG")
    long convertLocalDateTimeToLong(LocalDateTime time) {
        return time.atZone(ZoneId.systemDefault()).toEpochSecond();
    }

    @Named("GENERATE_ID")
    String generateId() {
        return IdGenerator.genID();
    }

    @Named("CONVERT_STRING_TO_ENUM")
    LevelEnum convertStringToEnum(String str) {
        if (str != null) {
            if (str.equalsIgnoreCase(LevelEnum.BEGINNER.getName())) {
                return LevelEnum.BEGINNER;
            } else if (str.equalsIgnoreCase(LevelEnum.INTERMEDIATE.getName())) {
                return LevelEnum.INTERMEDIATE;
            } else if (str.equalsIgnoreCase(LevelEnum.ADVANCED.getName())) {
                return LevelEnum.ADVANCED;
            }
        }
        return null;
    }

    @Named("CONVERT_ENUM_TO_STRING")
    String convertEnumToString(LevelEnum levelEnum) {
        if (levelEnum != null) {
            if (levelEnum.getName().equals("beginner")) {
                return "beginner";
            }
            if (levelEnum.getName().equals("intermediate")) {
                return "intermediate";
            }
            if (levelEnum.getName().equals("advanced")) {
                return "advanced";
            }
        }
        return null;
    }
}