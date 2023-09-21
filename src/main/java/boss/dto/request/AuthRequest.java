package boss.dto.request;

import boss.enums.Role;

public record AuthRequest(
        String email,
        String password,
        Role role
) {
}
