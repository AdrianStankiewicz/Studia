package lab3;

import java.util.Random;

public class algo3_1 {
	static int ai = -2;		// min x value boundary
	static int bi = 2;		// max x value boundary
	static int d = 5;		// number precision
	static int mi = (int) Math.ceil(log2((bi-ai) * Math.pow(10, d)));		// ammount of bits required to store one value
			
	public static double log2(double liczba) {
		return (Math.log10(liczba) / Math.log10(2));
	}
	
	public static void wypiszChromosom(int[] chromosom) {
		for(int i=0; i<mi; i++)
			System.out.print(chromosom[i]);
		System.out.println();
	}
	
	public static double f(double x[]) {
		return -Math.pow(x[0], 2) - Math.pow(x[1], 2) + 2;
	}
	
	public static double[] getX(int[] osobnik) {
		double[] x = new double[2];
        int wartoscX = 0, wartoscY = 0;
        
        for(int i=0 ; i<mi ; i++) {
            if(osobnik[i]==1)        wartoscX += Math.pow(2,mi-i);
            if(osobnik[i+mi]==1)     wartoscY += Math.pow(2,mi-i);
        }
        
        x[0] = dekoduj(wartoscX);
        x[1] = dekoduj(wartoscY);
        
		return x;
	}
	
	public static Boolean checkX(double[] x) {
		if(x[0] >= -2 && x[0] <=2 && x[1] >= -2 && x[1] <= 2)
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
	
    public static int[] generujOsobnika(int[] genX, int[] genY){
        int[] osobnik = new int[(mi*2)];

        for(int i=0; i<mi;i++) {
            osobnik[i] = genX[i];
            osobnik[i+mi] = genY[i];
        }
        
        return osobnik;
    }
    
    public static int[][] onePointCross(int[] rodzic0, int[] rodzic1) {
    	Random rand = new Random();
        int crossPoint = rand.nextInt(mi);
    	int[][] zwracaneWartosci = new int[2][mi*2];
        
    	System.out.println("\ncrossPoint: " + (crossPoint+1) + '\n');
    	
        for(int i=0; i<mi*2; i++) {
        	if(i < crossPoint) {
        		zwracaneWartosci[0][i]  = rodzic0[i];
        		zwracaneWartosci[1][i]  = rodzic1[i];
        	}
        	else {
        		zwracaneWartosci[0][i]  = rodzic1[i];
        		zwracaneWartosci[1][i]  = rodzic0[i];
        	}
        }
        return zwracaneWartosci;
    }
    
    public static int[][] twoPointCross(int[] rodzic0, int[] rodzic1) {
    	Random rand = new Random();
        int crossPoint1 = rand.nextInt(mi), crossPoint2 = rand.nextInt(mi);
    	int[][] zwracaneWartosci = new int[2][mi*2];
    	
    	while(crossPoint1 >= crossPoint2) {
    		crossPoint1 = rand.nextInt(mi);
    		crossPoint2 = rand.nextInt(mi);
    	}
    	
    	System.out.println("\ncrossPoint1: " + (crossPoint1+1) + "\ncrossPoint2: " + (crossPoint2+1) + '\n');
    	
        for(int i=0; i<mi*2; i++) {
        	if(i < crossPoint1) {
        		zwracaneWartosci[0][i]  = rodzic0[i];
        		zwracaneWartosci[1][i]  = rodzic1[i];
        	}
        	else if(i > crossPoint1 && i < crossPoint2) {
        		zwracaneWartosci[0][i]  = rodzic1[i];
        		zwracaneWartosci[1][i]  = rodzic0[i];
        	}
        	else {
        		zwracaneWartosci[0][i]  = rodzic0[i];
        		zwracaneWartosci[1][i]  = rodzic1[i];
        	}
        }
        return zwracaneWartosci;
    }
	
	public static double zakoduj(double xi) {
		return ( (xi - ai) / ( (bi-ai) / (Math.pow(2, mi)-1) ) );
	}
	
	public static double dekoduj(double decimal) {
		return ( ai + decimal * ((bi-ai)/(Math.pow(2, mi)-1)) );
	}
	
	public static void main(String[] args) {
		int[] chromosomX1, chromosomY1, chromosomX2, chromosomY2;
		double[] x, y;
		int[][] tablicaOsobnikow = new int[2][mi*2];

        while(true){
        	
            chromosomX1 = generujChromosom();	chromosomY1 = generujChromosom();
            chromosomX2 = generujChromosom();	chromosomY2 = generujChromosom();
            
        	if(checkX(getX(generujOsobnika(chromosomX1, chromosomY1))) && checkX(getX(generujOsobnika(chromosomX2, chromosomY2)))) {
        		
        		System.out.println("Rodzic1: ");
                wypiszChromosom(generujOsobnika(chromosomX1, chromosomY1));
                System.out.println("Rodzic2: ");
                wypiszChromosom(generujOsobnika(chromosomX2, chromosomY2));
        		
        		tablicaOsobnikow = twoPointCross(generujOsobnika(chromosomX1, chromosomY1), generujOsobnika(chromosomX2, chromosomY2));
        		x = getX(generujOsobnika(chromosomX1, chromosomY1));
        		y = getX(generujOsobnika(chromosomX2, chromosomY2));
        		break;
        	}
        }
        
        System.out.println("Potomek1: ");
        wypiszChromosom(tablicaOsobnikow[0]);
        System.out.println("Potomek2: ");
        wypiszChromosom(tablicaOsobnikow[1]);
        
        System.out.println("\nRodzice:\nf(x): " + f(x) + "\nf(y): " + f(y));
        x = getX(tablicaOsobnikow[0]);
		y = getX(tablicaOsobnikow[1]);
        System.out.println("\nPotomkowie:\nf(x): " + f(x) + "\nf(y): " + f(y));
    }

}
