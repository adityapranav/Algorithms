package com.recursive;

import java.util.Random;

public class RecursiveSort {
	
	public static void sort(int[] data, int startIndex) {
		if (startIndex < data.length) {
			max(data, startIndex);
			sort(data, startIndex+1);
		}
		
	}
	
	public static void max(int[] data, int startIndex) {
		int currentMax = data[startIndex];
		int maxIndex   = startIndex;
		for (int i=startIndex+1;i<data.length;++i) {
			int dat = data[i];
			if (dat > currentMax) {
				currentMax =  dat;
				maxIndex = i;
			} 
		}
		int temp = data[maxIndex];
		data[maxIndex] = data[startIndex];
		data[startIndex]  = temp;
 	}
	public static void main(String[] args) {
		Random r = new Random();
		int[] data = new int[8];
		for(int i=0;i<data.length;++i) {
			data[i] = r.nextInt(100);
		}
		System.out.println("Data in the Array");
		
		for(int x:data)
				System.out.print(x+"  ");
		System.out.println("");
		
		sort(data, 0);
		
		System.out.println("Data After Sorting");
		
		for(int x:data)
			System.out.print(x+"  ");
		System.out.println("");
	}
}

