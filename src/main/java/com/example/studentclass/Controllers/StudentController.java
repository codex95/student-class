package com.example.studentclass.Controllers;

import com.example.studentclass.Models.Status;
import com.example.studentclass.Models.Student;
import com.example.studentclass.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //GET student By Id
    @GetMapping(path = "{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") Long id){
        return new ResponseEntity<>(this.studentService.getStudentById(id), HttpStatus.OK);
    }


    //Get list of all active students
    @GetMapping
    public ResponseEntity<Student> getAllActiveStudents(@RequestParam(name = "status", required = false)Status status) {
        return new ResponseEntity<>(this.studentService.getAllActiveStudents(status), HttpStatus.OK );
    }

    
    //POST Student
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student newStudent){
        return new ResponseEntity<>(this.studentService.createNewStudent(newStudent), HttpStatus.CREATED );
    }


}
