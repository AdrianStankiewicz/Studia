package com.company;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import java.util.Scanner;

public class BST <K1, K2> {
    private Wierzcholek korzen;

    class Wierzcholek {
        K1 symbol;
        K2 wartosc;
        Wierzcholek lewyPotomek;
        Wierzcholek prawyPotomek;
        int rozmiarP;

        public Wierzcholek(K1 a, K2 b, int N) {
            this.symbol = a;
            this.wartosc = b;
            this.rozmiarP = N;
        }

        public String toString() {
            return symbol.toString() + " " + wartosc.toString();
        }
    }

    public Wierzcholek miejsceDla(K1 klucz, K2 wartosc) {
        String kierunek = "";
        Wierzcholek w = korzen, wP = null;
        boolean wystepuje = false;
        if (czyWystepuje(klucz) != null) {
            wystepuje = true;
        }
        while (w != null) {
            if (!wystepuje) w.rozmiarP++;
            wP = w;
            int porownanie = compS.compare(klucz, w.symbol);
            if (porownanie < 0) {
                kierunek = "lewy";
                w = w.lewyPotomek;
            } else if (porownanie > 0) {
                kierunek = "prawy";
                w = w.prawyPotomek;
            } else {
                kierunek = "trafiony";
                break;
            }
        }
        if (korzen == null) korzen = new Wierzcholek(klucz, wartosc, 1);
        else {
            if (kierunek.equals("lewy")) wP.lewyPotomek = new Wierzcholek(klucz, wartosc, 1);
            if (kierunek.equals("prawy")) wP.prawyPotomek = new Wierzcholek(klucz, wartosc, 1);
            if (kierunek.equals("trafiony")) wP.wartosc = wartosc;
        }

        return wP;
    }

    Comparator<K1> compS = new Comparator<K1>() {
        Collator c = Collator.getInstance(new Locale("pl", "PL"));

        @Override
        public int compare(K1 s1, K1 s2) {
            if (s1.getClass().getName().equals("java.lang.Integer")) return (int) Math.signum((int) s1 - (int) s2);
            return c.compare(s1, s2);
        }
    };

    public K2 czyWystepuje(K1 klucz) {
        Wierzcholek w = korzen;
        while (w != null) {
            int porownanie = compS.compare(klucz, w.symbol);
            if (porownanie < 0) w = w.lewyPotomek;
            else if (porownanie > 0) w = w.prawyPotomek;
            else return w.wartosc;
        }
        return null;
    }

    public static void main(String[] args) {
        BST<String, String> mors = new BST<>();

        mors.miejsceDla("E", ".");
        mors.miejsceDla("T", "-");
        mors.miejsceDla("I", "..");
        mors.miejsceDla("A", ".-");
        mors.miejsceDla("N", "-.");
        mors.miejsceDla("M", "--");
        mors.miejsceDla("S", "...");
        mors.miejsceDla("U", "..-");
        mors.miejsceDla("R", ".-.");
        mors.miejsceDla("W", ".--");
        mors.miejsceDla("D", "-..");
        mors.miejsceDla("K", "-.-");
        mors.miejsceDla("G", "--.");
        mors.miejsceDla("O", "---");
        mors.miejsceDla("H", "....");
        mors.miejsceDla("V", "...-");
        mors.miejsceDla("F", "..-.");
        mors.miejsceDla("L", ".-..");
        mors.miejsceDla("P", ".--.");
        mors.miejsceDla("J", ".---");
        mors.miejsceDla("B", "-...");
        mors.miejsceDla("X", "-..-");
        mors.miejsceDla("C", "-.-.");
        mors.miejsceDla("Y", "-.--");
        mors.miejsceDla("Z", "--..");
        mors.miejsceDla("Q", "--.-");
        mors.miejsceDla("5", ".....");
        mors.miejsceDla("4", "....-");
        mors.miejsceDla("3", "...--");
        mors.miejsceDla("2", "..---");
        mors.miejsceDla("+", ".-.-.");
        mors.miejsceDla("1", ".----");
        mors.miejsceDla("6", "-....");
        mors.miejsceDla("=", "-...-");
        mors.miejsceDla("/", "-..-.");
        mors.miejsceDla("7", "--...");
        mors.miejsceDla("8", "---..");
        mors.miejsceDla("9", "----.");
        mors.miejsceDla("0", "-----");
        mors.miejsceDla(" ", "   ");

        Scanner sc = new Scanner(System.in);
        String slowo = "";

        System.out.println("Podaj jaki tekst przetłumaczyć na Morsa: ");

        String tekst = sc.nextLine();
        for (int i = 0; i < tekst.length(); i++) {
            slowo = Character.toString(tekst.charAt(i));
            System.out.print(mors.czyWystepuje(slowo) + "   ");
        }
    }
}