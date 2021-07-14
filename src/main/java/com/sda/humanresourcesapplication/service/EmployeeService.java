package com.sda.humanresourcesapplication.service;

import com.sda.humanresourcesapplication.model.Employee;
import com.sda.humanresourcesapplication.model.Project;
import com.sda.humanresourcesapplication.repository.EmployeeRepositoryIF;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class EmployeeService {
    @Autowired
    private EmployeeRepositoryIF employeeRepositoryIF;

    public Employee saveEmployee(Employee employee) {
        employeeRepositoryIF.save(employee);
        log.info("Employee have been saved.");
        return employee;
    }

    public Integer deleteEmployeesWithSalariesBetween(Integer x, Integer y) {
        return employeeRepositoryIF.deleteEmployeeBySalaryIsBetween(x, y);
    }

    public List<Employee> findAllEmployeesByProjects(Set<Project> projectSet) {
        return employeeRepositoryIF.findEmployeeByProjectsEquals(projectSet);
    }
}
