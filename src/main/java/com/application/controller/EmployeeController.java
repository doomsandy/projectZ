package com.application.controller;

import com.application.entity.Employee;
import com.application.service.EmployeeService;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return new ResponseEntity<>("Added", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getEmployee(@PathVariable long id) {
        Employee employee = employeeService.getEmployee(id);
        return new ResponseEntity<>(employee.toString(), HttpStatus.OK);
    }
}