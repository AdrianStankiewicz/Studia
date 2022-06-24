package lab5;

import java.util.Random;

public class algo5_1 {
	static int ai = -2, bi = 2, d = 5;
	static int mi = (int) Math.ceil(log2((bi-ai) * Math.pow(10, d)));
	
	public static double log2(double liczba) {
		return (Math.log10(liczba) / Math.log10(2));
	}
	
	public static double f(double x[]) {
		return -Math.pow(x[0], 2) - Math.pow(x[1], 2) + 2;
	}
	
	public static double[] getX(int[] chrom1, int[] chrom2) {
		double[] x = new double[2];
        int wartoscX = 0, wartoscY = 0;
        
        for(int i=0 ; i<mi ; i++) {
            if(chrom1[i]==1)     wartoscX += Math.pow(2,mi-i);
            if(chrom2[i]==1)     wartoscY += Math.pow(2,mi-i);
        }
        
        x[0] = dekoduj(wartoscX);
        x[1] = dekoduj(wartoscY);
        
		return x;
	}
	
	public static double[] getX(int[] osobnik) {
		double[] x = new double[2];
        int wartoscX = 0, wartoscY = 0;
        
        for(int i=0 ; i<mi ; i++) {
            if(osobnik[i]==1)     	wartoscX += Math.pow(2,mi-i);
            if(osobnik[i+mi]==1)    wartoscY += Math.pow(2,mi-i);
        }
        
        x[0] = dekoduj(wartoscX);
        x[1] = dekoduj(wartoscY);
        
		return x;
	}
	
	public static Boolean checkX(double[] x) {
		if(x[0] >= ai && x[0] <= bi && x[1] >= ai && x[1] <= bi)
            return true;
		return false;
	}
	
	public static double dekoduj(double decimal) {
		return ( ai + decimal * ((bi-ai)/(Math.pow(2, mi)-1)) );
	}
	
	public static int[] generujChromosom() {
		Random rand = new Random();
        int[] chromosom = new int[(mi)];

        for(int i=0; i<mi;i++) {
            chromosom[i] = rand.nextInt(2);
        }
        
        return chromosom;
	}
	
	public static int[] generujPoprawnegoOsobnika() {
        int[] osobnik = new int[(mi*2)];
        int[] chrom1, chrom2;

        do {
           	chrom1 = generujChromosom();
        	chrom2 = generujChromosom();
        }while(!checkX(getX(chrom1, chrom2)));
        
        for(int i=0; i<mi; i++) {
        	osobnik[i] = chrom1[i];
        	osobnik[i+mi] = chrom2[i];
        }
        
        return osobnik;
	}
	
	public static int[][] generujPopulacje(int ilosc){
        int[][] populacja = new int[ilosc][mi];

        for(int i=0; i<ilosc;i++) {
        	populacja[i] = generujPoprawnegoOsobnika();
        }
        
        return populacja;
    }
	
	public static void wypiszPopulacje(int[][] populacja) {
		for(int i=0; i<populacja.length; i++) {
			for(int j=0; j<populacja[i].length; j++)
				System.out.print(populacja[i][j]);
			System.out.println();
		}
			System.out.println("\n=======================\n");
	}
	
	public static double[] wyznaczPrzystosowanie(int[][] populacja) {
		double[] przystosowanie = new double[populacja.length];
		
		for(int i=0; i<populacja.length; i++) {
			przystosowanie[i] = f(getX(populacja[i]));
		}
		
		return przystosowanie;
	}
	
	public static void wypiszPrzystosowanie(double[] przystosowanie) {
		for(int i=0; i<przystosowanie.length; i++)
			System.out.println(przystosowanie[i]);
		System.out.println("=======================\n");
	}
	
	public static void wypiszPopulacjePrzystosowanie(int[][] populacja, double[] przystosowanie) {
		for(int i=0; i<populacja.length; i++) {
			for(int j=0; j<populacja[i].length; j++)
				System.out.print(populacja[i][j]);
			System.out.println("\nPrzyst: " + przystosowanie[i] + "\n");
		}
			System.out.print("=======================\n");
	}
	
	public static double avgPrzystosowanie(double[] przystosowanie) {
		double sumPrzystosowanie = 0;
		for(int i=0; i<przystosowanie.length; i++)
			sumPrzystosowanie += przystosowanie[i];
		
		return sumPrzystosowanie/przystosowanie.length;
	}
	
	public static int lepszeNizSrednia(double[] przystosowanie) {
		int ilosc = 0;
		double srednia = avgPrzystosowanie(przystosowanie);
		
		for(int i=0; i<przystosowanie.length; i++) {
			if(przystosowanie[i] > srednia) ilosc++;
		}
		
		return ilosc;
	}
	
	public static void main(String[] args) {
		int ilosc = 10;
		int[][] populacja;
		double[] przystosowanie;

		populacja = generujPopulacje(ilosc);
		
		wypiszPopulacje(populacja);
		
		przystosowanie = wyznaczPrzystosowanie(populacja);
		
		wypiszPrzystosowanie(przystosowanie);
		
		wypiszPopulacjePrzystosowanie(populacja, przystosowanie);
		
		System.out.println(avgPrzystosowanie(przystosowanie));
		
		System.out.println(lepszeNizSrednia(przystosowanie));
	}
}
