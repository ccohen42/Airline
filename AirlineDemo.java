package program7;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class AirlineDemo {
public static void main (String[] args) {
	
	Scanner keyboard = new Scanner(System.in);
	Airline airline = new Airline();
	menu(keyboard, airline);
}

public static void menu(Scanner input, Airline airline) {
int choice;
	
	System.out.print("\n1. Add a flight\n2. Book a reservation\n3. "
		+ "Cancel a reservation\n4. Get info about a flight\n5. Get "
		+ "info about a passenger\n6. Add an employee\n7. Get info about an "
		+ "employee\n8. Exit\nEnter your choice: ");
	choice = input.nextInt();
	
	while (choice < 1 || choice > 8) {
		System.out.print("Invalid! Enter a number from 1-8: ");
		choice = input.nextInt();
	}
	
	choice(choice, input, airline);
}

public static void choice(int choice, Scanner input, Airline airline) {
	Scanner keyboard = new Scanner(System.in);
	switch (choice) {
	case 1:
		System.out.print("Enter the flight number: ");
		int flightNumber = keyboard.nextInt();
		while (flightNumber < 0) {
			System.out.print("Invalid! Enter a number greater than 0: ");
			flightNumber = keyboard.nextInt();
		}
		keyboard.nextLine();
		System.out.print("Enter the departure city: ");
		String departure = keyboard.nextLine();
		System.out.print("Enter the destination city: ");
		String destination = keyboard.nextLine();
		System.out.print("Enter the depature date and time.\nYear (4 digits): ");
		int year = keyboard.nextInt();
		while (year < 1000 || 9999 < year) {
			System.out.print("Invalid! Enter a 4 digit number: ");
			year = keyboard.nextInt();
		}
		System.out.print("Month (1-12): ");
		int month = keyboard.nextInt();
		while (month < 1 || month > 12) {
			System.out.print("Invalid! Enter a number from 1-12: ");
			month = keyboard.nextInt();
		}
		System.out.print("Day of Month: ");
		int day = keyboard.nextInt();
		while (day < 1 || day > 31) {
			System.out.print("Invalid! Enter a number from 1-31: ");
			day = keyboard.nextInt();
		}
		System.out.print("Hour: ");
		int hour = keyboard.nextInt();
		while(hour < 1 || hour > 12) {
			System.out.print("Invalid! Enter a number from 1-12: ");
			hour = keyboard.nextInt();
		}
		System.out.print("Minutes: ");
		int minutes = keyboard.nextInt();
		while (minutes < 0 || minutes > 59) {
			System.out.print("Invalid! Enter a number from 0-59");
			minutes = keyboard.nextInt();
		}
		System.out.print("Enter the arrival date and time.\nYear (4 digits): ");
		int y = keyboard.nextInt();
		while(y < 1000 || y > 9999) {
			System.out.print("Invalid! Enter a 4 digit number: ");
			y = keyboard.nextInt();
		}
		System.out.print("Month (1-12): ");
		int m = keyboard.nextInt();
		while (m < 1 || m > 12) {
			System.out.print("Invalid! Enter a number from 1-12: ");
			m = keyboard.nextInt();
		}
		System.out.print("Day of Month: ");
		int d = keyboard.nextInt();
		while (d < 1 || d > 31) {
			System.out.print("Invalid! Enter a number from 1-31: ");
			d = keyboard.nextInt();
		}
		System.out.print("Hour: ");
		int h = keyboard.nextInt();
		while(h < 1 || h > 12) {
			System.out.print("Invalid! Enter a number from 1-12: ");
			h = keyboard.nextInt();
		}
		System.out.print("Minutes: ");
		int min = keyboard.nextInt();
		while (min < 0 || min > 59) {
			System.out.print("Invalid! Enter a number from 0-59");
			min = keyboard.nextInt();
		}
		LocalDateTime dep = LocalDateTime.of(year, month, day, hour, minutes);
		LocalDateTime ar = LocalDateTime.of(y, m, d, h, min);
	
	
	try {
		Flight flight = new Flight(flightNumber, departure, destination, dep, ar);
	airline.addFlight(flight);
	System.out.println("\nFlight was added.");
	}
	catch (InvalidTimeException | FlightExistsException e) {
		System.out.println(e.getMessage());
	}
	menu(keyboard, airline);
	break;
	
	case 2:
		System.out.print("Enter a flight number:");
		flightNumber = input.nextInt();
		Flight findFlight = airline.findFlight(flightNumber);
		if (airline.findFlight(flightNumber) == null) {
			System.out.print("Invalid! Flight doesn't exist.");
			menu(input, airline);
			break;
		}
		
		System.out.print("Enter first name:");
		input.nextLine();
		String fnameE = input.nextLine();
		System.out.print("Enter last name:");
		String lnameE = input.nextLine();
		System.out.print("Gender (F or M): ");
		String gender1 = input.nextLine().toUpperCase();
		while (!gender1.equals("F") && !gender1.equals("M")) {
			System.out.print("Invalid! Please enter the letter F for female or M for male.");
			gender1 = input.nextLine().toUpperCase();}
		Gender gender = Gender.valueOf(gender1);
		System.out.println("Enter your address.");
		System.out.print("Street: ");
		String street = input.nextLine();
		System.out.print("City: ");
		String city = input.nextLine();
		System.out.print("State: ");
		String state = input.nextLine();
		System.out.print("Zipcode: ");
		String zipcode = input.nextLine();
		Address address = new Address(street, city, state, zipcode);
		System.out.println("Enter your Birthdate.");
		System.out.print("Year (4 digits): ");
		int yearB = input.nextInt();
		while (yearB < 1000 || yearB > 9999) {
			System.out.print("Invalid! Enter a 4 digit number: ");
			yearB = input.nextInt();}
		System.out.print("Month (1-12): ");
		int monthB = input.nextInt();
		while (monthB < 1 || monthB > 12) {
			System.out.print("Invalid! Enter a number from 1-12: ");
			monthB = input.nextInt();}
		System.out.print("Day of Month: ");
		int dayB = input.nextInt();
		while (dayB < 1 || dayB > 31) {
			System.out.print("Invalid! Enter a number from 1-31: ");
		dayB = input.nextInt(); }
		LocalDate date = LocalDate.of(yearB, monthB, dayB);
		String birthdate = String.valueOf(date);
		System.out.print("Booking Reference: ");
		int bookingReference = input.nextInt();
		input.nextLine();
		System.out.print("Passport Number: ");
		String passportNumber = input.nextLine();
		System.out.print("Nationality: ");
		String nationality = input.nextLine();
		Passenger passenger = new Passenger(fnameE, lnameE, gender, address, 
					birthdate, bookingReference, passportNumber, nationality);
		System.out.println("Enter your Reservation Date.");
		System.out.print("Year (4 digits): ");
		int yearR = input.nextInt();
		while (yearR < 1000 || yearR > 9999) {
			System.out.print("Invalid! Enter a 4 digit number: ");
			yearR = input.nextInt();}
		System.out.print("Month: (1-12)");
		int monthR = input.nextInt();
		while (monthR < 1 || monthR > 12) {
			System.out.print("Invalid! Enter a number from 1-12: ");
			monthR = input.nextInt();}
		System.out.print("Day of Month: ");
		int dayR = input.nextInt();
		while (dayR < 1 || dayR > 31) {
			System.out.print("Invalid! Enter a number from 1-31: ");
		dayR = input.nextInt(); }
		LocalDate reservationDate = LocalDate.of(yearB, monthB, dayB);
		
		try {
			Reservation reservation = new Reservation(findFlight, passenger, BookingStatus.CONFIRMED, reservationDate);
			airline.addReservation(reservation);
			System.out.println("\nReservation added sucessfully.\n");
		}
		
		catch (ReservationExistsException e) {
			System.out.println(e.getMessage());
		}
		menu(input, airline);
		break;
		
	case 3:
		try {
		System.out.print("Enter a booking reference: ");
		bookingReference = input.nextInt();
		airline.CancelReservation(bookingReference);
		System.out.println("Reservation cancelled."); }
		catch (ReservationNotFoundException e) {
			System.out.println(e.getMessage());
		}
		menu(input, airline);
		break;
	
	case 4:
		System.out.print("Enter a flight number: ");
		flightNumber = input.nextInt();
		airline.findFlight(flightNumber);
		System.out.println(airline.findFlight(flightNumber));
		menu(input, airline);
		break;
		
	case 5:
		System.out.print("Enter a booking reference: ");
		bookingReference = input.nextInt();
		airline.findPassenger(bookingReference);
		System.out.println(airline.findPassenger(bookingReference));
		menu(input, airline);
		break;
		
	case 6:
		input.nextLine();
		System.out.print("Enter first name: ");
		fnameE = input.nextLine();
		input.nextLine();
		System.out.print("Enter last name: ");
		lnameE = input.nextLine();
		System.out.print("Gender (F or M): ");
		gender1 = input.nextLine().toUpperCase();
		while (!gender1.equals("F") && !gender1.equals("M")) {
			System.out.print("Invalid! Enter the letter F for female or M for male: ");
			gender1 = input.nextLine().toUpperCase();}
		gender = Gender.valueOf(gender1);
		input.nextLine();
		System.out.println("Enter your address.");
		System.out.print("Street: ");
		street = input.nextLine();
		input.nextLine();
		System.out.print("City: ");
		city = input.nextLine();
		input.nextLine();
		System.out.print("State: ");
		state = input.nextLine();
		input.nextLine();
		System.out.print("Zipcode: ");
		zipcode = input.nextLine();
		address = new Address(street, city, state, zipcode);
		System.out.println("Enter your Birthdate.");
		System.out.print("Year (4 digits): ");
		yearB = input.nextInt();
		while (yearB < 1000 || yearB >9999) {
			System.out.print("Invalid! Enter a 4 digit number: ");
			yearB = input.nextInt();}
		System.out.print("Month (1-12): ");
		monthB = input.nextInt();
		while (monthB < 1 || monthB > 12) {
			System.out.print("Invalid! Enter a number from 1-12: ");
			monthB = input.nextInt();}
		System.out.print("Day of Month: ");
		dayB = input.nextInt();
		while (dayB < 1 || dayB > 31) {
			System.out.print("Invalid! Enter a number from 1-31: ");
		dayB = input.nextInt(); }
		input.nextLine();
		date = LocalDate.of(yearB, monthB, dayB);
		birthdate = String.valueOf(date);
		input.nextLine();
		System.out.print("EmployeeID: ");
		String employeeID = input.nextLine();
		input.nextLine();
		System.out.print("Employee Type: ");
		String employeeType = input.nextLine();
		input.nextLine();
		System.out.print("Department: ");
		String department = input.nextLine();
		
		try {
			Employee employee = new Employee(fnameE, lnameE, gender, address, 
					birthdate, employeeID, employeeType, department);
			airline.addEmployee(employee);
			System.out.println("\nEmployee added.\n");
		}
		
		catch (EmployeeExistsException e) {
			System.out.println(e.getMessage());
		}
		menu(input, airline);
		break;
		
	case 7:
		System.out.print("Enter an EmployeeID: ");
		input.nextLine();
		employeeID = input.nextLine();
		airline.findEmployee(employeeID);
		System.out.println(airline.findEmployee(employeeID));
		menu(input, airline);
		break;
		
	case 8:
		System.out.println("Good Bye!");
		System.exit(0);

	}
	}
}
