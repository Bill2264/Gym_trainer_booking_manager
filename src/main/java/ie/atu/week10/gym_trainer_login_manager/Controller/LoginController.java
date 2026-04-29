package ie.atu.week10.gym_trainer_login_manager.Controller;

import ie.atu.week10.gym_trainer_login_manager.Model.Booking;
import ie.atu.week10.gym_trainer_login_manager.Model.BookingHolder;
import ie.atu.week10.gym_trainer_login_manager.Model.UserDetails;
import ie.atu.week10.gym_trainer_login_manager.Service.LoginService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Login")
public class LoginController {
    private final LoginService loginService;
    public LoginController(LoginService loginService)
    {
        this.loginService = loginService;
    }

    @GetMapping("/GetBookings")
    public ResponseEntity<List<Booking>> getAllBookings()
    {
        return ResponseEntity.ok(loginService.getBookings());
    }

    @GetMapping("/GetBookings/ByTrainer/{trainerName}")
    public ResponseEntity<List<Booking>> getBookingsByTrainer(@PathVariable String trainerName)
    {
        return ResponseEntity.ok(loginService.getBookingsByTrainerName(trainerName));
    }

    @GetMapping("/GetTrainerNames")
    public ResponseEntity<List<String>> getTrainerNames()
    {
        return ResponseEntity.ok(loginService.getTrainerNames());
    }

    @PostMapping("/MakeBooking")
    public ResponseEntity<Booking> MakeBooking(@Valid @RequestBody BookingHolder bookingHolder)
    {
        return ResponseEntity.ok(loginService.makeBooking(bookingHolder));
    }
}
