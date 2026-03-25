package ie.atu.oop.week3.gym_trainer_booking_manager.Service;

import ie.atu.oop.week3.gym_trainer_booking_manager.GlobalExceptionHandler.EmailConflictExceptionHandler;
import ie.atu.oop.week3.gym_trainer_booking_manager.Repository.UserDetailsRepo;
import ie.atu.oop.week3.gym_trainer_booking_manager.model.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSignupService {
    private final UserDetailsRepo userDetailsRepo;
    public UserSignupService(UserDetailsRepo userDetailsRepo)
    {
        this.userDetailsRepo = userDetailsRepo;
    }
    public UserDetails userSignUp(UserDetails userDetails) throws EmailConflictExceptionHandler
    {
        List<UserDetails> userDetailsList = userDetailsRepo.findAll();
        for (UserDetails u: userDetailsList)
        {
            if(userDetails.getEmail().equals(u.getEmail()))
            {
                throw new EmailConflictExceptionHandler("Email is already used");
            }
        }
        userDetailsRepo.save(userDetails);
        return userDetails;
    }
}

