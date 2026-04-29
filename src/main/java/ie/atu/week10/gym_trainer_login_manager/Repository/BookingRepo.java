package ie.atu.week10.gym_trainer_login_manager.Repository;

import ie.atu.week10.gym_trainer_login_manager.Model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepo extends JpaRepository<Booking,Long> {
}
