package ie.atu.oop.week3.gym_trainer_booking_manager.Service;

import ie.atu.oop.week3.gym_trainer_booking_manager.GlobalExceptionHandler.EmailConflictExceptionHandler;
import ie.atu.oop.week3.gym_trainer_booking_manager.Repository.TrainerDetailsRepo;
import ie.atu.oop.week3.gym_trainer_booking_manager.model.TrainerDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainerSignupService {
    private final TrainerDetailsRepo trainerDetailsRepo;
    public TrainerSignupService(TrainerDetailsRepo trainerDetailsRepo){
        this.trainerDetailsRepo = trainerDetailsRepo;
    }

    public TrainerDetails trainerSignUp(TrainerDetails trainerDetails) throws EmailConflictExceptionHandler
    {
        List<TrainerDetails> trainerDetailsList = trainerDetailsRepo.findAll();
        for (TrainerDetails t: trainerDetailsList)
        {
            if(trainerDetails.getEmail().equals(t.getEmail()))
            {
                throw new EmailConflictExceptionHandler("Email is already used");
            }
        }
        trainerDetailsRepo.save(trainerDetails);
        return trainerDetails;
    }
}
