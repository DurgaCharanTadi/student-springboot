package com.projects.springboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class studentService {

    private final studentRepository studentRepository;

    @Autowired
    public studentService(studentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<student> getStudents(){
        System.out.println("In GET Call");
        return studentRepository.findAll();
    }

    public void addNewStudent(student student) {
        Optional<student> studentOptional = studentRepository.findStudentbyEmail(student.getEmail());

        if(studentOptional.isPresent()) {
            throw new IllegalStateException("Student emails already exists");
        }else{
            studentRepository.save(student);
        }
        System.out.println(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);

        if(!exists){
            throw new IllegalStateException("student with Id: " + studentId + " doesn't exists.");
        }

        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, student studentObj) {

        student studentRecord = studentRepository.findById(studentId).orElseThrow(
                ()-> new IllegalStateException("Student with Id: "+ studentId + " doesn't exists."));

        System.out.println("Inside PUT Method");
        System.out.println(studentRepository.findById(studentId));

        System.out.println(studentObj.getName());
        System.out.println(studentObj.getEmail());
        System.out.println(studentObj.getDob());

        studentRecord.setEmail(studentObj.getEmail());
        studentRecord.setDob(studentObj.getDob());
        studentRecord.setName(studentObj.getName());
    }
}

