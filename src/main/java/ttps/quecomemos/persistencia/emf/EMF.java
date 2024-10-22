package ttps.quecomemos.persistencia.emf;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EMF {
	private static final EntityManagerFactory em = Persistence.createEntityManagerFactory("quecomemos");

	public static EntityManagerFactory getEMF() {
		return em;
	}
}
