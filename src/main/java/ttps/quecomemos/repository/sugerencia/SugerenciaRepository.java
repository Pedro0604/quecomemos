package ttps.quecomemos.repository.sugerencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ttps.quecomemos.modelo.sugerencia.Sugerencia;

@Repository
public interface SugerenciaRepository extends JpaRepository<Sugerencia, Long> {
}