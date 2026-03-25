package ie.atu.oop.week3.gym_trainer_booking_manager.GlobalExceptionHandler;

public class EmailConflictExceptionHandler extends RuntimeException{
    public EmailConflictExceptionHandler(String emailAlreadyPresent){super(emailAlreadyPresent);}
}
