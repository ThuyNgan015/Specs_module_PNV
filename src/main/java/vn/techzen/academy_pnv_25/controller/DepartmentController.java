package vn.techzen.academy_pnv_25.controller;

import vn.techzen.academy_pnv_25.dto.ApiResponse;
import vn.techzen.academy_pnv_25.dto.JsonResponse;
import vn.techzen.academy_pnv_25.dto.exception.AppException;
import vn.techzen.academy_pnv_25.dto.exception.ErrorCode;
import vn.techzen.academy_pnv_25.entity.Department;
import vn.techzen.academy_pnv_25.service.IDepartmentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/department")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DepartmentController {
    IDepartmentService departmentService;

    @GetMapping("")
    public ResponseEntity<?> getAllDepartments() {
        return JsonResponse.ok(departmentService.getAllDepartments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDepartment(@PathVariable int id) {
        Optional<Department> department = departmentService.getDepartment(id);

        if (department != null) {
            return JsonResponse.ok(department);
        } else {
            throw new AppException(ErrorCode.DEPARTMENT_NOT_EXIST);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> addDepartment(@RequestBody Department dp) {
        return JsonResponse.created(departmentService.addDepartment(dp));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Department>> updateEmployee(@PathVariable int id, @RequestBody Department updatedData) {
        Department department = departmentService.updateDepartment(id, updatedData);

        if (department != null) {
            return JsonResponse.ok(department);
        } else {
            throw new AppException(ErrorCode.DEPARTMENT_NOT_EXIST);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable int id) {
        departmentService.deleteDepartment(id);
        return JsonResponse.noContent();
    }
}
