package ttps.quecomemos.modelo.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ResponsableDeTurno extends Usuario {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private Turno turno;

    public ResponsableDeTurno(int dni, String clave, String nombre, String apellido, String urlImagen, Turno turno) {
        super(dni, clave, nombre, apellido, urlImagen);
        this.turno = turno;
    }

    public ResponsableDeTurno() {
        super();
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

}
