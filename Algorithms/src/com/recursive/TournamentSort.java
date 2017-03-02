package com.recursive;

import java.util.Random;

public class TournamentSort {
	static int comparisoncount = 0;
	
	public static void tournmentSort(int[] data) {
		
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
		int[] data = new int[6];
		for(int i=0;i<data.length;++i)
			data[i] = r.nextInt(100);
		System.out.println("Data in the Array");
		for(int x:data)
			System.out.print(x+"  ");
		System.out.println("");
		//maxMinIterative(data);
		System.out.println("Total comparisons for arry of length "+data.length+" is "+comparisoncount);
	}
}
