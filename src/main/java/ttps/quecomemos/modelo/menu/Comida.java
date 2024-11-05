package ttps.quecomemos.modelo.menu;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Comida extends Preciable {
    @Column(unique = true, nullable = false)
    private String nombre;

    private String urlImagen;

    @Enumerated(EnumType.STRING)
    private TipoComida tipoComida;

    @Column(nullable = false)
    private boolean vegetariana;

    @Column(nullable = false)
    private double precio;

    public Comida() {
    }

    public Comida(String nombre, String urlImagen, TipoComida tipoComida, boolean vegetariana, double precio) {
        this.nombre = nombre;
        this.urlImagen = urlImagen;
        this.tipoComida = tipoComida;
        this.vegetariana = vegetariana;
        this.precio = precio;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Comida comida) {
            return comida.getNombre().equals(this.getNombre());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }
}
