package ttps.quecomemos.service.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ttps.quecomemos.modelo.usuario.Usuario;
import ttps.quecomemos.repository.usuario.UsuarioRepository;
import ttps.quecomemos.service.GenericService;

@Service
public abstract class UsuarioService<U extends Usuario> extends GenericService<Usuario> {

    private final UsuarioRepository<U> usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository<U> usuarioRepository) {
        super((JpaRepository<Usuario, Long>) usuarioRepository);
        this.usuarioRepository = usuarioRepository;
    }

    @Transactional(readOnly = true)
    public U getByDni(int dni) {
        return usuarioRepository.findByDni(dni);
    }
}