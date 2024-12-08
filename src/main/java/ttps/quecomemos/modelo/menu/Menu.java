package ttps.quecomemos.modelo.menu;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Setter;
import ttps.quecomemos.dto.MenuRequest;
import ttps.quecomemos.exception.ComidaNoVegetarianaException;
import ttps.quecomemos.exception.TipoComidaDuplicadoException;
import ttps.quecomemos.exception.TipoComidaNoPermitidoException;

import java.util.*;

@Data
@Entity
public class Menu extends Preciable {
    @Column(unique = true, nullable = false)
    private String nombre;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(
            name = "menu_comida",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "comida_id")
    )
    private List<Comida> comidas;

    @Setter
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

    public Menu(MenuRequest menuRequest) {
        this.nombre = menuRequest.getNombre();
        this.precio = menuRequest.getPrecio();
        this.vegetariano = menuRequest.isVegetariano();
        this.comidas = new ArrayList<>();
    }

    public void addComida(Comida comida) {
        if (this.vegetariano && !comida.isVegetariana()) {
            throw new ComidaNoVegetarianaException("La comida '" + comida.getNombre() + "' no es vegetariana");
        }

        if (comida.getTipoComida() == TipoComida.OTRO) {
            throw new TipoComidaNoPermitidoException("El tipo de comida '" + TipoComida.OTRO + "' no está permitido dentro de un menú");
        }

        if (this.getComidas().stream().anyMatch(c -> c.getTipoComida() == comida.getTipoComida())) {
            throw new TipoComidaDuplicadoException("El tipo de comida '" + comida.getTipoComida() + "' ya está presente en el menú");
        }

        this.getComidas().add(comida);
    }

    public boolean removeComida(Comida comida) {
        return this.getComidas().remove(comida);
    }

    public void setComidas(List<Comida> comidas) {
        if (this.vegetariano && comidas.stream().anyMatch(c -> !c.isVegetariana())) {
            throw new ComidaNoVegetarianaException("Una de las comidas no es vegetariana");
        }

        if (comidas.stream().anyMatch(c -> c.getTipoComida() == TipoComida.OTRO)) {
            throw new TipoComidaNoPermitidoException("El tipo de comida '" + TipoComida.OTRO + "' no está permitido");
        }

        // Verificar que no haya tipos de comida duplicados
        Set<TipoComida> tiposUnicos = new HashSet<>();
        for (Comida comida : comidas) {
            if (!tiposUnicos.add(comida.getTipoComida())) {
                throw new TipoComidaDuplicadoException("El tipo de comida '" + comida.getTipoComida() + "' ya está presente en el menú");
            }
        }

        this.comidas = comidas;
    }

    public void setVegetariano(boolean vegetariano) {
        if (vegetariano && this.comidas.stream().anyMatch(c -> !c.isVegetariana())) {
            throw new ComidaNoVegetarianaException("Una de las comidas existentes en el menú no es vegetariana");
        }
        this.vegetariano = vegetariano;
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

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), nombre, comidas, precio, vegetariano);
    }
}
