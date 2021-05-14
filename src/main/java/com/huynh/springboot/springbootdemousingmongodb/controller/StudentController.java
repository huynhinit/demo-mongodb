package com.huynh.springboot.springbootdemousingmongodb.controller;

import com.huynh.springboot.springbootdemousingmongodb.model.Students;
import com.huynh.springboot.springbootdemousingmongodb.repository.StudentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    private ResponseEntity<List<Students>> getAllStudent() {
        List<Students> list = studentRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{phone}")
    private ResponseEntity<Students> findByPhone(@PathVariable("phone") String phone) {
        Students st = studentRepository.findByPhone(phone).get();
        return new ResponseEntity<>(st, HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Students> createStudent(@RequestBody Students students) {
        Students st = studentRepository.insert(students);
        return new ResponseEntity<>(st, HttpStatus.OK);
    }

    @PutMapping("/{phone}")
    private ResponseEntity<Students> updateStudent(@PathVariable("phone") String phone, @RequestBody Students students) {

        Students students1 = studentRepository.findByPhone(phone).get();

        students1.setName(students.getName());
        students1.setPhone(students.getPhone());
        students1.setDateLogin(students.getDateLogin());

        Students st = studentRepository.save(students1);
        return new ResponseEntity<>(st, HttpStatus.OK);
    }

    @DeleteMapping("/{phone}")
    private ResponseEntity<?> deleteStudent(@PathVariable("phone") String phone) {
        Students students = studentRepository.findByPhone(phone).get();
        studentRepository.delete(students);
        return new ResponseEntity<>("Xoa OK", HttpStatus.OK);
    }

}































