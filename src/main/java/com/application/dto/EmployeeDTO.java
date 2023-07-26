package com.application.dto;

import com.application.entity.Employee;
import com.application.entity.Inventory;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class EmployeeDTO {
    private String fullName;
    private LocalDate dateOfBirth;
    private Set<PositionDTO> positionDTOS = new HashSet<>();
    private DepartmentDTO departmentDTO;
    private Set<InventoryDTO> inventoryDTOS = new HashSet<>();

    public EmployeeDTO(String fullName, LocalDate dateOfBirth, Set<PositionDTO> positionDTOS, DepartmentDTO departmentDTO, Set<InventoryDTO> inventoryDTOS) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.positionDTOS = positionDTOS;
        this.departmentDTO = departmentDTO;
        this.inventoryDTOS = inventoryDTOS;
    }

    public EmployeeDTO() {
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Set<PositionDTO> getPositions() {
        return positionDTOS;
    }

    public void setPositions(Set<PositionDTO> positionDTOS) {
        this.positionDTOS = positionDTOS;
    }

    public DepartmentDTO getDepartment() {
        return departmentDTO;
    }

    public void setDepartment(DepartmentDTO departmentDTO) {
        this.departmentDTO = departmentDTO;
    }

    public Set<InventoryDTO> getInventories() {
        return inventoryDTOS;
    }

    public void setInventories(Set<InventoryDTO> inventoryDTOS) {
        this.inventoryDTOS = inventoryDTOS;
    }

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
