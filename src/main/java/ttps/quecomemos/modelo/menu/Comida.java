package ttps.quecomemos.modelo.menu;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Data
@NoArgsConstructor
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
        return Objects.hash(super.hashCode(), nombre, urlImagen, tipoComida, vegetariana, precio);
    }
}
