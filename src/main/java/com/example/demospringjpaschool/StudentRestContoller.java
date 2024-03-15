package com.example.demospringjpaschool;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentRestContoller {

  private final StudentRepository studentRepository;

  public StudentRestContoller(StudentRepository studentRepository) {
    this.studentRepository = studentRepository;
  }

  @DeleteMapping("/student")
  public void deleteStudent(Long id) {
    studentRepository.deleteById(id);
  }

  @PostMapping("/student")
  public Student createStudent(Student student) {
    return studentRepository.save(student);
  }

  @PutMapping("/student")
  public Student updateStudent(Student student) {
    return studentRepository.save(student);
  }

  @GetMapping("/students")
  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

}
