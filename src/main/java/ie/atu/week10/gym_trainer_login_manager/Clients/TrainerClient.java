package ie.atu.week10.gym_trainer_login_manager.Clients;

import ie.atu.week10.gym_trainer_login_manager.Model.TrainerDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="Trainer-service", url="http://localhost:8080")
public interface TrainerClient {
    @GetMapping("/Trainer/{trainerName}")
    TrainerDetails getTrainerDetails(@PathVariable String trainerName);
}
