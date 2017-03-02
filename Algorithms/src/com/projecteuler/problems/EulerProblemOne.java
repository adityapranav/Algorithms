package com.projecteuler.problems;
// This problem takes a number n and returns the sum of all the multiples or X OR Y below that number n
// Eg: say n is 10 and X=3 , Y=5
// The output is 3+5+6+9 => 23 
public class EulerProblemOne {

	public static void main(String[] args) {
		System.out.println(sumofMultiples(1000, 3, 5));
	}
	
	public static long sumofMultiples(int n, int x, int y) {
		long sum = (x<y)?x:y;
		for (int i=(int) (sum+1); i<n; ++i ) {
			if (i%x == 0 || i%y == 0)
				sum+=i;
		}
		return sum;
	}
}
