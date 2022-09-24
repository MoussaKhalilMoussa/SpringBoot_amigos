package com.example.demo.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping(path ="/api/v1/students")
public class StudentController {

    private final StudentAService studentAService;
    @Autowired
    public StudentController(StudentAService studentAService) {
        this.studentAService = studentAService;
    }

    @GetMapping("/getAllStudent")
    public List<Student> getStudent(){
        return studentAService.getStudent();
    }

    @GetMapping("/getById/{studentId}")
    public Optional<Student> getStudentById(@PathVariable("studentId") Long studentId){
        return studentAService.getStudentById(studentId);
    }

    @PostMapping("/addStudent")
    public void registerNewStudent(@RequestBody Student student ){
        studentAService.addNewStudent(student);
    }

    @DeleteMapping(path = "/delete/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentAService.deleteStudent(studentId);
    }

    @PutMapping(path="/update/{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required=false) String name,
            @RequestParam(required=false) String surname,
            @RequestParam(required=false) String email){
        studentAService.updateStudent(studentId, name,surname,email);
    }
}
