package ttps.quecomemos.modelo.usuario;

public abstract class Usuario {

    private int dni;
    private String clave, nombre, apellido, urlImagen;

    public Usuario(int dni, String clave, String nombre, String apellido, String urlImagen) {
        this.dni = dni;
        this.clave = clave;
        this.nombre = nombre;
        this.apellido = apellido;
        this.urlImagen = urlImagen;
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
}
