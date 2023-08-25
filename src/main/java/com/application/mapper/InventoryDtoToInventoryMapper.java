package com.application.mapper;

import com.application.dto.InventoryDTO;
import com.application.entity.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InventoryDtoToInventoryMapper extends com.application.mapper.Mapper<InventoryDTO, Inventory> {

    InventoryDtoToInventoryMapper INSTANCE = Mappers.getMapper(InventoryDtoToInventoryMapper.class);

    @Override
    Inventory map(InventoryDTO entity);

    @Override
    default Class<InventoryDTO> getMyClass() {
        return InventoryDTO.class;
    }
}
