package models;



public class Driver extends Staff{
	private String licenseNumber;
    private String licenseExpirationDate;
    
    
	public Driver() {
		super();
		this.licenseNumber = "";
		this.licenseExpirationDate = "";
	}


	public Driver(int staffId, String firstName, String lastName, Date dob, Address address, String telephone,
			String email, String position, String status, String licenseNumber, String licenseExpirationDate) {
		super(staffId, firstName, lastName, dob, address, telephone, email, position, status);
		this.licenseNumber = licenseExpirationDate;
		this.licenseExpirationDate = licenseExpirationDate;
	}


	public String getLicenseNumber() {
		return licenseNumber;
	}


	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}


	public String getLicenseExpirationDate() {
		return licenseExpirationDate;
	}


	public void setLicenseExpirationDate(String licenseExpirationDate) {
		this.licenseExpirationDate = licenseExpirationDate;
	}

	
	//super class  and setter + To String
	
	
	
	

	@Override
	public void generatePaySlip() {
		// TODO Auto-generated method stub
		super.generatePaySlip();
	}
    
 
	
	
	
	

}
