package com.company;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class KlasaOsoba {
    static LocalDate dzisiaj = LocalDate.now();

    public double wiek(String data) {
        int uRok = Integer.parseInt(data.substring(0, 4));
        int uMiesiac = Integer.parseInt(data.substring(5, 7));
        int uDzień = Integer.parseInt(data.substring(8, 10));
        LocalDate dataUrodzenia = LocalDate.of(uRok, uMiesiac, uDzień);
        Period per = Period.between(dataUrodzenia, dzisiaj);
        return per.getYears() + per.getMonths() / 12.0 + per.getDays() / 365.0;
    }

    public static void Main(String[] args) {
        ArrayList<Osoba> lista = new ArrayList<>();
        lista.add(new Osoba("Kazimierz", "Wiśniewski", "1998-01-11"));
        lista.add(new Osoba("Janusz", "Wiśniak", "1998-10-11"));
        lista.add(new Osoba("Bartosz", "Adamski", "1998-10-11"));
        lista.add(new Osoba("Zygmunt", "Boruta", "1999-05-24"));
        lista.add(new Osoba("Bartosz", "Boruta", "1999-05-25"));
        lista.add(new Osoba("Paweł", "Zieliński", "1997-03-17"));
        lista.add(new Osoba("Wojciech", "Śliwiński", "1998-07-25"));
        lista.add(new Osoba("Bogdan", "Śliwiński", "2000-11-08"));
        lista.add(new Osoba("Bogdan", "reda", "2000-07-08"));
        lista.add(new Osoba("Stanis³aw", "Boruta", "1998-07-25"));

        ObiektListy pierwszy = new ObiektListy();
        ObiektListy kolejny = pierwszy;
        kolejny.osoba = new Osoba("Kazimierz", "Wiśniewski", "1998-01-11");
        kolejny.nastepny = new ObiektListy();
        kolejny = kolejny.nastepny;
        kolejny.osoba = new Osoba("Janusz", "Wiśniak", "1998-10-11");
        kolejny.nastepny = new ObiektListy();
        kolejny = kolejny.nastepny;
        kolejny.osoba = new Osoba("Bartosz", "Adamski", "1998-10-11");
        kolejny.nastepny = new ObiektListy();
        kolejny = kolejny.nastepny;
        kolejny.osoba = new Osoba("Zygmunt", "Boruta", "1999-05-24");
        for (int i = 0; i < dane.length; i++) {
            kolejny.nastepny = new ObiektListy();
            kolejny = kolejny.nastepny;
            kolejny.osoba = new Osoba(dane[i][0], dane[i][1], dane[i][2]);
        }
        kolejny.nastepny = null;

        ObiektListy biezacy = pierwszy;
        do {
            System.out.println(biezacy.osoba);
            biezacy = biezacy.nastepny;
        } while (biezacy.nastepny != null);
    }

    static String[][] dane = new String[][]{
            {"Janusz", "Zieliński", "1998-01-11"},
            {"Jan", "Nowicki", "2003-11-22"},
            {"Iwan", "Branicki", "2001-02-17"},
            {"Tadeusz", "Nowicki", "2000-07-21"},
            {"Jan", "ObiektListycki", "2000-01-11"},
            {"Jan", "Adamski", "2000-03-25"}};
    static class ObiektListy{
        Osoba osoba;
        ObiektListy nastepny;
        ObiektListy poprzedni;
    }
}