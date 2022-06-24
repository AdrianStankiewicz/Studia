package com.company;

import java.text.CollationKey;
import java.text.Collator;
import java.util.Locale;

public class SortowanieStringow {
    static String[] lista = new String[]{"", "Domaracki", "Żbikowska", "Sobieraj", "Wikliński", "Milewska", "Ćwikliński", "Czarnecki"};
    static String[] lista2 = new String[]{"", "Kowalski", "Frąckowiak", "Sobolewski", "Tochowicz", "Grzybek"};
    static Collator collator = Collator.getInstance(new Locale("pl","PL"));

    public static void main(String[] args)
    {
        System.out.println(collator.compare(lista[1],lista[2]));
        System.out.println(collator.compare("Żabinska","Źreda"));
        System.out.println("jest kopcem " + czyJestKopcem(lista));
        zanurzanie(lista, 1);
        System.out.println("jest kopcem " + czyJestKopcem(lista));
        wypiszElementy(lista);
    }
    public static boolean czyJestKopcem(String[] abc) {
        int dlugosc=abc.length;
        boolean jestKopcem = true;
        for(int k=1; k<abc.length;k++) {
            if(2*k>=dlugosc) return true;
            jestKopcem = collator.compare(abc[k],abc[2*k]) > -1;
            if(2*k+1>=dlugosc) return jestKopcem;
            jestKopcem = jestKopcem && collator.compare(abc[k],abc[2*k+1]) > -1;
            if (!jestKopcem) return false;}
        return true;
    }

    public static void zanurzanie(String[] lista, int k)
    { int N=lista.length-1;
        int j;
        while(2*k<=N) {
            j = 2*k;
            if(j<N && collator.compare(lista[j],lista[j+1]) <0)  j++;
            if(collator.compare(lista[k],lista[j]) >-1 ) break;
            String pom=lista[k];
            lista[k]=lista[j];
            lista[j]=pom;
            k=j;}
    }

    public static void wypiszElementy(String[] lista)
    {
        for(int i=1;i<lista.length;i++){
            System.out.print(lista[i]+ " ");
        }
        System.out.println();
    }
}
