package vn.techzen.academy_pnv_25.repository;

import vn.techzen.academy_pnv_25.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
}
