package clinicManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Client {
	
	// -- ATTRIBUTES --
	private int registrationYear;
	private String clientId;
	private String clientName;
	private String clientAddress;
	private String clientContactNumber;
	
	// -- ASSOCIATES MANY DENTIST FOR A ONE CLIENT --
	private List<Dentist> dentists = new ArrayList<>(); 
	
	// -- ARRAYTLIST FOR YEARLIST AND ITS COUNTER FOR CLIENT ID FORMAT --
	private static ArrayList<Integer> yearList = new ArrayList<>();
	private static ArrayList<Integer> yearCounters = new ArrayList<>();
	
	// -- CONSTRUCTOR --
	public Client(int registrationYear, String clientName,
				  String clientAddress, String clientContactNumber) {
		
		// -- VALIDATION --
		if(clientName == null || clientName.trim().isEmpty()) 
			throw new IllegalArgumentException("Client name cannot be empty or null.");
		if(clientAddress == null || clientAddress.trim().isEmpty())
			throw new IllegalArgumentException("Client address cannot be empty or null.");
		if(clientContactNumber == null)
			throw new IllegalArgumentException("Client contact number cannot be null.");
		
		// -- ASSIGNMENT --
		this.registrationYear = registrationYear;
		
	    int yearIndex = -1;
	    
	    // -- CHECKS IF YEAR ALREADY EXIST --
	    for (int index = 0; index < yearList.size(); index++) {
	        if (yearList.get(index) == registrationYear) {
	        	yearIndex = index;
	             break;
	        }
	    }
	    
	    int yearIdCount;
	    
        if (yearIndex == -1) {
            // -- IT MEANS IT IS A NEW YEAR ADDED --
        	yearList.add(registrationYear);
            yearCounters.add(1);
            yearIdCount = 1;
        } 
        else {
            // -- ELSE IT IS A EXISTING YEAR --
        	yearIdCount = yearCounters.get(yearIndex) + 1;
        	yearCounters.set(yearIndex, yearIdCount);
        }
        
		this.clientId =	 registrationYear + "-" + String.format("%04d", yearIdCount);
		this.clientName = clientName;
		this.clientAddress = clientAddress;
		this.clientContactNumber = clientContactNumber;	
	}
	

    // -- GETTERS --
    public String getClientId() { return clientId; }
    public String getClientName(){ return clientName; }

    // -- SETTERS --
    public void setClientName(String clientName) { this.clientName = clientName; }
    public void setClientAddress(String clientAddress) { this.clientAddress = clientAddress; }
    public void setClientContact(String clientContactNumber) { this.clientContactNumber = clientContactNumber; }

    // -- ASSOCIATION -- 
    public void addDentist(Dentist dentist){

        dentists.add(dentist);
        dentist.setClient(this);
    }
    public List<Dentist> getDentists(){ return dentists; }

    
	// -- METHODS --
    public void displayClient(){
        System.out.println("\n Client ID: " + clientId);
        System.out.println(" Name: " + clientName);
        System.out.println(" Address: " + clientAddress);
        System.out.println(" Contact: " + clientContactNumber);
        
        System.out.println(" Dentists Assigned: ");

        for(Dentist clientDentist: dentists){
            System.out.println(" - " + clientDentist.getDentistName());
        }
    }
}
