package com.recursive;

import java.util.Random;

public class MergeSort {
	
	// mergeSort to mergeSort the Array from index i to j
	public static void mergeSort(int[]data, int i, int j) {
		if (i >= j)
			return;
		else {
			// split the list into two parts. For now, split at middle
			int p = (i+j)/2;
			mergeSort(data, i, p);
			mergeSort(data, p+1, j);
			merge(data,i,j);
		}
	}
	
	private static void merge(int[] data, int l, int h) {
		int mid = (l+h)/2;
		int p   = l;
		int q   = mid+1;
		int[] result = new int[h-l+1];
		int k=0;
		while (p <= mid  && q <= h) {
			if (data[p] < data[q]) {
				result[k++] = data[p++];
			} else {
				result[k++] = data[q++];
			}
		}
		if (p > mid) {
			for (int i=q;i<=h;++i)
				result[k++] = data[i];
		}else  {
			for (int i=p;i<=mid;++i)
				result[k++] = data[i];
		}
	
		for (int i=0;i<result.length;i++) 
			data[l++] = result[i];
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
		
		mergeSort(data, 0, data.length-1);
		
		System.out.println("Data After Sorting");
		
		for(int x:data)
			System.out.print(x+"  ");
		System.out.println("");
	}
}
