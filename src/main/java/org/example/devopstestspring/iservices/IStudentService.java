package org.example.devopstestspring.iservices;


import org.example.devopstestspring.dtos.StudentDTO;
import org.example.devopstestspring.entities.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IStudentService {

    ResponseEntity<Student> addStudent(StudentDTO studentDTO);
    ResponseEntity<List<Student>> retrieveStudents();
    ResponseEntity<String> deleteStudent(String id);
}
