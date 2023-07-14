package com.application.service;

import com.application.entity.Employee;
import com.application.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void addEmployee(Employee employee) {

        repository.save(employee);

    }

    public Employee getEmployee(long id) {

        return repository.findAllById(id);

    }

}
