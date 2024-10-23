package ttps.quecomemos.modelo.usuario;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED) // o @Inheritance
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

    public Usuario() {
    }

    public int getDni() {
        return this.dni;
    }

    public String getClave() {
        return this.clave;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

}
