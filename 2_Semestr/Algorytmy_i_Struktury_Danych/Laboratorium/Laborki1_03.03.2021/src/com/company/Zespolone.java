package com.company;

public class Zespolone {

    double Re;
    double Im;

    public Zespolone() {
        Re = 0d;
        Im = 0d;
    }
    public Zespolone(double re, double im) {
        Re = re;
        Im = im;
    }

    // dodaj te liczbe do liczby inna
    public Zespolone dodaj(Zespolone inna){
        return new Zespolone(Re+inna.Re, Im+inna.Im);
    }

    // mnozenie tej liczby przez liczbe inna
    public Zespolone razy(Zespolone inna){
        return new Zespolone(Re*inna.Re-Im*inna.Im, Re*inna.Im+Im*inna.Re);
    }

    // abs tej liczby zespolonej
    public double abs() {
        return Math.sqrt(Re*Re+Im*Im);
    }

    // napis tej liczby zespolonej
    public String toString() {
        if (Im >= 0) {
            return "(" + Re + " + " + Im + "*i" + ")";
        } else {
            return "(" + Re + " - " + -Im + "*i" + ")";
        }
    }

    // test klasy Complex
    public static void main(String[] args) {
        Zespolone a = new Zespolone(1d, 2d);
        Zespolone b = new Zespolone(2d, -3d);
        System.out.println(a +"+"+ b +" = "+ a.dodaj(b));
        System.out.println(a +"*"+ b +" = "+ b.razy(b));
    }

}