package ie.atu.oop.week3.gym_trainer_booking_manager.Service;

import ie.atu.oop.week3.gym_trainer_booking_manager.model.Login;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrainerSignupService {
    private final List<Login> trainerDetails = new ArrayList<>();
    public Login Signup(Login login) {
        trainerDetails.add(login);
        return login;
    }
    public List<Login> getTrainerDetails(){return trainerDetails;}
}
