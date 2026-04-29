package ie.atu.week10.gym_trainer_login_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GymTrainerLoginManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(GymTrainerLoginManagerApplication.class, args);
    }

}
