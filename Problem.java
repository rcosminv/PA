package com.company;

import java.util.ArrayList;

public class Problem {
    private Depot[] depots;
    private Client[] clients;
    public Problem(){}
    public Problem(Client...clients){
        this.setClients(clients);
    }

    public Depot[] getDepots() {
        return depots;
    }

    public void setDepots(Depot...depots) {
        ArrayList<Depot> depotArrayList=new ArrayList<Depot>();
        boolean duplicat=false;
        for(Depot d : depots)
            if(!depotArrayList.isEmpty() && depotArrayList.contains(d))
            {
                System.out.println("Nu puteti adauga un client de mai multe ori:"+d.getName());
                duplicat=true;
            }
            else depotArrayList.add(d);
        if(!duplicat)
            this.depots = depots;
    }

    public Client[] getClients() {
        return clients;
    }

    public void setClients(Client...clients) {
        ArrayList<Client> clientArrayList=new ArrayList<Client>();
        boolean duplicat=false;
        for(Client c : clients)
            if(!clientArrayList.isEmpty() && clientArrayList.contains(c))
            {
                System.out.println("Nu puteti adauga un depot de mai multe ori:"+c.getName());
                duplicat=true;
            }
            else clientArrayList.add(c);
        if(!duplicat)
            this.clients = clients;
    }

    public Vehicle[] getVehicles(){
        ArrayList<Vehicle> vehicles= new ArrayList<>();
        if(depots!=null) {
            for (Depot d : depots) {
                if (d.getVehicles() != null) {
                    for (Vehicle v : d.getVehicles())
                        vehicles.add(v);
                }
            }
            Vehicle[] v=new Vehicle[vehicles.size()];
            return vehicles.toArray(v);
        }
        else {
            return null;
        }
    }
    @Override
    public String toString() {
        StringBuilder s= new StringBuilder();
        if(clients!=null)
            for(Client c : clients)
                s.append(c.getName()).append("(").append(c.getOrder()).append(")").append(",");
            s.append("\n");
            if(depots!=null)
            for(Depot d:depots) {
                s.append(d.getName()).append(":");
                if(d.getVehicles()!=null)
                    for (Vehicle v : d.getVehicles())
                        s.append(v.getName()).append(",");
                    s.append("\n");
            }
        return s.toString();
    }
}
