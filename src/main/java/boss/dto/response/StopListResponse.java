package boss.dto.response;

import boss.entities.Menu;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDate;

@Builder
public record StopListResponse(
         String reason,
         LocalDate date,
         @JsonProperty("menuName")
         String menuName
) {
}
