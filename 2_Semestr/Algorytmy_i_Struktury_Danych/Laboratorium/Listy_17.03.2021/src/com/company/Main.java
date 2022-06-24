package com.company;

import java.util.ArrayList;

public class Lista {
    static ArrayList<Osoba> lista = new ArrayList<Osoba>();

    public static void main() {
        lista.add( new Osoba("Kazimierz","Wiśniewski", "1998-01-11"));
        lista.add( new Osoba("Janusz", "Wiśniak","1998-10-11"));
        lista.add( new Osoba("Bartosz","Adamski","1998-10-11"));
        lista.add( new Osoba("Zygmunt","Boruta", "1999-05-24"));
        lista.add( new Osoba("Bartosz","Boruta", "1999-05-25"));
        lista.add( new Osoba("Paweł","Zieliński", "1997-03-17"));
        lista.add( new Osoba("Wojciech","Śliwiński", "1998-07-25"));
        lista.add( new Osoba("Bogdan","Śliwiński", "2000-11-08"));
        lista.add( new Osoba("Bogdan","Źreda", "2000-07-08"));
        lista.add( new Osoba("Stanisław","Boruta", "1998-07-25"));
        lista.add( new Osoba());
        Osoba osoba = new Osoba();
        Osoba osoba1 = new Osoba();
        System.out.println(osoba == osoba1);

        for (int i=0;i<lista.size();i++)
            System.out.println(lista.get(i));

    }
}
