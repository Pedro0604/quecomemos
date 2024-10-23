package ttps.quecomemos.persistencia.dao.jpa.usuarios;

import ttps.quecomemos.modelo.usuario.Administrador;

public class AdministradorDAOHibernateJPA extends GenericUserDAOHibernateJPA<Administrador> {
    public AdministradorDAOHibernateJPA() {
        super(Administrador.class);
    }

}
