package boss.repo.dao;

import boss.dto.response.StopListResponse;

import java.util.List;
import java.util.Optional;

public interface StopListJdbcTemplate {

    List<StopListResponse> getAllStopLists();

    Optional<StopListResponse>getSlById(Long id);
}
