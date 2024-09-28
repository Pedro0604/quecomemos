package usuarios;

public abstract class NoAdmin extends Usuario {

    private String nombre, apellido, urlImagen;

    public NoAdmin(int dni, String clave, String nombre, String apellido, String urlImagen) {
        super(dni, clave);
        this.nombre = nombre;
        this.apellido = apellido;
        this.urlImagen = urlImagen;
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
