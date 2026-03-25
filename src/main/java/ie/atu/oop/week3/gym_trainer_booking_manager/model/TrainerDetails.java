package ie.atu.oop.week3.gym_trainer_booking_manager.model;

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
    private long TrainerID;
    @NotBlank(message = "User name is required")
    private String TrainerName;
    @Email(message = "Email is required")
    private String email;
    @NotBlank(message = "password is required")
    private String password;

}
