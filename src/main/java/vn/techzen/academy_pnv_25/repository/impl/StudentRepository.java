package vn.techzen.academy_pnv_25.repository.impl;

import vn.techzen.academy_pnv_25.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentRepository {
    private List<Student> students = new ArrayList<>(
            Arrays.asList(
                    new Student(1, "Nguyen Van Duc", 9.6),
                    new Student(2, "Hoang Nhat Tan", 9.5)
            )
    );
    public List<Student> getStudents() {
        return students;
    }
    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Student save(Student student) {
        student.setId((int) (Math.random() * 100000));
        students.add(student);
        return student;
    }
}
