package ie.atu.week10.gym_trainer_login_manager.Service;

import ie.atu.week10.gym_trainer_login_manager.Exceptions.BookingConflictExceptionHandler;
import ie.atu.week10.gym_trainer_login_manager.Exceptions.NameNotFoundExceptionHandler;
import ie.atu.week10.gym_trainer_login_manager.Model.Booking;
import ie.atu.week10.gym_trainer_login_manager.Model.TrainerDetails;
import ie.atu.week10.gym_trainer_login_manager.Model.UserDetails;
import ie.atu.week10.gym_trainer_login_manager.clients.TrainerClient;
import ie.atu.week10.gym_trainer_login_manager.clients.UserClient;
import ie.atu.week10.gym_trainer_login_manager.Repository.BookingRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    public final TrainerClient trainerClient;
    public final UserClient userClient;
    public final BookingRepo bookingRepo;
    public LoginService(BookingRepo bookingRepo,TrainerClient trainerClient,UserClient userClient)
    {
        this.trainerClient = trainerClient;
        this.userClient = userClient;
        this.bookingRepo = bookingRepo;
    }

    public Boolean trainerLogin(TrainerDetails trainerDetails)
    {
        try {
            TrainerDetails t = trainerClient.getTrainerDetails(trainerDetails.getTrainerName());
            return trainerDetails.equals(t);
        }
        catch(RuntimeException e)
        {
            throw new RuntimeException(e);
        }
    }

    public Boolean userLogin(UserDetails userDetails) {
        try {
            UserDetails u = userClient.getUserDetails(userDetails.getUserName());
            return userDetails.equals(u);
        }
        catch (RuntimeException e)
        {
            throw new RuntimeException(e);
        }
    }

    public List<Booking> getBookings()
    {
        return bookingRepo.findAll();
    }

    public List<Booking> getBookingsByTrainerName(String trainerName)
    {
        return bookingRepo.findAllByTrainerName(trainerName);
    }

    public Booking makeBooking(UserDetails userDetails,Booking booking)
    {
        if(!userDetails.getUserName().equals(booking.getUserName()))
        {
            throw new BookingConflictExceptionHandler("Username must be same on booking as on Login");
        }
        if(!booking.getTrainerName().equals(trainerClient.getTrainerDetails(booking.getTrainerName()).getTrainerName()))
        {
            throw new NameNotFoundExceptionHandler("Trainer not found");
        }
        List<Booking> bookings = bookingRepo.findAll();
        if(userLogin(userDetails))
        {
            for(Booking b:bookings)
            {
                if(booking.getTrainerName().equals(b.getTrainerName())&&
                        booking.getBookingDate().equals(b.getBookingDate()))
                {
                    int existStart = b.getStartHour();
                    int existEnd = b.getStartHour()+b.getDurationHour();
                    int newStart = booking.getStartHour();
                    int newEnd = booking.getStartHour()+booking.getDurationHour();
                    if(existStart < newEnd && newStart < existEnd){
                        if(userDetails.getUserName().equals(b.getUserName())) {
                            throw new BookingConflictExceptionHandler("Booking already made by you");
                        }
                        else{
                            throw new BookingConflictExceptionHandler("Booking already made by another");
                        }
                    }
                }
            }
        }
        bookingRepo.save(booking);
        return booking;
    }

    public List<String> getTrainerNames()
    {
        return trainerClient.getTrainerNames();
    }
}
