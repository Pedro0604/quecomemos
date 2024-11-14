package ttps.quecomemos.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ttps.quecomemos.exception.EmptyListException;

import java.util.List;

@Service
public abstract class GenericService<T> {

    private final JpaRepository<T, Long> repository;

    public String getName() {
        return this.getClass().getSimpleName().toLowerCase().replace("service", "");
    }

    @Autowired
    public GenericService(JpaRepository<T, Long> repository) {
        this.repository = repository;
    }

    @Transactional
    public T save(T entity) {
        return repository.save(entity);
    }

    @Transactional(readOnly = true)
    public List<T> findAll() {
        List<T> entities = repository.findAll();
        if (entities.isEmpty()) {
            throw new EmptyListException();
        } else {
            return entities;
        }
    }

    public List<T> findAllByIds(List<Long> ids) {
        List<T> entities = repository.findAllById(ids);
        if (entities.size() != ids.size()) {
            throw new EntityNotFoundException("Une o más " + this.getName() + " no fueron encontrades");
        }
        return entities;
    }

    @Transactional(readOnly = true)
    public T findById(Long id) {
        return repository
                .findById(id)
                .orElseThrow(
                        () -> new EntityNotFoundException("No se encontró le " + this.getName() + " con id " + id)
                );
    }

    @Transactional
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Transactional
    public void deleteById(Long id) {
        this.findById(id);
        repository.deleteById(id);
    }

    @Transactional
    public void deleteAll() {
        repository.deleteAll();
    }

    @Transactional
    public T update(T entity, Long id) {
        this.findById(id);
        return repository.save(entity);
    }
}
