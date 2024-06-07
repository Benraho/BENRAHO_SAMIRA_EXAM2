package com.example.demo.Services;


import com.example.demo.DAO.EmployeeRepository;
import com.example.demo.DAO.ProjectRepository;
import com.example.demo.Entities.Employee;
import com.example.demo.Entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid employee ID"));
    }

    public void affectEmployeeToProject(Long employeeId, Long projectId, int implication) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new IllegalArgumentException("Invalid employee ID"));
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new IllegalArgumentException("Invalid project ID"));
        // Assume we have a way to set implication percentage in the project
        // This is simplified; normally, you would handle the implication logic in a different way
        employee.getProjects().add(project);
        employeeRepository.save(employee);
    }
}
