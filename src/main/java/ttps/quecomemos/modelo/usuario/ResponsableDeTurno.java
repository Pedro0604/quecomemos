package ttps.quecomemos.modelo.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ResponsableDeTurno extends Usuario {
    @Column(nullable = false)
    private Turno turno;

    public ResponsableDeTurno(int dni, String clave, String nombre, String apellido, String urlImagen, Turno turno) {
        super(dni, clave, nombre, apellido, urlImagen);
        this.turno = turno;
    }
}
