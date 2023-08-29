package com.application.mapper;

import com.application.dto.InventoryDTO;
import com.application.entity.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface InventoryMapper extends com.application.mapper.Mapper<Inventory, InventoryDTO> {

    InventoryMapper INSTANCE = Mappers.getMapper(InventoryMapper.class);

    @Override
    InventoryDTO toDto(Inventory entity);

    @Override
    Inventory toEntity(InventoryDTO dto);
}