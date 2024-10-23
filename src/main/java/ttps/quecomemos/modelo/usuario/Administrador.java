package ttps.quecomemos.modelo.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Administrador extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Administrador(int dni, String clave, String nombre, String apellido, String urlImagen) {
        super(dni, clave, nombre, apellido, urlImagen);
    }

    public Administrador() {
        super();
    }

}
