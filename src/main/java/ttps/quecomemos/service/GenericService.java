package ttps.quecomemos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public abstract class GenericService<T> {

    private final JpaRepository<T, Long> repository;

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
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public T findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Transactional
    public void delete(T entity) {
        repository.delete(entity);
    }

    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Transactional
    public void deleteAll() {
        repository.deleteAll();
    }

    @Transactional
    public T update(T entity) {
        return repository.save(entity);
    }
}
