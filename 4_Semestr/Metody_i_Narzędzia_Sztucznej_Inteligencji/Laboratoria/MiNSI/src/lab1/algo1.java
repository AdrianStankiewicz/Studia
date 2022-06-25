package lab1;

import java.io.IOException;
import java.util.Random;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class algo1 {

	 static int M = 1000;
	
	public double f(double x[]) {
		return -Math.pow(x[0], 2) - Math.pow(x[1], 2) + 2;
	}
	
	public double[] getX() {
		Random r = new Random();
		double[] x = new double[2];
		x[0] = -2.0 + r.nextDouble() * (2.0 + 2.0);
		x[1] = -2.0 + r.nextDouble() * (2.0 + 2.0);
		return x;
	}
	
	public static void writeFile(String fileName, String content) {
		try {
	         BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
	         out.write(content);
	         out.close();
	         System.out.println("File created successfully");
	      }
	      catch (IOException e) {
	      }
	}
	public static void writeFile(String fileName, double content) {
		try {
	         BufferedWriter out = new BufferedWriter(new FileWriter(fileName));
	         out.write("" + content);
	         out.close();
	         System.out.println("File created successfully");
	      }
	      catch (IOException e) {
	      }
	}
	
	public static void main(String[] args) {
		algo1 tworca = new algo1();
		
		double[] x0 = tworca.getX();
		System.out.println("x1: " + x0[0] + "\nx2: " + x0[1]);
		
		double fmax = tworca.f(x0);
		
		double[] x = new double[2];
		double[] xmax = new double[2];
		String wynikf = "";
		String wynikfMax = "";
		double f;
		
		for(int k = 1; k <= M; k++) {
			x = tworca.getX();
			f = tworca.f(x);
			wynikf += f + "\n";
			wynikfMax += fmax + "\n";
			if(f > fmax) {
				fmax = f;
				xmax[0] = x[0];	xmax[1] = x[1];
			}
		}
		
		writeFile("best_step.txt", wynikfMax);
		writeFile("current.txt", wynikf);
		
		System.out.println("fMax: " + fmax + "\nxMax: " + xmax[0] + ", " + xmax[1]);
	}
}
