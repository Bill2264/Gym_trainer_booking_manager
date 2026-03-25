package ie.atu.oop.week3.gym_trainer_booking_manager.Repository;

import ie.atu.oop.week3.gym_trainer_booking_manager.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepo extends JpaRepository<UserDetails, Long> {
}
