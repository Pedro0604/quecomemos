package menu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ComidaTest {

    @Test
    public void nombreIsSetCorrectly() {
        Comida comida = new Comida("Pizza", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 10.0);
        assertEquals("Pizza", comida.getNombre());
    }

    @Test
    public void urlImagenIsSetCorrectly() {
        Comida comida = new Comida("Pizza", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 10.0);
        assertEquals("urlImagen", comida.getUrlImagen());
    }

    @Test
    public void tipoComidaIsSetCorrectly() {
        Comida comida = new Comida("Pizza", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 10.0);
        assertEquals(TipoComida.PLATO_PRINCIPAL, comida.getTipoComida());
    }

    @Test
    public void esVegetarianaIsSetCorrectly() {
        Comida comida = new Comida("Pizza", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 10.0);
        assertTrue(comida.esVegetariana());
    }

    @Test
    public void precioIsSetCorrectly() {
        Comida comida = new Comida("Pizza", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 10.0);
        assertEquals(10.0, comida.getPrecio());
    }

    @Test
    public void equalsReturnsTrueForEqualObjects() {
        Comida comida1 = new Comida("Pizza", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 10.0);
        Comida comida2 = new Comida("Pizza", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 10.0);
        assertEquals(comida1, comida2);
    }

    @Test
    public void equalsReturnsFalseForDifferentObjects() {
        Comida comida1 = new Comida("Pizza", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 10.0);
        Comida comida2 = new Comida("Burger", "urlImagen", TipoComida.PLATO_PRINCIPAL, false, 8.0);
        assertNotEquals(comida1, comida2);
    }

    @Test
    public void equalsReturnsFalseForNull() {
        Comida comida = new Comida("Pizza", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 10.0);
        assertNotEquals(null, comida);
    }

    @Test
    public void equalsReturnsFalseForDifferentClass() {
        Comida comida = new Comida("Pizza", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 10.0);
        String notAComida = "Not a Comida";
        assertNotEquals(comida, notAComida);
    }
}