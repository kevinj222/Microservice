package com.example.SpringBootTestDemo.StudentControllerTest;

import com.example.SpringBootTestDemo.controller.StudentController;
import com.example.SpringBootTestDemo.entity.Student;
import com.example.SpringBootTestDemo.service.StudentServices;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(StudentController.class)
public class StudentTestController {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private StudentServices studentServices;
    private Student student;

    @BeforeEach
    void setup() {
        student = new Student(1, "finla", "Thrissur", "245242");
    }

    @Test
    void testSaveStudent() throws Exception {
        Student student = new Student(1, "Finla", "Thrissur", "245242");
        Mockito.when(studentServices.addStudent(student)).thenReturn(student);
        mockMvc.perform(MockMvcRequestBuilders.post("/student/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\r\n" +
                                " \"id\" : 1, \r\n" +
                                " \"name\" : \"Finla\", \r\n" +
                                " \"address\" :\"Thrissur\", \r\n" +
                                " \"rollNo\" : \"245242\" \r\n" + "}"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
