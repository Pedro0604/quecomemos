package ttps.quecomemos.persistencia.dao.classes;

import ttps.quecomemos.modelo.usuario.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {
    public Usuario getByEmail(String email);
}
