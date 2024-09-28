package usuarios;

public class Cliente extends NoAdmin {

    private String email;

    public Cliente(int dni, String clave, String nombre, String apellido, String urlImagen, String email) {
        super(dni, clave, nombre, apellido, urlImagen);
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
