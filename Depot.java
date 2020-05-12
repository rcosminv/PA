package com.company;

import java.util.ArrayList;
//import java.util.Collection;

public class Depot {
    private String name;
    private Vehicle[] vehicles;
    private static String[] names=new String[1];

    public Depot(){}
    public Depot(String name){
        this.setName(name);
    }

    public Depot(String name,Vehicle...vehicles){
        this.setName(name);
        this.setVehicles(vehicles);
    }

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        for(String n : names)
            if(n!=null && n.equals(name))
            {
                System.out.println("Error: exista deja un depot cu numele "+name);
                return false;
            }
        String[] s=new String[names.length+1];
        System.arraycopy(names, 0, s, 0, names.length);
        s[names.length]=name;
        this.name = name;
        names=s;
        return true;
    }


    public Vehicle[] getVehicles() {
        return vehicles;
    }

    public void setVehicles(Vehicle ... vehicles) {
        ArrayList<Vehicle> vehicleArrayList = new ArrayList<Vehicle>();
        for (Vehicle v : vehicles) {
            if (!vehicleArrayList.isEmpty() && vehicleArrayList.contains(v))
            {
                System.out.println("Eroare la adaugarea vehiculului " + v.getName() + " in depoul " + this.getName());
            }
            else {
                v.setDepot(this);
                vehicleArrayList.add(v);
            }
        }
        this.vehicles=new Vehicle[vehicleArrayList.size()];
        this.vehicles = vehicleArrayList.toArray(this.vehicles);
    }

    @Override
    public String toString(){
        return this.getName();
    }

    @Override
    public boolean equals(Object obj){
        if(obj==null || !(obj instanceof Depot))
            return false;
        Depot dep=(Depot) obj;
        /*ArrayList<Vehicle> vehicleArrayList=new ArrayList<Vehicle>();
        if(dep.getVehicles()!=null)
            for(Vehicle v:dep.getVehicles())
                vehicleArrayList.add(v);
        for(Vehicle v : this.vehicles)
            if(this.vehicles!=null && vehicleArrayList.contains(v))
          */
        return name.equals(dep.getName());

    }

}
