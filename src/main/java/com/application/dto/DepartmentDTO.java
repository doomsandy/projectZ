package com.application.dto;

import com.application.entity.Department;

public class DepartmentDTO {

    private String name;

    public DepartmentDTO(String name) {
        this.name = name;
    }

    public DepartmentDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static DepartmentDTO fromDepartment(Department department) {
        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setName(department.getName());
        return departmentDTO;
    }
}