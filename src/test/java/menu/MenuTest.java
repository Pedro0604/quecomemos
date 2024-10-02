package menu;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {

    @Test
    public void addComidaVegetarianaSuccessfully() {
        Menu menu = new Menu("Menu vegetariano", 20.0);
        Comida comida = new Comida("Ensalada", "urlImagen", TipoComida.ENTRADA, true, 5.0);
        assertTrue(menu.addComidaVegetariana(comida));
    }

    @Test
    public void addComidaVegetarianaFailsWhenDuplicateType() {
        Menu menu = new Menu("Menu vegetariano", 20.0);
        menu.addComidaVegetariana(new Comida("Ensalada", "urlImagen", TipoComida.ENTRADA, true, 5.0));
        Comida comida = new Comida("Sopa", "urlImagen", TipoComida.ENTRADA, true, 7.0);
        assertFalse(menu.addComidaVegetariana(comida));
    }

    @Test
    public void addComidaVegetarianaFailsWhenComidaNoVegetariana() {
        Menu menu = new Menu("Menu vegetariano", 20.0);
        Comida comida = new Comida("Carneeeee", "urlImagen", TipoComida.PLATO_PRINCIPAL, false, 5.0);
        assertFalse(menu.addComidaVegetariana(comida));
    }

    @Test
    public void addComidaNoVegetarianaSuccessfully() {
        Menu menu = new Menu("Menu no vegetariano", 25.0);
        Comida comida = new Comida("Pollo", "urlImagen", TipoComida.PLATO_PRINCIPAL, false, 10.0);
        assertTrue(menu.addComidaNoVegetariana(comida));
    }

    @Test
    public void addComidaNoVegetarianaFailsWhenDuplicateType() {
        Menu menu = new Menu("Menu no vegetariano", 25.0);
        menu.addComidaNoVegetariana(new Comida("Pollo", "urlImagen", TipoComida.PLATO_PRINCIPAL, false, 10.0));
        Comida comida = new Comida("Bife", "urlImagen", TipoComida.PLATO_PRINCIPAL, false, 12.0);
        assertFalse(menu.addComidaNoVegetariana(comida));
    }

    @Test
    public void removeComidaVegetarianaSuccessfully() {
        Menu menu = new Menu("Menu vegetariano", 20.0);
        Comida comida = new Comida("Ensalada", "urlImagen", TipoComida.ENTRADA, true, 5.0);
        menu.addComidaVegetariana(comida);
        assertTrue(menu.removeComidaVegetariana(comida));
    }

    @Test
    public void removeComidaNoVegetarianaSuccessfully() {
        Menu menu = new Menu("Menu no vegetariano", 25.0);
        Comida comida = new Comida("Pollo", "urlImagen", TipoComida.PLATO_PRINCIPAL, false, 10.0);
        menu.addComidaNoVegetariana(comida);
        assertTrue(menu.removeComidaNoVegetariana(comida));
    }

    @Test
    public void removeComidaVegetarianaFailsWhenNotPresent() {
        Menu menu = new Menu("Menu vegetariano", 20.0);
        Comida comida = new Comida("Ensalada", "urlImagen", TipoComida.ENTRADA, true, 5.0);
        assertFalse(menu.removeComidaVegetariana(comida));
    }

    @Test
    public void removeComidaNoVegetarianaFailsWhenNotPresent() {
        Menu menu = new Menu("Menu no vegetariano", 25.0);
        Comida comida = new Comida("Pollo", "urlImagen", TipoComida.PLATO_PRINCIPAL, false, 10.0);
        assertFalse(menu.removeComidaNoVegetariana(comida));
    }
}