package com.recursive;

import java.util.Random;

public class Multiplication {
	public static int multiply(int a, int  b) {
		if (a<0 || b<0)
			return 0;
		if (a==0 || b==0)
			return 0;
		if (b == 1)
			return a;
		return a + multiply(a, b-1);
	}
	public static void main(String[] args) {
		System.out.println("Hello! Welcome to Recursive Multiplication Algorithm ( Positive Integers Only )");
		Random r = new Random();
		int[] data = new int[2];
		for(int i=0;i<data.length;++i)
			data[i] = r.nextInt(100);
		System.out.println("Product of "+data[0]+" and "+data[1]+" is "+multiply(data[0], data[1]));
	}
}
