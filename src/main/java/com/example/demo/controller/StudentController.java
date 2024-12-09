package com.example.demo.controller;

import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.StudentService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/students")
//This annotation shows that anything under it is a route
public class StudentController {
    private final StudentService service;

    @Autowired
    public StudentController(StudentService service){
        this.service = service;
    }
//create (adding a new student)
@PostMapping("/students")
//@PreAuthorize("hasRole('role_user') or hasRole('role_admin')")
public ResponseEntity<Student> createStudent(@RequestBody Student student) {
    Student createdStudent = service.createStudent(student);
    return ResponseEntity.ok(createdStudent);
}


//read (getting all students)
@GetMapping("/students")
//@PreAuthorize("hasRole(role_user)")
public ResponseEntity<List<Student>> getAllStudents() {
    List<Student> students = service.readStudents();
    return ResponseEntity.ok(students);
}

    
//read (getting a student by id)
@GetMapping("api/students/{id}")
//@PreAuthorize("hasRole('role_admin')")
public ResponseEntity<Student> getStudentById(@PathVariable int id) {
    Optional<Student> student = service.getOneStudent(id);
    return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
}

//update(editing an existing student's details)
@PutMapping("api/students/{id}")
//@PreAuthorize("hasRole(role_user)")
public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student) {
    Student updatedStudent = service.updateStudent(id, student);
    return updatedStudent != null ? ResponseEntity.ok(updatedStudent) : ResponseEntity.notFound().build();
}

//delete
@DeleteMapping("api/students/{id}")
public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
    service.deleteStudent(id);
    return ResponseEntity.noContent().build();
}
}
