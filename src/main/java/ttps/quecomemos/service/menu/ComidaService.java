package ttps.quecomemos.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ttps.quecomemos.modelo.menu.Comida;
import ttps.quecomemos.repository.menu.ComidaRepository;
import ttps.quecomemos.service.GenericService;

@Service
public class ComidaService extends GenericService<Comida> {

    private final ComidaRepository comidaRepository;

    @Autowired
    public ComidaService(ComidaRepository comidaRepository) {
        super(comidaRepository);
        this.comidaRepository = comidaRepository;
    }

    @Transactional(readOnly = true)
    public Comida getByName(String nombre) {
        return comidaRepository.findByNombre(nombre);
    }


    @Transactional
    @Override
    public Comida update(Comida comida, Long id) {
        // Buscar la comida existente por ID
        Comida existingComida = this.findById(comida.getId());
        if (existingComida == null) {
            throw new RuntimeException();
        }
        // Guardar la comida actualizada
        return super.update(existingComida, existingComida.getId());
    }


}