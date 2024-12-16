package program7;
import java.time.*;

public class Flight {

	//These are the fields
private int flightNumber;
private String departureCity;
private String destinationCity;
private LocalDateTime departureTime;
private LocalDateTime arrivalTime;

// this is a no-arg constructor
public Flight() {
	flightNumber = 0;
	departureCity = "unkonwn";
	destinationCity = "unknown";
	departureTime = LocalDateTime.now();
	arrivalTime = LocalDateTime.now();
}

//this is a constructor
public Flight(int flightNumber, String departureCity, String destinationCity) {
	this.flightNumber = flightNumber;
	this.departureCity = departureCity;
	this.destinationCity = destinationCity;
	departureTime = LocalDateTime.now();
	arrivalTime = LocalDateTime.now();
}

public Flight(int flightNumber, String departureCity, String destinationCity, LocalDateTime departure, LocalDateTime arrival) throws InvalidTimeException{
	this (flightNumber, departureCity, destinationCity);
	if (this.departureTime.isBefore(this.arrivalTime)==false) {
		throw new InvalidTimeException();
	}
	departureTime = departure;
	arrivalTime = arrival;
}

	//sets the departure time
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	
	public void setArrivalTime (LocalDateTime arrivalTime) throws InvalidTimeException{
		if (departureTime.isBefore(arrivalTime)==false) {
			throw new InvalidTimeException();
		}
		this.arrivalTime = arrivalTime;
	}
	
	//returns the flight number
	public int getFlightNumber() {
		return flightNumber;
	}

	public String getDepartureCity() {
		return departureCity;
	}
	
	public String getDestinationCity() {
		return destinationCity;
	}
	
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Flight Number: " + flightNumber + "\nDeparture City " + departureCity + "\nDestination City: " + destinationCity + "\nDeparture Time: " + departureTime + "\nArrival Time: " + arrivalTime);
		return str.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (flightNumber != other.flightNumber)
			return false;
		return true;
	}
}
