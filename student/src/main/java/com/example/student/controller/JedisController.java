package com.example.student.controller;

import com.example.student.JedisRepository;
import com.example.student.entity.isMongo;
import com.example.student.mongoStudent.controller.StudentController;
import com.example.student.mongoStudent.entity.Student;
import com.example.student.postgresStudent.controller.PostStudentController;
import com.example.student.service.JedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/jedis")
public class JedisController {

    @Autowired
    JedisService jedisService;

    @Autowired
    StudentController studentController;

    @Autowired
    PostStudentController postStudentController;

    @GetMapping("")
    public ResponseEntity<Object> get(String id){


        if(jedisService.get()){
            return new ResponseEntity<>(studentController.get(id), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(postStudentController.get(id), HttpStatus.OK);
        }
    }

    @PostMapping("/setMongo/{id}")
    public ResponseEntity<isMongo> set(@PathVariable("id") Boolean id){
        return new ResponseEntity<>(jedisService.set(id), HttpStatus.OK);
    }
}
