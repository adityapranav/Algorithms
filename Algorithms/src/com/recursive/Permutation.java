package com.recursive;

import java.util.Random;

public class Permutation {
	
	public static void permute(int[] data, int n, int r) {
		
		
	}
	
	public static int[] delete(int [] data,int i) {
		int[] newdata = new int[data.length-1];
		for(int index=0;index<i;++index)
			newdata[index] = data[index];
		return newdata;
	}
	
	public static void main(String[] args) {
		Random r = new Random();
		int[] data = new int[6];
		for(int i=0;i<data.length;++i) {
			data[i] = r.nextInt(100);
		}
		System.out.println("Data in the Array");
		
		for(int x:data)
				System.out.print(x+"  ");
		System.out.println("");
		
		int[] ndata= delete(data, 0);
		
		System.out.println("Data After Sorting");
		
		for(int x:ndata)
			System.out.print(x+"  ");
		System.out.println("");
	}
}
