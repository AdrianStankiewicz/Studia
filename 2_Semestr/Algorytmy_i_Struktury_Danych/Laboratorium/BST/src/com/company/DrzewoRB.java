package com.company;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

//W nawiasach kontowych zapisujemy wartosci, ktre wypelnia figurantow pozwalajacych nam na parametryzacje klasy generycznej
public class DrzewoRB<Klucz, Wartosc> {

    static final boolean CZERWONY = true;
    static final boolean CZARNY = false;
    private Wierzcholek korzen;

    class Wierzcholek {
        Klucz klucz;
        Wartosc wartosc;
        Wierzcholek lewyPotomek;
        Wierzcholek prawyPotomek;
        int N;
        boolean kolor;

        public Wierzcholek(Klucz a, Wartosc b, int N, boolean kolor) {
            this.klucz = a;
            this.wartosc = b;
            this.N = N;
            this.kolor = kolor;
        }

        public String toString() {
            return klucz.toString() + " " + wartosc.toString();
        }
    }

    Comparator<Klucz> compS = new Comparator<Klucz>() {
        Collator c = Collator.getInstance(new Locale("pl", "PL"));

        @Override
        public int compare(Klucz s1, Klucz s2) {
            if (s1.getClass().getName().equals("java.lang.Integer")) return (int) Math.signum((int) s1 - (int) s2);
            return c.compare(s1, s2);
        }
    };

    public Wierzcholek rotacjaLewa(Wierzcholek h) {
        Wierzcholek x = h.prawyPotomek;
        h.prawyPotomek = x.lewyPotomek;
        x.lewyPotomek = h;
        x.N = h.N;
        x.kolor = h.kolor;
        h.kolor = CZERWONY;
        h.N = 1 + rozmiar(h.lewyPotomek) + rozmiar(h.prawyPotomek);
        return x;
    }

    public Wierzcholek rotacjaPrawa(Wierzcholek h) {
        Wierzcholek x = h.lewyPotomek;
        h.lewyPotomek = x.prawyPotomek;
        x.prawyPotomek = h;
        x.kolor = h.kolor;
        h.kolor = CZERWONY;
        x.N = h.N;
        h.N = 1 + rozmiar(h.lewyPotomek) + rozmiar(h.prawyPotomek);
        return x;
    }

    void zmienKolory(Wierzcholek h) {
        h.kolor = CZERWONY;
        h.lewyPotomek.kolor = CZARNY;
        h.prawyPotomek.kolor = CZARNY;
    }

    boolean jestCzerwony(Wierzcholek x) {
        if (x == null) return false;
        return x.kolor == CZERWONY;
    }

    public void dodaj(Klucz klucz, Wartosc wartosc) {
        korzen = dodaj(korzen, klucz, wartosc);
        korzen.kolor = CZARNY;
    }

    private Wierzcholek dodaj(Wierzcholek wierz, Klucz klucz, Wartosc wartosc) {
        if (wierz == null)
            return new Wierzcholek(klucz, wartosc, 1, CZERWONY);
        int por??wnanie = compS.compare(klucz, wierz.klucz);
        if (por??wnanie < 0) wierz.lewyPotomek = dodaj(wierz.lewyPotomek, klucz, wartosc);
        else if (por??wnanie > 0) wierz.prawyPotomek = dodaj(wierz.prawyPotomek, klucz, wartosc);
        else wierz.wartosc = wartosc;
        if (jestCzerwony(wierz.prawyPotomek) && !jestCzerwony(wierz.lewyPotomek)) wierz = rotacjaLewa(wierz);
        if (jestCzerwony(wierz.lewyPotomek) && jestCzerwony(wierz.lewyPotomek.lewyPotomek)) wierz = rotacjaPrawa(wierz);
        if (jestCzerwony(wierz.prawyPotomek) && jestCzerwony(wierz.lewyPotomek)) zmienKolory(wierz);
        wierz.N = rozmiar(wierz.lewyPotomek) + rozmiar(wierz.prawyPotomek) + 1;
        return wierz;
    }

    private int rozmiar(Wierzcholek w) {
        if (w == null) return 0;
        else return w.N;
    }

    public int zwrocPoziom(Klucz klucz) {
        int poziom = 0;
        Wierzcholek w = korzen;
        while (w != null) {
            poziom++;
            int porownanie = compS.compare(klucz, w.klucz);
            if (porownanie < 0) w = w.lewyPotomek;
            else if (porownanie > 0) w = w.prawyPotomek;
            else return poziom;
        }
        return -1;
    }

    public int wysokoscDrzewa(Klucz[] klucze) {
        int wysokosc = 0;
        int poziomKlucza = 0;
        for (Klucz klucz : klucze) {
            poziomKlucza = zwrocPoziom(klucz);
            if (wysokosc < poziomKlucza) wysokosc = poziomKlucza;
        }
        return wysokosc;
    }

    ArrayList<Wierzcholek> kolejka = new ArrayList<>();

    private void przeszukajZakres(Wierzcholek x, Klucz dolny, Klucz g??rny) {
        if (x == null) return;

        int dZDanym = compS.compare(dolny, x.klucz);
        int gZDanym = compS.compare(g??rny, x.klucz);

        if (dZDanym == -1) przeszukajZakres(x.lewyPotomek, dolny, g??rny);
        if (dZDanym <= 0 && gZDanym >= 0) kolejka.add(x);
        if (gZDanym == 1) przeszukajZakres(x.prawyPotomek, dolny, g??rny);
    }

    public static void main(String[] args) {

        // Gdyby to by??o drzewoBST to pierwszym wierzcholkiem bylaby Ala bo by??a pierwsza dodana
        // Ale w wypadku drzewaRB jest to nie do znalezienia, poniewaz przy kazdym dodaniu mieszamy w prawo i lewo,
        // przez co struktura jest nieprzewidywalna

        DrzewoRB<String, String> drzewo = new DrzewoRB<>();
        drzewo.dodaj("Ala", "kot");
        drzewo.dodaj("Aleksandra", "pies");
        drzewo.dodaj("Gdynia", "1999");
        drzewo.dodaj("Gda??sk", "2010");
        drzewo.dodaj("Drezno", "2010-11-11");
        drzewo.dodaj("Gniezno", "2015-12-11");
        drzewo.dodaj("Grudzi??dz", "2017-11-11");
        drzewo.dodaj("Hrubiesz??w", "2017-01-21");
        drzewo.dodaj("Pozna??", "2018-01-21");
        drzewo.dodaj("Pruszcz", "2011");
        drzewo.dodaj("Przemy??l", "2008-01-21");
        drzewo.dodaj("S??upsk", "2010-10-12");
        drzewo.dodaj("??roda", "3");
        drzewo.dodaj("Zawada", "2011");
        drzewo.dodaj("??abi??ska", "2011");

        //Przeszukujemy zakres od (g??ry) korzenia, o wartosciach od A do ????
        drzewo.przeszukajZakres(drzewo.korzen,"A","????");
        String[] lista = new String[drzewo.kolejka.size()];

        for(int i=0;i < lista.length; i++) {
            lista[i] = drzewo.kolejka.get(i).klucz;
        }
        int wys = drzewo.wysokoscDrzewa(lista);
        System.out.println(wys);
        System.out.println("-------------");
        System.out.println(drzewo.korzen.klucz);
    }
}