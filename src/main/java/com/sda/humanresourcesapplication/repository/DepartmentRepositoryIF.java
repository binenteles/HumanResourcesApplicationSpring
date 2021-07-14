package com.sda.humanresourcesapplication.repository;

import com.sda.humanresourcesapplication.model.Department;
import com.sda.humanresourcesapplication.model.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepositoryIF extends CrudRepository<Department, Integer> {
    Integer deleteDepartmentByName(String name);

    Integer deleteDepartmentById(Integer id);

    Department findDepartmentByEmployeeList(List<Employee> employeeList);
}
