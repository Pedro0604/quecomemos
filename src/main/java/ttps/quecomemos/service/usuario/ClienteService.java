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

    @Transactional
    public Cliente save(Cliente cliente) {
        if (this.getByEmail(cliente.getEmail()) != null) {
            throw new IllegalArgumentException("Ya existe un cliente con ese email");
        } else {
            if (this.getByDni(cliente.getDni()) != null) {
                throw new IllegalArgumentException("Ya existe un cliente con ese DNI");
            }
        }
        return clienteRepository.save(cliente);
    }

    @Transactional
    public Cliente update(Cliente cliente, Long id) {
        Cliente existingClient = (Cliente) findById(id);
        if (!cliente.getEmail().equals(existingClient.getEmail()) && this.getByEmail(cliente.getEmail()) != null) {
            throw new IllegalArgumentException("Ya existe un cliente con ese email");
        } else {
            if (cliente.getDni() != existingClient.getDni() && this.getByDni(cliente.getDni()) != null) {
                throw new IllegalArgumentException("Ya existe un cliente con ese DNI");
            }
        }
        return clienteRepository.save(cliente);
    }
}