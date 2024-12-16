package program7;
import java.time.*;

public class Reservation {

	//These are the fields
	private Flight flight;
	private Passenger passenger;
	private BookingStatus bookingStatus;
	private LocalDate reservationDate;
	
	//Overloaded constructor
	public Reservation(Flight flight, Passenger passenger, BookingStatus bookingStatus) {
		this.flight = flight;
		this.passenger = passenger;
		this.bookingStatus = bookingStatus;
	}
	
	//Overloaded constructor
	public Reservation(Flight flight, Passenger passenger, BookingStatus bookingStatus, LocalDate reservationDate) {
		this (flight, passenger, bookingStatus);
		this.reservationDate = reservationDate;
	}
	
	//Overloaded constructor
	public Reservation(Flight flight, Passenger passenger, BookingStatus bookingStatus, String reservationDate) {
		this (flight, passenger, bookingStatus);
		this.reservationDate = LocalDate.parse(reservationDate);
	}
	
	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
	public void setReservaitonDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}
	
	public Flight getFlight() {
		return flight;
	}
	
	public Passenger getPassenger() {
		return passenger;
	}
	
	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}
	
	public LocalDate getReservationDate() {
		return reservationDate;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("\n" + flight + "\n" + passenger + "Booking Status: " + bookingStatus + "Reservation Date " + reservationDate);
		return str.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (flight == null) { 
			if (other.flight != null)
				return false;
		} else if (!flight.equals(other.flight))
			return false;
		if (passenger == null) {
			if (other.passenger != null)
				return false;
		} else if (!passenger.equals(other.passenger))
			return false;
		return true;
	}
}
