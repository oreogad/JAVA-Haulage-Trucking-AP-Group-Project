package models;

public class TripOrder {
	
	 	private int invoiceNo;
	    private String company;
	    private Address sourceAddress;
	    private Address destinationAddress;
	    private double rate;
	    private Driver driver;
	    private String billedBy;
	    
	    
	    
	    public TripOrder() {
			super();
			this.invoiceNo = 0;
			this.company = "";
			this.sourceAddress = new Address();
			this.destinationAddress = new Address();
			this.rate = 0;
			this.driver = new Driver();
			this.billedBy = "";
		}
	    
	  
		public TripOrder(int invoiceNo, String company, Address sourceAddress, Address destinationAddress, double rate,
				Driver driver, String billedBy) {
			super();
			this.invoiceNo = invoiceNo;
			this.company = company;
			this.sourceAddress = sourceAddress;
			this.destinationAddress = destinationAddress;
			this.rate = rate;
			this.driver = driver;
			this.billedBy = billedBy;
		}
		
		public int getInvoiceNo() {
			return invoiceNo;
		}
		public void setInvoiceNo(int invoiceNo) {
			this.invoiceNo = invoiceNo;
		}
		public String getCompany() {
			return company;
		}
		public void setCompany(String company) {
			this.company = company;
		}
		public Address getSourceAddress() {
			return sourceAddress;
		}
		public void setSourceAddress(Address sourceAddress) {
			this.sourceAddress = sourceAddress;
		}
		public Address getDestinationAddress() {
			return destinationAddress;
		}
		public void setDestinationAddress(Address destinationAddress) {
			this.destinationAddress = destinationAddress;
		}
		public double getRate() {
			return rate;
		}
		public void setRate(double rate) {
			this.rate = rate;
		}
		public Driver getDriver() {
			return driver;
		}
		public void setDriver(Driver driver) {
			this.driver = driver;
		}
		public String getBilledBy() {
			return billedBy;
		}
		public void setBilledBy(String billedBy) {
			this.billedBy = billedBy;
		}
		
	
	    @Override
	  		public String toString() {
	  			return "TripOrder [invoiceNo=" + invoiceNo + ", company=" + company + ", sourceAddress=" + sourceAddress.toString()
	  					+ ", destinationAddress=" + destinationAddress.toString() + ", rate=" + rate + ", driver=" + driver.toString()
	  					+ ", billedBy=" + billedBy + "]";
	  		}

}
