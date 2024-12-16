package program7;

public class FlightExistsException extends RuntimeException{
	
	public FlightExistsException() {
		super("Invalid! This flight already exists.\n");
	}
	
	public FlightExistsException(String message) {
		super(message);
	}

}
