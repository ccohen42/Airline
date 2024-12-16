package program7;

public class Passenger extends Person{

	//Fields
	private int bookingReference;
	private String passportNumber;
	private String nationality;
	
	//Constructor
	public Passenger (String fname, String lname, Gender gen, Address add, String bday, int book, String pass, String nation) {
		super(fname, lname, gen, add, bday);
		bookingReference = book;
		passportNumber = pass;
		nationality = nation;
	}
	
	public Passenger (Passenger pass) {
		super(pass);
		bookingReference = pass.bookingReference;
		passportNumber = pass.passportNumber;
		nationality = pass.nationality;
	}
	
	public void setBookingReference (int book) {
		bookingReference = book;
	}
	
	public void setPassportNumber(String pass) {
		passportNumber = pass;
	}
	
	public void setNationality (String nation) {
		nationality = nation;
	}
	
	public int getBookingReference() {
		return bookingReference;
	}
	
	public String getPassportNumber() {
		return passportNumber;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Passenger:\n" + super.toString() + "\nBooking Reference: " + bookingReference + "\nPassport Number: " + passportNumber + "\nNationality: " + nationality);
		return str.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passenger other = (Passenger) obj;
		if (passportNumber == null) {
			if (other.passportNumber != null)
				return false;
		} else if (!passportNumber.equals(other.passportNumber))
			return false;
		return true;
	} 
	
	
}
