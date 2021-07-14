package com.sda.humanresourcesapplication.repository;

import com.sda.humanresourcesapplication.model.Employee;
import com.sda.humanresourcesapplication.model.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Set;

public interface EmployeeRepositoryIF extends CrudRepository<Employee, Integer> {
    Integer deleteEmployeeBySalaryIsBetween(Integer x, Integer y);

    List<Employee> findEmployeeByProjectsEquals(Set<Project> projectSet);
}
