package com.sda.humanresourcesapplication.service;

import com.sda.humanresourcesapplication.model.Department;
import com.sda.humanresourcesapplication.model.Employee;
import com.sda.humanresourcesapplication.repository.DepartmentRepositoryIF;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DepartmentService {
    @Autowired
    private DepartmentRepositoryIF departmentRepositoryIF;

    public Department saveDepartment(Department department) {
        departmentRepositoryIF.save(department);
        log.info("Department saved successfully");
        return department;
    }

    public Integer deleteById(Integer id) {
        Integer department = departmentRepositoryIF.deleteDepartmentById(id);
        if (department == 0) {
            log.warn("Department has not been deleted");
        } else {
            log.info("Department with id: " + id + " has been deleted.");

        }
        return department;
    }

    public Integer deleteByName(String name) {
        Integer department = departmentRepositoryIF.deleteDepartmentByName(name);
        if (department == 0) {
            log.warn("Department has not been deleted");
        } else {
            log.info("Department with id: " + department + " has been deleted.");
        }
        return department;
    }

    public Department findDepartmentWithEmployeeList(List<Employee> employeeList) {
        return departmentRepositoryIF.findDepartmentByEmployeeList(employeeList);
    }
}
