package ie.atu.week10.gym_trainer_login_manager.Exceptions;

public class BookingConflictExceptionHandler extends RuntimeException{
    public BookingConflictExceptionHandler(String bookingConflict){super(bookingConflict);}
}
