package com.application.mapper;

import com.application.dto.InventoryDTO;
import com.application.entity.Inventory;

public interface Mapper<E extends Inventory, D extends InventoryDTO> {
    D toDto(E entity);
    E toEntity(D dto);
}