package serial;

import java.util.ArrayList;
import models.Customer;

public class Serialization {
	
	//for each customer object made this method will accept it and add it to the customer file
	public void customerSerialization(Customer customer)
	{
		ArrayList<Customer> customerList = new ArrayList<>();
		
		customerList.add(customer);
		
		Customer.writeToCustomerFile(customerList);
	}
}