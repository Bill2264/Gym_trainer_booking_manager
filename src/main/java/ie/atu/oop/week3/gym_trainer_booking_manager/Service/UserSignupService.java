package ie.atu.oop.week3.gym_trainer_booking_manager.Service;

import ie.atu.oop.week3.gym_trainer_booking_manager.model.UserLogin;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSignupService {
    private final List<UserLogin> userDetails = new ArrayList<>();
    public UserLogin Signup(UserLogin userLogin) {
        userDetails.add(userLogin);
        return userLogin;
    }
    public List<UserLogin> getUserDetails(){return userDetails;}
}

