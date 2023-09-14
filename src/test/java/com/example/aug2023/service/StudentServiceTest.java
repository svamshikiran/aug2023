package com.example.aug2023.service;

import com.example.aug2023.model.Student;
import com.example.aug2023.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
class StudentServiceTest {

    @InjectMocks
    StudentService studentService;

    @Mock
    StudentRepository studentRepository;

    private Student student;

    @BeforeEach
    void setUp() {
        System.out.println("CREATING THE TEST DATA");
        student = new Student();
        student.setRollno(1);
        student.setCity("TESTCITY");
        student.setName("TESTNAME");
    }

    @Test
    void getStudentByRollno() {
        doReturn(Optional.of(student)).when(studentRepository).findById(anyInt());

        Student actualStudent = studentService.getStudentByRollno(1);
        assertNotNull(actualStudent);
        assertEquals(1, actualStudent.getRollno());
    }

    @Test
    void getStudentByRollnoStudentDoesntExist() {
        doReturn(Optional.empty()).when(studentRepository).findById(anyInt());

        //doNothing(Optional.empty()).when(studentRepository).findById(anyInt());

        //doThrow(IllegalStateException.class).when(studentRepository).findById(anyInt());

        Student actualStudent = studentService.getStudentByRollno(1);
        assertNotNull(actualStudent);
        assertEquals(0, actualStudent.getRollno());
    }
}