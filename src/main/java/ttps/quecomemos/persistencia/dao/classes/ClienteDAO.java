package ttps.quecomemos.persistencia.dao.classes;

import ttps.quecomemos.modelo.usuario.Cliente;

public interface ClienteDAO extends GenericDAO<Cliente> {
    public Cliente getByEmail(String email);
}
