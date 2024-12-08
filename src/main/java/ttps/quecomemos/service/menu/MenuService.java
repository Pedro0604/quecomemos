package ttps.quecomemos.service.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ttps.quecomemos.dto.MenuRequest;
import ttps.quecomemos.exception.MenuSinComidasException;
import ttps.quecomemos.modelo.menu.Comida;
import ttps.quecomemos.modelo.menu.Menu;
import ttps.quecomemos.repository.menu.MenuRepository;
import ttps.quecomemos.service.GenericService;

import java.util.List;

@Service
public class MenuService extends GenericService<Menu> {

    private final MenuRepository menuRepository;
    private final ComidaService comidaService;

    @Autowired
    public MenuService(MenuRepository menuRepository, ComidaService comidaService) {
        super(menuRepository);
        this.menuRepository = menuRepository;
        this.comidaService = comidaService;
    }

    @Transactional(readOnly = true)
    public Menu findByName(String nombre) {
        return menuRepository.findByNombre(nombre);
    }

    @Transactional
    @Override
    public Menu save(Menu menu) {
        if (this.findByName(menu.getNombre()) != null) {
            throw new IllegalArgumentException("Ya existe un menú con ese nombre");
        }
        if (menu.getComidas().isEmpty()) {
            throw new MenuSinComidasException();
        }
        return menuRepository.save(menu);
    }

    @Transactional
    public Menu saveMenuRequest(MenuRequest menuRequest) {
        Menu menu = new Menu(menuRequest);
        if (this.findByName(menu.getNombre()) != null) {
            throw new IllegalArgumentException("Ya existe un menú con ese nombre");
        }
        List<Comida> comidas = comidaService.findAllByIds(menuRequest.getComidaIds());
        if (comidas.isEmpty()) {
            throw new MenuSinComidasException();
        }
        comidas.forEach(menu::addComida);
        return menuRepository.save(menu);
    }

    @Transactional
    @Override
    public Menu update(Menu menu, Long id) {
        Menu existingMenu = findById(id);
        if (!menu.getNombre().equals(existingMenu.getNombre()) && this.findByName(menu.getNombre()) != null) {
            throw new IllegalArgumentException("Ya existe un menú con ese nombre");
        }
        if (menu.getComidas().isEmpty()) {
            throw new MenuSinComidasException();
        }
        menu.setId(id);
        return menuRepository.save(menu);
    }

    @Transactional
    public Menu updateMenuRequest(MenuRequest menuRequest, Long id) {
        Menu existingMenu = findById(id);
        Menu menu = new Menu(menuRequest);
        if (!menu.getNombre().equals(existingMenu.getNombre()) && this.findByName(menu.getNombre()) != null) {
            throw new IllegalArgumentException("Ya existe un menú con ese nombre");
        }
        List<Comida> comidas = comidaService.findAllByIds(menuRequest.getComidaIds());
        if (comidas.isEmpty()) {
            throw new MenuSinComidasException();
        }
        comidas.forEach(menu::addComida);
        menu.setId(id);
        return menuRepository.save(menu);
    }
}