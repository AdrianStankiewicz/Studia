package com.company;

public class Stos<Element> {
    public ObiektStosu pierwszy = null;
    private int N=0;


    class ObiektStosu {
        Element element;
        ObiektStosu elPonizej;
    }

    public boolean czyPusty() {
        return N == 0;
    }

    public int rozmiar() {
        return N;
    }

    public void polozNaStosie(Element el){
        ObiektStosu sPierwszy = pierwszy;
        pierwszy = new ObiektStosu();
        pierwszy.element = el;
        pierwszy.elPonizej = sPierwszy;
        N++;
    }
    public Element zdejmijZeStosu() {
        Element pobrany=pierwszy.element;
        pierwszy = pierwszy.elPonizej;
        N--;
        return pobrany;
    }
}
