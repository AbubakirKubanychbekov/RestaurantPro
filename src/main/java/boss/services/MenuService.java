package boss.services;

import boss.dto.SimpleResponse;
import boss.dto.request.MenuRequest;
import boss.dto.response.MenusResponse;

import java.util.List;

public interface MenuService {
    List<MenusResponse> getAllMenus();

    SimpleResponse saveMenu(MenuRequest saveMenu, Long restId);

    MenusResponse getMeById(Long id);

    SimpleResponse deleteMe(Long id);

    SimpleResponse updateMenu(Long id, Long menuId,MenuRequest menuRequest);
}
