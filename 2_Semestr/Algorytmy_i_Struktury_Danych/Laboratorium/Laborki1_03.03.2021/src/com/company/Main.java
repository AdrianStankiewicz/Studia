package com.company;

public class Main {

    public static boolean czyJestKopcem(int[] abc) {
        int dlugosc=abc.length;
        boolean jestKopcem = true;
        for(int k=1; k<abc.length;k++) {
            if(2*k>=dlugosc) return true;
            jestKopcem=abc[k]>=abc[2*k];
            if(2*k+1>=dlugosc) return jestKopcem;
            jestKopcem=jestKopcem && abc[k]>=abc[2*k+1];
            if (!jestKopcem) return false;}
        return true; }
    //---------------------------------------------------
    public static void wynurzanie(int[] lista, int k)
    { int pom;
        while(k>1 && lista[k/2]<lista[k]) {
            pom=lista[k];
            lista[k]=lista[k/2];
            lista[k/2]=pom;
            k=k/2;}}
    //---------------------------------------------------
    public static void zanurzanie(int[] lista, int k)
    { int N=lista.length-1;
        int j;
        while(2*k<=N) {
            j = 2*k;
            if(j<N && lista[j]<lista[j+1]) j++;
            if(!(lista[k]<lista[j])) break;
            int pom=lista[k];
            lista[k]=lista[j];
            lista[j]=pom;
            k=j;}}
    //---------------------------------------------------
    public static void wypiszElementyListy(int[] lista)
    {
        for(int i=1;i < lista.length; i++){
            System.out.print(lista[i] + " ");
        }
        System.out.println();
    }
    public static void utworzKopiec(int[] abc)
    {
        int N = abc.length;
        for(int k=N/2; k>=1; k--){
            zanurzanie(abc, k);
        }
    }
    public static void zanurzanie(int[] lista, int k, int N) {
        int j;
        while (2 * k <= N) {
            j = 2 * k;
            if (j < N && lista[j] < lista[j + 1]) j++;
            if (!(lista[k] < lista[j])) break;
            int pom = lista[k];
            lista[k] = lista[j];
            lista[j] = pom;
            k = j;
        }
    }
    public static void sortowanie(int[] abc){
        int N = abc.length-1;
        for(int k=N/2; k>=1; k--) zanurzanie(abc, k);
        while(N>1) {
            int pom = abc[1];
            abc[1] = abc[N];
            abc[N--] = pom;
            zanurzanie(abc, 1, N);
        }
    }

    public static void main(String[] args) {
	int[] lista = new int[]{0, 6, 45, 34, 25, 22, 19, 15, 11, 12, 19, 3, 5};
	System.out.println("Witam!");
	//System.out.println("Jestem kopcem " + czyJestKopcem(lista));
	//wypiszElementyListy(lista);
	//wynurzanie(lista, 12);
	//System.out.println("Jestem kopcem " + czyJestKopcem(lista));
    //zanurzanie(lista, 1);
    //System.out.println("Jestem kopcem " + czyJestKopcem(lista));
    //wypiszElementyListy(lista);

    //int[] listaB =new int[]{0, 9, 84, 7, 5, 6, 5, 6, 4, 3, 11, 2, 1, 43, 4};
    //utworzKopiec(listaB);
    //System.out.println(czyJestKopcem(listaB));
    //wypiszElementyListy(listaB);

    sortowanie(lista);
    wypiszElementyListy(lista);
    }
}
