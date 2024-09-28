package menu;

import java.util.ArrayList;
import java.util.List;

public class Menu implements Preciable {
    private String nombre;
    private List<Comida> menuVegetariano, menuNoVegetariano;
    private double precio;

    public Menu(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.menuVegetariano = new ArrayList<>();
        this.menuNoVegetariano = new ArrayList<>();
    }

    public boolean addComidaVegetariana(Comida comida) {
        if (menuVegetariano.size() < 4 && menuVegetariano.stream().noneMatch(c -> c.getTipoComida() == comida.getTipoComida())) {
            menuVegetariano.add(comida);
            return true;
        }
        return false;
    }

    public boolean addComidaNoVegetariana(Comida comida) {
        if (menuNoVegetariano.size() < 4 && menuNoVegetariano.stream().noneMatch(c -> c.getTipoComida() == comida.getTipoComida())) {
            menuNoVegetariano.add(comida);
            return true;
        }
        return false;
    }

    public boolean removeComidaVegetariana(Comida comida) {
        return menuVegetariano.remove(comida);
    }

    public boolean removeComidaNoVegetariana(Comida comida) {
        return menuVegetariano.remove(comida);
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Menu menu) {
            return menu.getNombre().equals(this.getNombre());
        }
        return false;
    }
}
