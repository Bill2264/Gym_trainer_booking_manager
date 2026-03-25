package ie.atu.oop.week3.gym_trainer_booking_manager.Controller;

import ie.atu.oop.week3.gym_trainer_booking_manager.GlobalExceptionHandler.EmailConflictExceptionHandler;
import ie.atu.oop.week3.gym_trainer_booking_manager.Service.UserSignupService;
import ie.atu.oop.week3.gym_trainer_booking_manager.model.UserDetails;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/User")
public class UserSignUpController {
    private final UserSignupService userSignupService;
    public UserSignUpController(UserSignupService userSignupService){this.userSignupService = userSignupService;}
    @PostMapping("/Signup")
    public ResponseEntity<UserDetails> userSignup(@Valid @RequestBody UserDetails userDetails)
    {
        UserDetails saved;
        try {
            saved = userSignupService.userSignUp(userDetails);
        }
        catch (EmailConflictExceptionHandler e)
        {
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
