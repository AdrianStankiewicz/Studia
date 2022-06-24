package lab1;

import java.util.Random;

public class algo2 {
	static Random rand = new Random();
	
	static double T = rand.nextDouble();
	static double y = rand.nextDouble();
	static int M = 1000;
	
	public static double[] getX() {
		Random r = new Random();
		double[] x = new double[2];
		x[0] = -2.0 + r.nextDouble() * (2.0 + 2.0);
		x[1] = -2.0 + r.nextDouble() * (2.0 + 2.0);
		return x;
	}
	
	public static double f(double x[]) {
		return -Math.pow(x[0], 2) - Math.pow(x[1], 2) + 2;
	}
	
	public static void main(String[] args) {
		double x0[] = getX();
		double fMax = f(x0);
		double xMax[] = x0;
		double xk[] = new double[2];
		double xn[] = new double[2];
		double w, omega, Z;

		for(int k=1; k<=M; k++) {
			if(k == 1) xk = x0;
			w = rand.nextDouble();
			
			// TU JEST COŚ ŹLE
			if(w == 1) {
				omega = rand.nextDouble();
				xn[0] = xk[0] + y*omega;
				xn[1] = xk[1] + y*omega;
			}
			else {
				omega = rand.nextDouble();
				xn[0] = xk[0] - y*omega;
				xn[1] = xk[1] - y*omega;
			}
			
			if(f(xn) > fMax) {
				fMax = f(xn);
				xMax = xn;
				xk = xn;
			}
			else {
				Z = rand.nextDouble();
				
				if(Z < Math.exp(-(f(xn) - f(xk)/T))) {
					fMax = f(xn);
					xMax = xn;
					xk = xn;
				}
			}
		}
		
		System.out.println("fMax: " + fMax + "\nxMax: " + xMax[0] + ", " + xMax[1]);
	}

}
