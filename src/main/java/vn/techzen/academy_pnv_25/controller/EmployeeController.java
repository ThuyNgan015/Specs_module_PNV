package vn.techzen.academy_pnv_25.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techzen.academy_pnv_25.dto.ApiResponse;
import vn.techzen.academy_pnv_25.dto.exception.AppException;
import vn.techzen.academy_pnv_25.dto.exception.ErrorCode;
import vn.techzen.academy_pnv_25.model.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:8082")
public class EmployeeController {

    private List<Employee> employees = new ArrayList<>();

    // Constructor để thêm dữ liệu mẫu
    public EmployeeController() {
        employees.add(new Employee(1L, "Thùy Ngân", "15/10/2004", "Nữ", 76000000L));
        employees.add(new Employee(2L, "Kiều Nhan", "20/05/1999", "Nữ", 12300000L));
        employees.add(new Employee(3L, "Lê Văn Sỹ", "30/07/2000", "Nam", 31400000L));
        employees.add(new Employee(4L, "Phạm Nhàn", "05/07/2003", "Nữ", 42300000L));
        employees.add(new Employee(5L, "J97", "25/09/1995", "Nam", 5000000L));
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employees;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getEmployeeById(@PathVariable Long id) {
        Employee employee = employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new AppException(ErrorCode.EMPLOYEE_NOT_FOUND));
        return ResponseEntity.ok(new ApiResponse(true, "Employee found: " + employee.getName()));
    }

    @PostMapping
    public ResponseEntity<ApiResponse> addEmployee(@RequestBody Employee employee) {
        employee.setId((long) (employees.size() + 1));
        employees.add(employee);
        return new ResponseEntity<>(new ApiResponse(true, "Employee created successfully!"), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                employee.setName(updatedEmployee.getName());
                employee.setBirthDate(updatedEmployee.getBirthDate());
                employee.setGender(updatedEmployee.getGender());
                employee.setSalary(updatedEmployee.getSalary());
                return employee;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteEmployee(@PathVariable Long id) {
        boolean removed = employees.removeIf(employee -> employee.getId().equals(id));
        if (!removed) {
            throw new AppException(ErrorCode.EMPLOYEE_NOT_FOUND);
        }
        return new ResponseEntity<>(new ApiResponse(true, "Employee deleted successfully!"), HttpStatus.NO_CONTENT);
    }
}
