package ttps.quecomemos.modelo.menu;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Menu implements Preciable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombre;

    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id")
    private List<Comida> comidas;

    @Column(nullable = false)
    private double precio;

    public Menu() {
        this.comidas = new ArrayList<>();
    }

    public Menu(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.comidas = new ArrayList<>();
    }

    public boolean addComidaVegetariana(Comida comida) {
        if (comida.isVegetariana() && comida.getTipoComida() != TipoComida.OTRO && getComidasVegetarianas().stream().noneMatch(c -> c.getTipoComida() == comida.getTipoComida())) {
            return getComidasVegetarianas().add(comida);
        }
        return false;
    }

    public boolean addComidaNoVegetariana(Comida comida) {
        if (comida.getTipoComida() != TipoComida.OTRO && getComidasNoVegetarianas().stream().noneMatch(c -> c.getTipoComida() == comida.getTipoComida())) {
            return getComidasNoVegetarianas().add(comida);
        }
        return false;
    }

    public boolean removeComidaVegetariana(Comida comida) {
        return getComidasVegetarianas().remove(comida);
    }

    public boolean removeComidaNoVegetariana(Comida comida) {
        return getComidasNoVegetarianas().remove(comida);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Comida> getComidas() {
        return comidas;
    }

    public void setComidas(List<Comida> comidas) {
        this.comidas = comidas;
    }

    public List<Comida> getComidasVegetarianas() {
        return comidas.stream().filter(Comida::isVegetariana).collect(Collectors.toList());
    }

    public List<Comida> getComidasNoVegetarianas() {
        return comidas.stream().filter(comida -> !comida.isVegetariana()).collect(Collectors.toList());
    }

    @Override
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Menu menu) {
            return menu.getNombre().equals(this.getNombre());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}
