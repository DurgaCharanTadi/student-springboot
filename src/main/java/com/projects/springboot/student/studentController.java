package com.projects.springboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
public class studentController {

    private final studentService studentServ;

    @Autowired
    public studentController(studentService studentServ) {
        this.studentServ = studentServ;
    }

    @GetMapping
    public List<student> getStudents(){
        return studentServ.getStudents();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody student student){
        studentServ.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId){
        studentServ.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(@PathVariable("studentId") Long studentId, @RequestBody student student){
        studentServ.updateStudent(studentId, student);
    }
}
