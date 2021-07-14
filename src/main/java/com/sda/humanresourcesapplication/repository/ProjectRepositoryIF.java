package com.sda.humanresourcesapplication.repository;

import com.sda.humanresourcesapplication.model.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProjectRepositoryIF extends CrudRepository<Project, Integer> {
    List<Project> findAllByBudget(double x);
}
