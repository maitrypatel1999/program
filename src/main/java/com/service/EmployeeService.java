package com.service;

import com.entity.Employee;
import com.errors.ItemNotFoundException;
import com.repo.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> employees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeHighestSalary() {
        return employeeRepository.findTopByOrderBySalaryDesc();
    }

    public Employee getEmployeeLowestSalary() {
        return employeeRepository.findTopByOrderBySalaryAsc();
    }

    public Employee getEmployeeById(Long id) {

        return employeeRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateOrCreateEmployee(Employee employee) {

        return employeeRepository.findById(employee.getId())
                .map(e -> {
                    e.setName(employee.getName());
                    e.setAddress(employee.getAddress());
                    e.setPhone(employee.getPhone());
                    e.setDepartment(employee.getDepartment());
                    e.setSalary(employee.getSalary());
                    return employeeRepository.save(e);
                })
                .orElseGet(() -> {
                    return employeeRepository.save(employee);
                });
    }
}
