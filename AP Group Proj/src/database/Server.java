package database;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.ServerSocket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.io.IOException;
import java.io.EOFException;
import javax.swing.JOptionPane;
import models.Customer;

public class Server {

	private ServerSocket serverSocket;
	private Socket connectionSocket;
	private ObjectOutputStream objOs;
	private ObjectInputStream objIs;
	private static Connection dBConn = null;
	private Statement stmt;
	private ResultSet result = null;
	
	public Server() {
		this.createConnection();
		this.waitForRequests();
		//getDatabaseConnection method is already initialized in the waitForRequests() method
	}
	
	private void createConnection() {
		try {
			//Create new instance of the ServerSocket listening on port 8888
			serverSocket = new ServerSocket(8888);
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	private void configureStreams() {
		try {
			//Instantiate the output stream, using the getOutputStream method of the Socket object as argument to the constructor
			objOs = new ObjectOutputStream(connectionSocket.getOutputStream());
			//Instantiate the input stream, using the getInputStream method of the Socket object as argument to the constructor
			objIs = new ObjectInputStream(connectionSocket.getInputStream());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	private static Connection getDatabaseConnection() {
		if(dBConn == null) {
			try {
				String url = "jdbc:mysql://localhost:3306/dbLab";
				dBConn = DriverManager.getConnection(url, "root", "");
				
				JOptionPane.showMessageDialog(null, "DB Connection Established", "Connection Status", JOptionPane.INFORMATION_MESSAGE);
				
			} catch(SQLException sqle) {
				JOptionPane.showMessageDialog(null, "Could not connect to database\n" + sqle, "Connection Failure", JOptionPane.ERROR_MESSAGE);
			}
		}
		return dBConn;
	}
	private void closeConnection() {
		try {
			objOs.close();
			objIs.close();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	private void addCustomerToFile(Customer customer) {
		String sql = "INSERT INTO jht.'customers' (id, customerId, company, contactPerson, telephone, address, email, status)"
					+ "VALUES (" + null + ", '" + customer.getCustomerId() + "', '" + customer.getCompany() + "', '" 
					+ customer.getContactPerson() + "', '" + customer.getTelephone() + "', '" + customer.getAddress() + "', '" 
					+ customer.getEmail() + "', '" + customer.getStatus() + "');";
		try {
			stmt = dBConn.createStatement();
			if((stmt.executeUpdate(sql) == 1)) {
				objOs.writeObject(true); //return true to client if successful
			} else {
				objOs.writeObject(false);
			}
		} catch(IOException ioe) {
			//Ideally you want to save errors to a log file
			ioe.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	
	private Customer findCustomerById(String customerId) {
		Customer customerObj = new Customer();
		String query = "SELECT * FROM jht.customers WHERE customerId = " + customerId;
		try {
			stmt = dBConn.createStatement();
			result = stmt.executeQuery(query);
			if(result.next()) {
				customerObj.setCustomerId(result.getString(2));
				customerObj.setCompany(result.getString(3));
				customerObj.setContactPerson(result.getString(4));
				customerObj.setTelephone(result.getString(5));
				customerObj.setAddress(result.getString(6));
				customerObj.setEmail(result.getString(7));
				customerObj.setStatus(result.getString(8));				
			}
		} catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		return customerObj;
	}
	
	private void waitForRequests() {
		String action = "";
		getDatabaseConnection();
		Customer customerObj = null;
		try {
			while(true) {
				connectionSocket = serverSocket.accept();
				this.configureStreams();
				try {
					action = (String) objIs.readObject();
					if(action.equals("Add Customer")) {
						customerObj = (Customer) objIs.readObject();
						addCustomerToFile(customerObj);
						objOs.writeObject(true);
					} else if(action.equals("Find Customer")) {
						String customerId = (String) objIs.readObject();
						//call method to find customer based on id number
						customerObj = findCustomerById(customerId);
						objOs.writeObject(customerObj);
					}
				} catch(ClassNotFoundException cnfe) {
					cnfe.printStackTrace();
				} catch(ClassCastException cce) {
					cce.printStackTrace();
				}
				this.closeConnection();
			}
		} catch(EOFException eofe) {
			System.out.println("Client has terminated connections with the server");
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
}