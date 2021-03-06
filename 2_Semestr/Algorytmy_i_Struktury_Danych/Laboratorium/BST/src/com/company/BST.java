package com.company;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Locale;

public class BST <K1, K2>{
    private Wierzcholek korzen;

    class Wierzcholek {
        K1 klucz;
        K2 wartosc;
        Wierzcholek lewyPotomek;
        Wierzcholek prawyPotomek;
        int rozmiarP;

        public Wierzcholek(K1 a, K2 b, int N) {
            this.klucz = a;
            this.wartosc = b;
            this.rozmiarP = N;
        }

        public String toString() {
            return klucz.toString() + " " + wartosc.toString();
        }
    }

    public void wypisz(K1 kluczDolny, K1 kluczGorny) {
        przeszukajZakres(korzen, kolejka, kluczDolny, kluczGorny);
        for(Wierzcholek x: kolejka) System.out.print(x + "   ");
    }

    public Wierzcholek miejsceDla(K1 klucz, K2 wartosc) {
        String kierunek = "";
        Wierzcholek w = korzen, wP = null;
        boolean wystepuje = false;
        if(czyWystepuje(klucz) != null) {
            wystepuje = true;
        }
        while(w != null) {
            if(!wystepuje) w.rozmiarP++;
            wP = w;
            int porownanie = compS.compare(klucz, w.klucz);
            if(porownanie < 0) {
                kierunek = "lewy";
                w = w.lewyPotomek;
            }
            else if(porownanie > 0) {
                kierunek = "prawy";
                w = w.prawyPotomek;
            }
            else {
                kierunek = "trafiony";
                break;
            }
        }
        if(korzen == null) korzen = new Wierzcholek(klucz, wartosc, 1);
        else {
            if(kierunek.equals("lewy")) wP.lewyPotomek = new Wierzcholek(klucz, wartosc, 1);
            if(kierunek.equals("prawy")) wP.prawyPotomek = new Wierzcholek(klucz, wartosc, 1);
            if(kierunek.equals("trafiony")) wP.wartosc = wartosc;
        }

        return wP;
    }

