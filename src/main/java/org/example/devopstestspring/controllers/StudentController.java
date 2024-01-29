package org.example.devopstestspring.controllers;

import lombok.AllArgsConstructor;
import org.example.devopstestspring.dtos.StudentDTO;
import org.example.devopstestspring.entities.Student;
import org.example.devopstestspring.iservices.IStudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    IStudentService iStudentService;

    @PostMapping("/create")
    public ResponseEntity<Student> create_student(@RequestBody StudentDTO studentDTO){
        return iStudentService.addStudent(studentDTO);
    }

    @GetMapping("/retrieve")
    public ResponseEntity<List<Student>> retrieve_students(){
        return iStudentService.retrieveStudents();
    }

    @DeleteMapping( "/delete/{id}")
    public ResponseEntity<String> remove_student(@PathVariable("id") String id){
        return iStudentService.deleteStudent(id);
    }

}
