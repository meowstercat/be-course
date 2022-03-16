package com.truecoder.spring.service.impl;

import com.truecoder.spring.dto.CourseDTO;
import com.truecoder.spring.dto.CourseNestedDTO;
import com.truecoder.spring.dto.ListResponseDTO;
import com.truecoder.spring.dto.SingleResponseDTO;
import com.truecoder.spring.entity.Course;
import com.truecoder.spring.entity.Lesson;
import com.truecoder.spring.mapper.CourseMapper;
import com.truecoder.spring.mapper.CourseNestedMapper;
import com.truecoder.spring.repository.CourseRepository;
import com.truecoder.spring.security.payload.response.MessageResponse;
import com.truecoder.spring.service.CourseService;
import com.truecoder.spring.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseNestedMapper courseNestedMapper;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public MessageResponse createCourse(CourseDTO requestDTO) {

        Course course = courseMapper.toEntity(requestDTO);
        course.setId(IdGenerator.genID());
        course.setCreatedDate(LocalDateTime.now());
        course.setLastModifiedDate(LocalDateTime.now());
        for (Lesson lesson : course.getLessonList()){
            lesson.setCreatedDate(LocalDateTime.now());
            lesson.setLastModifiedDate(LocalDateTime.now());
        }

        if (ObjectUtils.isEmpty(course)) {
            return new MessageResponse("Add not successfully");
        }
        courseRepository.save(course);
        return new MessageResponse("Add successfully");
    }

    @Override
    public ListResponseDTO<CourseDTO> getAllCourse() {
        List<Course> courseList = courseRepository.findAll();
        List<CourseDTO> courseDTOList = courseMapper.toListDTO(courseList);
        return new ListResponseDTO<>(courseDTOList);
    }

    @Override
    public ListResponseDTO<CourseDTO> find6CourseHighestViewer() {
        List<Course> courseList = courseRepository.find6CourseHighestViewer();
        List<CourseDTO> courseDTOList = courseMapper.toListDTO(courseList);
        return new ListResponseDTO<>(courseDTOList);
    }

    @Override
    public SingleResponseDTO<CourseNestedDTO> getCourseNestedById(String id) {
        Course course = courseRepository.findById(id).get();
        CourseNestedDTO courseNestedDTO = courseNestedMapper.toDTO(course);
        return new SingleResponseDTO<>(courseNestedDTO);
    }

}
