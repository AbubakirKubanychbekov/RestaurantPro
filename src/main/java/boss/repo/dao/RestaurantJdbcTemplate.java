package boss.repo.dao;

import boss.dto.response.RestaurantResponse;

import java.util.List;
import java.util.Optional;

public interface RestaurantJdbcTemplate {

  List<RestaurantResponse>getAllRestaurants();
  Optional<RestaurantResponse> getRestById(Long id);
}
