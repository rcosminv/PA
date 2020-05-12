package com.company;

import java.util.*;

public class Solution {
    private Problem instance;

    public Solution(){}
    public Solution(Problem problem){
        this.setInstance(problem);
    }

    public Problem getInstance() {
        return instance;
    }

    public void setInstance(Problem instance) {
        this.instance = instance;
    }

    /**
     * Algoritmul greedy construieste un tur astfel: gaseste succesiune de clienti si aloca acesteia un vehicul care sa efectueze cursa;
     * Succesiunea de clienti alocata unei curse se alege in ordinea data la initializare; se iau crescator in functie de ordin,
     * astfel incat sa nu existe doi clienti cu acelasi ordin intr-o cursa sau un client sa aiba ordin mai mare decat succesorul sau.
     * Se construiesc mai multe astfel de tururi pana se epuizeaza numarul de vehicule sau clientii.
     */
    public Tour[] solveProblemGreedy(){
        if (instance==null || instance.getClients()==null || instance.getDepots()==null || instance.getVehicles()==null)
            return null;
        else {
            List<Tour> tur=new ArrayList<>();
            Tour[] tours;
            int lastOrder = 0;
            int vehicleCount = instance.getVehicles().length;
            List<Client> clientsTaken = new ArrayList<>();
            List<Vehicle> vehicles=new ArrayList<>();

            while (vehicleCount > 0 && clientsTaken.size() < instance.getClients().length) {
                ArrayList<Client> clients=new ArrayList<>();
                lastOrder=0;

                for (Client c : instance.getClients()) {
                    if (lastOrder < c.getOrder() && !clientsTaken.contains(c)) {
                        clientsTaken.add(c);
                        clients.add(c);
                        lastOrder = c.getOrder();
                    }
                }
                Tour tour=new Tour();
                tour.setVehicle(instance.getVehicles()[--vehicleCount]);
                Client[] clients2=new Client[clients.size()];
                tour.setClients(clients.toArray(clients2));
                tur.add(tour);
            }
            tours=new Tour[tur.size()];
            tur.toArray(tours);
            return tours;
        }
    }

    private int[][] getCostMatrix(){
        //de la o locatie la oricare alta ; o locatie=depou(vehicul),client
        int size = instance.getClients().length+instance.getDepots().length;
        int[][] costMatrix=new int[size][size];

        for(int i =0;i<costMatrix.length;i++) //populam matricea
            for(int j=0;j<costMatrix.length;j++)
                if(i==j)
                    costMatrix[i][j]=-1;
                else
                    costMatrix[i][j]=(new Random()).nextInt(4)<2? 0: (new Random()).nextInt(7);


        return costMatrix;
    }

    public List<Tour> solveProblemDijkstra(){
        int[][] costMatrix=getCostMatrix();
        //afisam matricea:
        for(int i=0;i<costMatrix.length;i++) {
            for (int j = 0; j < costMatrix.length; j++)
                System.out.print(costMatrix[i][j] + " ");
            System.out.print("\n");
        }

        //presupunem ca primele k pozitii din matrice sunt depourile, iar restul sunt clientii in ordinea primita initial
        int size2=instance.getDepots().length;
        Set<Client> takenClients=new HashSet<>();
        //aplicam algoritmul cu src fiecare depou
        int[] solution=new Dijkstra(costMatrix).dijkstra(0); //aplicam alg. Dijkstra pe matricea de cost minim
        for(int value:solution)
            System.out.print(value+" ");

        List<Client> clientList=new ArrayList<>();
        int i=0;
        Tour t=new Tour();
        List<Tour> tours=new ArrayList<>();

        while(!takenClients.containsAll(Arrays.asList(instance.getClients()))){
            if(solution[i]<size2) //am gasit un Depou, incepem construirea unui tur
                t.setVehicle(instance.getDepots()[i].getVehicles()[0]);

            while(solution[i]>=size2) //luam toti clientii pana gasim in lista un nou depou
            {
                clientList.add(instance.getClients()[i-size2]);
                takenClients.add(instance.getClients()[i-size2]);
                i++;
            }
            if(clientList!=null)
            {
                Client[] clients=new Client[clientList.size()];
                t.setClients(clients); //adaugam clientii la tur
                clientList=null;
                tours.add(t);
            } //salvam turul
        }

        return tours;
    }

}
