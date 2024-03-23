package models;

public class MaintenanceWorker extends Staff{
	
	
	
	
	  // Additional attributes specific to maintenance workers
    private String skillSet;



    
    public MaintenanceWorker() {
		super();
		this.skillSet = "";
	}




	public MaintenanceWorker(int staffId, String firstName, String lastName, Date dob, Address address,
			String telephone, String email, String position, String status, String skillSet ) {
		super(staffId, firstName, lastName, dob, address, telephone, email, position, status);
		this.skillSet = skillSet;
	}



	public String getSkillSet() {
		return skillSet;
	}




	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}
	

	//super class  and setter + To String


	@Override
    public void generatePaySlip() {
        // Implementation for generating pay slip for maintenance workers
    }
	
	
	
	
	
	
	
	
	
	
	

}
