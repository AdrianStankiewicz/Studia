package com.company;

import java.text.Collator;
import java.util.Locale;

public class Priorytetowa<Element> {
    private int N = 0;

    public class ObiektKolejki {
        Element element;
        ObiektKolejki następny;
    }

    ObiektKolejki pierwszy;
    ObiektKolejki ostatni;

    public void dodajDoKolejki(Element el) {
        ObiektKolejki staryOstatni = ostatni;
        ostatni = new ObiektKolejki();
        ostatni.element = el;
        ostatni.następny = null;
        if (jestPusta()) pierwszy = ostatni;
        else
            staryOstatni.następny = ostatni;
        N++;
        if (N > 1) wynurzanieOstatniego();
    }

    public Element pobierzPierwszego()
    {
        if (jestPusta()) return null;
        Element el = pierwszy.element;
        zamień(1,N);
        pobierzItego(N-1).następny = null;
        if (jestPusta()) ostatni = null;
        N--;
        if (N > 1)
            zanurzaniePierwszego();
        return el;
    }

    public void zanurzaniePierwszego()
    { int k=1;
        int j;
        Osoba pD;
        Osoba dD;
        boolean warunek;
        while(2*k<=N) {
        j = 2*k;
        pD=(Osoba)pobierzItego(j).element;
        dD=(Osoba)pobierzItego(j+1).element;
        warunek=pD.compareTo(dD)==-1;
        if(j<N && warunek) j++;
        pD=(Osoba)pobierzItego(k).element;
        dD=(Osoba)pobierzItego(j).element;
        warunek=pD.compareTo(dD)==-1;
        if(!warunek) break;
        zamień(k,j);
        k=j;
        }
    }

    public boolean jestPusta() {
        return N == 0;
    }

    public int ileOczekujących() {
        return N;
    }

    public void drukuj() {
        ObiektKolejki pom;
        pom = pierwszy;
        int i = 1;
        System.out.println("Elementów " + N + " ======================");
        do {
            System.out.println(i + " " + pom.element);
            i++;
            pom = pom.następny;
        }
        while (pom != null);
        System.out.println("=================================");
    }

    public boolean czyJestKopcem(Priorytetowa<Osoba> lista) {
        int dlugosc = lista.N + 1;
        boolean jestKopcem = true;
        for (int k = 1; k < lista.N; k++) {
            Priorytetowa<Osoba>.ObiektKolejki kTy = lista.pobierzItego(k);
            Priorytetowa<Osoba>.ObiektKolejki dwakTy = lista.pobierzItego(k * 2);
            if (2 * k >= dlugosc) return true;
            jestKopcem = kTy.element.compareTo(dwakTy.element) > -1;
            if (2 * k + 1 >= dlugosc) return jestKopcem;
            dwakTy = lista.pobierzItego(k * 2 + 1);
            jestKopcem = jestKopcem && kTy.element.compareTo(dwakTy.element) > -1;
            if (!jestKopcem) return false;
        }
        return true;
    }

    public ObiektKolejki pobierzItego(int ity) {
        if (jestPusta()) return null;
        ObiektKolejki zwracany = pierwszy;
        for (int i = 1; i < N; i++) {
            if (i == ity) return zwracany;
            zwracany = zwracany.następny;
        }
        if (ity == N) return zwracany;
        return null;
    }

    public boolean zamień(int i, int j) {
        if (i > N || j > N) return false;
        ObiektKolejki pierwszy = pobierzItego(i);
        ObiektKolejki drugi = pobierzItego(j);
        Element pom = pierwszy.element;
        pierwszy.element = drugi.element;
        drugi.element = pom;
        return true;
    }

    /* wynurzanie po nazwisku
    public void wynurzanieOstatniego() {
        int k = N;
        Osoba pD = (Osoba) pobierzItego(k / 2).element;
        Osoba dD = (Osoba) pobierzItego(k).element;
        boolean warunek = pD.compareTo(dD) == -1;
        while (k > 1 && warunek) {
            zamień(k / 2, k);
            k = k / 2;
            if (k == 1) break;
            else {
                pD = (Osoba) pobierzItego(k / 2).element;
                dD = (Osoba) pobierzItego(k).element;
                warunek = pD.compareTo(dD) == -1;
            }
        }
    }
    */

    public void wynurzanieOstatniego() {
        int k = N;
        Osoba pD = (Osoba) pobierzItego(k / 2).element;
        Osoba dD = (Osoba) pobierzItego(k).element;
        boolean warunek = pD.compareToDataUr(dD) == -1;
        while (k > 1 && warunek) {
            zamień(k / 2, k);
            k = k / 2;
            if (k == 1) break;
            else {
                pD = (Osoba) pobierzItego(k / 2).element;
                dD = (Osoba) pobierzItego(k).element;
                warunek = pD.compareToDataUr(dD) == -1;
            }
        }
    }

    public static void main(String[] args) {
        Priorytetowa<Osoba> priorytetowa = new Priorytetowa<>();
        priorytetowa.dodajDoKolejki(new Osoba("Janusz", "Wiśniowski", "1999-10-10"));
        priorytetowa.dodajDoKolejki(new Osoba("Stanisław", "Wiśniak", "1998-10-12"));
        priorytetowa.dodajDoKolejki(new Osoba("Stanisław", "Ćwikliński", "1987-10-12"));
        priorytetowa.dodajDoKolejki(new Osoba("Stanisław", "Biegała", "1950-10-12"));
        priorytetowa.dodajDoKolejki(new Osoba("Kazimierz", "Domagalski", "1964-10-12"));
        priorytetowa.dodajDoKolejki(new Osoba("Stefan", "Zabłocki", "1984-10-12"));
        priorytetowa.dodajDoKolejki(new Osoba("Włodzimierz", "Adamski", "1997-10-12"));
        priorytetowa.dodajDoKolejki(new Osoba("Marcin", "Turowski", "1980-10-12"));
        priorytetowa.dodajDoKolejki(new Osoba("Damian", "Żabiński", "1995-08-19"));
        priorytetowa.wynurzanieOstatniego();
        priorytetowa.drukuj();
        System.out.println("Jest kopcem " + priorytetowa.czyJestKopcem(priorytetowa));
        Osoba pierwszy = priorytetowa.pobierzPierwszego();
        System.out.println(pierwszy);
    }







}