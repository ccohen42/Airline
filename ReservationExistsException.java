package program7;

public class ReservationExistsException extends RuntimeException {
	
	public ReservationExistsException() {
		super("Invalid. This reservation already exists.\n");
	}
	
	public ReservationExistsException(String message) {
		super(message);
	}

}
