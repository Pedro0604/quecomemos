package ttps.quecomemos.modelo.menu;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Override
    public boolean equals(Object object) {
        if (object instanceof Comida comida) {
            return comida.getNombre().equals(this.getNombre());
        }
        return false;
    }
}
