package ttps.quecomemos.service.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ttps.quecomemos.modelo.usuario.Administrador;
import ttps.quecomemos.repository.usuario.AdministradorRepository;

@Service
public class AdministradorService extends UsuarioService<Administrador> {
    private final AdministradorRepository administradorRepository;

    @Autowired
    public AdministradorService(AdministradorRepository administradorRepository) {
        super(administradorRepository);
        this.administradorRepository = administradorRepository;
    }

    @Transactional
    public Administrador save(Administrador administrador) {
        if (this.getByDni(administrador.getDni()) != null) {
            throw new IllegalArgumentException("Ya existe un administrador con ese DNI");
        }
        return administradorRepository.save(administrador);
    }

    @Transactional
    public Administrador update(Administrador administrador, Long id) {
        Administrador existingAdmin = (Administrador) findById(id);
        if (administrador.getDni() != existingAdmin.getDni() && this.getByDni(administrador.getDni()) != null) {
            throw new IllegalArgumentException("Ya existe un administrador con ese DNI");
        }
        return administradorRepository.save(administrador);
    }
}