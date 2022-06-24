package com.company;


import java.time.LocalDate;
import java.time.Period;

public class Osoba {
    String nazwisko="Kowalski";
    String imię="Stanisław";
    String dataUr = "1999-10-12";
    static LocalDate dzisiaj=LocalDate.now();
    public Osoba(String imię, String nazwisko, String dataUr){
        this.imię=imię;
        this.nazwisko=nazwisko;
        this.dataUr=dataUr;
    }

    public Osoba(){}
    public String toString() {
        return  "Imię:      " + this.imię +
                "     Nazwisko:  " + this.nazwisko +
                "     Data ur.:  " + this.dataUr+
                String.format("     Wiek:      %6.3f",wiek(dataUr));}
    public double wiek(String data){
        int uRok=Integer.parseInt(data.substring(0,4));
        int uMiesiac=Integer.parseInt(data.substring(5,7));
        int uDzień=Integer.parseInt(data.substring(8,10));
        LocalDate dataUrodzenia = LocalDate.of(uRok, uMiesiac, uDzień);
        Period per=Period.between(dataUrodzenia, dzisiaj);
        return per.getYears()+per.getMonths()/12.0+per.getDays()/365.0;
    }
    public boolean jestRówna(Osoba inna) {
        return     this.imię.equals(inna.imię) &&
                this.nazwisko.equals(inna.nazwisko)&&
                this.dataUr.equals(inna.dataUr);
    }
}