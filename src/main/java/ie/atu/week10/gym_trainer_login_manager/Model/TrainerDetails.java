package ie.atu.week10.gym_trainer_login_manager.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TrainerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long trainerID;
    @NotBlank(message = "User name is required")
    private String trainerName;
    @Email(message = "Email is required")
    private String email;
    @NotBlank(message = "password is required")
    private String password;

}
