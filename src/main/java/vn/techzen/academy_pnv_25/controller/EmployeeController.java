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
import java.util.UUID;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:8082")
public class EmployeeController {

    private List<Employee> employees = new ArrayList<>();

    // Constructor để thêm dữ liệu mẫu
    public EmployeeController() {
        new Employee(UUID.randomUUID(), "Thùy Ngân", "15/10/2004", "Nữ", 76000000L);
        new Employee(UUID.randomUUID(), "Kiều Nhan", "20/05/1999", "Nữ", 12300000L);
        new Employee(UUID.randomUUID(), "Lê Văn Sỹ", "30/07/2000", "Nam", 31400000L);
        new Employee(UUID.randomUUID(), "Phạm Nhàn", "05/07/2003", "Nữ", 42300000L);
        new Employee(UUID.randomUUID(), "J97", "25/09/1995", "Nam", 5000000L);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll (){
        return ResponseEntity.ok(employees);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable UUID id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        employee.setId(UUID.randomUUID());
        employees.add(employee);
        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable UUID id, @RequestBody Employee employee) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .map(
                        e ->{
                            e.setName(employee.getName());
                            e.setBirthDate(employee.getBirthDate());
                            e.setGender(employee.getGender());
                            e.setSalary(employee.getSalary());
                            return ResponseEntity.ok(e);
                        }
                )
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable UUID id) {
        return employees.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .map(e -> {
                    employees.remove(e);
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
