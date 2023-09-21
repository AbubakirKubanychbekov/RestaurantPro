package boss.services;

import boss.dto.SimpleResponse;
import boss.dto.request.SubCategoryRequest;
import boss.dto.response.SubCategoryResponse;

import java.util.List;

public interface SubCategoryService {
    List<SubCategoryResponse> getAllSubCats();

    SimpleResponse saveSubC(Long catId,Long menuId,SubCategoryRequest saveSabC);
}
