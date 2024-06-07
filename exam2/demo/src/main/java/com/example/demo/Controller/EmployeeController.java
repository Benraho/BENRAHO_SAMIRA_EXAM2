package com.example.demo.Controller;

import com.example.demo.Entities.Employee;
import com.example.demo.Entities.Project;

import com.example.demo.Services.EmployeeService;
import com.example.demo.Services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ProjectService projectService;

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> employees = employeeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employee_list";
    }

    @GetMapping("/affectation")
    public String showAffectationForm(@RequestParam("id") Long employeeId, Model model) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        List<Project> projects = projectService.getAllProjects();
        model.addAttribute("employee", employee);
        model.addAttribute("projects", projects);
        return "employee_affectation";
    }

    @PostMapping("/affect")
    public String affectEmployeeToProject(@RequestParam Long employeeId, @RequestParam Long projectId, @RequestParam int implication) {
        employeeService.affectEmployeeToProject(employeeId, projectId, implication);
        return "redirect:/employees/list";
    }
}
