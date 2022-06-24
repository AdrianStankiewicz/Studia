package com.company;

public class Main {

    static Stos<Integer> stosWartosci = new Stos<>();
    static Stos<String> stosOperatorow = new Stos<>();

    static void wykonajDzialanie(Stos<Integer> stosWartosci, Stos<String> StosOperatorow) {
        String a = stosOperatorow.zdejmijZeStosu();
        int op1 = stosWartosci.zdejmijZeStosu();
        int op2 = stosWartosci.zdejmijZeStosu();
        switch(a)
        {
            case "+": stosWartosci.polozNaStosie(op1+op2); break;
            case "*": stosWartosci.polozNaStosie(op1*op2); break;
            case "-": stosWartosci.polozNaStosie(op2-op1); break;
            case "/": stosWartosci.polozNaStosie(op2/op1); break;
        }
    }

    public static void main(String[] args) {
	/*    String onp = "3 -7 -";
	    String[] podzielonyONP = onp.split(" ");
	    int k = 0;

	    while(k < podzielonyONP.length){
	        String a = podzielonyONP[k];
	        if(a.matches("-[0-9]{1,}") || a.matches("[0-9]{1,}")) {
	            stosWartosci.polozNaStosie(Integer.valueOf(a));
            }
	        else {
	            stosOperatorow.polozNaStosie(a);
	            wykonajDzialanie(stosWartosci, stosOperatorow);
            }
            k++;
        }
	    System.out.println("Wartość końcowa: " + stosWartosci.zdejmijZeStosu());
	  */

        Stos<String> stosNazwisk1 = new Stos<>();
        Stos<String> stosNazwisk2 = new Stos<>();

        stosNazwisk1.polozNaStosie("Stankiewicz");
        stosNazwisk1.polozNaStosie("Jagiełło");
        stosNazwisk1.polozNaStosie("Frąckowiak");

        System.out.println(stosNazwisk1.pierwszy.element);
        System.out.println(stosNazwisk1.pierwszy.elPonizej.element);
        System.out.println(stosNazwisk1.pierwszy.elPonizej.elPonizej.element);

        System.out.println("======================================");

        stosNazwisk2.polozNaStosie(stosNazwisk1.zdejmijZeStosu());
        stosNazwisk2.polozNaStosie(stosNazwisk1.zdejmijZeStosu());
        stosNazwisk2.polozNaStosie(stosNazwisk1.zdejmijZeStosu());

        System.out.println(stosNazwisk2.pierwszy.element);
        System.out.println(stosNazwisk2.pierwszy.elPonizej.element);
        System.out.println(stosNazwisk2.pierwszy.elPonizej.elPonizej.element);
    }
}