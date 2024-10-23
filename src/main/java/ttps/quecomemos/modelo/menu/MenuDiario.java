package ttps.quecomemos.modelo.menu;

import jakarta.persistence.*;

import java.time.DayOfWeek;

@Entity
public class MenuDiario extends Preciable {
    @Column(nullable = false)
    private double precio;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DayOfWeek dia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_vegetariano_id", nullable = false)
    private Menu menuVegetariano;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_no_vegetariano_id", nullable = false)
    private Menu menuNoVegetariano;

    public MenuDiario() {
    }

    public MenuDiario(double precio) {
        this.precio = precio;
    }

    public Menu getMenuVegetariano() {
        return menuVegetariano;
    }

    public void setMenuVegetariano(Menu menuVegetariano) {
        if (menuVegetariano == null) {
            throw new IllegalArgumentException("El menu no puede ser nulo");
        }
        if (!menuVegetariano.isVegetariano()) {
            throw new IllegalArgumentException("El menu debe ser vegetariano");
        }
        this.menuVegetariano = menuVegetariano;
    }

    public Menu getMenuNoVegetariano() {
        return menuNoVegetariano;
    }

    public void setMenuNoVegetariano(Menu menuNoVegetariano) {
        if (menuNoVegetariano == null) {
            throw new IllegalArgumentException("El menu no puede ser nulo");
        }
        if (menuNoVegetariano.isVegetariano()) {
            throw new IllegalArgumentException("El menu no puede ser vegetariano");
        }
        this.menuNoVegetariano = menuNoVegetariano;
    }

    public DayOfWeek getDia() {
        return dia;
    }

    public void setDia(DayOfWeek dia) {
        this.dia = dia;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public double getPrecio() {
        return this.precio;
    }
}
