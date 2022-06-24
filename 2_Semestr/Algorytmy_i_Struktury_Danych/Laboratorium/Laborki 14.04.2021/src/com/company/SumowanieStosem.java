package com.company;

public class SumowanieStosem {
    static int[] tabl = {23,45,62,7,-1,60,45};
    static int suma = 0;
    static int sumuj(int i) {
        if (i == tabl.length - 1) return 0;
        i++;
        System.out.println("Odkładanie i: " + i);
        sumuj(i);
        suma += tabl[i];
        System.out.println("Suma częściowa: " + suma);
        return suma;
    }
    public static void main(String[] args){
        System.out.println("Ostateczna suma: " + sumuj(-1));
        Stos<Integer> obiektStosu = new Stos<>();
        for(int i=0; i<tabl.length; i++) {
            obiektStosu.polozNaStosie(tabl[i]);
            System.out.println("Odkładanie i: " + i);
        }
        suma = 0;
        for(int i = 0; i < tabl.length ; i++) {
            suma += obiektStosu.zdejmijZeStosu();
            System.out.println("zdejmowanie " + i);
        }
        System.out.println("drukowanie sumy: " + suma);
    }
}
