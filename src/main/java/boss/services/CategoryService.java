package boss.services;

import boss.dto.SimpleResponse;
import boss.dto.request.CategoryRequest;
import boss.dto.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getAllCategories();

    SimpleResponse saveCategory(CategoryRequest saveCategory);

    CategoryResponse getCategoryById(Long id);

    SimpleResponse updateCategory(Long id, CategoryRequest categoryRequest);

    SimpleResponse deleteCategory(Long id);
}
