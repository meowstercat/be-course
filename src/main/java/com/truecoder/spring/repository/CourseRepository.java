package com.truecoder.spring.repository;

import com.truecoder.spring.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
    @Query(nativeQuery = true,value = "SELECT * FROM course order by views desc limit 6")
    List<Course> find6CourseHighestViewer();
}
