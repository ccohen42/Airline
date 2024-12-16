package program7;
import java.util.ArrayList;

public class Airline {

	
	//Fields
	private ArrayList<Flight> flights;
	private ArrayList<Reservation> reservations;
	private ArrayList<Employee> employees;
	
	//No-arg constructor
	public Airline() {
		flights = new ArrayList<Flight>();
		reservations = new ArrayList<Reservation>();
		employees = new ArrayList<Employee>();
	}
	
	//Constructor with deep copies
	public Airline (ArrayList<Flight> flights, ArrayList<Reservation> reservations, ArrayList<Employee> employees) {
		ArrayList<Flight> flightsList = new ArrayList<>();
		for (int i = 0; i < flights.size(); i++)
		{
			flightsList.add(flights.get(i));
		}
		this.flights = new ArrayList<>(flightsList);
		
		ArrayList<Reservation> reservationsList = new ArrayList<>();
		for(int i =0; i < reservations.size(); i++)
		{
			reservationsList.add(reservations.get(i));
		}
		this.reservations = new ArrayList<>(reservationsList);
		
		ArrayList<Employee> employeeList = new ArrayList<>();
		for(int i = 0; i < employees.size(); i++)
		{
			employeeList.add(employees.get(i));
		}
		this.employees = new ArrayList<>(employeeList);
	}
	
	//Setter with a deep copy
	public void setFlights(ArrayList<Flight> flights) {
		ArrayList<Flight> flightsList = new ArrayList<>();
		for(int i = 0; i < flights.size(); i++) {
			flightsList.add(flights.get(i));
		}
		this.flights = new ArrayList<Flight>(flightsList);
	}
	
	public void setReservations(ArrayList<Reservation> reservation) {
		ArrayList<Reservation> reservationsList = new ArrayList<>();
		for(int i = 0; i < reservations.size(); i++) {
			reservationsList.add(reservations.get(i));
		}
		this.reservations = new ArrayList<Reservation>(reservationsList);
	}
	
	public void setEmployees(ArrayList<Employee> employees) {
		ArrayList<Employee> employeeList = new ArrayList<>();
		for(int i = 0; i < employees.size(); i++) 
		{	employeeList.add(employees.get(i));}
		}
		
		
		//Getter with a deep copy
		public ArrayList<Flight> getFlights(){
			ArrayList<Flight> flightsList = new ArrayList<>();
			for(int i = 0; i < flights.size(); i++) {
				flightsList.add(flights.get(i));
			}
			return flightsList;
		}
		
		public ArrayList<Reservation> getReservations(){
			ArrayList<Reservation> reservationsList = new ArrayList<>();
			for(int i = 0; i < reservations.size(); i++) {
				reservationsList.add(reservations.get(i));
			}
			return reservationsList;
		}
		
		public ArrayList<Employee> getEmployees(){
			ArrayList<Employee> employeesList = new ArrayList();
			for(int i = 0; i < employees.size(); i++) {
				employeesList.add(employees.get(i));
			}
			return employeesList;
		}
		
		@Override
		public String toString() {
			StringBuilder str = new StringBuilder();
			str.append("Fligts:\n");
			for (int i = 0; i < reservations.size(); i++) {
				str.append(reservations.get(i) + "\n");
			}
			str.append("Reservations:\n");
			for (int i = 0; i < reservations.size(); i++) {
				str.append(reservations.get(i) + "\n");
			}
			str.append("Employee:\n");
			for(int i = 0; i < employees.size(); i++) {
				str.append(employees.get(i) + "\n");
			}
			return str.toString();
	}
		
		public void addFlight(Flight flight) throws FlightExistsException{
			if(!flights.contains(flight))
				flights.add(flight);
			else 
				throw new FlightExistsException();
		}
		
		public void addReservation (Reservation i) throws ReservationExistsException {
			if(!reservations.contains(i))
				reservations.add(i);
			else {
				throw new ReservationExistsException();
			}
		}
		
		public void CancelReservation (int bookingReference) {
			boolean x = false;
			for (Reservation i:reservations) {
				if(i.getPassenger().getBookingReference() == bookingReference) {
					reservations.remove(i);
					x = true;
				}
			}
			if (x == false)
				throw new ReservationNotFoundException();
		}
		
		public Flight findFlight(int flightNumber) {
			for (Flight i:flights) {
				if(i.getFlightNumber() == flightNumber)
					return i;
			}
			return null;
		}
		
		public Passenger findPassenger (int bookingReference) {
			for(Reservation i:reservations) {
				if(i.getPassenger().getBookingReference() == bookingReference)
					return i.getPassenger();
			}
			return null;
		}
		
		public void addEmployee(Employee e) throws EmployeeExistsException{
			if(!employees.contains(e))
				employees.add(e);
			else {
				throw new EmployeeExistsException();
			}
		}

		public Employee findEmployee (String employeeID) {
			for (Employee e:employees) {
				if(e.getEmployeeID().equals(employeeID))
			return e;
			}
			return null;
		}
	
	}