package lab4;

import java.util.Random;

public class algo4_3 {
	public static int[] generujOsobnikaSciezka() {
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
	
	public static boolean czyWpisac(int[] potomek, int wpisywana) {
		for(int i=0; i<potomek.length; i++)
			if(potomek[i] == wpisywana)
				return false;
		return true;
	}
	
	public static int[] inwersujOsobnika(int[] osobnik) {
		Random r = new Random();
		int losowa = r.nextInt((osobnik.length - 1 - 0) + 1) + 0;
		int chwilowa;
		
		if(losowa == osobnik.length-1) {
			chwilowa = osobnik[osobnik.length-1];
			osobnik[osobnik.length-1] = osobnik[0];
			osobnik[0] = chwilowa;
		}
		else {
			chwilowa = osobnik[losowa+1];
			osobnik[losowa+1] = osobnik[losowa];
			osobnik[losowa] = chwilowa;
		}
		return osobnik;
		
	}
	
	public static void main(String[] args) {
		int[] osobnik = generujOsobnikaSciezka();
		
		for(int i=0; i<osobnik.length; i++)
			System.out.print(osobnik[i] + "\t");
		System.out.println();
		
		osobnik = inwersujOsobnika(osobnik);
		
		for(int i=0; i<osobnik.length; i++)
			System.out.print(osobnik[i] + "\t");
		System.out.println();
	}

}
