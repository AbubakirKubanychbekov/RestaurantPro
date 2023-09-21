package boss.repo.dao.impl;

import boss.dto.response.SubCategoryResponse;
import boss.repo.dao.SubCategoryJdbcTemplate;
import boss.services.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SubCategoryJdbcTemplateImpl implements SubCategoryJdbcTemplate {

    private final JdbcTemplate jdbcTemplate;

    private SubCategoryResponse rowMapper(ResultSet rs,int rowName) throws SQLException{
        return new SubCategoryResponse(
                rs.getString("name")
        );
    }

    @Override
    public List<SubCategoryResponse> getAllSubCats() {
        String sql = """
                select id,
                name as name
                from sub_categories
                """;
        return jdbcTemplate.query(sql,this::rowMapper);
    }
}
