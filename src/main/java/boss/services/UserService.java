package boss.services;

import boss.dto.SimpleResponse;
import boss.dto.request.AuthRequest;
import boss.dto.request.UserRequest;
import boss.dto.response.AuthResponse;

public interface UserService {

    void init();
    SimpleResponse signUp(UserRequest signUp, Long restId);

    AuthResponse signIn(AuthRequest signInRequest);
}
