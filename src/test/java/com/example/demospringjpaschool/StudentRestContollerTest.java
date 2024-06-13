package com.example.demospringjpaschool;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest
class StudentRestContollerTest {

  @Autowired
  MockMvc mockMvc;

  @MockBean
  StudentRepository studentRepository;

  @Test
  void deleteStudent() throws Exception {
    mockMvc.perform(
        delete("/student").param("id", "1"))
        .andExpect(status().isOk());
  }

  @Test
  void createStudent() throws Exception {
    mockMvc.perform(
        post("/student").param("name", "John"))
        .andExpect(status().isOk());
  }

  @Test
  void updateStudent() throws Exception {
    mockMvc.perform(
        MockMvcRequestBuilders.put("/student").param("name", "John"))
        .andExpect(status().isOk());
  }

  @Test
  void getStudents() throws Exception {
    when(studentRepository.findAll()).thenReturn(
        java.util.Arrays.asList(new Student(1L, "John")));

    mockMvc.perform(
            get("/students"))
        .andExpect(status().isOk())
        .andExpect(content().json("[{\"id\":1,\"name\":\"John\"}]"));
  }
}
