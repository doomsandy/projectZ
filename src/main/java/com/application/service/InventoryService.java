package com.application.service;

import com.application.dto.InventoryDTO;
import com.application.entity.Inventory;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class MapperService {
    private final Map<String, Mapper<?, ?>> mapperMap;

    public MapperService(List<Mapper<?, ?>> mappers) {
        this.mapperMap = new HashMap<>();
        for (Mapper<?, ?> mapper : mappers) {
            mapperMap.put(mapper.getClass().getSimpleName(), mapper);
        }
    }

    public <E extends Inventory, D extends InventoryDTO> D convertEntityToDto(E entity) {
        Mapper mapper = mapperMap.get(entity.getClass().getSimpleName());
        return mapper.toDto(entity);
    }
}



