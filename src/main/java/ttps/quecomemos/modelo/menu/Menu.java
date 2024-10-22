package ttps.quecomemos.modelo.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu implements Preciable {
    private String nombre;
    private List<Comida> comidasVegetarianas, comidasNoVegetarianas;
    private double precio;

    public Menu(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.comidasVegetarianas = new ArrayList<>();
        this.comidasNoVegetarianas = new ArrayList<>();
    }

    public boolean addComidaVegetariana(Comida comida) {
        if (comida.esVegetariana() && comida.getTipoComida() != TipoComida.OTRO && comidasVegetarianas.stream().noneMatch(c -> c.getTipoComida() == comida.getTipoComida())) {
            return comidasVegetarianas.add(comida);
        }
        return false;
    }

    public boolean addComidaNoVegetariana(Comida comida) {
        if (comida.getTipoComida() != TipoComida.OTRO && comidasNoVegetarianas.stream().noneMatch(c -> c.getTipoComida() == comida.getTipoComida())) {
            return comidasNoVegetarianas.add(comida);
        }
        return false;
    }

    public boolean removeComidaVegetariana(Comida comida) {
        return comidasVegetarianas.remove(comida);
    }

    public boolean removeComidaNoVegetariana(Comida comida) {
        return comidasNoVegetarianas.remove(comida);
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
