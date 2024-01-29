package org.example.devopstestspring.servicesimpl;

import org.example.devopstestspring.entities.Student;
import org.example.devopstestspring.repositories.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {StudentServiceImpl.class})
class StudentServiceImplTest {

    @InjectMocks
    private StudentServiceImpl  studentService;

    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    void retrieveStudents() {
        ResponseEntity<List<Student>> students = new ResponseEntity<>(new ArrayList<>(), HttpStatus.OK);
        when(studentRepository.findAll()).thenReturn(students.getBody());
        ResponseEntity<List<Student>> result = studentService.retrieveStudents();
        assertEquals(students.getBody(), result.getBody());
    }

}