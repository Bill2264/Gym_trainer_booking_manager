package ie.atu.week10.gym_trainer_login_manager.Model;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
public class UserDetails {
    private long userID;
    @NotBlank(message = "User name is required")
    private String userName;
    @Email(message = "Email is required")
    private String email;
    @NotBlank(message = "password is required")
    private String password;


}
