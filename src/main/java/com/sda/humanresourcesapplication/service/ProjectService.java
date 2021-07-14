package com.sda.humanresourcesapplication.service;

import com.sda.humanresourcesapplication.model.Project;
import com.sda.humanresourcesapplication.repository.ProjectRepositoryIF;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProjectService {
    @Autowired
    private ProjectRepositoryIF projectRepositoryIF;

    public Project saveProject(Project project) {
        projectRepositoryIF.save(project);
        log.info("Project saved");
        return project;
    }

    public List<Project> findAllProjectsWithBudget(double x) {
        return projectRepositoryIF.findAllByBudget(x);
    }
}
