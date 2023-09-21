package boss.dto.request;

import boss.enums.RestType;

public record RestaurantRequest(
        String name,
        String location,
        RestType restType,
        int numberOfEmployees,
        int service
) {

}
