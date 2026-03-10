package ie.atu.oop.week3.gym_trainer_booking_manager.Controller;


import ie.atu.oop.week3.gym_trainer_booking_manager.Service.UserSignupService;
import ie.atu.oop.week3.gym_trainer_booking_manager.model.UserLogin;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/User")
public class UserSignupController {
    private final UserSignupService userLoginService;
    public UserSignupController(UserSignupService userLoginService){this.userLoginService = userLoginService;}
    @PostMapping("/Signup")
    public ResponseEntity<UserLogin> Signup(@Valid @RequestBody UserLogin userlogin)
    {
        UserLogin details = userLoginService.Signup(userlogin);
        return ResponseEntity.status(HttpStatus.CREATED).body(details);
    }
}
