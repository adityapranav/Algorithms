package com.recursive;

import java.util.Random;

public class MaxSecondMaxArray {
	static int comparisoncount = 0;
	public static void maxSecondMaxBasic(int[] data) { 
		int max = data[0];
		int next_max = max;
		for (int i=1;i<data.length; ++i) {
			comparisoncount += 2;
			if (data[i]>max)
				max = data[i];
			else if(data[i]>next_max)
				next_max = data[i];
		}
		System.out.println("MAXIMUM is "+max+" NEXT MAXIMUM IS "+next_max);	
	}
	
	public static void maxSecondMaxTournmentModel(int[] data) {
		int[] tour = new int[2*data.length-1];
		buildTournment(data, tour);
		int next_max = min(tour[1], tour[2]);
		int i = 1;
		while ( i < tour.length ) {
			if (tour[i] < tour[i+1]) {
				next_max = max(next_max, tour[i]);
				i  =  2*i+2;
			} else {
				next_max = max(next_max, tour[i+1]);
				i = 2*i+1;
			}
		}
		
		System.out.println("MAXIMUM is "+tour[1]+" NEXT MAXIMUM IS "+next_max);	
	}
	
	private static void buildTournment(int[] data, int[] tour) {
		
		int k=0;
		for (int i=data.length-1;i<tour.length;++i)
			tour[i] = data[k++];
		
		for (int i=tour.length-1; i>=1; i=i-2) {
			tour[(i-1)/2] = max(tour[i], tour[i-1]);
		}
	}

	private static int max(int i, int j) {
		return (i>=j)?i:j;
	}
	
	private static int min(int i, int j) {
		return (i<j)?i:j;
	}

	public static void main(String[] args) {
		Random r = new Random();
	//	for (int k=5;k<20;++k) {
			int[] data = new int[8];
			for(int i=0;i<data.length;++i)
				data[i] = r.nextInt(100);
			System.out.println("Data in the Array");
			for(int x:data)
				System.out.print(x+"  ");
			System.out.println("");
			maxSecondMaxTournmentModel(data);
			System.out.println("Total comparisons for arry of length "+data.length+" is "+comparisoncount);
			comparisoncount =0;
		//}
	}
}
