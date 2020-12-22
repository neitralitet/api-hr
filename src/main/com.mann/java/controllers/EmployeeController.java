package controllers;

import exception.ResourceNotFoundException;
import model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import repository.EmployeeRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Vladimir Mann
 */

@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("employees")
    public List<Employee> getAllEmployee() {

        return this.employeeRepository.findAll();
    }

    @GetMapping("employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Integer employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id::" + employeeId));

        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("employee")
    public Employee createEmployee(@RequestBody Employee employee) {

        return this.employeeRepository.save(employee);
    }

    @PutMapping("employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Integer employeeId,
                                                   @Validated @RequestBody Employee employeeDetails) throws ResourceNotFoundException {

        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id::" + employeeId));

        employee.setId(employeeDetails.getId());
        employee.setName(employeeDetails.getName());
        employee.setSecondName(employeeDetails.getSecondName());
        employee.setPatronymicName(employeeDetails.getPatronymicName());
        employee.setDateOfBirth(employeeDetails.getDateOfBirth());
        employee.setDepartmentId(employeeDetails.getDepartmentId());
        employee.setSalary(employeeDetails.getSalary());

        return ResponseEntity.ok(this.employeeRepository.save(employee));
    }

    @DeleteMapping("employee/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId).
                orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id::" + employeeId));
        this.employeeRepository.delete(employee);

        Map<String, Boolean> respons = new HashMap<>();
        respons.put("deleted", Boolean.TRUE);

        return respons;
    }
}
