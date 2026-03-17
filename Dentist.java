package clinicManagementSystem;

import java.util.ArrayList;

public class Dentist {
	
	// -- ATTRIBUTES --
	private static int BASE_EMPLOYEE_ID =  1;
	private String dentistId;
	private String dentistName;
	private String dentistAddress;
	private String dentistContactNumber;
	private double dentistCommissionRate;
	private ArrayList<String> dentistServicesOffered;
	
	// -- ASSOCIATES ONE CLIENT FOR EVERY A DENTIST APPOINTMENT --
	private Client dentistClient;
	
	// -- CONSTRUCTOR --
	public Dentist(String dentistName, String dentistAddress, 
				   String dentistContactNumber, double dentistCommissionRate, 
				   ArrayList <String> dentistServicesOffered) {
		
		// -- VALIDATION --
		if(dentistName == null || dentistName.trim().isEmpty() ) 
			throw new IllegalArgumentException("Employee name cannot be empty.");
		if(dentistAddress == null || dentistAddress.trim().isEmpty())
			throw new IllegalArgumentException("Employee address cannot be empty.");
		if(dentistContactNumber == null)
			throw new IllegalArgumentException("Employee contact number cannot be null.");
		if(dentistCommissionRate < 0 || dentistCommissionRate > 1.0)
			throw new IllegalArgumentException("Employee commission rate must be valid.");
		
		// -- ASSIGNMENT --
		this.dentistId = String.format("%04d", BASE_EMPLOYEE_ID++);
		this.dentistName = dentistName;
		this.dentistAddress = dentistAddress;
		this.dentistContactNumber = dentistContactNumber;
		this.dentistCommissionRate = dentistCommissionRate;
		this.dentistServicesOffered = new ArrayList<>(dentistServicesOffered);
	}
	
	// -- GETTERS --
	public String getDentistId() { return dentistId; }
	public String getDentistName() { return dentistName; }
	public ArrayList<String> getDentistServices() { return dentistServicesOffered; }
	
	// -- ASSOCIATION METHODS THAT ASSOCIATES SINGLE CLIENT --
	public void setClient(Client dentistClient) { this.dentistClient = dentistClient; }
	public Client getClient() {	return dentistClient; }
	
}

	
	
	
	

