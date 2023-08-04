package com.application.dto;

import com.application.entity.Chair;
import com.application.entity.Inventory;
import com.application.entity.Mouse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class InventoryDTO {

    private int cost;
    private int depreciation;

    public static Set<InventoryDTO> fromInventories(Set<Inventory> inventories) {
        Set<InventoryDTO> inventoryDTOS = new HashSet<>();
        for (Inventory inventory : inventories) {
            int cost = inventory.getCost();
            int depreciation = inventory.getDepreciation();
            if (inventory instanceof Mouse) {
                Mouse mouse = (Mouse) inventory;
                inventoryDTOS.add(new MouseDTO(cost, depreciation, mouse.getSensorType()));
            }
            if (inventory instanceof Chair) {
                Chair chair = (Chair) inventory;
                inventoryDTOS.add(new ChairDTO(cost, depreciation, chair.getColor(), chair.getType()));
            }
        }
        return inventoryDTOS;
    }
}