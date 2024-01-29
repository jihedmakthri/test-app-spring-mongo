package org.example.devopstestspring.servicesimpl;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.example.devopstestspring.dtos.StudentDTO;
import org.example.devopstestspring.entities.Student;
import org.example.devopstestspring.iservices.IStudentService;
import org.example.devopstestspring.repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements IStudentService {

    StudentRepository studentRepository;

    ModelMapper mapper;

    @Override
    public ResponseEntity<Student> addStudent(StudentDTO studentDTO) {

        Student student = this.mapper.map(studentDTO, Student.class);
        student.setFirst_name(studentDTO.getFirst_name());
        student.setFamily_name(studentDTO.getFamily_name());
        student.setEmail_address(studentDTO.getEmail_address());
        studentRepository.save(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    @Override
    public ResponseEntity<List<Student>> retrieveStudents() {
        return ResponseEntity.status(HttpStatus.FOUND).body(studentRepository.findAll());
    }

    @Override
    public ResponseEntity<String> deleteStudent(String id) {
        studentRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("ITEM DELETED WITH KEY "+id);
    }
}