    Comparator <K1> compS = new Comparator<K1>() {
        Collator c = Collator.getInstance(new Locale("pl", "PL"));

        @Override
        public int compare(K1 s1, K1 s2) {
            if (s1.getClass().getName().equals("java.lang.Integer")) return (int) Math.signum((int) s1 - (int) s2);
            return c.compare(s1, s2);
        }
    };
    public Wierzcholek czyWystepuje(K1 klucz) {
        Wierzcholek w = korzen;
        while (w != null) {
            int porownanie = compS.compare(klucz, w.klucz);
            if (porownanie < 0) w = w.lewyPotomek;
            else if (porownanie > 0) w = w.prawyPotomek;
            else return w;
        }
        return null;
    }
    public K1 znajdzMinKlucz() {
        Wierzcholek w = korzen;
        while(w.lewyPotomek != null) w=w.lewyPotomek;
        return w.klucz;
    }
    public K1 znajdzMaxKlucz() {
        Wierzcholek w = korzen;
        while(w.prawyPotomek != null) w=w.prawyPotomek;
        return w.klucz;
    }
    ArrayList<Wierzcholek> kolejka = new ArrayList<>();
    private void przeszukajZakres(Wierzcholek x, ArrayList<Wierzcholek> kolejka, K1 dolny, K1 g??rny) {
        if (x==null) return;

        int dZDanym=compS.compare(dolny, x.klucz);
        int gZDanym=compS.compare(g??rny, x.klucz);

        if(dZDanym==-1) przeszukajZakres(x.lewyPotomek,kolejka,dolny, g??rny);

        if(dZDanym<=0 && gZDanym>=0) kolejka.add(x);
        if(gZDanym==1) przeszukajZakres(x.prawyPotomek,kolejka,dolny, g??rny);
    }
    private void przeszukajZakres(Wierzcholek x, K1 dolny, K1 g??rny) {
        if (x==null) return;

        int dZDanym=compS.compare(dolny, x.klucz);
        int gZDanym=compS.compare(g??rny, x.klucz);

        if(dZDanym==-1) przeszukajZakres(x.lewyPotomek,dolny, g??rny);
        if(dZDanym<=0 && gZDanym>=0) kolejka.add(x);
        if(gZDanym==1) przeszukajZakres(x.prawyPotomek,dolny, g??rny);
    }
    public int zwrocPoziom (K1 klucz) {
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

    public int wysokoscDrzewa(K1[] klucze) {
        int wysokosc = 0;
        int poziomKlucza = 0;
        for (K1 klucz: klucze) {
            poziomKlucza = zwrocPoziom(klucz);
            if (wysokosc < poziomKlucza) wysokosc = poziomKlucza;
        }
        return wysokosc;
    }
    //log2(n) = wysoko???? drzewa

    public static void main(String[] args) {
        BST <Integer, String> bst = new BST<>();
/*
        BST <String, Integer> bst = new BST<>();
        bst.miejsceDla("Adam",1998);
        bst.miejsceDla("Bronislaw",2001);
        bst.miejsceDla("Grzegorz",1998);
        bst.miejsceDla("Kacper",2007);
        bst.miejsceDla("??ukasz",2003);
        bst.miejsceDla("Szczepan",2001);
        bst.miejsceDla("Trebusz",1995);
        bst.miejsceDla("Zbigniew",2001);
        bst.miejsceDla("??aneta",2005);
*/

/*
        BST<String, Integer>.Wierzcholek szukany = bst.czyWystepuje("Grzegorz");
        if(szukany != null) System.out.println("Warto???? szukanego: " + szukany.klucz + " " + szukany.wartosc);
*/
/*
        String minKlucz = bst.znajdzMinKlucz();
        //if(minKlucz != null) System.out.println("Minimalny klucz: " + minKlucz);

        String maxKlucz = bst.znajdzMaxKlucz();
        //if(maxKlucz != null) System.out.println("Minimalny klucz: " + maxKlucz);

        bst.przeszukajZakres(bst.korzen,bst.kolejka,minKlucz,maxKlucz);
        for(BST<String, Integer>.Wierzcholek x: bst.kolejka)
            System.out.println(x.klucz);
*/
/*
        bst.przeszukajZakres(bst.korzen,bst.kolejka,"D","S");
        for(BST<String, Integer>.Wierzcholek x: bst.kolejka)
            System.out.print(x + "   ");
*/
        //bst.wypisz("S","S??");
/*
        bst.kolejka.clear();
        BST<String, Integer>.Wierzcholek x = bst.czyWystepuje("Zbigniew");
        bst.przeszukajZakres(x,"A","????");
        for(BST<String, Integer>.Wierzcholek xx: bst.kolejka)
            System.out.print(xx + "   ");

        String[] lista = new String[bst.kolejka.size()];
        int i=0;
        for(BST<String, Integer>.Wierzcholek xx: bst.kolejka)
            lista[i++] = x.klucz;

        int wysokosc = bst.wysokoscDrzewa(lista);
        System.out.println("wysokosc wynosi: " + wysokosc);
*/

        String tekst="Kompaktowy SUV wyra??nie ur??s??, co przek??ada si?? "
                + "na przestrze?? w kabinie. Tej nie brakuje w dw??ch rz??dach, "
                + "dzi??ki czemu cztery ros??e osoby wygodnie pokonaj?? tras?? "
                + "o d??ugo??ci kilkuset kilometr??w. Drugi rz??d zosta?? wyposa??ony "
                + "w regulacj?? w zakresie 14 cm i oparcie o zmiennym "
                + "k??cie nachylenia. Baga??nik o pojemno??ci 435 litr??w "
                + "oferuje do???? niski pr??g za??adunku i foremny kszta??t."
                + "Wzgl??dem poprzednika, wyra??nie poprawiono jako???? "
                + "materia????w wyko??czeniowych. Znaczna ich cz?????? jest "
                + "mi??kka i przyjemna w dotyku. Zdobienia wykonane "
                + "z aluminium i tworzywa o fakturze fortepianowej "
                + "wprowadzaj?? klimat premium. To samo mo??emy powiedzie?? "
                + "o elektronice. Centralny panel sk??ada si?? z dw??ch, "
                + "calowych ekran??w. Ten przed oczami kierowcy ma zmienn?? "
                + "grafik?? i nienagann?? przejrzysto????. Drugi z nich zawiaduje "
                + "zestawem kamer, zewn??trznymi no??nikami pami??ci i "
                + "nawigacj?? z funkcj?? rozszerzonej rzeczywisto??ci. "
                + "Wpisuje w map?? obraz z kamery, co przek??ada si?? na "
                + "lepsze lokalizowanie skr??t??w i adres??w. "
                + "Systemem sterujemy za pomoc?? g??adzika umieszczonego "
                + "mi??dzy fotelami lub g??osowo. "
                + "Wystarczy powiedzie?? hej, Mercedes, zimno mi "
                + "by elektronika zwi??kszy??a temperatur?? nawiewu. "
                + "Komputer rozpoznaje te?? wiele innych komend.";
        String[] podzielony=tekst.split(" ");

        int chwilowa;
        for(int i=0;i<podzielony.length;i++){
            if(podzielony[i].length() > 2) {
                chwilowa = podzielony[i].hashCode()&0x7fffffff;

                bst.miejsceDla(chwilowa,podzielony[i]);
            }
        }
        System.out.println(bst.korzen.rozmiarP);

        bst.przeszukajZakres(bst.korzen,0,0x7fffffff);
        //Tworzymy liste kluczy potrzebna do wypisania wysokosci
        Integer[] lista = new Integer[bst.kolejka.size()];
        int i=0;
        System.out.println(bst.kolejka.size());
        for(BST<Integer, String>.Wierzcholek xx: bst.kolejka) {
            lista[i++] = xx.klucz;
            //System.out.println(xx.klucz);
        }
        System.out.println(bst.wysokoscDrzewa(lista));

    }
}