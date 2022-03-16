package com.truecoder.spring.service;

import com.truecoder.spring.dto.CourseDTO;
import com.truecoder.spring.dto.CourseNestedDTO;
import com.truecoder.spring.dto.ListResponseDTO;
import com.truecoder.spring.dto.SingleResponseDTO;
import com.truecoder.spring.security.payload.response.MessageResponse;

import java.util.List;

public interface CourseService {

    MessageResponse createCourse(CourseDTO requestDTO);

    ListResponseDTO<CourseDTO> getAllCourse();

    ListResponseDTO<CourseDTO> find6CourseHighestViewer();

    SingleResponseDTO<CourseNestedDTO> getCourseNestedById(String id);
}
