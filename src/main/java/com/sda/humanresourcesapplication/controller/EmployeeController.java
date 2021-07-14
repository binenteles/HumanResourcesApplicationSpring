package com.sda.humanresourcesapplication.controller;

import com.sda.humanresourcesapplication.model.Employee;
import com.sda.humanresourcesapplication.model.Project;
import com.sda.humanresourcesapplication.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping(value = "/humanresources/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<String> findAllEmployeesBasedOnProjects(@RequestBody Set<Project> projectSet) {
        List<Employee> employeeList = employeeService.findAllEmployeesByProjects(projectSet);
        log.info("Employees found.");
        log.debug(employeeList.toString());
        return new ResponseEntity<>(employeeList.toString(), HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        log.info(employee.toString());
        return new ResponseEntity<>(employee.toString(), HttpStatus.CREATED);
    }

    @DeleteMapping("/employees")
    @Transactional
    public ResponseEntity<String> deleteEmployee(@RequestParam(value = "minSalary") Integer minSalary,
                                                 @RequestParam(value = "maxSalary") Integer maxSalary) {
        employeeService.deleteEmployeesWithSalariesBetween(minSalary, maxSalary);
        return new ResponseEntity<>("Employees with salary between the specific values", HttpStatus.OK);
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updatedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok(updatedEmployee);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> catchIllegalArgumentException(IllegalArgumentException e) {
        return new ResponseEntity<>("Illegal arguments " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
