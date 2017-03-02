package com.recursive;

import java.util.Random;

public class MergeSortedLists {
	
	public static int[] mergeSortedArrays(int[] List1, int[] List2) {
		
		int[] finalList = new int[List1.length+List2.length];
		int i,j,k;i=j=k=0;
		while (i<List1.length && j<List2.length) {
			if (List1[i] < List2[j]) {
				finalList[k++] = List1[i++];
			} else {
				finalList[k++] = List2[j++];
			}
		}
		
		if(i < List1.length)
			copyList(finalList, k, List1, i );
		else if (j<List2.length)
			copyList(finalList, k, List2, j);
		
		return finalList;
		
	}

	private static void copyList(int[] finalList, int k, int[] list2, int i) {
		for (int index=i;index<list2.length;++index) {
			finalList[k++] = list2[index];
		}
		
	}
	public static void main(String[] args) {
		int[] L1 = {45, 98, 105, 113};
		int[] L2 = {31, 42, 119};
		int[] result = mergeSortedArrays(L1, L2);
		for(int data:result)
			System.out.println(data+" ");
	}
	

}
