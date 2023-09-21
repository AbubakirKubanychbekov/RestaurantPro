package boss.services.impl;

import boss.dto.SimpleResponse;
import boss.dto.request.CategoryRequest;
import boss.dto.response.CategoryResponse;
import boss.entities.Category;
import boss.exceptions.BadCredentialsException;
import boss.exceptions.NotFoundException;
import boss.repo.CategoryRepo;
import boss.repo.dao.CategoryJdbcTemplate;
import boss.services.CategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryServiceImpl implements CategoryService {

   private final CategoryRepo categoryRepo;
   private final CategoryJdbcTemplate categoryJdbcTemplate;


    @Override
    public List<CategoryResponse> getAllCategories() {
        return categoryJdbcTemplate.getAllCategories();
    }

    @Override
    public SimpleResponse saveCategory(CategoryRequest saveCategory) {
        Category category=new Category();
        category.setName(saveCategory.name());
        categoryRepo.save(category);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Category with id: %s is saved".formatted(category.getId()))
                .build();
    }

    @Override
    public CategoryResponse getCategoryById(Long id) {
        return categoryJdbcTemplate.getCategoryById(id).orElseThrow(()->
                new NotFoundException("CATEGORY with id: %s not found".formatted(id)));
    }

    @Override
    public SimpleResponse updateCategory(Long id, CategoryRequest categoryRequest) {
        Category category = categoryRepo.findById(id).orElseThrow(() ->
                new NotFoundException("Category with id: %s not found".formatted(id)));
        category.setName(categoryRequest.name());
        categoryRepo.save(category);
        log.info("Category is updated");
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Category with id: %s is updated".formatted(category.getId()))
                .build();
    }

    @Override
    public SimpleResponse deleteCategory(Long id) {
        if (!categoryRepo.existsById(id)){
            throw new BadCredentialsException("Category with id: %s is exists".formatted(id));
        }
        categoryRepo.deleteById(id);
        log.info("Category is deleted");
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("Category with id: %s is deleted".formatted(id))
                .build();
    }
}
