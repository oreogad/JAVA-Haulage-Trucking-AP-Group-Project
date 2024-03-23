package models;

public class Staff implements Payable{
	
	
	private int staffId;
	private String firstName;
	private String lastName;
	private Date dob;
	private Address address;
	private String telephone;
	private String email;
	private String position;
	private String status = "active";
	
	public Staff() {
		this.staffId = 0;
		this.firstName = "???";
		this.lastName = "???";
		this.dob = new Date();
		this.address = new Address();
		this.telephone = "(000)-000-0000";
		this.email = "???";
		this.position = "???";
		this.status = "active"; //customers have active accounts by default
	}
	public Staff(int staffId, String firstName, String lastName, Date dob, Address address,
				String telephone, String email, String position, String status) {
		this.staffId = staffId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.address = address;
		this.telephone = telephone;
		this.email = email;
		this.position = position;
		this.status = status;
	}

	public int getStaffId() {
		return staffId;
	}
	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String toString() {
		return "Staff ID: " + staffId + "\nName: " + firstName + " " + lastName + "\nDate of Birth: " + dob.toString()
				+ "\nAddress: " + address.toString() + "\nTelephone: " + telephone + "\nEmail: " + email + "\nPosition: " + position
				+ "\nStatus: " + status;
	}
	@Override
	public void generatePaySlip() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
