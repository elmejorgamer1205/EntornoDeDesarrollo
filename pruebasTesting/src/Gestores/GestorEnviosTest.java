package Gestores;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GestorEnviosTest {
    static GestorEnvios g;

    @BeforeAll
    static void setUp(){
        g = new GestorEnvios();
    }

    @Test
    @DisplayName("Pedido de menos de 20€ envio debe costar 5€")
    void pedidoPequeño(){
        double res = g.calcular(10);
        assertEquals(5, res);
    }

    @Test
    void pedidoMedio_Paga3() {
        GestorEnvios g = new GestorEnvios();
        double envio = g.calcular(30.0);
        assertEquals(3.0, envio);
    }

    public double calcular(double total) {
        if (total < 20) {
            return 5.0;
        }
        // Por ahora devolvemos 3.0 para el resto
        return 3.0;
    }

    @ParameterizedTest (name = "Precio {0} paga {1}")
    @CsvSource({
            "10.0,5.0",
            "45.0,3.0",
            "60.0,0.0",
            "20.0,3.0",
            "50.0,0.0"
    })
    void pruebaMasiva(int precio, double precioEnvio){
        double res = g.calcular(precio);
        assertEquals(precioEnvio, res);
    }
}