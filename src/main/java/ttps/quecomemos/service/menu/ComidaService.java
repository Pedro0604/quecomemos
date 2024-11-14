package ttps.quecomemos.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ttps.quecomemos.exception.TipoComidaInvalidoException;
import ttps.quecomemos.exception.TipoComidaDuplicadoException;
import ttps.quecomemos.modelo.menu.Comida;
import ttps.quecomemos.modelo.menu.Menu;
import ttps.quecomemos.modelo.menu.TipoComida;
import ttps.quecomemos.repository.menu.ComidaRepository;
import ttps.quecomemos.service.GenericService;

import java.util.Arrays;
import java.util.List;

@Service
public class ComidaService extends GenericService<Comida> {

    private final ComidaRepository comidaRepository;

    @Autowired
    public ComidaService(ComidaRepository comidaRepository) {
        super(comidaRepository);
        this.comidaRepository = comidaRepository;
    }

    @Transactional
    @Override
    public Comida save(Comida comida) {
        if (this.findByName(comida.getNombre()) != null){
            throw new IllegalArgumentException("Ya existe una comida con ese nombre");
        }
        return comidaRepository.save(comida);
    }

    @Transactional(readOnly = true)
    public Comida findByName(String nombre) {
        return comidaRepository.findByNombre(nombre);
    }

    @Transactional
    @Override
    public Comida update(Comida comida, Long id) {
        Comida existingComida = findById(id);
        List<TipoComida> tiposComida = this.getAllTiposComida();
        if (!tiposComida.contains(comida.getTipoComida())) {
            throw new TipoComidaInvalidoException("Tipo de comida inválido");
        }
        if (!comida.getNombre().equals(existingComida.getNombre()) && this.findByName(comida.getNombre()) != null) {
            throw new TipoComidaDuplicadoException("Ya existe una comida con ese nombre");
        }
        return comidaRepository.save(comida);
    }

    public List<TipoComida> getAllTiposComida() {
        return Arrays.asList(TipoComida.values());
    }

}