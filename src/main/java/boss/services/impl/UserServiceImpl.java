package boss.services.impl;

import boss.dto.SimpleResponse;
import boss.dto.request.AuthRequest;
import boss.dto.request.UserRequest;
import boss.dto.response.AuthResponse;
import boss.entities.Restaurant;
import boss.entities.User;
import boss.enums.Role;
import boss.exceptions.BadCredentialsException;
import boss.exceptions.NotFoundException;
import boss.repo.RestaurantRepo;
import boss.repo.UserRepo;
import boss.security.JwtService;
import boss.services.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepo userRepo;
    private final JwtService jwtService;
    private final RestaurantRepo restaurantRepo;


    @PostConstruct
    @Override
    public void init() {
    User user=new User();
    user.setRole(Role.ADMIN);
    user.setFirstName("Abubakir");
    user.setLastName("Boss");
    user.setDateOfBirth(LocalDate.of(1997,05,06));
    user.setEmail("admin@gmail.com");
    user.setPassword(passwordEncoder.encode("admin"));
    user.setPhoneNumber("+996778000202");
    user.setExperience(5);
      if (!userRepo.existsByEmail("admin@gmail.com")){
          userRepo.save(user);
      }
    }


    @Override
    public SimpleResponse signUp(UserRequest signUp,Long restId) {
        Restaurant restaurant = restaurantRepo.findById(restId).orElseThrow(() ->
                new NotFoundException("Restaurant with id: %s not found".formatted(restId)));
        User user = new User();
        user.setFirstName(signUp.firstName());
        user.setLastName(signUp.lastName());
        user.setDateOfBirth(signUp.dateOfBirth());
        user.setEmail(signUp.email());
        user.setPassword(passwordEncoder.encode(signUp.password()));
        user.setPhoneNumber(signUp.phoneNumber());
        user.setRole(signUp.role());
        user.setExperience(signUp.experience());
        user.setRestaurant(restaurant);
        if (!userRepo.existsByEmail(signUp.email())){
             userRepo.save(user);
             log.info("User successfully saved");
             return SimpleResponse.builder()
                     .httpStatus(HttpStatus.OK)
                     .message("Successfully save user with id: "+user.getId())
                     .build();
        }else{
            return SimpleResponse.builder()
                    .httpStatus(HttpStatus.BAD_REQUEST)
                    .message("Role is invalid!")
                    .build();
        }
    }

    @Override
    public AuthResponse signIn(AuthRequest signInRequest) {
        User user = userRepo.getUserByEmail(signInRequest.email()).orElseThrow(() ->
                new EntityNotFoundException("User with email: " + signInRequest.email() + " not found"));


        if (signInRequest.email().isBlank()){
            throw new BadCredentialsException("Email is blank");
        }
        if (!passwordEncoder.matches(signInRequest.password(),user.getPassword())){
            throw new BadCredentialsException("Wrong password!");
        }
        Role role= user.getRole();
        String jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .email(user.getEmail())
                .token(jwtToken)
                .role(role)
                .build();
    }

}
