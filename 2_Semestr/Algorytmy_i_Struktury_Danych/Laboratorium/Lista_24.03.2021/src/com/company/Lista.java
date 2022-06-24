package com.company;

public class Lista<Element> {
    ObiektListy ostatni;
    ObiektListy pierwszy;
    int N = 0;

    public static void main(String[] args){
        Lista<Osoba> lista = new Lista<Osoba>();
        lista.dodajDoListy(new Osoba("Kazimierz", "Wiśniewski", "1998-01-11"));
        lista.dodajDoListy(new Osoba("Janusz", "Wiśniak", "1998-10-11"));
        lista.dodajDoListy(new Osoba("Bartosz", "Adamski", "1998-10-11"));
        lista.dodajDoListy(new Osoba("Zygmunt", "Boruta", "1999-05-24"));

        //System.out.println(lista.N);
        //lista.drukujDrugi();

        //Osoba usunieta = lista.pobierzPierwszego();
        //System.out.println(usunieta);

        //ObiektListy nowy = lista.pobierzItego(1);
        //System.out.println(nowy.osoba);

        //lista.zamien(0,1);
        //lista.drukuj();

        lista.usunItego(0);
        lista.drukuj();
    }
    public void dodajDoListy(Element el) {
        ObiektListy staryOstatni = ostatni;
        ostatni = new ObiektListy();
        ostatni.osoba = el;
        ostatni.nastepny = null;
        if (jestPusta()) pierwszy=ostatni;
        else
            staryOstatni.nastepny=ostatni;
        N++;
    }
    public Element pobierzPierwszego() {
        if (jestPusta()) return null;
        Element el= (Element) pierwszy.osoba;
        pierwszy=pierwszy.nastepny;
        if (jestPusta()) ostatni = null;
        N--;
        return el;
    }
    public void drukujDrugi(){
        System.out.println(((Osoba)(pierwszy.nastepny.nastepny.osoba)).nazwisko);
    }
    public void drukuj(){
        ObiektListy kolejny = pierwszy;
        do{
            System.out.println(kolejny.osoba);
            kolejny = kolejny.nastepny;
        }while(kolejny!=null);
    }
    public boolean jestPusta(){
        return N==0;
    }
    static class ObiektListy<Element>{
        Element osoba;
        ObiektListy nastepny;
        ObiektListy poprzedni;
    }
    public ObiektListy pobierzItego(int ity) {
        if(jestPusta()) return null;
        ObiektListy zwracany = pierwszy;
        for(int i=0; i<N; i++) {
            if (i == ity) return zwracany;
            zwracany = zwracany.nastepny;
        }
        return null;
    }
    public boolean zamien(int i, int j) {
        if(i>N || j>N) return false;
        ObiektListy pierwszyit = pobierzItego(i);
        ObiektListy pierwszyjt = pobierzItego(j);
        Element pomocniczy = (Element) pierwszyit.osoba;
        pierwszyit.osoba = pierwszyjt.osoba;
        pierwszyjt.osoba = pomocniczy;
        return true;
    }
    public ObiektListy usunItego(int ity) {
        if (jestPusta()) return null;
        ObiektListy poprzedni = pierwszy;
        ObiektListy usuwany = pierwszy;
        for(int i=0;i<N;i++){
            if(i==ity){
                poprzedni.nastepny=usuwany.nastepny;
                if(i==0)pierwszy=usuwany.nastepny;
                else if(i==N-1) ostatni=poprzedni;
                N--;
                return usuwany;
            }
            poprzedni=usuwany;
            usuwany=usuwany.nastepny;
        }
        return null;
    }
}
