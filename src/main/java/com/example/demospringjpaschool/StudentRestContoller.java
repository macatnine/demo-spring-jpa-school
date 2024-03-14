package com.example.demospringjpaschool;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestContoller {

  private final StudentRepository studentRepository;

  public StudentRestContoller(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @PostMapping("/student")
  public Student createStudent(Student student) {
    return studentRepository.save(student);
  }

  @GetMapping("/students")
  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

}
