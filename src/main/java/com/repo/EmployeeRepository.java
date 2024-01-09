package com.repo;

import com.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findTopByOrderBySalaryDesc();
    Employee findTopByOrderBySalaryAsc();
}
