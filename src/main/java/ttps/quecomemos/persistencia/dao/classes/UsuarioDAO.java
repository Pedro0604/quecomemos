package ttps.quecomemos.persistencia.dao.classes;

import ttps.quecomemos.modelo.usuario.Usuario;

public interface UsuarioDAO<T> extends GenericDAO<T> {
    public T getByDni(int dni);
}
