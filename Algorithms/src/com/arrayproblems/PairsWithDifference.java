package com.arrayproblems;

/*

PROBLEM STATEMENT:  Given an integer array and a positive integer k, count all distinct pairs with difference equal to k.

Input: arr[] = {1, 5, 3, 4, 2}, k = 3
Output: 2
There are 2 pairs with difference 3, the pairs are {1, 4} and {5, 2} 

Input: arr[] = {8, 12, 16, 4, 0, 20}, k = 4
Output: 5
There are 5 pairs with difference 4, the pairs are {0, 4}, {4, 8}, 
{8, 12}, {12, 16} and {16, 20} 



*/
public class PairsWithDifference {

	public static void bruteForce(int[] data, int k) {

		for (int i = 0; i < data.length; i++) {
			checkfor(i, data, k);
		}
	}

	private static void checkfor(int i, int[] data, int p) {
		for (int k = i + 1; k < data.length; ++k)
			if (Math.abs(data[i] - data[k]) == p)
				System.out.println("{" + data[i] + ", " + data[k] + "}");

	}

	public static void main(String[] args) {

		int arr[] = {8, 12, 16, 4, 0, 20};
		int k = 4;
		bruteForce(arr, k);
	}

} 