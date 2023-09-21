package boss.dto.response;

import boss.enums.RestType;

public record RestaurantResponse(
        Long id,
        String name,
        String location,
        RestType restType,
        int numberOfEmployees,
        int service
) {
}
