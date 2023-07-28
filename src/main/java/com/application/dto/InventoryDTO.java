package com.application.dto;

import com.application.entity.Chair;
import com.application.entity.Inventory;
import com.application.entity.Mouse;

import java.util.HashSet;
import java.util.Set;

public class InventoryDTO {
    private int cost;
    private int depreciation;

    public InventoryDTO() {
    }

    public InventoryDTO(int cost, int depreciation) {
        this.cost = cost;
        this.depreciation = depreciation;
    }

    public InventoryDTO(int cost, int depreciation, MouseDTO mouseDTO) {

    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getDepreciation() {
        return depreciation;
    }

    public void setDepreciation(int depreciation) {
        this.depreciation = depreciation;
    }

    public static InventoryDTO fromInventory(Inventory inventory) {
        int cost = inventory.getCost();
        int depreciation = inventory.getDepreciation();
        if (inventory instanceof Mouse) {
            Mouse mouse = (Mouse) inventory;
            return new MouseDTO(cost, depreciation, mouse.getSensorType());
        }
        if (inventory instanceof Chair) {
            Chair chair = (Chair) inventory;
            return new ChairDTO(cost, depreciation, chair.getColor(), chair.getType());
         }
        return new InventoryDTO(cost, depreciation);
    }

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