package com.example.aug2023.controller;

import com.example.aug2023.model.Student;
import com.example.aug2023.service.StudentService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class StudentControllerTest {

    @InjectMocks
    StudentController studentController;

    @Mock
    StudentService studentService;

    private Student student;

    @BeforeEach
    public void doSetUp(){
        System.out.println("CREATING THE TEST DATA");
        student = new Student();
        student.setRollno(1);
        student.setCity("TESTCITY");
        student.setName("TESTNAME");
    }

    @Test
    void getAllStudents() {
    }

    @Test
    void getStudentByRollno() {

        when(studentService.getStudentByRollno(anyInt())).thenReturn(student);

        ResponseEntity<Object> response = studentController.getStudentByRollno(1);
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(1, ((Student)response.getBody()).getRollno());

    }

    @Test
    void getStudentByRollnoStudentDoesntExist() {

        when(studentService.getStudentByRollno(anyInt())).thenReturn(new Student());

        ResponseEntity<Object> response = studentController.getStudentByRollno(1);
        assertNotNull(response);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("STUDENT DOESN'T EXIST", response.getBody());

    }

    @Test
    void getStudentsByName() {
    }

    @Test
    void addStudent() {
    }

    @Test
    void deleteStudent() {
    }

    @Test
    void handleFileUpload() {
    }

    @Test
    void getAllEmployeesInCsv() {
    }
}