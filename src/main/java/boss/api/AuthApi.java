package boss.api;

import boss.dto.SimpleResponse;
import boss.dto.request.AuthRequest;
import boss.dto.request.UserRequest;
import boss.dto.response.AuthResponse;
import boss.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@Tag(name = "AuthApi")
public class AuthApi {

    private final UserService userService;


    @PostMapping("/signUp/{restId}")
    @Operation(summary = "Sign Up")
    ResponseEntity<SimpleResponse> signUp(@RequestBody @Valid UserRequest signUp,
                                          @PathVariable Long restId){
      return ResponseEntity.ok(userService.signUp(signUp,restId));
    }


    @PostMapping("/sigIn")
    @Operation(summary = "Sign In")
    AuthResponse signIn(@RequestBody AuthRequest signInRequest){
        return userService.signIn(signInRequest);
    }

}
