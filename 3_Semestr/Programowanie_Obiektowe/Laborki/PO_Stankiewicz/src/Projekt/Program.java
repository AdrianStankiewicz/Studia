package Projekt;

import java.util.Scanner;

public class Program {
	public static void opcje() {
		System.out.println("\n? 	  -  Komendy dostepne w programie");
		System.out.println("produkty  -  Wypisuje wszystkie produkty dostepne w sklepie");
		System.out.println("koszyk 	  -  Wypisuje zawartosc koszyka");
		System.out.println("doKoszyka -  Dodaj produkt do koszyka");
		System.out.println("exit      -  Wychodzi z programu");
		System.out.println("vege      -  Wypisuje produkty weganskie w sklepie");
	}
	
	public static void main(String[] args) {
		Koszyk koszyk = new Koszyk();
		koszyk.fill();
		
		System.out.println("Jaka funkcje chcesz wybrac? Jezeli nie znasz funkcji wpisz \'?\'");
		Scanner sc = new Scanner(System.in);
		String opcja = null;
		
		while(true) {
			opcja = sc.nextLine();
			
			if(opcja.equals("exit")) System.exit(0);
			else if(opcja.equals("?")) opcje();
			else if(opcja.equals("produkty")) koszyk.produkty();
			else if(opcja.equals("koszyk")) koszyk.wypiszZawartosc();
			else if(opcja.equals("doKoszyka")) koszyk.dodaj();
			else if(opcja.equals("vege")) koszyk.wypiszVege();
			else System.out.println("Jezeli nie znasz funkcji wpisz \'?\'");
			System.out.println("\nJaka funkcje chcesz wybrac?");
		}
	}
}
