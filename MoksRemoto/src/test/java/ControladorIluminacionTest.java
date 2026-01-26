import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

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

    @Test
    void testEncenderCuandoEsDeNocheYEstaOscuro() {
        // 1. Configuración (Stubbing): Forzamos la realidad
        when(mockSensor.obtenerLux()).thenReturn(10); // Muy oscuro
        when(mockReloj.obtenerHora()).thenReturn(22);  // 10:00 PM

        // 2. Ejecución
        controlador.actualizarEstado();

        // 3. Verificación: ¿Se llamó al método encender()?
        verify(mockInterruptor).encender();
        verify(mockInterruptor, never()).apagar();
    }

    @Test
    void testNoEncenderDeDiaAunqueEsteOscuro() {
        // 1. Configuración: Es mediodía pero el sensor está tapado
        when(mockSensor.obtenerLux()).thenReturn(10);
        when(mockReloj.obtenerHora()).thenReturn(12); // 12:00 PM

        // 2. Ejecución
        controlador.actualizarEstado();

        // 3. Verificación
        verify(mockInterruptor).apagar();
        verify(mockInterruptor, never()).encender();
    }

    @Test
    void testApagarPorSeguridadSiElSensorFalla() {
        // 1. Configuración: El sensor lanza una excepción (simula cable roto)
        when(mockSensor.obtenerLux()).thenThrow(new RuntimeException("Error de hardware"));

        // 2. Ejecución
        controlador.actualizarEstado();

        // 3. Verificación: La lógica de catch debería apagar la luz
        verify(mockInterruptor).apagar();
    }
}