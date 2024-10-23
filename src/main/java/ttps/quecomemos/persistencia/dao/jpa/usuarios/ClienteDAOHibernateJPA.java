package ttps.quecomemos.persistencia.dao.jpa.usuarios;

import ttps.quecomemos.modelo.usuario.Cliente;

public class ClienteDAOHibernateJPA extends GenericUserDAOHibernateJPA<Cliente> {
    public ClienteDAOHibernateJPA() {
        super(Cliente.class);
    }

}
