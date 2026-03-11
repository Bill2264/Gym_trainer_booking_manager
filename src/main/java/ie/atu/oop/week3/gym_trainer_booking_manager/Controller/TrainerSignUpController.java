package ie.atu.oop.week3.gym_trainer_booking_manager.Controller;

import ie.atu.oop.week3.gym_trainer_booking_manager.Service.TrainerSignupService;
import ie.atu.oop.week3.gym_trainer_booking_manager.model.Login;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Trainer")
public class TrainerSignUpController {
    private final TrainerSignupService trainerSignupService;
    public TrainerSignUpController(TrainerSignupService trainerSignupService){this.trainerSignupService = trainerSignupService;}
    @PostMapping("/Signup")
    public ResponseEntity<Login> Signup(@Valid @RequestBody Login login)
    {
        Login details = trainerSignupService.Signup(login);
        return ResponseEntity.status(HttpStatus.CREATED).body(details);
    }
}
