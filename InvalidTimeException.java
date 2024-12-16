package program7;

public class InvalidTimeException extends RuntimeException{
public InvalidTimeException() {
	super("Invalid! Arrival time must be later than the departure time.\n");
}

public InvalidTimeException(String message) {
	super(message);
}
}
