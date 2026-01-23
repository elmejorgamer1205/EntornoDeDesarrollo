package Gestores;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class GestorDescuentosTest {

    static GestorDescuentos g;

    @BeforeAll
    static void setUp() {
        g = new GestorDescuentos();
    }

    @Test
    void pruebaEjemplo() {
        // 2. ACT (Adulto 30 años)
        double res = g.calcular(500, 45, 1);

        // 3. ASSERT (Paga 100)
        assertEquals(500.0, res);
    }

    @Test
    void senior65_Descuento50() {

        //Act
        double res = g.calcular(100, 65, 1);

        assertEquals(50, res);
    }

    @Test
    void cantidad5_SinBonusExtra() {
        // 10€, 30 años, 5 items > Total 50
        double res = g.calcular(10.0, 30, 5);
        assertEquals(50.0, res);
    }

    @Test
    void precioNegativo_LanzaExcepcion() {
        assertThrows(IllegalArgumentException.class, () -> {
            g.calcular(-50, 30, 1);
        });
    }

    @Test
    void pruebaPrecision() {
        // Resultado real: 3.3333333 .
        double res = 10.0 / 3.0;
        // Aceptamos si la diferencia es < 0.001
        assertEquals(3.333, res, 0.001);
    }

    // FORMA CORRECTA (JUnit 5)
    @ParameterizedTest
    @ValueSource(ints = {0, 5, 9})
    void niños_DescuentoOk(int edad) {
        // Se ejecuta 3 veces inyectando 'edad'
    }

    @ParameterizedTest(name = "Edad {0} paga {1}")
    @CsvSource({
            "5, 80.0", // Niño (20% desc)
            "30, 100.0", // Adulto (0% desc)
            "70, 50.0" // Senior (50% desc)
    })
    void pruebaMasiva(int edad, double precioEsperado) {
        double res = g.calcular(100.0, edad, 1);
        assertEquals(precioEsperado, res, 0.01);
    }
}
