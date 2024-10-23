package modelo.menu;

import org.junit.jupiter.api.Test;
import ttps.quecomemos.modelo.menu.Comida;
import ttps.quecomemos.modelo.menu.Menu;
import ttps.quecomemos.modelo.menu.TipoComida;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    @Test
    public void addComidaSuccessfully() {
        Menu menu = new Menu("Menu mixto", 30.0);
        Comida comida = new Comida("Pasta", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 8.0);
        assertTrue(menu.addComida(comida));
    }

    @Test
    public void addComidaFailsWhenDuplicateType() {
        Menu menu = new Menu("Menu mixto", 30.0);
        menu.addComida(new Comida("Pasta", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 8.0));
        Comida comida = new Comida("Pizza", "urlImagen", TipoComida.PLATO_PRINCIPAL, false, 10.0);
        assertFalse(menu.addComida(comida));
    }

    @Test
    public void addComidaFailsWhenTipoEsOtro() {
        Menu menu = new Menu("Menu mixto", 30.0);
        Comida comida = new Comida("Chupetin", "urlImagen", TipoComida.OTRO, true, 2.0);
        assertFalse(menu.addComida(comida));
    }

    @Test
    public void addComidaFailsWhenVegetarianoAndComidaNoVegetariana() {
        Menu menu = new Menu("Menu vegetariano", 20.0, true);
        Comida comida = new Comida("Carne", "urlImagen", TipoComida.PLATO_PRINCIPAL, false, 10.0);
        assertFalse(menu.addComida(comida));
    }

    @Test
    public void removeComidaSuccessfully() {
        Menu menu = new Menu("Menu mixto", 30.0);
        Comida comida = new Comida("Pasta", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 8.0);
        menu.addComida(comida);
        assertTrue(menu.removeComida(comida));
    }

    @Test
    public void removeComidaFailsWhenNotPresent() {
        Menu menu = new Menu("Menu mixto", 30.0);
        Comida comida = new Comida("Pasta", "urlImagen", TipoComida.PLATO_PRINCIPAL, true, 8.0);
        assertFalse(menu.removeComida(comida));
    }

    @Test
    public void setComidasFailsWhenVegetarianoAndComidaNoVegetariana() {
        Menu menu = new Menu("Menu vegetariano", 20.0, true);
        List<Comida> comidas = new ArrayList<>();
        comidas.add(new Comida("Ensalada", "urlImagen", TipoComida.ENTRADA, true, 5.0));
        comidas.add(new Comida("Carne", "urlImagen", TipoComida.PLATO_PRINCIPAL, false, 10.0));
        assertThrows(IllegalArgumentException.class, () -> menu.setComidas(comidas));
    }

    @Test
    public void setVegetarianoFailsWhenComidasNoVegetarianas() {
        Menu menu = new Menu("Menu mixto", 30.0);
        menu.addComida(new Comida("Carne", "urlImagen", TipoComida.PLATO_PRINCIPAL, false, 10.0));
        assertThrows(IllegalArgumentException.class, () -> menu.setVegetariano(true));
    }
}