package com.application.repository;

import com.application.entity.Employee;
import com.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee save(Employee employee);
    Employee findAllById(long id);
}
