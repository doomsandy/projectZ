package com.application.service;

import com.application.dto.EmployeeDTO;
import com.application.entity.Employee;
import com.application.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void addEmployee(Employee employee) {

        employeeRepository.save(employee);

    }

    public EmployeeDTO getEmployee(long id) {
        return EmployeeDTO.fromEmployee(employeeRepository.findById(id));
    }

}
