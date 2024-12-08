package ttps.quecomemos.modelo.menu;

import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MenuDiarioTest {
    @Test
    public void setMenuVegetarianoSuccessfully() {
        MenuDiario menuDiario = new MenuDiario();
        Menu menuVegetariano = new Menu("Menu Vegetariano", 20.0, true);
        menuDiario.setMenuVegetariano(menuVegetariano);
        assertEquals(menuVegetariano, menuDiario.getMenuVegetariano());
    }

    @Test
    public void setMenuVegetarianoFailsWhenMenuIsNotVegetariano() {
        MenuDiario menuDiario = new MenuDiario();
        Menu menuNoVegetariano = new Menu("Menu No Vegetariano", 20.0, false);
        assertThrows(IllegalArgumentException.class, () -> menuDiario.setMenuVegetariano(menuNoVegetariano));
    }

    @Test
    public void setMenuNoVegetarianoSuccessfully() {
        MenuDiario menuDiario = new MenuDiario();
        Menu menuNoVegetariano = new Menu("Menu No Vegetariano", 20.0, false);
        menuDiario.setMenuNoVegetariano(menuNoVegetariano);
        assertEquals(menuNoVegetariano, menuDiario.getMenuNoVegetariano());
    }

    @Test
    public void setMenuNoVegetarianoFailsWhenMenuIsVegetariano() {
        MenuDiario menuDiario = new MenuDiario();
        Menu menuVegetariano = new Menu("Menu Vegetariano", 20.0, true);
        assertThrows(IllegalArgumentException.class, () -> menuDiario.setMenuNoVegetariano(menuVegetariano));
    }

    @Test
    public void setDiaSuccessfully() {
        MenuDiario menuDiario = new MenuDiario();
        menuDiario.setDia(DayOfWeek.MONDAY);
        assertEquals(DayOfWeek.MONDAY, menuDiario.getDia());
    }
}
