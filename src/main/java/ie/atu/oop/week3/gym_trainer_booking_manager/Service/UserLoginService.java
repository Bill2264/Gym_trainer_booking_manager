package ie.atu.oop.week3.gym_trainer_booking_manager.Service;

import ie.atu.oop.week3.gym_trainer_booking_manager.model.UserLogin;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserLoginService {
    private final List<UserLogin> userdetails = new ArrayList<>();
    public UserLogin adddetails(UserLogin userlogin) {
        userdetails.add(userlogin);
        return userlogin;
    }
    public boolean Login(UserLogin userLogin)
    {
        boolean logincheck = false;
            for (UserLogin userdetail : userdetails) {
                if(userLogin == userdetail)
                {
                    logincheck = true;
                }

            }

            return logincheck;
    }
}
