package program7;
import java.time.*;

public class Person {

	//Fields
	private String firstName;
	private String lastName;
	private Gender gender;
	private Address address;
	private LocalDate birthdate;
	
	//Constructor
	public Person(String fname, String lname, Gender gen, Address add, String bday) {
		firstName = fname;
		lastName = lname;
		gender = gen;
		address = add;
		birthdate = LocalDate.parse(bday);
	}
	
	public Person(String fname, String lname, Gender gen, String s, String c, String state, String zip, String bday) {
		firstName = fname;
		lastName = lname;
		gender = gen;
		address = new Address(s, c, state, zip);
		birthdate = LocalDate.parse(bday);
	}
	
	public Person(String fname, String lname, Gender gen, Address add, LocalDate bday) {
		firstName = fname;
		lastName = lname;
		gender = gen;
		address = add;
		birthdate = bday;
	}
	
	//Copy constructor
	public Person (Person per) {
		firstName = per.firstName;
		lastName = per.lastName;
		gender = per.gender;
		address = per.address;
		birthdate = per.birthdate;
	}
	
	public void setLastName(String lname) {
		lastName = lname;
	}
	
	public void setAddress(Address add) {
		address = add;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public Address getAddress() {
		return address;
	}
	
	public LocalDate getBirthDate() {
		return birthdate;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Name: " + firstName + " " + lastName + "\nGender: " + gender + 
				"\n" + address + "\nBrthdate: " + birthdate);
		return str.toString();
	}
	
	@Override
	public boolean equals(Object other) {
		if (this == other)
			return true;
		if (other == null)
			return false;
		if (getClass() != other.getClass())
			return false;
		Person other2 = (Person) other;
		if(birthdate == null) {
			if(other2.birthdate != null)
				return false;
		} else if (!birthdate.equals(other2.birthdate))
			return false;
		if(firstName == null) {
			if (other2.firstName != null)
				return false;
		} else if (!firstName.equals(other2.firstName))
			return false;
		if (lastName == null) {
			if(other2.lastName != null)
				return false;
		} else if (!lastName.equals(other2.lastName))
			return false;
		return true;
		}
}
