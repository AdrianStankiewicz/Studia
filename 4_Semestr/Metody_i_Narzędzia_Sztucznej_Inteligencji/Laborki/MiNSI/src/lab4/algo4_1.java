package lab4;

import java.util.Random;

public class algo4_1 {
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
	
    public static int[] generujOsobnika(int[] chromosomX, int[] chromosomY){
        int[] osobnik = new int[(mi*2)];

        for(int i=0; i<mi;i++) {
        	osobnik[i] = chromosomX[i];
        	osobnik[i+mi] = chromosomY[i];
        }
        
        return osobnik;
    }
    
    public static int[] mutujOsobnika(int[] osobnik, double pm) throws InterruptedException {
    	int[] osobnikMutowany = new int[38];
    	for(int i=0; i<osobnik.length; i++)
    		osobnikMutowany[i] = osobnik[i];
    	
    	double[] x;
    	Random r = new Random();
    	
    	for(int i=0; i<osobnikMutowany.length; i++) {
    		if(r.nextDouble() <= pm)
				if(osobnikMutowany[i] == 0) osobnikMutowany[i] = 1;
				else osobnikMutowany[i] = 0;
    		
    		x = getX(osobnikMutowany);
    		if(x[0] < -2 || x[0] > 2 || x[1] < -2 || x[1] > 2) {
    			Thread.sleep(500);
    			System.out.println("\nx0 : " + x[0] + "\t x1: " + x[1] + "\t i:" + i);
    			wypiszOsobnika(osobnikMutowany);
    			
    	    	for(int j=0; j<osobnik.length; j++)
    	    		osobnikMutowany[j] = osobnik[j];
    	    	
    			wypiszOsobnika(osobnikMutowany);
    			i = 0;
    		}
    	}
    	
    	return osobnikMutowany;
    }
    
    public static void wypiszOsobnika(int[] osobnik) {
		for(int i=0; i<mi*2; i++)
			System.out.print(osobnik[i]);
		System.out.println();
	}
	
	public static void main(String[] args) throws InterruptedException {
		double pm = 0.5;
		double x[];
		int[] osobnik;
		
		do {
			osobnik = generujOsobnika(generujChromosom(), generujChromosom());
			x = getX(osobnik);
		}while(!checkX(x));
		
		System.out.println("Przed mutacją: \nx[0]: " + x[0] + "\tx[1]: " + x[1] + "\n" + f(x));
		wypiszOsobnika(osobnik);
		
		osobnik = mutujOsobnika(osobnik, pm);
		x = getX(osobnik);
		
		System.out.println("\nPo mutacji: \nx[0]: " + x[0] + "\tx[1]: " + x[1] + "\n" + f(x));
		wypiszOsobnika(osobnik);
	}

}
