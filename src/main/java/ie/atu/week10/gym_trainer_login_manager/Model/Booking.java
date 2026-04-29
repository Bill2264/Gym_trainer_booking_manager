package ie.atu.week10.gym_trainer_login_manager.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long bookingId;
    @NotBlank(message = "User name is required")
    private String trainerName;
    @NotBlank(message = "User name is required")
    private String userName;
    @NotBlank
    private LocalDate bookingDate;
    @Min(value = 6, message = "Start Hour must be 6 or greater")
    @Max(value = 19, message = "Start Hour must be 19 or less")
    private int startHour;
    @Min(value = 1, message = " Duration must be 1 or greater")
    @Max(value = 2, message = "Duration Hour must be 2 or less")
    private int durationHour;
}
