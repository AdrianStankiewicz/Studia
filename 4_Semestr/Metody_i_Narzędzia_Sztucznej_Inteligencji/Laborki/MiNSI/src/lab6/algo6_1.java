package lab6;

import java.util.Random;

public class algo6_1 {
	static int ai = -2, bi = 2, d = 5;
	static int mi = (int) Math.ceil(log2((bi-ai) * Math.pow(10, d)));
			
	public static double log2(double liczba) {
		return (Math.log10(liczba) / Math.log10(2));
	}
	
	public static double dekoduj(double decimal) {
		return ( ai + decimal * ((bi-ai)/(Math.pow(2, mi)-1)) );
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
	
	public static int[][] generujPopulacje(int N){
        int[][] populacja = new int[N][mi];

        for(int i=0; i<N; i++) {
        	populacja[i] = generujPoprawnegoOsobnika();
        }
        
        return populacja;
    }
	
	public static double[] policzTarczeRuletki(int[][] populacja) {
		double[] przedzialyWartosci = new double[populacja.length];
		double sumaWartosci = 0;
		
		for(int i=0; i<populacja.length; i++) {
			for(int j=0; j<=i; j++)
				przedzialyWartosci[i] += f(getX(populacja[j])) + 6;
			sumaWartosci += f(getX(populacja[i])) + 6;
		}
	
		for(int i=0; i<populacja.length; i++)
			przedzialyWartosci[i] /= sumaWartosci;
		
		return przedzialyWartosci;
	}
	
	public static int[] ruletkaOsobnika(int[][] populacja) {
		Random r = new Random();
		double wylosowanaWartosc = r.nextDouble(); 
		
		double[] przedzialyWartosci = policzTarczeRuletki(populacja);
		
		for(int i=0; i<przedzialyWartosci.length; i++) {
			if(przedzialyWartosci[i] >= wylosowanaWartosc)
				return populacja[i];
		}
		return null;
	}
	
	public static int[][] ruletkaPopulacji(int[][] populacja) {
		Random r = new Random();
		double wylosowanaWartosc;
		
		int[][] nowaPopulacja = new int[populacja.length][populacja[0].length];
		double[] przedzialyWartosci = policzTarczeRuletki(populacja);
		
		for(int i=0; i<nowaPopulacja.length; i++) {
			 wylosowanaWartosc = r.nextDouble();
			 
			for(int j=0; j<przedzialyWartosci.length; j++) {
				if(przedzialyWartosci[j] >= wylosowanaWartosc) {
					nowaPopulacja[i] = populacja[j];
					break;
				}
			}
		}
		
		return nowaPopulacja;
	}
	
	public static double avgPrzystosowanie(int[][] populacja) {
		double sumaPrzystosowania = 0;
		for(int i=0; i<populacja.length; i++)
			sumaPrzystosowania += f(getX(populacja[i]));
		
		return sumaPrzystosowania / populacja.length;
	}
	
	public static void main(String[] args) {
		int N = 10;
		
		int[][] P1 = generujPopulacje(N);
		int[][] P2 = new int[N][];
		
		P2 = ruletkaPopulacji(P1);
		
		System.out.println("Avg z P1: " + avgPrzystosowanie(P1));
		System.out.println("Avg z P2 (populacji): " + avgPrzystosowanie(P2));
	}

}





