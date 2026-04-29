package ie.atu.week10.gym_trainer_login_manager.Clients;

import ie.atu.week10.gym_trainer_login_manager.Model.TrainerDetails;
import ie.atu.week10.gym_trainer_login_manager.Model.UserDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="User-service", url="http://localhost:8080")
public interface UserClient {
    @GetMapping("/User/{userName}")
    UserDetails getUserDetails(@PathVariable String userName);
}
