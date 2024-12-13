package vn.techzen.academy_pnv_25.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_pnv_25.dto.ApiResponse;
import vn.techzen.academy_pnv_25.dto.exception.AppException;
import vn.techzen.academy_pnv_25.dto.exception.ErrorCode;
import vn.techzen.academy_pnv_25.model.Student;

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
    public ResponseEntity<ApiResponse<Student>> getStudent(@PathVariable int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return ResponseEntity.ok(ApiResponse.<Student>builder()
                        .data(student)
                        .build());
            }
        }
        throw new AppException(ErrorCode.TEACHER_NOT_EXIST);
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        student.setId((int) (Math.random() * 1000000));
        students.add(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }
}