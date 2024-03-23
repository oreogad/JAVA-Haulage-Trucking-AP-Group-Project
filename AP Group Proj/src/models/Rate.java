package models;

public class Rate {
	private int rateID;
    private Route route;
    private double rateAmount;
    
    
  	public Rate() {
  		super();
  		this.rateID = 0;
  		this.route = new Route();
  		this.rateAmount = 0;
  	}
    
	public Rate(int rateID, Route route, double rateAmount) {
		super();
		this.rateID = rateID;
		this.route = route;
		this.rateAmount = rateAmount;
	}
	
	
	public int getRateID() {
		return rateID;
	}
	public void setRateID(int rateID) {
		this.rateID = rateID;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public double getRateAmount() {
		return rateAmount;
	}
	public void setRateAmount(double rateAmount) {
		this.rateAmount = rateAmount;
	}

	@Override
	public String toString() {
		return "Rate [rateID=" + rateID + ", route=" + route.toString() + ", rateAmount=" + rateAmount + "]";
	}
    
    
    
    
}
