package com.company;

public class Tour {
    private Vehicle vehicle;
    private Client[] clients;
    public Tour(){};
    public Tour(Vehicle vehicle,Client...clients){
        this.setVehicle(vehicle);
        this.setClients(clients);
    }
    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Client[] getClients() {
        return clients;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        StringBuilder str=new StringBuilder();
        str.append(vehicle.getName());
        str.append(":");
        str.append(vehicle.getDepot());
        str.append("->");
        for(Client c : clients)
        {
            str.append(c.getName());
            str.append("->");
        }
        str.append(vehicle.getDepot());
        return str.toString();
    }
}
