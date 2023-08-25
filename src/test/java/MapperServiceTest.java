import com.application.dto.InventoryDTO;
import com.application.entity.Chair;
import com.application.entity.Inventory;
import com.application.mapper.InventoryToInventoryDtoMapper;
import com.application.mapper.Mapper;
import com.application.service.MapperService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MapperServiceTest {

    private MapperService mapperService;

    @Mock
    private Mapper<Inventory, InventoryDTO> inventoryMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        when(inventoryMapper.getMyClass()).thenAnswer(ourclass -> Inventory.class);

        List<Mapper<?, ?>> mappers = List.of(inventoryMapper);
        mapperService = new MapperService(mappers);
    }

    @Test
    public void givenInventory_whenMappingToDto_thenDtoIsGenerated() {

        Inventory inventory = new Inventory();
        InventoryDTO expectedDto = new InventoryDTO();

        when(inventoryMapper.map(inventory)).thenReturn(expectedDto);

        InventoryDTO resultDto = mapperService.toDto(inventory);

        verify(inventoryMapper).map(inventory);

        assertEquals(expectedDto, resultDto);
    }

    @Test
    public void givenNullChair_whenMappingToDto_thenNullPointerExceptionIsThrown() {

        Chair chair = new Chair();

        assertThrows(NullPointerException.class, () -> mapperService.toDto(chair));
    }

    @Test
    public void givenIncorrectMapper_whenMappingChairToDto_thenNullPointerExceptionIsThrown() {
        Mapper<Chair, InventoryDTO> incorrectMapper = Mockito.mock(Mapper.class);

        Chair chair = new Chair();

        InventoryDTO expectedDto = new InventoryDTO();

        when(incorrectMapper.map(chair)).thenReturn(expectedDto);

        when(incorrectMapper.getMyClass()).thenAnswer(ourclass -> Inventory.class);

        List<Mapper<?, ?>> mappers = List.of(incorrectMapper);

        MapperService mapperService = new MapperService(mappers);

        assertThrows(NullPointerException.class, () -> mapperService.toDto(chair));
    }

    @Test
    public void givenNullMappers_whenCreatingMapperService_thenNullPointerExceptionIsThrown() {
        assertThrows(NullPointerException.class, () -> new MapperService(null));
    }

    @Test
    public void givenMapperReturningNull_whenMappingInventoryToDto_thenNullPointerExceptionIsThrown() {
        Mapper<Inventory, InventoryDTO> mapper = mock(Mapper.class);
        when(mapper.map(mock(Inventory.class))).thenReturn(null);

        List<Mapper<?, ?>> mappers = List.of(mapper);
        MapperService mapperService = new MapperService(mappers);

        Inventory inventory = new Inventory();
        assertThrows(NullPointerException.class, () -> mapperService.toDto(inventory));
    }

    @Test
    public void givenMapperWithNullInput_whenMappingToDto_thenNullPointerExceptionIsThrown() {
        Mapper<Inventory, InventoryDTO> mapper = mock(Mapper.class);
        when(mapper.map(null)).thenReturn(mock(InventoryDTO.class));

        List<Mapper<?, ?>> mappers = List.of(mapper);
        MapperService mapperService = new MapperService(mappers);

        assertThrows(NullPointerException.class, () -> mapperService.toDto(null));
    }
}