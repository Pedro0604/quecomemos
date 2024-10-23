package ttps.quecomemos.persistencia.dao.jpa;

import ttps.quecomemos.modelo.usuario.Administrador;
import ttps.quecomemos.persistencia.dao.classes.AdministradorDAO;

public class AdministradorDAOHibernateJPA extends GenericDAOHibernateJPA<Administrador> implements AdministradorDAO {
    public AdministradorDAOHibernateJPA() {
        super(Administrador.class);
    }

}
