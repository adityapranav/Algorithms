package com.recursive;

public class Permutations {

	public static void permutations(char data[]) {
		permutationsRecursive(data, 0);
	}

	private static void permutationsRecursive(char[] data, int n) {
		if (n == data.length-1)
			return;
		for (int j=0;j <= n;++j) {
			System.out.print(data[j]+" ");
			permutationsRecursive(data, n+1);
		}
		System.out.println("\n");
	}
	
	private static void printData(char[] data) {
		for (char c:data)
			System.out.print(c+' ');
		System.out.println("\n");
		
	}

	public static void main(String[] args) {
		char[] a = new char[2];
		a[0]='A';
		a[1]='B';
		permutations(a);
	}
}
