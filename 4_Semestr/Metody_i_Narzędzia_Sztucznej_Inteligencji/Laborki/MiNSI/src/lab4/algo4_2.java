package lab4;

import java.util.ArrayList;
import java.util.Random;

public class algo4_2 {
	static int ai = -2, bi = 2, d = 5;
	static int mi = (int) Math.ceil(log2((bi-ai) * Math.pow(10, d)));
	
	public static double log2(double liczba) {
		return (Math.log10(liczba) / Math.log10(2));
	}
	
	public static int[] generujRodzicaSciezka() {
		int[] chromosom = new int[(10)];
		Random r = new Random();
		int i = 0, losowa;

        while(i != 10) {
        	losowa = r.nextInt((10 - 1) + 1) + 1;
        	if(czyWpisac(chromosom, losowa)) {
        		chromosom[i] = losowa;
        		i++;
        	}
        }
        
        return chromosom;
	}
	
	public static void wypiszPopulacje(int[][] populacja) {		
		for(int i=0; i<populacja[0].length;i++)
			System.out.print(populacja[0][i] + "\t");
		System.out.println();
		for(int i=0; i<populacja[1].length;i++)
			System.out.print(populacja[1][i] + "\t");
		
		System.out.println("\n=======================\n");
	}
	
	public static boolean czyWpisac(int[] potomek, int wpisywana) {
		for(int i=0; i<potomek.length; i++)
			if(potomek[i] == wpisywana)
				return false;
		return true;
	}
	
	public static boolean czySaZera(int[] potomek) {
		for(int i=0; i<potomek.length; i++) {
			if(potomek[i] == 0) return true;
		}
		return false;
	}
	
	public static int[][] krzyzujPMX(int[][] rodzice) {
		Random r = new Random();
		int[][] potomki = new int[2][10];
		ArrayList<Integer> nieudane0 = new ArrayList<>();
		ArrayList<Integer> nieudane1 = new ArrayList<>();
		int cut1, cut2;
		
		do {
			cut1 = r.nextInt((9 - 0) + 0) + 1;
			cut2 = r.nextInt((9 - 0) + 0) + 1;
		}while(cut1 == cut2 || cut1 > cut2);
		
		for(int i=cut1; i<cut2; i++) {
			potomki[0][i] = rodzice[1][i];
			potomki[1][i] = rodzice[0][i];
		}
		
		for(int i=0; i<cut1; i++) {
			if(czyWpisac(potomki[0], rodzice[0][i])) potomki[0][i] = rodzice[0][i];
			else nieudane0.add(rodzice[0][i]);
			if(czyWpisac(potomki[1], rodzice[1][i])) potomki[1][i] = rodzice[1][i];
			else nieudane1.add(rodzice[1][i]);
		}
		
		for(int i=cut2; i<potomki[0].length; i++) {
			if(czyWpisac(potomki[0], rodzice[0][i])) potomki[0][i] = rodzice[0][i];
			else nieudane0.add(rodzice[0][i]);
			if(czyWpisac(potomki[1], rodzice[1][i])) potomki[1][i] = rodzice[1][i];
			else nieudane1.add(rodzice[1][i]);
		}

		for(int i=0; i<nieudane1.size(); i++) {
			for(int j=0; j<potomki[0].length; j++)
				if(potomki[0][j] == 0) {
					potomki[0][j] = nieudane1.get(i);
					break;
				}

			for(int j=0; j<potomki[1].length; j++)
				if(potomki[1][j] == 0) {
					potomki[1][j] = nieudane0.get(i);
					break;
				}
		}

		return potomki;
	}
	
	public static void main(String[] args) {
		int[][] rodzice = new int[2][10];
		int[][] potomki = new int[2][10];

		rodzice[0] = generujRodzicaSciezka();
		rodzice[1] = generujRodzicaSciezka();

		wypiszPopulacje(rodzice);

		potomki = krzyzujPMX(rodzice);

		wypiszPopulacje(potomki);
	}

}
