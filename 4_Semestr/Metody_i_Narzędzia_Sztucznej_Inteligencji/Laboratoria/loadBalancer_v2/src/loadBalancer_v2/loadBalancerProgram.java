package loadBalancer_v2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class loadBalancerProgram {
	// divides a given number (amount of tasks) by a given number (amount of processors).
	// Returns an array of numbers. Elements of that array sum up to the value of n.
	public static int[] divideN(int m, int n) {
	    int[] randoms = new int[m];
	    Arrays.fill(randoms, 1); // At least one
	    int remainder = n - m;
	    Random random = new Random();
	    for (int i = 0; i < m - 1 && remainder > 0; ++i) {
	        int diff = random.nextInt(remainder);
	        randoms[i] += diff;
	        remainder -= diff;
	   }
	   randoms[m - 1] += remainder;
	   return randoms;
	}
	
	// generates list of random time tasks with given max time.
    // Returns an array of numbers which represent time of given tasks. Each task has a value between 1 and maxTaskTime.
	public static int[] generateTasks(int n, int maxTaskTime) {
		Random r = new Random();
        int[] tasks = new int[n];
        
        for(int i=0; i<n; i++)
        	tasks[i] = r.nextInt(maxTaskTime - 1) + 1;
        
        return tasks;
	}
	
	// assigns given amount of tasks to one processor
	// Returns an array with elements of J from given range. The array represents tasks assigned to a certain processor
	public static int[] generateGene(int[] J, int nPart, int startPoint) {
        int[] gene = new int[J.length];
    
        for(int i=startPoint; i<nPart+startPoint; i++) {
        	gene[i-startPoint] = J[i];
        }
        
        return gene;
	}
	
	// assigns given ammount of processors to one chromosome
	// Returns a two-dimentional array that represents a set of processors, each with assigned tasks
	public static int[][] generateChromosome(int m, int[] J) {
        int[][] chromosome = new int[m][J.length];
        int startPoint = 0;
        
        int[] nPart = divideN(m, J.length);

        for(int i=0; i<m; i++) {
        	chromosome[i] = generateGene(J, nPart[i], startPoint);
        	
        	startPoint += nPart[i];
        }
        
        return chromosome;
    }
	
	// assigns given amount of chromosomes to population
	// Returns a three-dimentional array that represents our population of sets of processors
	public static int[][][] generatePopulation(int sizeP, int m, int[] J) {
		int[][][] P = new int[sizeP][][];
		
		for(int i=0; i<sizeP; i++)
			P[i] = generateChromosome(m, J);
		
		return P;
	}
	
	// calculates total time of tasks on one processor
	// Returns an integer that represents a total time in seconds
	public static int getTotalTime(int[] tasks) {
		int sum = 0;
		
		for(int i=0; i<tasks.length; i++)
			sum += tasks[i];
		
		return sum;
	}
	
	// calculates total time of tasks on one processor
	// Returns an integer that represents max time of processor in seconds
	public static int getMaxTime(int[][] processors) {
		int maxTime = -1;
		
		for(int i=0; i<processors.length; i++)
			if(maxTime < getTotalTime(processors[i]))
				maxTime = getTotalTime(processors[i]);
		
		return maxTime;
	}
	
	// calculate avg fitness of a population
	public static int getAvgPopulationMaxTime(int[][][] P) {
		int maxTime = -1;
		
		for(int i=0; i<P.length; i++)
			maxTime += getMaxTime(P[i]);
			
		return maxTime/P.length;
	}
	
	// crosses a processor with another random one in the same chromosome
	public static int[][][] twoPointCross(int[][][] P) {
    	Random r = new Random();
        int randomParent, crossPoint1, crossPoint2;
        int js = P.length, m = P[0].length, n = P[0][0].length;
        
    	int[][][] returnChromosome = new int[js][m][n];
    	for(int i=0; i<P.length; i++) {
    		for(int j=0; j<m; j++) {
    			if(r.nextDouble() <= 0.6) {		// 0.6 is the chance if the chromosme gets crossovered
    			
    				do{
    					crossPoint1 = r.nextInt(n);
    					crossPoint2 = r.nextInt(n);
    				} while(crossPoint1 >= crossPoint2);
    			
    				randomParent = r.nextInt(m);
    			
    				for(int k=0; k<n; k++) {
    					if(k < crossPoint1)
    						returnChromosome[i][j][k]  = P[i][j][k];
    					else if(k > crossPoint1 && k < crossPoint2)
    						returnChromosome[i][j][k]  = P[i][randomParent][k];
    					else
    						returnChromosome[i][j][k]  = P[i][j][k];
    				}
    			}
    			else {
    				for(int k=0; k<n; k++)
    					returnChromosome[i][j][k] = P[i][j][k];
    			}
    		}
    	}
    		
    	return returnChromosome;
    }
	
	// mutates a processor with another random one in the same chromosome
	public static int[][][] mutation(int[][][] P) {
    	Random r = new Random();
        int randomParent, mutatingGene;
        int js = P.length, m = P[0].length, n = P[0][0].length;

        for(int i=0; i<js; i++) {
        	for(int j=0; j<m; j++) {
        		if(r.nextDouble() <= 0.02) {		// 0.02 is the chance if the processor gets mutated
        			for(int k=0; k<n; k++) {
        				if(r.nextDouble() <= 0.1) {		// 0.1 is the chance if the task gets changed
        					randomParent = r.nextInt(m);
        					mutatingGene = P[i][j][k];
    					
        					P[i][j][k] = P[i][randomParent][k];
        					P[i][randomParent][k] = mutatingGene;
        				}
        			}
        		}
        	}
        }
    					
    	return P;
	}
	
	// calculate boundary values for every chromosome in a population to pick from using a roulette
	public static double[] calculateRouletteWheel(int[][][] P) {
		double[] wheelSections = new double[P.length];
		double sumFitness = 0;
			
		for(int i=0; i<P.length; i++) {
			for(int j=0; j<=i; j++)
				wheelSections[i] += (double)1 / (getMaxTime(P[j])+1);
			sumFitness += (double)1 / (getMaxTime(P[i])+1);
			//System.out.println(getMaxTime(P[i]));
		}

		for(int i=0; i<P.length; i++) {
			wheelSections[i] /= sumFitness;
			//System.out.println(wheelSections[i]);
		}
		
		return wheelSections;
	}
		
		// select chromosomes using roulette to fill a whole population that gets returned
		public static int[][][] rouletteSelection(int[][][] P) {
			Random r = new Random();
			double randomValue;
			
			int[][][] returnPopulation = new int[P.length][P[0].length][P[0][0].length];
			double[] wheelSections = calculateRouletteWheel(P);
			
			for(int i=0; i<returnPopulation.length; i++) {
				randomValue = r.nextDouble();
				 
				for(int j=0; j<wheelSections.length; j++) {
					if(wheelSections[j] >= randomValue) {
						returnPopulation[i] = P[j];
						break;
					}
				}
			}
			
			return returnPopulation;
		}
	
	// write fitness to file function	
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
	
	public static void main(String[] args) {
		int m = 20;					// ilość genów (procesorów)
		int n = 1000;				// ilość zadań (łącznie)
		int sizeP = 200;			// ilość chromosomów (zestawów procesorów)
		int cycleAmmount = 1000;	// ilość wyliczeń fitness
		int maxTaskTime = 100;		// maksymalny czas zadania (pojedynczego)
		int[][][] P;				// populacja
		int[] J;					// zadania
		
		int[] currentTable = new int[cycleAmmount];
		int[] best_currentTable = new int[cycleAmmount];
		int[] best_globalTable = new int[cycleAmmount];
		double current = 0, best_current = -7, best_global = 0;
		String currentString = "", best_currentString = "", best_globalString = "";
		
		J = generateTasks(n, maxTaskTime);
		
		for(int i=0; i<20; i++) {
				
			//generate random population
			P = generatePopulation(sizeP, m, J);
		
			for(int j=0; j<cycleAmmount; j++) {
			
				//use roulette selection on the population
				P = rouletteSelection(P);
			
				//use two point crossover on the population
				P = twoPointCross(P);
			
				//use mutation on the population
				P = mutation(P);
				
				//System.out.println((double)j/(10*20) + "%");
				for(int k=0; k<P.length; k++) {
					if(getMaxTime(P[k]) < best_current) {
						best_current = getMaxTime(P[k]);
					}
				}
				if(best_current < best_global) best_global = best_current;
				
				currentTable[j] += getAvgPopulationMaxTime(P);
				best_currentTable[j] += best_current;
				best_globalTable[j] += best_global;
				
				best_current = n * maxTaskTime;
			}
			
			best_global = n * maxTaskTime;
			best_current = n * maxTaskTime;
			
			System.out.println((i*5)+5 + "%");
		}
		
		for(int j=0; j<cycleAmmount; j++) {
			currentTable[j] /= 20;
			best_currentTable[j] /= 20;
			best_globalTable[j] /= 20;
		}
		
		for(int j=0; j<cycleAmmount; j++) {
			currentString += (currentTable[j] + "\n");
			best_currentString += (best_currentTable[j] + "\n");
			best_globalString += (best_globalTable[j] + "\n");
		}
		
		writeFile("current.txt", currentString);
		writeFile("best_current.txt", best_currentString);
		writeFile("best_global.txt", best_globalString);
	}
}
