package boss.repo.dao;

import boss.dto.response.SubCategoryResponse;

import java.util.List;

public interface SubCategoryJdbcTemplate {

    List<SubCategoryResponse>getAllSubCats();
}
