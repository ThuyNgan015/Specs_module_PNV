package vn.techzen.academy_pnv_25.service;

import vn.techzen.academy_pnv_25.dto.EmployeeSearchRequest;
import vn.techzen.academy_pnv_25.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    List<Employee> findByAttributes(EmployeeSearchRequest employeeSearchRequest);
    Employee updateEmployee(int id, Employee updatedData);
    void deleteEmployee(int id);
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployee(int id);
    List<Employee> addEmployee(Employee emp);
}
