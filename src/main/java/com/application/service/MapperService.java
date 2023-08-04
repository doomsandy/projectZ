package com.application.service;

import com.application.dto.InventoryDTO;
import com.application.entity.Inventory;
import org.springframework.stereotype.Service;
import com.application.mapper.Mapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MapperService {
    private final Map<String, Mapper<?, ?>> mapperMap;

    public MapperService(List<Mapper<?, ?>> mappers) {
        this.mapperMap = new HashMap<>();
        for (Mapper<?, ?> mapper : mappers) {
            mapperMap.put(mapper.getClass().getSimpleName(), mapper);
        }
    }

    public <E extends Inventory, D extends InventoryDTO> D toDto(E entity) {
        Mapper<E, D> mapper = (Mapper<E, D>) mapperMap.get(entity.getClass().getSimpleName());
        return mapper.toDto(entity);
    }
}