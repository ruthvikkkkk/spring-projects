package com.example.student.postgresStudent.service.impl;


import com.example.student.postgresStudent.entity.Course;
import com.example.student.postgresStudent.repository.PostCourseRepository;
import com.example.student.postgresStudent.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostCourseServiceImpl implements CourseService {

    @Autowired
    PostCourseRepository postCourseRepository;

    @Override
    public Course addOrUpdate(Course course) {
        return postCourseRepository.save(course);
    }

    @Override
    public Boolean deleteById(String id) {
        if(postCourseRepository.existsById(id)){
            postCourseRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Course get(String id) {
        Optional<Course> optionalCourse= postCourseRepository.findById(id);
        if(optionalCourse.isPresent()){
            Course course = optionalCourse.get();
            return course;
        }
        return null;
    }
}
