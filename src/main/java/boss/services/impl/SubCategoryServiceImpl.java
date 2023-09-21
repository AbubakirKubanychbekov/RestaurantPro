package boss.services.impl;

import boss.dto.SimpleResponse;
import boss.dto.request.SubCategoryRequest;
import boss.dto.response.SubCategoryResponse;
import boss.entities.Category;
import boss.entities.Menu;
import boss.entities.SubCategory;
import boss.exceptions.NotFoundException;
import boss.repo.CategoryRepo;
import boss.repo.MenuRepo;
import boss.repo.SubCategoryRepo;
import boss.repo.dao.SubCategoryJdbcTemplate;
import boss.services.MenuService;
import boss.services.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements SubCategoryService {

    private final SubCategoryRepo subCategoryRepo;
    private final CategoryRepo categoryRepo;
    private final MenuRepo menuRepo;
    private final SubCategoryJdbcTemplate subCategoryJdbcTemplate;

    @Override
    public List<SubCategoryResponse> getAllSubCats() {
        return subCategoryJdbcTemplate.getAllSubCats();
    }

    @Override
    public SimpleResponse saveSubC(Long catId,Long menuId ,SubCategoryRequest saveSabC) {
        Category category = categoryRepo.findById(catId).orElseThrow(() ->
                new NotFoundException("Category with id: %s not found".formatted(catId)));
        Menu menu = menuRepo.findById(menuId).orElseThrow(() ->
                new NotFoundException("Menu with id: %s not found".formatted(menuId)));
        SubCategory subCategory=new SubCategory();
        subCategory.setName(saveSabC.name());
        subCategory.setCategory(category);



        return null;
    }
}
