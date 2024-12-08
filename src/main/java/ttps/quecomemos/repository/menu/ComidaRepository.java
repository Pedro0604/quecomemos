package ttps.quecomemos.repository.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ttps.quecomemos.modelo.menu.Comida;

@Repository
public interface ComidaRepository extends JpaRepository<Comida, Long> {
    Comida findByNombre(String nombre);
}