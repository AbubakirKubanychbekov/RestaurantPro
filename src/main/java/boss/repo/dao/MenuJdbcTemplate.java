package boss.repo.dao;

import boss.dto.response.MenusResponse;

import java.util.List;
import java.util.Optional;

public interface MenuJdbcTemplate {

    List<MenusResponse> getAllMenus();

    Optional<MenusResponse>getMeById(Long id);
}
