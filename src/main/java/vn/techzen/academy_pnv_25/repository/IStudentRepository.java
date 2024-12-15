package vn.techzen.academy_pnv_25.repository;

import vn.techzen.academy_pnv_25.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();

    Student findById(int id);

    Student save(Student student);
}