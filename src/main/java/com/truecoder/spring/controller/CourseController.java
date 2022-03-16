package com.truecoder.spring.controller;

import com.truecoder.spring.dto.*;
import com.truecoder.spring.security.payload.response.MessageResponse;
import com.truecoder.spring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping
    public ResponseEntity<ListResponseDTO> viewAll() {
        ListResponseDTO<CourseDTO> list = courseService.getAllCourse();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<SingleResponseDTO> getCourseNestedById(@PathVariable String id){
        SingleResponseDTO<CourseNestedDTO> responseDTO = courseService.getCourseNestedById(id);
        return new ResponseEntity<>(responseDTO,HttpStatus.OK);
    }

    @GetMapping("get-6-course-highest")
    public ResponseEntity<ListResponseDTO> get6CourseHighestViewer() {
        ListResponseDTO<CourseDTO> list = courseService.find6CourseHighestViewer();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("create-course")
    public ResponseEntity<MessageResponse> createCourse(@RequestBody CourseDTO requestDTO) {
        MessageResponse result = courseService.createCourse(requestDTO);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
