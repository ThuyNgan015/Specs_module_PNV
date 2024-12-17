package vn.techzen.academy_pnv_25.service;

import vn.techzen.academy_pnv_25.entity.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll(String name, Double fromScore, Double toScore);

    Student findById(int id);

    Student save(Student student);
}