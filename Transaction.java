package clinicManagementSystem;

import java.util.ArrayList;

public class Transaction {

    private Client client;
    private ArrayList<String> servicesAvailed = new ArrayList<>();
    private ArrayList<Dentist> dentists = new ArrayList<>();
    private ArrayList<Double> prices = new ArrayList<>();

    private double totalPrice;

    public Transaction(Client client){ this.client = client; }

    public Client getClient(){ return client; }

    public void addService(String service, Dentist dentist, double price){

        servicesAvailed.add(service);
        dentists.add(dentist);
        prices.add(price);

        totalPrice += price;
    }

    public boolean hasService(String service){ return servicesAvailed.contains(service); }

    public ArrayList<String> getServices(){ return servicesAvailed; }
    public ArrayList<Dentist> getDentists(){ return dentists; }
    public ArrayList<Double> getPrices(){ return prices; }
    public double getTotalPrice(){ return totalPrice; }
}