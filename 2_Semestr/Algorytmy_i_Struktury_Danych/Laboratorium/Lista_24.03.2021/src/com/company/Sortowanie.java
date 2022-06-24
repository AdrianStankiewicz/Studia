package com.company;

public class Sortowanie {

    static int lista[] = {4,6,3,47,34,7,8,10,12,5,78,345,762,7,234,63,21,2,76,2,6};
    static int pomocnicza[] = new int[lista.length];

    public static void main(String[] args) {
        Sortowanie obiekt = new Sortowanie();
        int ile = obiekt.utworzTrojki(lista.length);  // TODO Auto-generated method stub
        Trojka trojka;
        for (int i = 0; i < ile; i++) {
            trojka = obiekt.kTr.pobierzPierwszego();
            if (trojka.x == 0) for (int k = 0; k < lista.length; k++) pomocnicza[k] = lista[k];
            obiekt.scal(lista, pomocnicza, trojka.x, trojka.y, trojka.z);
        }
        for (int k = 0; k < lista.length; k++) System.out.print(lista[k] + " ");
        System.out.println();
    }

    Kolejka<Trojka>kTr = new Kolejka<>();

    int utworzTrojki(int n) {
        int numer=0;
        int tr1,tr2,tr3,pzakres;
        for(int zakres=2; zakres<2*n; zakres*=2) {
            for (int x=0; x<n; x+=zakres) {
                tr1=x; tr2=x+(zakres-1)/2;
                pzakres=zakres;
                while (tr2>n-1) {
                    pzakres=pzakres/2; tr2=x+(pzakres-1)/2;
                }
                tr3=x+zakres-1;
                if(tr3>n-1) tr3=n-1;
                kTr.dodajDoKolejki(new Trojka(tr1,tr2,tr3));
                System.out.println(tr1+" "+tr2+" "+tr3);
                numer++;
            }
        }
        return numer;
    }
    void scal(int[] lista, int[] pomocnicza, int odPoz, int srodek, int doPoz) {
        int i=odPoz, j=srodek+1;
        for (int k=odPoz; k<=doPoz; k++){
            if (i>srodek) lista[k]=pomocnicza[j++];
            else if (j>doPoz) lista[k]=pomocnicza[i++];
            else if (pomocnicza[j]<pomocnicza[i]) lista[k]=pomocnicza[j++];
            else lista[k]=pomocnicza[i++];
        }}
}
class Trojka {
    int x, y, z;

    public Trojka(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Trojka() {
    }
}