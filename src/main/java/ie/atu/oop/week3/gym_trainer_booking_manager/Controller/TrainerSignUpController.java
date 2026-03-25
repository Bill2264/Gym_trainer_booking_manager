package ie.atu.oop.week3.gym_trainer_booking_manager.Controller;

import ie.atu.oop.week3.gym_trainer_booking_manager.GlobalExceptionHandler.EmailConflictExceptionHandler;
import ie.atu.oop.week3.gym_trainer_booking_manager.Service.TrainerSignupService;
import ie.atu.oop.week3.gym_trainer_booking_manager.model.TrainerDetails;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Trainer")
public class TrainerSignUpController {
    private final TrainerSignupService trainerSignupService;
    public TrainerSignUpController(TrainerSignupService trainerSignupService){this.trainerSignupService = trainerSignupService;}
    @PostMapping("/Signup")
    public ResponseEntity<TrainerDetails> trainerSignup(@Valid @RequestBody TrainerDetails trainerDetails)
    {
        TrainerDetails saved;
        try {
            saved = trainerSignupService.trainerSignUp(trainerDetails);
        }
        catch (EmailConflictExceptionHandler e)
        {
            throw new RuntimeException(e);
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
}
