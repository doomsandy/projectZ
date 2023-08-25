package com.application.mapper;

import com.application.dto.InventoryDTO;
import com.application.entity.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InventoryToInventoryDtoMapper extends com.application.mapper.Mapper<Inventory, InventoryDTO> {

    InventoryToInventoryDtoMapper INSTANCE = Mappers.getMapper(InventoryToInventoryDtoMapper.class);

    @Override
    InventoryDTO map(Inventory entity);

    @Override
    default Class<Inventory> getMyClass() {
        return Inventory.class;
    }
}