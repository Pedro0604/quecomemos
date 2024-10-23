package ttps.quecomemos.modelo.menu;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nombre;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(
            name = "menu_comida",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "comida_id")
    )
    private List<Comida> comidas = new ArrayList<>();

    @Column(nullable = false)
    private double precio;

    @Column(nullable = false)
    private boolean vegetariano;

    public Menu() {
        this.comidas = new ArrayList<>();
    }

    public Menu(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.comidas = new ArrayList<>();
    }

    public Menu(String nombre, double precio, boolean vegetariano) {
        this.nombre = nombre;
        this.precio = precio;
        this.vegetariano = vegetariano;
        this.comidas = new ArrayList<>();
    }

    public boolean addComida(Comida comida) {
        if ((!this.vegetariano || comida.isVegetariana()) && comida.getTipoComida() != TipoComida.OTRO && this.getComidas().stream().noneMatch(c -> c.getTipoComida() == comida.getTipoComida())) {
            return this.getComidas().add(comida);
        }
        return false;
    }

    public boolean removeComida(Comida comida) {
        return this.getComidas().remove(comida);
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
        if (this.vegetariano && comidas.stream().anyMatch(c -> !c.isVegetariana())) {
            throw new IllegalArgumentException("No se puede hacer un menu vegetariano con comidas no vegetarianas");
        }
        this.comidas = comidas;
    }

    public boolean isVegetariano() {
        return vegetariano;
    }

    public void setVegetariano(boolean vegetariano) {
        if (vegetariano && this.comidas.stream().anyMatch(c -> !c.isVegetariana())) {
            throw new IllegalArgumentException("No se puede hacer un menu vegetariano con comidas no vegetarianas");
        }
        this.vegetariano = vegetariano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
