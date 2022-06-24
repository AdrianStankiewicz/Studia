package Projekt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Koszyk implements Iterable<Produkt>{
	ArrayList<Produkt> lista = new ArrayList<Produkt>();
	
	public void dodajMagazynowo(Vege item) {
		lista.add(item);
	}
	public void dodajMagazynowo(Miensne item) {
		lista.add(item);
	}
	public void dodaj() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Jaki produkt chcesz dodac do koszyka?");
		String produkt = sc.nextLine();

		if(czyJestNaMagazynie(produkt)) {
			System.out.println("Ile sztuk chcesz dodac do koszyka?");
			
			try {
				int ile = Integer.parseInt(sc.nextLine());
				
				if(ile > lista.get(znajdzIndexProduktu(produkt)).ileMagazyn) {
					System.out.println("Brak wystarczajacej ilosci produktu w magazynie.");
					return;
				}
				else {
					lista.get(znajdzIndexProduktu(produkt)).ileKoszyk = ile;
					System.out.println("Do koszyka dodano: " + ile + "*" + produkt);
				}
			}
			catch(Exception NumberFormatException) {
				System.out.println("Prosze podac poprawny format liczby.");
			}
		}
		else {
			System.out.println("Produktu " + produkt +" nie ma na stanie magazynowym.");
		}
	}
	public int znajdzIndexProduktu(String nazwa) {
		int i = 0; 
		for(Produkt P : lista)
			if(P.nazwa.equals(nazwa)) return i;
			else i++;
		return -1;
	}
	public Boolean czyJestNaMagazynie(String produkt) {
		for(Produkt P : lista)
			if(P.nazwa.equals(produkt))
				return true;
		return false;
	}
	
	public Produkt item(int index) {
		return lista.get(index);
	}
	
	public boolean czyPusty() {
		Boolean puste = true;
		for(Produkt P : this.lista)
			if(P.ileKoszyk != 0) puste = false;
		
		return puste;
	}
	
	public <T> boolean czyVege(T item) {
		if(item.getClass().toString().endsWith("Vege")) return true;
		else return false;
	}
	
	public void fill() {
		this.lista.add(new Vege("kiwi", 1.99, 20));
		this.lista.add(new Vege("mandarynka", 1.49, 15));
		this.lista.add(new Vege("gruszka", 2.49, 35));
		this.lista.add(new Vege("banan", 0.99, 19));
	
		this.lista.add(new Miensne("kurczak", 7.99, 15));
		this.lista.add(new Miensne("baranina", 9.99, 10));
		this.lista.add(new Miensne("indyk", 14.99, 5));
		this.lista.add(new Miensne("wieprzowina", 10.99, 12));
	}
	
	public void wypiszZawartosc() {
		if(this.czyPusty())
			System.out.println("Koszyk jest obecnie pusty");
		else {
			System.out.println("\nZawartosc koszyka:");
			for(Produkt P : this) {
				if(P.ileKoszyk != 0)
					System.out.println("- " + P.nazwa + "\n   Ilosc sztuk: " + P.ileKoszyk + "	Cena: " + P.ileKoszyk*P.cena);
			}
		}
	}
	
	public void produkty() {
		System.out.println("\nDostepne produkty:");
		for(Produkt P : this) {
			if(P.ileMagazyn != 0)
				if(czyVege(P))
					System.out.println("- " + P.nazwa + "\n   Dostepna ilosc: " + P.ileMagazyn + "	Cena: " + P.cena + ((Vege)P).ilosc);
				else
					System.out.println("- " + P.nazwa + "\n   Dostepna ilosc: " + P.ileMagazyn + "	Cena: " + P.cena + ((Miensne)P).ilosc);
		}
	}
	
	public void wypiszVege() {
		for(Produkt P: this)
			if(czyVege(P))
				System.out.println("- " + P.nazwa + "\n   Dostepna ilosc: " + P.ileMagazyn + "	Cena: " + P.cena + ((Vege)P).ilosc);
	}
	
	@Override
    public Iterator<Produkt> iterator() {
        return lista.iterator();
    }
	
	public static void main(String[] args) {

	}
}
