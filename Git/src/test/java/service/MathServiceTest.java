package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathServiceTest {

    MathService mathService;

    @BeforeEach
    void setp(){
        mathService = new MathService();
    }

    @Test
    void testSuma(){
        int a = 2;
        int b = 3;

        int res = MathService.sumar(2, 3);

        assertEquals(5, res);
    }

    @Test
    public  void  testRestar(){
        int a = 5;
        int b = 4;
        int res = MathService.restar(5,4);
        assertEquals(1,res);
    }
}