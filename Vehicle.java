package com.company;

public abstract class Vehicle {
    protected String name;
    private Depot depot;
    private VehicleType type;
    private static String[] names=new String[1];

    public Vehicle(String name) {
        this.setName(name);
    }


    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        for(String n : names)
            if(n!=null && n.equals(name))
            {
                System.out.println("Error: exista deja un vehicul cu numele "+name);
                return false;
            }
        String[] s=new String[names.length+1];
            for(int i=0;i<names.length;i++)
                s[i]=names[i];
        s[names.length]=name;
        this.name = name;
        names=s;
        return true;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public Depot getDepot(){
        return depot;
    }

    protected void setDepot(Depot dep)
    {
        this.depot=dep;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null || !(obj instanceof Vehicle)) {
            return false;
        }
        Vehicle other=(Vehicle) obj;
        return name.equals(other.getName());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
