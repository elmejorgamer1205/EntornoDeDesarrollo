import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

class ControladorIluminacionTest {

    private SensorLuz mockSensor;
    private Reloj mockReloj;
    private Interruptor mockInterruptor;
    private ControladorIluminacion controlador;

    @BeforeEach
    void setUp() {
        // Creamos los "Dobles de Acción"
        mockSensor = mock(SensorLuz.class);
        mockReloj = mock(Reloj.class);
        mockInterruptor = mock(Interruptor.class);

        // Creamos la instancia real usando los mocks
        controlador = new ControladorIluminacion(mockSensor, mockReloj, mockInterruptor);
    }
}