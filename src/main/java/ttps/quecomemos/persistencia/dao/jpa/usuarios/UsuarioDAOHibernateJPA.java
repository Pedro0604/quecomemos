package ttps.quecomemos.persistencia.dao.jpa.usuarios;

import ttps.quecomemos.modelo.usuario.Usuario;

public class UsuarioDAOHibernateJPA extends GenericUserDAOHibernateJPA<Usuario> {

    public UsuarioDAOHibernateJPA() {
        super(Usuario.class);
    }

}
