package ttps.quecomemos.service.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ttps.quecomemos.modelo.usuario.Administrador;
import ttps.quecomemos.repository.usuario.AdministradorRepository;

@Service
public class AdministradorService extends UsuarioService<Administrador> {
    @Autowired
    public AdministradorService(AdministradorRepository administradorRepository) {
        super(administradorRepository);
    }

    @Transactional(readOnly = true)
    public boolean isAdministradorExist(Administrador administrador) {
        return getByDni(administrador.getDni()) != null;
    }
}