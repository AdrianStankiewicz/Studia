package lab5;

import java.util.Random;

public class algo5_2 {
	static int d = 3;
	static double ai = -5.21, bi = 5.21;
	static int mi = (int) Math.ceil(log2((bi-ai) * Math.pow(10, d)));
	
	public static double log2(double liczba) {
		return (Math.log10(liczba) / Math.log10(2));
	}
	
	public static double dekoduj(double decimal) {
		return ( ai + decimal * ((bi-ai)/(Math.pow(2, mi)-1)) );
	}
	
	public static int[] generujPoprawnyChromosom() {
		Random rand = new Random();
        int[] chromosom = new int[(mi)];

        do {
        	for(int i=0; i<mi;i++) {
        		chromosom[i] = rand.nextInt(2);
        	}
        }while(!checkX(getX(chromosom)));
        
        return chromosom;
	}
	
	public static int[][] generujPopulacje(int ilosc) {
		int[][] populacja = new int[ilosc][mi];
		
		for(int i=0; i<ilosc; i++)
			populacja[i] = generujPoprawnyChromosom();
		
		return populacja;
	}
	
	public static double getX(int[] chromosom) {
		double x=0.0;
        
        for(int i=0 ; i<mi ; i++) {
            if(chromosom[i]==1)     x += Math.pow(2,mi-i);
        }
   
		return dekoduj(x);
	}
	
	public static Boolean checkX(double x) {
		if(x >= ai && x<= bi)
            return true;
		return false;
	}
	
	public static double rastrigin(int[][] populacja) {
		int A = 10, n = 10;
		double suma=0;
		
		double[] xi = new double[populacja.length];
		
		for(int i=0; i<populacja.length; i++)
			xi[i] = getX(populacja[i]);
		
		for(int i=1; i < n; i++) {
			suma += Math.pow(xi[i], 2) - A * Math.cos(2 * Math.PI * xi[i]);
		}
		
		return (A * n) + suma;
	}
	
	public static void main(String[] args) {
		int dlugosc = 10;
		int[][] populacja = generujPopulacje(dlugosc);
		
		System.out.println(rastrigin(populacja));
		System.out.println("koniec");
	}
}