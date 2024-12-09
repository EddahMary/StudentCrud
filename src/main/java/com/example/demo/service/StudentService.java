package com.example.demo.service;

import com.example.demo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.StudentRepository;
import java.util.List;
import java.util.Optional;

@Service
//@Autowired
public class StudentService {
//    private static StudentRepository studentRepository = null;

    @Autowired
//    Used to import a class in another
    public StudentService(){
    }
@Autowired
 StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

//    create operation
    public  Student createStudent(Student student){
        return studentRepository.save(student);
    }

//    read operation
    public  List<Student> readStudents() {
        return studentRepository.findAll();
    }

//    read operation but for one student using their Id
    public  Optional<Student> getOneStudent(int id) {
        return studentRepository.findById(id);
    }

//    update operation
public  Student updateStudent(int id, Student updatedStudent) {
    if (studentRepository.existsById(id)) {
        updatedStudent.setId(id);
        return studentRepository.save(updatedStudent);
    }
    return null;
}

//delete operation
    public  void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }
}

