package usuarios;

public abstract class Usuario {

    private int dni;
    private String clave;

    public Usuario(int dni, String clave) {
        this.dni = dni;
        this.clave = clave;
    }

    public int getDni() {
        return this.dni;
    }

    public String getClave() {
        return this.clave;
    }
}
