package com.company;


public class Main {

        public static void main(String[] args) {
            Client c1 = new Client();
            c1.setName("Client 1");
            c1.setOrder(1);
            Client c2 = new Client("Client 2", 1);
            Client c3= new Client("Client 3",3);
            Client c4=new Client("Client 4",3);
            Client c5=new Client("Client 5",2);
            Client c6=new Client("Client 6",1);
            Client c7=new Client("Client 7",3);
            Client c8=new Client("Client 8",1);

            Car v1=new Car("Car 1");
            v1.setType(VehicleType.CAR);
            Car v2=new Car("Car 2");
            v2.setType(VehicleType.CAR);
            Drone v3=new Drone("Drone 1");
            Truck v4=new Truck("Truck 1");


            Depot d1 = new Depot("Depot 1");
            d1.setVehicles(v1, v2);
            Depot d2 = new Depot("Depot 2");
            d2.setVehicles(v3,v4);

            Problem pb=new Problem(); //instanta a problemei
            pb.setClients(c1,c2,c3,c4,c5,c6,c7);
            pb.setDepots(d1,d2);

            Solution s=new Solution(pb); //rezolvarea problemei
            for (Tour tour: s.solveProblemGreedy()){
                System.out.println(tour);
            }

            for(Tour t : s.solveProblemDijkstra()){
                System.out.println(t);
            }


        }
    }


