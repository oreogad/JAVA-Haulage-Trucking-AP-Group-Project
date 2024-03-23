package models;

public class PaySlip {
	
	 	private int payID;
	    private Staff staff;
	    private Date startDate;
	    private Date endDate;
	    private double salary;
	    private String preparedBy;
	    
	    
	    
	  	public PaySlip() {
	  			this.payID = 0;
	  			this.staff = new Staff();
	  			this.startDate = new Date();
	  			this.endDate = new Date();
	  			this.salary = 0;
	  			this.preparedBy = "";
	  		}
	    
	    
		public PaySlip(int payID, Staff staff, Date startDate, Date endDate, double salary, String preparedBy) {
			this.payID = payID;
			this.staff = staff;
			this.startDate = startDate;
			this.endDate = endDate;
			this.salary = salary;
			this.preparedBy = preparedBy;
		}
		
		
		public int getPayID() {
			return payID;
		}
		public void setPayID(int payID) {
			this.payID = payID;
		}
		public Staff getStaff() {
			return staff;
		}
		public void setStaff(Staff staff) {
			this.staff = staff;
		}
		public Date getStartDate() {
			return startDate;
		}
		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}
		public Date getEndDate() {
			return endDate;
		}
		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public String getPreparedBy() {
			return preparedBy;
		}
		public void setPreparedBy(String preparedBy) {
			this.preparedBy = preparedBy;
		}


		@Override
		public String toString() {
			return "PaySlip [payID=" + payID + ", staff=" + staff.toString() + ", startDate=" + startDate.toString() + ", endDate=" + endDate.toString()
					+ ", salary=" + salary + ", preparedBy=" + preparedBy + "]";
		}
	
	    
	    
	    
	    
	    
	

}
