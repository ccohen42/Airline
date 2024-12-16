package program7;

public class Employee extends Person {

	//Fields
	private String employeeID;
	private String employeeType;
	private String department;
	
	//Constructor
	public Employee(String fname, String lname, Gender gen, Address add, String bday,
			String id, String type, String dep) {
		super(fname, lname, gen, add, bday);
		employeeID = id;
		employeeType = type;
		department = dep;
	}
	
	//Copy constructor
	public Employee(Employee emp) {
		super(emp);
		this.employeeID = emp.employeeID;
		this.employeeType = emp.employeeType;
		this.department = emp.department;
	}
	
	public void setEmployeeID(String id) {
		employeeID = id;
	}
	
	public void setEmployeeType(String type) {
		employeeType = type;
	}
	
	public void setDepartment(String dep) {
		department = dep;
	}
	
	public String getEmployeeID() {
		return employeeID;
	}
	
	public String getEmployeeType() {
		return employeeType;
	}
	
	public String getDepartment() {
		return department;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Employee:\n" + super.toString() + "\nEmployee ID: "
				+ employeeID + "\nEmployee Type: " + employeeType + "\nDepartment: "
				+ department);
		return str.toString();
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null)
			return false;
		if(!(o instanceof Employee))
			return false;
		Employee other = (Employee) o;
		if(employeeID == null) {
			if(other.employeeID != null)
				return false;
		}else if (!employeeID.equals(other.employeeID))
			return false;
		return true;
	}
}
