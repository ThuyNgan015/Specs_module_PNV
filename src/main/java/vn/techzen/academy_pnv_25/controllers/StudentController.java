package vn.techzen.academy_pnv_25.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_pnv_25.models.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Nguyen Van Duc", 9.6),
                    new Student(2, "Hoang Nhat Tan", 9.5)
            )
    );

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        for (Student student : students){
            if (student.getId() == id) {
                return ResponseEntity.ok(student);
            }
        }
        return null;
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        student.setId((int) (Math.random() * 100000));
        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}
