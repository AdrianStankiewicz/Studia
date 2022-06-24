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
    private void przeszukajZakres(Wierzcholek x, ArrayList<Wierzcholek> kolejka, K1 dolny, K1 górny) {
        if (x==null) return;

        int dZDanym=compS.compare(dolny, x.klucz);
        int gZDanym=compS.compare(górny, x.klucz);

        if(dZDanym==-1) przeszukajZakres(x.lewyPotomek,kolejka,dolny, górny);

        if(dZDanym<=0 && gZDanym>=0) kolejka.add(x);
        if(gZDanym==1) przeszukajZakres(x.prawyPotomek,kolejka,dolny, górny);
    }
    private void przeszukajZakres(Wierzcholek x, K1 dolny, K1 górny) {
        if (x==null) return;

        int dZDanym=compS.compare(dolny, x.klucz);
        int gZDanym=compS.compare(górny, x.klucz);

        if(dZDanym==-1) przeszukajZakres(x.lewyPotomek,dolny, górny);
        if(dZDanym<=0 && gZDanym>=0) kolejka.add(x);
        if(gZDanym==1) przeszukajZakres(x.prawyPotomek,dolny, górny);
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
    //log2(n) = wysokość drzewa

    public static void main(String[] args) {
        BST <Integer, String> bst = new BST<>();
/*
        BST <String, Integer> bst = new BST<>();
        bst.miejsceDla("Adam",1998);
        bst.miejsceDla("Bronislaw",2001);
        bst.miejsceDla("Grzegorz",1998);
        bst.miejsceDla("Kacper",2007);
        bst.miejsceDla("Łukasz",2003);
        bst.miejsceDla("Szczepan",2001);
        bst.miejsceDla("Trebusz",1995);
        bst.miejsceDla("Zbigniew",2001);
        bst.miejsceDla("Żaneta",2005);
*/

/*
        BST<String, Integer>.Wierzcholek szukany = bst.czyWystepuje("Grzegorz");
        if(szukany != null) System.out.println("Wartość szukanego: " + szukany.klucz + " " + szukany.wartosc);
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
        //bst.wypisz("S","Sż");
/*
        bst.kolejka.clear();
        BST<String, Integer>.Wierzcholek x = bst.czyWystepuje("Zbigniew");
        bst.przeszukajZakres(x,"A","Żż");
        for(BST<String, Integer>.Wierzcholek xx: bst.kolejka)
            System.out.print(xx + "   ");

        String[] lista = new String[bst.kolejka.size()];
        int i=0;
        for(BST<String, Integer>.Wierzcholek xx: bst.kolejka)
            lista[i++] = x.klucz;

        int wysokosc = bst.wysokoscDrzewa(lista);
        System.out.println("wysokosc wynosi: " + wysokosc);
*/

        String tekst="Kompaktowy SUV wyraźnie urósł, co przekłada się "
                + "na przestrzeń w kabinie. Tej nie brakuje w dwóch rzędach, "
                + "dzięki czemu cztery rosłe osoby wygodnie pokonają trasę "
                + "o długości kilkuset kilometrów. Drugi rząd został wyposażony "
                + "w regulację w zakresie 14 cm i oparcie o zmiennym "
                + "kącie nachylenia. Bagażnik o pojemności 435 litrów "
                + "oferuje dość niski próg załadunku i foremny kształt."
                + "Względem poprzednika, wyraźnie poprawiono jakość "
                + "materiałów wykończeniowych. Znaczna ich część jest "
                + "miękka i przyjemna w dotyku. Zdobienia wykonane "
                + "z aluminium i tworzywa o fakturze fortepianowej "
                + "wprowadzają klimat premium. To samo możemy powiedzieć "
                + "o elektronice. Centralny panel składa się z dwóch, "
                + "calowych ekranów. Ten przed oczami kierowcy ma zmienną "
                + "grafikę i nienaganną przejrzystość. Drugi z nich zawiaduje "
                + "zestawem kamer, zewnętrznymi nośnikami pamięci i "
                + "nawigacją z funkcją rozszerzonej rzeczywistości. "
                + "Wpisuje w mapę obraz z kamery, co przekłada się na "
                + "lepsze lokalizowanie skrętów i adresów. "
                + "Systemem sterujemy za pomocą gładzika umieszczonego "
                + "między fotelami lub głosowo. "
                + "Wystarczy powiedzieć hej, Mercedes, zimno mi "
                + "by elektronika zwiększyła temperaturę nawiewu. "
                + "Komputer rozpoznaje też wiele innych komend.";
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