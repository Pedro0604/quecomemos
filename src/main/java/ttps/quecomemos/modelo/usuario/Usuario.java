package ttps.quecomemos.modelo.usuario;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, nullable = false)
    private int dni;

    @Column(nullable = false)
    private String clave;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String urlImagen;

    public Usuario(int dni, String clave, String nombre, String apellido, String urlImagen) {
        this.dni = dni;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
        this.urlImagen = urlImagen;
    }
}
