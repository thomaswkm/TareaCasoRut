import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CasoRutTest {

    @Test
    void devolverOperacionCuatroTest() {
        String rutFormateado = "12345678";
        int[] multiplicaciones = {1*2,2*3,3*4,4*5,5*6,6*7,7*2,8*3};
        assertArrayEquals(multiplicaciones,CasoRut.devolverOperacionCuatro(rutFormateado));
    }
}