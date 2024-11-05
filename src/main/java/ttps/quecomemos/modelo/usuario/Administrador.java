package ttps.quecomemos.modelo.usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Administrador extends Usuario {
    public Administrador(int dni, String clave, String nombre, String apellido, String urlImagen) {
        super(dni, clave, nombre, apellido, urlImagen);
    }
}
