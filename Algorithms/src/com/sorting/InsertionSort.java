package com.sorting;

import java.util.Random;

public class InsertionSort {
	
	public static void insertionSort(int[] data) {
		int n = data.length;
		for (int i = 1 ; i<n ; ++i) {
			int element = data[i];
			int j = i-1;
			while (j >= 0  && data[j] > element ) {
				shiftRight(data,j);
				j--;
			}
			data[j+1] = element;
		}
	}
	
	private static void shiftRight(int[] data, int j) {
		data[j+1] = data[j];
	}
	
	public static void main(String... args) {
		System.out.println("Hello! Welcome to InsertionSort Algorithm");
		Random r = new Random();
		int[] data = new int[8];
		for(int i=0;i<8;++i)
			data[i] = r.nextInt(100);
		System.out.println("Data Before sorting");
		for(int x:data)
			System.out.print(x+"  ");
		insertionSort(data);
		System.out.println("\nData After sorting");
		for (int x:data)
			System.out.print(x+"  ");
	}
}
