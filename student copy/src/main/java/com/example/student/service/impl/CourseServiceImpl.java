package com.example.student.service.impl;

import com.example.student.DTO.CourseDTO;
import com.example.student.DTO.InstructorDTO;
import com.example.student.entity.Course;
import com.example.student.entity.Instructor;
import com.example.student.repository.CourseRepository;
import com.example.student.repository.InstructorRepository;
import com.example.student.service.CourseService;
import com.example.student.service.InstructorService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    InstructorService instructorService;

    @Override
    public Course get(String id) {
        Optional<Course> courseOptional = courseRepository.findById(id);
        if(courseOptional.isPresent())
            return courseOptional.get();
        return null;
    }

    @Override
    public Course addOrUpdate(CourseDTO courseDTO) {
        Course course = new Course();
        BeanUtils.copyProperties(courseDTO, course);

        List<Instructor> instructors = courseDTO.getInstructor();
        for(Instructor instructor : instructors){
            InstructorDTO instructorDTO = new InstructorDTO();
            BeanUtils.copyProperties(instructor, instructorDTO);
            instructorService.addOrUpdate(instructorDTO);
        }
        return courseRepository.save(course);
    }

    @Override
    public Boolean deleteById(String id) {
        if(courseRepository.existsById(id)){
            courseRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }
}
