package models;

public class Route {

	private int routeID;
    private Address sourceAddress;
    private Address destinationAddress;
    private Rate rate;
	
	
    public Route() {
		this.routeID = 0;
		this.sourceAddress = new Address();
		this.destinationAddress = new Address();
		this.rate = new Rate();
	}
    
    
	
	public Route(int routeID, Address sourceAddress, Address destinationAddress, Rate rate) {
		this.routeID = routeID;
		this.sourceAddress = sourceAddress;
		this.destinationAddress = destinationAddress;
		this.rate = rate;
	}
	
	public int getRouteID() {
		return routeID;
	}
	public void setRouteID(int routeID) {
		this.routeID = routeID;
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
	public Rate getRate() {
		return rate;
	}
	public void setRate(Rate rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "Route [routeID=" + routeID + ", sourceAddress=" + sourceAddress + ", destinationAddress="
				+ destinationAddress + ", rate=" + rate.toString() + "]";
	}
		
	
	
	
}
