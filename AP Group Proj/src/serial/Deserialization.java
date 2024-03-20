package serial;

import java.util.List;
import java.util.ArrayList;
import models.Customer;

public class Deserialization {

	//this method with print all customer records saved to the customer file
	public void customerDeserialization() 
	{
		List<Customer> customerList = new ArrayList<Customer>();
		customerList = Customer.readFromCustomerFile();
		
		for(Customer customer : customerList){
			System.out.println(customer);
		}
	}
}