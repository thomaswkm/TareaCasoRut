import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidadorRutTest {

    @Test
    void devolverOperacionCuatroTest() {
        String rutFormateado = "12345678";
        int[] multiplicaciones = {1*2,2*3,3*4,4*5,5*6,6*7,7*2,8*3};
        assertArrayEquals(multiplicaciones,ValidadorRut.devolverOperacionCuatro(rutFormateado));
    }

    @Test
    void quitarPuntosTest() {
        assertEquals("20367240",ValidadorRut.quitarPuntos("20.367.240"));
    }

    @Test
    void quitarGuionTest() {
        assertEquals("20.367.2403",ValidadorRut.quitarGuion("20.367.240-3"));
    }

    @Test
    void invertirRutTest() {
        assertEquals("12345678",ValidadorRut.invertirRut("87654321"));
    }

    @Test
    void quitarDigitoVerificadorTest() {
        assertEquals("20367240",ValidadorRut.quitarDigitoVerificador("203672403"));
        assertEquals("20367240",ValidadorRut.quitarDigitoVerificador("20367240k"));
    }

    @Test
    void formatearRutTest() {
        assertEquals("04276302",ValidadorRut.formatearRut("20.367.240-3"));
    }

    @Test
    void convertirDigitosAArregloEnterosTest() {
        String r = "04276302";
        int[] digitos = {0,4,2,7,6,3,0,2};
        assertArrayEquals(digitos,ValidadorRut.convertirDigitosAArregloEnteros(r));
    }

}