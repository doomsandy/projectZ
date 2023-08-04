package com.application.mapper;

import com.application.dto.EmployeeDTO;
import com.application.entity.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    @Mapping(source = "positions", target = "positions")
    @Mapping(source = "department", target = "department")
    @Mapping(source = "inventories", target = "inventories")
    EmployeeDTO toDTO(Employee employee);
}