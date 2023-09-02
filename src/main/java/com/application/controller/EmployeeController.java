package com.application.controller;

import com.application.dto.EmployeeDTO;
import com.application.dto.InventoryDTO;
import com.application.entity.Employee;
import com.application.mapper.InventoryToInventoryDtoMapper;
import com.application.repository.InventoryRepository;
import com.application.service.EmployeeService;
import com.application.service.MapperService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final InventoryRepository inventoryRepository;
    private final MapperService mapperService;
    private final InventoryToInventoryDtoMapper inventoryToInventoryDtoMapper;

    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return new ResponseEntity<>("Added", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable long id) {
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    @GetMapping("/servicetest/{id}")
    public InventoryDTO getInventory(@PathVariable long id) {
        return mapperService.toDto(inventoryRepository.findById(id));
    }

    @GetMapping("/mappertest/{id}")
    public InventoryDTO getInventoryById(@PathVariable long id) {
        return inventoryToInventoryDtoMapper.map(inventoryRepository.findById(id));
    }
}