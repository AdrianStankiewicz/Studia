package lab7;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class algo7_1 {
	static int ai = -2;		// min x value boundary
	static int bi = 2;		// max x value boundary
	static int d = 5;		// number precision
	static int mi = (int) Math.ceil(log2((bi-ai) * Math.pow(10, d)));		// ammount of bits required to store one value
			
	// function to calculate log with base of 2
	public static double log2(double liczba) {
		return (Math.log10(liczba) / Math.log10(2));
	}
	
	// function to decode binary value to usable decimal value
	public static double decode(double decimal) {
		return ( ai + decimal * ((bi-ai)/(Math.pow(2, mi)-1)) );
	}
	
	// fitness function
	public static double f(double x[]) {
		return -Math.pow(x[0], 2) - Math.pow(x[1], 2) + 2;
	}
	
	// calculate X and Y axis points for chromosome using genes
	public static double[] getX(int[] gene1, int[] gene2) {
		double[] x = new double[2];
        int axisX = 0, axisY = 0;
        
        for(int i=0 ; i<mi ; i++) {
            if(gene1[i]==1)     axisX += Math.pow(2,mi-i);
            if(gene2[i]==1)     axisY += Math.pow(2,mi-i);
        }
        
        x[0] = decode(axisX);
        x[1] = decode(axisY);
        
		return x;
	}
	
	// calculate X and Y axis points for chromosome using chromosome
	public static double[] getX(int[] chromosome) {
		double[] x = new double[2];
        int axisX = 0, axisY = 0;
        
        for(int i=0 ; i<mi ; i++) {
            if(chromosome[i]==1)     	axisX += Math.pow(2,mi-i);
            if(chromosome[i+mi]==1)   	axisY += Math.pow(2,mi-i);
        }
        
        x[0] = decode(axisX);
        x[1] = decode(axisY);
        
		return x;
	}
	
	// check if X and Y axis points are placed between boundary values
	public static Boolean checkX(double[] x) {
		if(x[0] >= ai && x[0] <= bi && x[1] >= ai && x[1] <= bi)
            return true;
		return false;
	}
	
	// generate a random gene in binary representation
	public static int[] generateGene() {
		Random r = new Random();
        int[] gene = new int[(mi)];

        for(int i=0; i<mi;i++) {
            gene[i] = r.nextInt(2);
        }
        
        return gene;
	}
	
	// generate a random but correct chromosome (that has X and Y axis values with allowed values)
	public static int[] generateCorrectChromosome() {
        int[] chromosome = new int[(mi*2)];
        int[] gene1, gene2;

        do {
           	gene1 = generateGene();
        	gene2 = generateGene();
        }while(!checkX(getX(gene1, gene2)));
        
        for(int i=0; i<mi; i++) {
        	chromosome[i] = gene1[i];
        	chromosome[i+mi] = gene2[i];
        }
        
        return chromosome;
	}
	
	// generate a population of chosen size with random correct chromosomes
	public static int[][] generatePopulation(int populationSize){
        int[][] population = new int[populationSize][mi];

        for(int i=0; i<populationSize; i++) {
        	population[i] = generateCorrectChromosome();
        }
        
        return population;
    }
	
	// calculate average fitness value of a population
	public static double avgFitness(int[][] population) {
		double sumFitness = 0;
		
		for(int i=0; i<population.length; i++)
			sumFitness += f(getX(population[i]));
		
		return sumFitness / population.length;
	}
	
	// calculate boundary values for every chromosome in a population to pick from using a roulette
	public static double[] calculateRouletteWheel(int[][] population) {
		double[] wheelSections = new double[population.length];
		double sumFitness = 0;
		
		for(int i=0; i<population.length; i++) {
			for(int j=0; j<=i; j++)
				wheelSections[i] += f(getX(population[j])) + 6;
			sumFitness += f(getX(population[i])) + 6;
		}
		
		for(int i=0; i<population.length; i++)
			wheelSections[i] = wheelSections[i] / sumFitness;
		
		return wheelSections;
	}
	
	// select chromosomes using roulette to fill a whole population that gets returned
	public static int[][] rouletteSelection(int[][] population) {
		Random r = new Random();
		double randomValue;
		
		int[][] returnPopulation = new int[population.length][population[0].length];
		double[] wheelSections = calculateRouletteWheel(population);
		
		for(int i=0; i<returnPopulation.length; i++) {
			randomValue = r.nextDouble();
			 
			for(int j=0; j<wheelSections.length; j++) {
				if(wheelSections[j] >= randomValue) {
					returnPopulation[i] = population[j];
					break;
				}
			}
		}
		
		return returnPopulation;
	}
	
	// crossover chromosomes in a given population with each other to create a whole crossed population that gets returned
	public static int[][] twoPointCross(int[][] population) {
    	Random r = new Random();
        int crossPoint1 = r.nextInt(mi), crossPoint2 = r.nextInt(mi);
    	int[][] returnPopulation = new int[population.length][population[0].length];
    	int randomParent;
    	
    	for(int i=0; i<population.length; i++) {
    		if(r.nextDouble() <= 0.6) {		// 0.6 is the chance if the chromosme gets crossovered
    			
    			while(crossPoint1 >= crossPoint2) {
    				crossPoint1 = r.nextInt(mi);
    				crossPoint2 = r.nextInt(mi);
    			}
    			
    			randomParent = r.nextInt(population.length);
    			
    			for(int j=0; j<mi*2; j++) {
    				if(j < crossPoint1) {
    					returnPopulation[i][j]  = population[i][j];
    				}
    				else if(j > crossPoint1 && j < crossPoint2) {
    					returnPopulation[i][j]  = population[randomParent][j];
    				}
    				else {
    					returnPopulation[i][j]  = population[i][j];
    				}
    			}
    		}
    		else {
    			for(int j=0; j<population[i].length; j++)
    				returnPopulation[i][j] = population[i][j];
    		}
    	
    		crossPoint1 = r.nextInt(mi);
			crossPoint2 = r.nextInt(mi);
    	}
    		
    	return returnPopulation;
    }
	
	// mutate chromosomes in a given population to create a whole population that gets returned
	public static int[][] mutujPopulacje(int[][] population) {
    	int[][] returnPopulation = new int[population.length][population[0].length];
    	Random r = new Random();
    	
    	for(int i=0; i<population.length; i++) {
    		
    		if(r.nextDouble() <= 0.02) {		// 0.02 is the probability we will mutate a particular chromosome
    			for(int j=0; j<population[i].length; j++) {
    				if(r.nextDouble() <= 0.1)	// 0.1 is the probability we will mutate a particular bit in a chromosome
    					if(population[i][j] == 0) returnPopulation[i][j] = 1;
    					else returnPopulation[i][j] = 0;
    			}
    		
    			if(!checkX(getX(returnPopulation[i]))) {
    				for(int j=0; j<returnPopulation[i].length; j++) {
    					returnPopulation[i][j] = population[i][j];
    				}
    				i--;
    			}
    		}
    		else {
    			if(i < 0) i = 0;
    			for(int j=0; j<population[i].length; j++) {
    				returnPopulation[i][j] = population[i][j];
    			}
    		}
    		
    		if(i < 0) i = 0;
    		if(!checkX(getX(returnPopulation[i]))) {
    			for(int j=0; j<returnPopulation[i].length; j++)
    				returnPopulation[j] = population[i];
    			i--;
    		}
    	}
    	
    	return returnPopulation;
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
	
	public static void main(String[] args) {
		int populationSize = 200;		// how many chromosomes exist in population
		int cycleAmmount = 1000;		// how many times should the algorithm run in a single run
		int[][] population;				// array to hold the population
		
		double[] currentTable = new double[cycleAmmount];
		double[] best_currentTable = new double[cycleAmmount];
		double[] best_globalTable = new double[cycleAmmount];
		double current = 0, best_current = -7, best_global = 0;
		
		String currentString = "", best_currentString = "", best_globalString = "";
		
		for(int i=0; i<50; i++) {
				
			//generate random population
			population = generatePopulation(populationSize);
		
			for(int j=0; j<cycleAmmount/populationSize; j++) {
			
				//use roulette selection on the population
				population = rouletteSelection(population);
			
				//use two point crossover on the population
				population = twoPointCross(population);
			
				//use mutation on the population
				population = mutujPopulacje(population);
				
				for(int k=0; k<population.length; k++) {
					if(f(getX(population[k])) > best_current) {
						best_current = f(getX(population[k]));
					}
				}
				if(best_current > best_global) best_global = best_current;
				
				currentTable[j] += avgFitness(population);
				best_currentTable[j] += best_current;
				best_globalTable[j] += best_global;
				
				best_current = -7;
			}
			
			best_global = -7;
			best_current = -7;
			System.out.println(i*2 + "%");
		}
		
		for(int j=0; j<cycleAmmount/populationSize; j++) {
			currentTable[j] /= 50;
			best_currentTable[j] /= 50;
			best_globalTable[j] /= 50;
		}
		
		for(int j=0; j<cycleAmmount/populationSize; j++) {
			currentString += (currentTable[j] + "\n");
			best_currentString += (best_currentTable[j] + "\n");
			best_globalString += (best_globalTable[j] + "\n");
		}
	
		writeFile("current.txt", currentString);
		writeFile("best_current.txt", best_currentString);
		writeFile("best_global.txt", best_globalString);
	}
}
