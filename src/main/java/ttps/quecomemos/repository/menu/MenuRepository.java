package ttps.quecomemos.repository.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ttps.quecomemos.modelo.menu.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    Menu findByNombre(String nombre);
}