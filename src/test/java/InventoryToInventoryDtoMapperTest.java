import com.application.dto.InventoryDTO;
import com.application.entity.Inventory;
import com.application.mapper.InventoryToInventoryDtoMapper;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InventoryToInventoryDtoMapperTest {
    private InventoryToInventoryDtoMapper mapper = Mappers.getMapper(InventoryToInventoryDtoMapper.class);

    @Test
    public void givenInventoryToInventoryDto_whenMaps_thenCorrect() {
        Inventory inventory = new Inventory();
        inventory.setCost(111);
        inventory.setDepreciation(222);

        InventoryDTO dto = mapper.map(inventory);

        assertEquals(inventory.getCost(), dto.getCost());
        assertEquals(inventory.getDepreciation(), dto.getDepreciation());
    }
}