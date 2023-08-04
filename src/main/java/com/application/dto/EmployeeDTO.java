package com.application.dto;

import com.application.entity.Employee;
import com.application.entity.Inventory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeDTO {
    private String fullName;
    private LocalDate dateOfBirth;
    private Set<PositionDTO> positions = new HashSet<>();
    private DepartmentDTO department;
    private Set<InventoryDTO> inventories = new HashSet<>();

    public static EmployeeDTO fromEmployee(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFullName(employee.getFullName());
        employeeDTO.setDateOfBirth(employee.getDateOfBirth());
        employeeDTO.setDepartment(DepartmentDTO.fromDepartment(employee.getDepartment()));
        employeeDTO.setPositions(PositionDTO.fromPositions(employee.getPositions()));
        employeeDTO.setInventories(InventoryDTO.fromInventories(employee.getInventories()));
        return employeeDTO;
    }

}
