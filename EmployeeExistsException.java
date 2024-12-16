package program7;

public class EmployeeExistsException extends RuntimeException {
	
	public EmployeeExistsException() {
		super("Invalid! This Employee already exists.\n");
	}
	
	public EmployeeExistsException(String message) {
		super(message);
	}

}

