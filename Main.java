package com.company;
import java.util.Date;
public class Main {
        static void dfs( boolean matrice[][], boolean viz[],int x, String cuvinte[],int i){
        viz[i] = true;
        System.out.print(cuvinte[i] + ", ");
        for (int iterator = 0; iterator < x; iterator++)
            if (matrice[iterator][i] == true || matrice[i][iterator] == true){
                if (viz[iterator] == false){
                    dfs(matrice,viz,x,cuvinte,iterator);
                }
            }
    }
    static void bonus(int x, boolean matrice[][], String cuvinte[])
    {
        boolean vizitat[] = new boolean[x];
        for (boolean v : vizitat) v = false;
        for (int iterator= 0; iterator < x; iterator++) {
            if (vizitat[iterator] == false) {
                System.out.println("\nComponenta conexa " + (iterator+1));
                dfs( matrice, vizitat,x, cuvinte,iterator);
            }
        }
    }
    public static void main(String[] args) {
        int i = 0, j = 0, x, n, greseala = 0;
        char c[] = new char[100];
        Date startTimer = new Date();
        String errorMsg = "";
        x = Integer.parseInt(args[0]);
        n = Integer.parseInt(args[1]);
        int lungime_c = j;
        String cuvinte[] = new String[x];
        for (i = 0; i < x; i++) {
            cuvinte[i] = "";
            for (j = 0; j < n; j++) {
                int nr_random = (int) (Math.random() * lungime_c);
                cuvinte[i] += c[nr_random];
            }
            System.out.println(cuvinte[i]);
        }
        System.out.println("Cuvintele:");
        boolean matrice[][] = new boolean[x][x];
        for (i = 0; i < x; i++)
            for (j = i + 1; j < x; j++) {
                greseala = 0;
                for (int z = 0; z < n; z++) {
                    if (cuvinte[i].charAt(z) == cuvinte[j].charAt(z)) {
                        greseala = 1;
                        break;
                    }
                }
                matrice[i][j] = !(greseala == 0);
                matrice[j][i] = matrice[i][j];
            }
        int nr[] = new int[x];
        int max = 0;
        int min = x + 1;
        greseala = 0;
        if (x <= 100)
            System.out.println("Matricea de vecini: ");
        for (i = 0; i < x; i++) {
            nr[i] = 0;
            for (j = 0; j < x; j++) {
                if (x <= 100)
                    System.out.print(matrice[i][j] + " ");
                if (matrice[i][j] == true)
                    nr[i]++;
            }
            if (nr[i] > max)
                max = nr[i];
            if (nr[i] < min)
                min = nr[i];
            if (i > 0)
                if (nr[i] != nr[i - 1])
                    greseala = 1;
                if (x <= 100)
                System.out.println();
        }
        System.out.println("Cuvinte cu un nr maxim de vecini ");
        for (i = 0; i < x; i++) {
            if (nr[i] == max)
                System.out.println(cuvinte[i]);
        }
        System.out.println("cuvintele cu un nr minim de vecini ");
        for (i = 0; i < x; i++) {
            if (nr[i] == min)
                System.out.println(cuvinte[i]);
        }
        if (greseala == 0)
            System.out.println("cuvinte nr vecini egali");
        else System.out.println("cuvinte nr vecini inegali");
        Date finalTimer = new Date();
        float perioada = (finalTimer.getTime() - startTimer.getTime());
        System.out.println("Durata procesare= " + perioada);
        bonus1(x, matrice, cuvinte);
    }
}
