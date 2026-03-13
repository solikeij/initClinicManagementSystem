package clinicManagementSystem;
	
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	// -- MASTER LISTS AND ARRAYS --
    static List<Dentist> dentistList = new ArrayList<>();
    static List<Client> clientList = new ArrayList<>();
    static List<Transaction> transactionList = new ArrayList<>();
    static double[] SERVICE_PRICES = { 1000, 600, 500, 700 };
    static String[] NAME_OF_SERVICES = { "Fillings", "Check Up And Cleaning", 
    									 "Teeth Whitening", "Tooth Extraction" };
    
    // -- DUMMY DATA TO POPULATE THE SYSTEM -- 
    private static void populateDummyData() {

        // -- DUMMY DATA TO DENTISTS --

        ArrayList<String> dentist1Services = new ArrayList<>();
        dentist1Services.add("Fillings");
        dentist1Services.add("Tooth Extraction");

        Dentist d1 = new Dentist(
                "Dr. Kenji Rivera",
                "123 Kanto St.",
                "09159512781",
                0.50,
                dentist1Services
        );
        dentistList.add(d1);


        ArrayList<String> dentist2Services = new ArrayList<>();
        dentist2Services.add("Check Up And Cleaning");
        dentist2Services.add("Teeth Whitening");

        Dentist d2 = new Dentist(
                "Dr. Leslie Cruz",
                "456 Street Blvd.",
                "0951254123",
                0.30,
                dentist2Services
        );
        dentistList.add(d2);


        ArrayList<String> dentist3Services = new ArrayList<>();
        dentist3Services.add("Fillings");
        dentist3Services.add("Check Up And Cleaning");

        Dentist d3 = new Dentist(
                "Dr. Maria Santos",
                "78 Mabini Ave.",
                "09181234567",
                0.40,
                dentist3Services
        );
        dentistList.add(d3);


        ArrayList<String> dentist4Services = new ArrayList<>();
        dentist4Services.add("Tooth Extraction");
        dentist4Services.add("Teeth Whitening");

        Dentist d4 = new Dentist(
                "Dr. Paolo Reyes",
                "21 Rizal Street",
                "09192345678",
                0.35,
                dentist4Services
        );
        dentistList.add(d4);


        // -- DUMMY DATA TO CLIENTS --

        Client c1 = new Client(2025,"Juan Dela Cruz","Laguna","09123456789");
        Client c2 = new Client(2025,"Maria Santos","Manila","09129876543");
        Client c3 = new Client(2026,"Pedro Reyes","Quezon City","09121234567");

        clientList.add(c1);
        clientList.add(c2);
        clientList.add(c3);


        // -- DUMMY DATA TO TRANSACTIONS --

        // -- Transaction 1 (Juan) --
        Transaction t1 = new Transaction(c1);
        t1.addService("Fillings", d1, 2000);
        t1.addService("Teeth Whitening", d2, 500);
        transactionList.add(t1);


        // -- Transaction 2 (Maria) --
        Transaction t2 = new Transaction(c2);
        t2.addService("Check Up And Cleaning", d3, 600);
        transactionList.add(t2);


        // -- Transaction 3 (Pedro) --
        Transaction t3 = new Transaction(c3);
        t3.addService("Tooth Extraction", d4, 1400);
        t3.addService("Check Up And Cleaning", d3, 600);
        transactionList.add(t3);

    }
 	
	// -- BORDER FOR UI DESIGN --
	private static void setBorder() { 
		System.out.print("\n +-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n"); 
	}
	
	// -- METHOD TO DISPLAY SYSTEM MAIN MENU --
	private static void displayMenu() { 
		System.out.printf("%50s", "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
		System.out.printf("%n%50s", "| Dr. Rivera Clinic Management System |");
		System.out.printf("%n%50s", "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
		
		System.out.printf("%n%n%14s %n%n%s %n%s %n%s %n%s %n%s %n%s %n%n%s",
						  " Management System Menu: ",
						  " [1] Add Dentists Details",
						  " [2] Add Client Details",
						  " [3] Manage Records [Update & Archive]",
						  " [4] Create Transaction",
						  " [5] Show Transactions Reports",
						  " [6] Exit System",
						  " Choose Your Option: > ");
	}
	
	// -- METHOD TO DISPLAY SERVICES MENU --
	private static void displayServices() {
		
		System.out.println();
		for(int index = 0; index < NAME_OF_SERVICES.length; index++) {
			System.out.println(" [" + (index+1) + "] " + NAME_OF_SERVICES[index]);
		}
	}
	
	// -- FILLS UP ALL DETAILS OF DENTIST INFORMATIONS --
	public static Dentist dentistFillUpDetails(BufferedReader reader) throws IOException{
		
		// -- MESSAGE DETAIL FOR DENTIST --
		setBorder();
		System.out.println("\n - Fill All Your Dentist Information - \n");
		
		// -- DECLARING INPUT VARIABLES --
		ArrayList <String> dentistServicesOffered = new ArrayList<>();
		String dentistName, dentistAddress, dentistContact;
		double dentistCommisionRate;
		int dentistServiceChoice, addServiceChoice;
		
		// -- DENTIST INFORMATION INPUTS --
		System.out.print(" Enter Your Name: > ");
		dentistName = reader.readLine();
		
		System.out.print(" Enter Your Address: > ");
		dentistAddress = reader.readLine();
		
		System.out.print(" Enter Your Contact Number: > ");
		dentistContact = reader.readLine();
		
		System.out.print(" How Much Is Your Commision Rate: > ");
		dentistCommisionRate = Double.parseDouble(reader.readLine());
		
		// -- OFFERED SERVICE MENU --
		do {
			// -- TITLE MESSAGE --
			setBorder();
			System.out.println("\n - Clinic Services You Can Provide -");
			
			// -- CALLS SERVICE DISPLAY METHOD --
			displayServices();
			System.out.print("\n What Service Could You Offer? > ");
			dentistServiceChoice = Integer.parseInt(reader.readLine());
			
			// -- STORES STRING VALUE OF THE SERVICE CHOICE
			String SERVICE_VALUE = switch (dentistServiceChoice) {
				case 1 -> "Fillings";
				case 2 -> "Check Up And Cleaning";
				case 3 -> "Teeth Whitening ";
				case 4 -> "Tooth Extraction";
				default -> 
				throw new IllegalArgumentException(" Unexpected value: " 
												   + dentistServiceChoice);	
			};
			
			if (!dentistServicesOffered.contains(SERVICE_VALUE)) { 
				dentistServicesOffered.add(SERVICE_VALUE);
				System.out.println("\n - Service successfully added. -");
			}else { System.out.println("\n - This service already added. -"); }
		
			// -- ASK IF USER WANT TO ADD ANOTHER SERVICE --
			setBorder();
			System.out.printf("%n%s %n%n%s %n%s %n%n%s", 
							  " Do You Offer Additional Service/s?",
							  " [1] Yes",
							  " [2] That's All",
							  " Choose Your Answer: > ");
			addServiceChoice = Integer.parseInt(reader.readLine());
			
		}while(addServiceChoice != 2);
		
		return new Dentist(dentistName, dentistAddress, 
						   dentistContact, dentistCommisionRate,
						   dentistServicesOffered);
	}
	
	// -- METHOD FOR ADD DENTIST OPTION [1.0] --
	public static void addDentistDetails(BufferedReader reader) throws IOException {
			
		Dentist newDentist = dentistFillUpDetails(reader);
		dentistList.add(newDentist);
				
		// -- ALERTS USER FILLING INFORMATION IS SUCCESSFULL --
		System.out.println("\n - Dentist Information Successfully Added! -");
		setBorder();
			
	}
	
	// -- FILLS UP ALL DETAILS OF CLIENTS INFORMATIONS --
	public static Client clientFillUpDetails(BufferedReader reader) throws IOException{
		
		// -- MESSAGE DETAIL FOR CLIENT -- 
		setBorder();
		System.out.println("\n - Fill All Your Customer Information - \n");
				
		// -- DECLARING INPUT VARIABLES -- 
		String clientName, clientAddress, clientContact;
		int clientYearAdded;
				
		// -- Client INFORMATION INPUTS --
		System.out.print(" Enter Client Year Added: ");
		clientYearAdded = Integer.parseInt(reader.readLine());
				
		System.out.print(" Enter Client Name: > ");
		clientName = reader.readLine();
						
		System.out.print(" Enter Client Address: > ");
		clientAddress = reader.readLine();
						
		System.out.print(" Enter Client Contact Number: > ");
		clientContact = reader.readLine();
		
		return new Client(clientYearAdded, clientName, clientAddress, clientContact);	
	}
	
	// -- METHOD FOR ADD CUSTOMER OPTION [2.0] --
	public static void addClientDetails(BufferedReader reader) throws IOException{
			
		Client newClient = clientFillUpDetails(reader);
		
		// -- ADD CLIENT DETAILS TO CLIENT LIST --
		clientList.add(newClient);
		
		System.out.println("\n -- Client Details Successfully Added -- ");
		setBorder();
	}
	
	// -- METHODS FOR MANAGING RECORDS ARCHIVE AND UPDATE [3.0] --
	public static void manageRecords(BufferedReader reader) throws IOException{
		
		setBorder();
		int menuChoice;
		if(dentistList.size() == 0 && clientList.size() == 0) {
			System.out.println("\n -- Add Client And Dentist Available First! -- ");
			setBorder();
			return;
		}

		// -- PROMPTS TO WHAT OPTION SHOULD USER MANAGE --
		System.out.printf("%n%s %n%n%s %n%s %n%n%s",
						  " Manage The System Records: ",
						  " [1] Update Record",
						  " [2] Archive Record",
						  " Manage Choice: > ");
		
		menuChoice = Integer.parseInt(reader.readLine());
		
		switch(menuChoice) {
			case 1 -> updateRecords(reader);
			case 2 -> archiveRecords(reader);
		}
	}
	
	// -- FINDS DENTIST INDEX TO UPDATE / ARCHIVE DETAILS [3.1.1]--
	private static int findDentistIndex(String dentistId) {
		for(int index = 0; index < dentistList.size(); index++) {
			if(dentistList.get(index).getDentistId().equals(dentistId)) {
				return index;
			}
		}
		return -1;
	}
		
	// -- FINDS CLIENT INDEX TO UPDATE / ARCHIVE DETAILS [3.1.2] --
	private static int findClientIndex(String clientId) {
		for(int index = 0; index < clientList.size(); index++) {
			if(clientList.get(index).getClientId().equals(clientId)) {
				return index;
			}
		}
		return -1;
	}
	
	// -- MANAGE RECORDS [3.2] UPDATE --
	public static void updateRecords(BufferedReader reader) throws IOException{
		
		int menuChoice;
		String clientSearchId, dentistSearchId;
		int searchIndex;
		
		setBorder();
		System.out.printf("%n%s %n%n%s %n%s %n%n%s",
						  " Manage Data Records of: ",
				          " [1] Dentist",
				          " [2] Client",
				          " Manage Choice: > ");
		
		menuChoice = Integer.parseInt(reader.readLine());
		
		switch(menuChoice) {
			case 1 -> {
				
				System.out.print(" Enter Dentist ID to Update: ");
				dentistSearchId = reader.readLine();
				
				searchIndex = findDentistIndex(dentistSearchId);
				
				if(searchIndex == -1) {
					System.out.println(" -- Dentist Not Found. --");
					return;
				}
				
				System.out.println("\n -- Updating Dentist Information... --");
			
				Dentist updateDentist = dentistFillUpDetails(reader);
				dentistList.set(searchIndex, updateDentist);
				
				System.out.println(" -- Dentist Information Successfully Updated! --");
				setBorder();
				
			}
			case 2 -> {
				
				System.out.print("Enter Client ID to Update: ");
				clientSearchId = reader.readLine();
				
				searchIndex = findClientIndex(clientSearchId);
				
				if(searchIndex == -1) {
					System.out.println(" -- Dentist Not Found. --");
					return;
				}
				
				System.out.println("\n -- Updating Client Information... --");
				
				Client updateClient = clientFillUpDetails(reader);
				clientList.set(searchIndex, updateClient);
				
				System.out.println(" -- Client Information Successfully Updated! --");
				setBorder();		
			}
		}
	}
	
	// -- MANAGE RECORDS [3.3] ARCHIVE --
	public static void archiveRecords(BufferedReader reader) throws IOException{
		
		int menuChoice;
		String clientSearchId, dentistSearchId;
		int searchIndex;
		
		setBorder();
		System.out.printf("%n%s %n%n%s %n%s %n%n%s",
						  " Manage Data Records of: ",
				          " [1] Dentist",
				          " [2] Client",
				          " Manage Choice: > ");
		menuChoice = Integer.parseInt(reader.readLine());
		
		switch(menuChoice) {
			case 1 -> {
				System.out.println(" Enter Dentist ID to Archive: ");
				dentistSearchId = reader.readLine();
				
				searchIndex = findDentistIndex(dentistSearchId);
				
				if(searchIndex == -1) {
					System.out.println(" -- Dentist Not Found. --");
					return;
				}
				
				System.out.println("\n -- Archiving Dentist Information... --");
				
				dentistList.remove(searchIndex);
				System.out.println("\n -- Dentist Information Successfully Archived... --");
				setBorder();
				
			}
			case 2 -> {
				System.out.println(" Enter Client ID to Archive: ");
				clientSearchId = reader.readLine();
				
				searchIndex = findClientIndex(clientSearchId);
				
				if(searchIndex == -1) {
					System.out.println(" -- Dentist Not Found. --");
					return;
				}
				
				System.out.println("\n -- Archiving Dentist Information... --");
				clientList.remove(searchIndex);	
				System.out.println("\n -- Client Information Successfully Archived... --");
				setBorder();
			}
		}
	}
	
	// -- CREATE TRANSACTION [4.0] -- 
	private static void createTransaction(BufferedReader reader) throws IOException {
		
		ArrayList<Dentist> availableDentists = new ArrayList<>();
	    String searchClientId, chosenService;
	    Client clientFound = null;
	    boolean anotherTransaction = true;
	    int serviceChoice, dentistChoice, toothCount = 1;
	    double initialPrice;

	    setBorder();

	    if(dentistList.size() == 0 && clientList.size() == 0){
	        System.out.println("\n -- Add Client And Dentist Available First! -- ");
	        setBorder();
	        return;
	    }

	    System.out.print(" Enter Client ID To Transact: ");
	    searchClientId = reader.readLine();

	    for(Client searchClient : clientList){
	        if(searchClient.getClientId().equals(searchClientId)){
	            clientFound = searchClient;
	            break;
	        }
	    }

	    if(clientFound == null){
	        System.out.println(" -- Client Not Found In The System -- ");
	        return;
	    }

	    Transaction createTransaction = new Transaction(clientFound);

	    while(anotherTransaction){

	        setBorder();

	        for(int index = 0; index < NAME_OF_SERVICES.length; index++){
	            System.out.println("\n ["+(index+1)+"] "
	                    		   + NAME_OF_SERVICES[index] + " - "
	                    		   + SERVICE_PRICES[index]);
	        }

	        System.out.print("\n Choose A Service You Want: > ");
	        serviceChoice = Integer.parseInt(reader.readLine()) - 1;

	        chosenService = NAME_OF_SERVICES[serviceChoice];

	        if(createTransaction.hasService(chosenService)){
	            System.out.println("\n -- Service Already Been Performed. --");
	            continue;
	        }

	        initialPrice = SERVICE_PRICES[serviceChoice];

	        if(chosenService.equals("Fillings")
	                || chosenService.equals("Tooth Extraction")){

	            System.out.print(" How Many Tooth To Operate: > ");
	            toothCount = Integer.parseInt(reader.readLine());

	            initialPrice = initialPrice * toothCount;
	        }

	        setBorder();
	        System.out.println("\n -- List Of Available Dentists In The Given Service --");

	        availableDentists.clear();

	        int availableDentistCounter = 1;

	        for(Dentist showDentists : dentistList){

	            if(showDentists.getDentistServices().contains(chosenService)){

	                System.out.println("\n ["+availableDentistCounter+"] "
	                        + showDentists.getDentistName());

	                availableDentists.add(showDentists);

	                availableDentistCounter++;
	            }
	        }

	        if(availableDentists.isEmpty()){
	            System.out.println("\n -- No Dentist Are Available In This Service --");
	            continue;
	        }

	        System.out.print("\n Choose Your Dentist: > ");
	        dentistChoice = Integer.parseInt(reader.readLine()) - 1;

	        Dentist chosenDentist = availableDentists.get(dentistChoice);

	        System.out.println(" Service Price: " + initialPrice);

	        createTransaction.addService(chosenService, chosenDentist, initialPrice);

	        setBorder();
	        System.out.print("\n Do You Want To Add Another Service? (yes/no): > ");

	        if(!reader.readLine().equalsIgnoreCase("yes")){
	            anotherTransaction = false;
	        }
	    }

	    transactionList.add(createTransaction);

	    System.out.println("\n The Total Price Of All Services Is: "
	            + createTransaction.getTotalPrice());

	    System.out.println("\n -- Transaction Successful! Thank You For Your Trust In Our Service! --");

	    setBorder();
	}
	
	// -- SHOW TRANSACTION REPORTS [5.0] -- 
	private static void showReports() {
		
		setBorder();
	    System.out.println("\n --- Transactions Reports ---");

	    int dentistCounter = 1;

	    for(Dentist dentist : dentistList){

	        System.out.println("\n Dentist #" + dentistCounter++);
	        System.out.println(" Dentist ID: " + dentist.getDentistId());
	        System.out.println(" Dentist Name: " + dentist.getDentistName());

	        for(String service : dentist.getDentistServices()){

	            System.out.println("\n   Service: " + service);

	            boolean serviceFound = false;

	            for(Transaction transaction : transactionList){

	                if(transaction.getDentists().contains(dentist)){

	                    for(int i = 0; i < transaction.getServices().size(); i++){

	                        if(transaction.getDentists().get(i) == dentist &&
	                                transaction.getServices().get(i).equals(service)){

	                            serviceFound = true;

	                            System.out.println("      Client: "
	                                    + transaction.getClient().getClientName());

	                            System.out.println("      Payment: "
	                                    + transaction.getPrices().get(i));
	                        }
	                    }
	                }
	            }

	            if(!serviceFound){
	                System.out.println("      No Clients Yet.");
	            }
	        }

	        setBorder();
	    }
	}
	
	// -- MAIN METHOD -- 
	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int menuChoice;
		
		System.out.println();
		do {
			
			displayMenu();
			menuChoice = Integer.parseInt(reader.readLine());
			
			switch(menuChoice) {
			
				case 1 -> addDentistDetails(reader);
				case 2 -> addClientDetails(reader);
				case 3 -> manageRecords(reader);
				case 4 -> createTransaction(reader);
				case 5 -> {
					populateDummyData(); 
					showReports();
				}
				case 6 ->{
					
					setBorder();
					System.out.println("\n Thank You For Using The System! \n System Terminated!");
					setBorder();	
					System.exit(0);
					
				}
			}
			
			System.out.println();
			
		}while(menuChoice != 6);
	}
}
