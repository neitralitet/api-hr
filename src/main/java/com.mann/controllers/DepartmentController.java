package com.mann.controllers;

import com.mann.exception.ResourceNotFoundException;
import com.mann.model.Department;
import com.mann.model.Employee;
import com.mann.repository.DepartmentRepository;
import com.mann.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vladimir Mann
 */


@RestController
@RequestMapping("/api/v1")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/departments")
    public List<Department> getAllDepartment() {

        return this.departmentRepository.findAll();
    }

    @GetMapping("/department/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable(value = "id") Integer departmentId) throws ResourceNotFoundException {
        Department department = departmentRepository.findById(departmentId).
                orElseThrow(() -> new ResourceNotFoundException("Department not found for this id::" + departmentId));

        return ResponseEntity.ok().body(department);
    }

    @PostMapping("/department")
    public Department createDepartment(@RequestBody Department department) {

        return this.departmentRepository.save(department);
    }

    @PutMapping("/department/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable(value = "id") Integer departmentId,
                                                   @Valid @RequestBody Department departmentDetails) throws ResourceNotFoundException {

        Department department = departmentRepository.findById(departmentId).
                orElseThrow(() -> new ResourceNotFoundException("Department not found for this id::" + departmentId));

        department.setId(departmentDetails.getId());
        department.setDepartmentName(departmentDetails.getDepartmentName());

        final Department updatedDepartment = departmentRepository.save(department);
        return ResponseEntity.ok(updatedDepartment);
    }

    @DeleteMapping("/department/{id}")
    public Map<String, Boolean> deleteDepartment(@PathVariable(value = "id") Integer departmentId) throws ResourceNotFoundException {
        Department department= departmentRepository.findById(departmentId).
                orElseThrow(() -> new ResourceNotFoundException("Department not found for this id::" + departmentId));
        this.departmentRepository.delete(department);

        Map<String, Boolean> respons = new HashMap<>();
        respons.put("deleted", Boolean.TRUE);

        return respons;
    }
}
