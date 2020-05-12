package com.company;

public class Client {
    private String name;
    private int order;

    public Client() {}
    public Client(String name,int order){
        this.setName(name);
        this.setOrder(order);
    }

    public Client(String name) {
        this.setName(name);
    }

    @Override
    public String toString(){
        return getName();
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getName() {
        return name;
    }

    public int getOrder() {return order;}

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null || !(obj instanceof Client))
            return false;
        Client cli=(Client) obj;
        return name.equals(cli.getName()) && order==cli.getOrder();
    }
}
