package program7;

public class Address {

	//Feilds
	String street;
	String city;
	String state;
	String zipCode;
	
	//Constructor
	public Address (String street, String city, String state, String zip) {
		this.street = street;
		this.city = city;
		this.state = state;
		zipCode = zip;
	}
	
	
//Getter
	public String getStreet() {
		return street;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getZip() {
		return zipCode;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Adress:\nStreet: " + street + "\nCtiy: " + city + "\nState: " + state + "\nZip Code: " + zipCode);
		return str.toString();
	}
	
}
