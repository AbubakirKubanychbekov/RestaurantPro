package boss.services;

import boss.dto.SimpleResponse;
import boss.dto.request.RestaurantRequest;
import boss.dto.response.RestaurantResponse;

import java.util.List;

public interface RestaurantService {
    List<RestaurantResponse> getAllRestaurants();

    SimpleResponse saveRest(RestaurantRequest saveRest);

    RestaurantResponse getRestById(Long id);

    SimpleResponse deleteRestById(Long id);

    SimpleResponse updateRest(Long id, RestaurantRequest restaurantRequest);
}
