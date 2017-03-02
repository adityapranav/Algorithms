package com.recursive;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class GCD {
	public static HashSet<Integer> divisorSet = new HashSet<Integer>();
	public static ArrayList<Integer> commondivisorList = new ArrayList<Integer>();
	public static int gcdBruteForce(int a, int  b) {
		System.out.println("numbers are "+a+" and "+b);
		getAllDivisors(a);
		getAllDivisors(b);
		return greatestInList();
	}
	private static int greatestInList() {
		if (commondivisorList.isEmpty())
			return 0;
		int largest = commondivisorList.get(0);
		for (int i=1;i<commondivisorList.size(); ++i) {
			if (largest < commondivisorList.get(i))
				largest = commondivisorList.get(i);
		}
		return largest;
	}
	private static void getAllDivisors(int a) {
		for(int i=1; i<= a/2; ++i) {
			if(a%i == 0) {
				if (divisorSet.contains(i))
					commondivisorList.add(i);
				else
					divisorSet.add(i);
			}
		}
		if (divisorSet.contains(a))
			commondivisorList.add(a);
		else
			divisorSet.add(a);

	}
	public static void main(String[] args) {
		
		Random r = new Random();
		int[] data = new int[2];
		for(int i=0;i<data.length;++i)
			data[i] = r.nextInt(15);
		System.out.println("GCD of "+data[0]+" and "+data[1]+" is "+gcdBruteForce(data[0], data[1]));
	}
}
