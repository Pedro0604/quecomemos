package ttps.quecomemos.persistencia.dao.classes;

public interface UsuarioDAO<T> extends GenericDAO<T> {
    public T getByDni(int dni);
}
