package com.recursive;

import java.util.Random;

public class SmallestInArray {
	
	public static int smallestRecursive(int[] data, int n) {
		if (n == 0)
			return data[n];
		int temp = smallestRecursive(data, n - 1 );
		if (temp < data[n])
			return temp;
		else
			return data[n];
	}
	
	public static void smallest(int[] data)
	{
		System.out.println("Smallest in Array is " + smallestRecursive(data, data.length-1));
	}
	
	public static void main(String... args) {
		System.out.println("Hello! Welcome to Smallest Number in Array Algorithm");
		Random r = new Random();
		int[] data = new int[5];
		for(int i=0;i<data.length;++i)
			data[i] = r.nextInt(100);
		System.out.println("Data in the Array");
		for(int x:data)
			System.out.print(x+"  ");
		System.out.println("");
		smallest(data);
	}
}
