package lab2;

import java.util.Random;

public class algo2_1 {
	static int ai = -2;
	static int bi = 2;
	static int d = 5;
	static int mi = (int) Math.ceil(log2((bi-ai) * Math.pow(10, d)));
			
	public static double log2(double liczba) {
		return (Math.log10(liczba) / Math.log10(2));
	}
	
	public static double f(double x[]) {
		return -Math.pow(x[0], 2) - Math.pow(x[1], 2) + 2;
	}
	
	public static double[] getX(int[] genX, int[] genY) {
		double[] x = new double[2];
        int wartoscX = 0, wartoscY = 0;
        
        for(int i=0 ; i<mi ; i++) {
            if(genX[i]==1)        wartoscX += Math.pow(2,mi-i);
            if(genY[i]==1)        wartoscY += Math.pow(2,mi-i);
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
	
	public static int[] generujGen() {
		Random rand = new Random();
        int[] gen = new int[(mi)];

        for(int i=0; i<mi;i++) {
            gen[i] = rand.nextInt(2);
        }
        
        return gen;
	}
	
    public static int[] generujChromosom(int[] genX, int[] genY){
        int[] chromosom = new int[(mi*2)];

        for(int i=0; i<mi;i++) {
            chromosom[i] = genX[i];
            chromosom[i+mi] = genY[i];
        }
        
        return chromosom;
    }
	
	public static double zakoduj(double xi) {
		return ( (xi - ai) / ( (bi-ai) / (Math.pow(2, mi)-1) ) );
	}
	
	public static double dekoduj(double decimal) {
		return ( ai + decimal * ((bi-ai)/(Math.pow(2, mi)-1)) );
	}
	
	public static void main(String[] args) {
		int[] chromosom, genX, genY;
        double[] x;
		double f;

        while(true){
        	genX = generujGen();
        	genY = generujGen();		
            chromosom = generujChromosom(genX, genY);

            x = getX(genX, genY);

            if(checkX(x)) break;
        }
        
        f=f(x);
        
        System.out.println("x1: " + x[0] + "\t\tx2: " + x[1] + "\nf: " + f);
    }
}
