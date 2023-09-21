package boss.repo.dao;

import boss.dto.response.CategoryResponse;

import java.util.List;
import java.util.Optional;

public interface CategoryJdbcTemplate {
    List<CategoryResponse>getAllCategories();

    Optional<CategoryResponse>getCategoryById(Long id);
}
