package com.recursive;

import java.util.Random;

public class OptimizedMinandMax {
	static int comparisoncount = 0;

	public static void maxMinIterative(int[] data) {
		
		int temp_max = data[0];
		int temp_min = temp_max;
		for (int i=1;i <= data.length-2 ;i=i+2) {
			comparisoncount++;
			if ( (data[i] > data[i+1]) ) {
				temp_max = data[i] > temp_max ? data[i] : temp_max;
				temp_min = data[i+1] < temp_min ? data[i+1] : temp_min;
			} else {
				temp_max = data[i+1] > temp_max ? data[i+1] : temp_max;
				temp_min = data[i] < temp_min ? data[i] : temp_min;
			}
			comparisoncount = comparisoncount+2;
		}
		System.out.println("MAXIMUM is "+temp_max+" MINIMUM IS "+temp_min);	
	}
	
	public static void main(String[] args) {
		Random r = new Random();
		int[] data = new int[80];
		for(int i=0;i<data.length;++i)
			data[i] = r.nextInt(100);
		System.out.println("Data in the Array");
		for(int x:data)
			System.out.print(x+"  ");
		System.out.println("");
		maxMinIterative(data);
		System.out.println("Total comparisons for arry of length "+data.length+" is "+comparisoncount);
	}
}
