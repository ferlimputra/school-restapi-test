package com.school.controller;

import java.util.Arrays;
import java.util.List;
import com.school.dto.StudentDTO;
import com.school.model.Student;
import com.school.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



/**
 * StudentController
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/{name}")
    @ResponseBody
    public StudentDTO getStudentByName(@PathVariable("name") String name) {
        return modelMapper.map(studentService.findByName(name), StudentDTO.class);
    }

    @GetMapping("/class/{className}")
    @ResponseBody
    public List<StudentDTO> getStudentsByClassName(@PathVariable("className") String className) {
        return Arrays.asList(
                modelMapper.map(studentService.findByClassroomName(className), StudentDTO[].class));
    }

    @PostMapping(value = "/save")
    @ResponseBody
    public StudentDTO saveStudent(@RequestBody StudentDTO studentData) {
        return modelMapper.map(studentService.save(modelMapper.map(studentData, Student.class),
                studentData.getClassroomName()), StudentDTO.class);
    }

}
