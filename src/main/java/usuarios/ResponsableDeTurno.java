package usuarios;

public class ResponsableDeTurno extends NoAdmin {

	private Turno turno;

	public ResponsableDeTurno() {
		super();
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	
}
