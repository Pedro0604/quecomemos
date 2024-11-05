package ttps.quecomemos.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ttps.quecomemos.modelo.menu.Menu;
import ttps.quecomemos.repository.menu.MenuRepository;
import ttps.quecomemos.service.GenericService;

@Service
public class MenuService extends GenericService<Menu> {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        super(menuRepository);
        this.menuRepository = menuRepository;
    }

    @Transactional(readOnly = true)
    public Menu getByName(String nombre) {
        return menuRepository.findByNombre(nombre);
    }
}