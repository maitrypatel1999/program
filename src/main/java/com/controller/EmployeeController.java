package com.controller;

import com.entity.Employee;
import com.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("")
    List<Employee> employees() {
        return employeeService.employees();
    }

    @GetMapping("/highest")
    Employee getEmployeeHighestSalary() {
        return employeeService.getEmployeeHighestSalary();
    }

    @GetMapping("/lowest")
    Employee getEmployeeLowestSalary() {
        return employeeService.getEmployeeLowestSalary();
    }

    @GetMapping("/{id}")
    Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("")
    Employee createEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("")
    Employee updateOrCreateEmployee(@RequestBody Employee employee) {
        return employeeService.updateOrCreateEmployee(employee);
    }

    @DeleteMapping("/{id}")
    void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }
}
