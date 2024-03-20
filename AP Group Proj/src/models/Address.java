package models;

public class Address {

	private String line1;
	private String line2;
	private String postOffice;
	private String parish;
	
	public Address() {
		this.line1 = "?";
		this.line2 = "?";
		this.postOffice = "?";
		this.parish = "?";
	}
	public Address(String line1, String line2, String postOffice, String parish) {
		this.line1 = line1;
		this.line2 = line2;
		this.postOffice = postOffice;
		this.parish = parish;
	}

	public String getLine1() {
		return line1;
	}
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	public String getLine2() {
		return line2;
	}
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	public String getPostOffice() {
		return postOffice;
	}
	public void setPostOffice(String postOffice) {
		this.postOffice = postOffice;
	}
	public String getParish() {
		return parish;
	}
	public void setParish(String parish) {
		this.parish = parish;
	}
	public String toString() {
		return line1 + ",\n" + line2 + ",\nP.O. " + postOffice + ",\n" + parish + ".";
	}
}