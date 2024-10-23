package ttps.quecomemos.modelo.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cliente extends Usuario {

    @Id
    @GeneratedValue
    private long id;

    @Column(unique = true, nullable = false)
    private String email;

    public Cliente(int dni, String clave, String nombre, String apellido, String urlImagen, String email) {
        super(dni, clave, nombre, apellido, urlImagen);
        this.email = email;
    }

    public Cliente() {
        super();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
