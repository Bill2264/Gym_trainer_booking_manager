package ie.atu.oop.week3.gym_trainer_booking_manager.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Login {
    @Email(message = "Email is required")
    private String email;
    @NotBlank(message = "password is required")
    private String password;
}
