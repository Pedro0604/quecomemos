package ttps.quecomemos.service.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ttps.quecomemos.modelo.usuario.Cliente;
import ttps.quecomemos.repository.usuario.ClienteRepository;

@Service
public class ClienteService extends UsuarioService<Cliente> {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        super(clienteRepository);
        this.clienteRepository = clienteRepository;
    }

    @Transactional(readOnly = true)
    public Cliente getByEmail(String email) {
        return clienteRepository.findByEmail(email);
    }
}