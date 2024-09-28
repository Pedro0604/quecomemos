package usuarios;

public abstract class Usuario {
	
	private int dni;
	private String clave;
	
	public Usuario() {
		super();
	}
	
	public Usuario(int dni, String clave) {
		this.dni = dni;
		this.clave = clave;
	}
	
	public void setDni(int dni) {
		this.dni = dni;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public int getDni() {
		return this.dni;
	}
	
	public String getClave() {
		return this.clave;
	}
	
}
