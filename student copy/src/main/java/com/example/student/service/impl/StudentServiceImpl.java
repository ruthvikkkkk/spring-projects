package com.example.student.service.impl;

import com.example.student.DTO.CourseDTO;
import com.example.student.DTO.StudentDTO;
import com.example.student.entity.Course;
import com.example.student.entity.Instructor;
import com.example.student.entity.Student;
import com.example.student.repository.StudentRepository;
import com.example.student.service.CourseService;
import com.example.student.service.InstructorService;
import com.example.student.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseService courseService;

    @Autowired
    InstructorService instructorService;

    @Override
    public Student get(String id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent())
            return student.get();
        return null;
    }

    @Override
    public Boolean deleteById(String id) {
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Student addOrUpdate(StudentDTO studentDTO) {
        Student student = new Student();
        BeanUtils.copyProperties(studentDTO, student);

        List<Course> coursesEnrolled = studentDTO.getCoursesEnrolled();
        for(Course course : coursesEnrolled){
            CourseDTO courseDTO = new CourseDTO();
            BeanUtils.copyProperties(course, courseDTO);
            courseService.addOrUpdate(courseDTO);
        }
        return studentRepository.save(student);
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Map<String, String> findByCourse(String id){
        List<Student> students = studentRepository.findAll();
        List<Course> courses = courseService.findAll();

        Map<String, String> filteredByCourse = new HashMap();
        filteredByCourse.put(id, "");

        for(Student student : students){
            for(Course course : student.getCoursesEnrolled()){
                if(course.getCourseId().equals(id)) {
                    String res = student.getStudentId() + "||||" + course.getInstructor().toString() + "||||";
                    filteredByCourse.put(id, filteredByCourse.get(course.getCourseId()) + res);
                }
            }
        }

        return filteredByCourse;
    }

    @Override
    public Map<String, String> findByCourseStatus(String status) {
        List<Student> students = studentRepository.findAll();
        HashMap<String, String> studentFilter = new HashMap<>();
        for(Student s : students){
            for(Course c : s.getCoursesEnrolled()){
                if(c.getCourseProgress().equals(status)) {
                    if (!studentFilter.containsKey(c.getCourseId())) {
                        studentFilter.put(c.getCourseId(), s.getName() + " | " + s.getStudentId() + " | ");
                    } else
                        studentFilter.put(c.getCourseId(), studentFilter.get(c.getCourseId()) + s.getName() + " | " + s.getStudentId() + " | ");
                }
            }
        }
        return studentFilter;
    }
}
