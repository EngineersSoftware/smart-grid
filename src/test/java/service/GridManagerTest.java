package service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.devsenior.andresh.model.SolarPanel;
import com.devsenior.andresh.model.enums.WeatherCondition;
import com.devsenior.andresh.service.GridManager;

@DisplayName("Prueba de Certificación: NexusGrid Manager")
class GridManagerTest {

    private GridManager manager;

    @BeforeEach
    void setUp(){
        manager = new GridManager();
    }

    @Test
    @DisplayName("1. Validacion de capacidad: Debe fallar con valores negativos")
    void shouldThwroExceptionWhenCapacityIsNegative(){
        assertThrows(InvadCapacityException.class, () -> {
            new SolarPanel("SQL ERROR", -500.0, WeatherCondition.SUNNY);
        });
    }
    
    @Test
    @DisplayName("2. Validacion de duplicados: No permitir IDs identicos en el Map")
    void shouldThwroExceptionsOnDuplicateId(){
        SolarPanel p1 = new SolarPanel("ID-UNICO", 100.0, WeatherCondition.SUNNY);
        SolarPanel p2 = new SolarPanel("ID-UNICO", 200.0, WeatherCondition.CLOUDY);

        manager.registerSource(p1);

        assertThrows(SourceAlreadyExistException.class, () ->{
            manager.registerSource(p2);
        });
    }

    // tEST PARA VALIDACION DE BUSQUEDA Y LANZAR EXCEPCION SI EL ID NO EXISTE

    // TEST PARA INTEGRIDAD DE CALCULO: FLUJO POLIMORFICO EXITOSO
}
