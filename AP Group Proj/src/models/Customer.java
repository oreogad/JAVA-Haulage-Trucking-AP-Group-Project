package models;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable{

	private static final long serialVersionUID = 1L;
	private int customerId;
	private String company;
	private String contactPerson;
	private String telephone;
	private Address address;
	private String email;
	private String status;
	
	public Customer() {
		this.customerId = 0;
		this.company = "???";
		this.contactPerson = "???";
		this.telephone = "(000)-000-0000";
		this.address = new Address();
		this.email = "???";
		this.status = "active"; //customers have active accounts by default
	}
	public Customer(int customerId, String company, String contactPerson, 
					String telephone, Address address,String email, String status) {
		this.customerId = customerId;
		this.company = company;
		this.contactPerson = contactPerson;
		this.telephone = telephone;
		this.address = address;
		this.email = email;
		this.status = status;
	}
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String toString() {
		return "Customer ID: " + customerId + "\nCompany: " + company + "\nContact Person:" + contactPerson
				+ "\nTelephone: " + telephone + "\nAddress: " + address.toString() + "\nEmail: " + email + "\nStatus: " + status;
	}
	
	//create a customer file to write customer objects to
	public static void writeToCustomerFile(ArrayList<Customer> customerList)
	{
		try (FileOutputStream fileOut = new FileOutputStream("./src/customerDB.ser");
			 ObjectOutputStream out = new ObjectOutputStream(fileOut);)
		{
			for (Customer customer : customerList) {
				out.writeObject(customer);
			}
			System.out.println("Serialized customers' data are saved");
		
		} catch (FileNotFoundException fnfe) {
			System.err.println("\nCustomers file could not be found\n" + fnfe.getMessage());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//create & returns a list of the customers saved on the file
	public static ArrayList<Customer> readFromCustomerFile()
	{
		Customer customer = null;
		ArrayList<Customer> customerList = new ArrayList<Customer>();
		
		try (FileInputStream fileIn = new FileInputStream("./src/customerDB.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);)
		{
			while (true) {
				try {
					customer = (Customer)in.readObject();
					if (customer != null) {
						customerList.add(customer);
					} else if (customer == null) {
						break;
					}
					
				} catch(ClassNotFoundException cnfe) {
					System.out.println("\nObject could not be converted to a customer\n" + cnfe.getMessage());
				} catch (EOFException eofe) {
					break;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException fnfe) {
			System.err.println("\nCustomers file could not be found\n" + fnfe.getMessage());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return customerList;
	}
}