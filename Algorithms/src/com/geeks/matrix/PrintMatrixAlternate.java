package com.geeks.matrix;

/*
 * Input : arr[][2] = { {1, 2}
					    {2, 3}
					   }; 
   Output : 1  2  3  2 

   Input :arr[][3] = { { 7 , 2 , 3 },
					   { 2 , 3 , 4 },
					   { 5 , 6 ,  1 }
					  }; 
   Output : 7  2   3  4  3  2  5  6  1
 
 */

import java.util.Random;

public class PrintMatrixAlternate {

	public static void main(String[] args) {

		int[][] m = new int[4][4];
		Random r = new Random();
		
		for(int i=0;i<4;++i)
			for(int j=0;j<4;++j)
				m[i][j] = r.nextInt(5);
		
		System.out.println("Data Before Alternate Printing is");
		for(int i=0;i<4;++i) {
			for(int j=0;j<4;++j) 
				System.out.print(m[i][j] +"  ");
			System.out.println("\n\n");
		}
		
		System.out.println("Data after Alternate Printing is");
		printMatrixAlternate(m);
		
	}
	
	public static void printMatrixAlternate(int[][] m) {
		final int NO_OF_ROWS = m.length;
		final int NO_OF_COLS = m[0].length;
		boolean lefttoRight = true;
		
		for(int i=0;i<NO_OF_ROWS;++i) {
			if (lefttoRight)
				printLeft(m,i, NO_OF_COLS);
			else
				printRight(m,i, NO_OF_COLS);
			System.out.println("\n\n");
			lefttoRight = !lefttoRight;
		}
		
	}

	private static void printRight(int[][] m, int i, int nO_OF_COLS) {
		for (int j=nO_OF_COLS-1; j>=0; j--)
			System.out.print(m[i][j]+"  ");
		
	}

	private static void printLeft(int[][] m, int i, int nO_OF_COLS) {
		for (int j=0; j<nO_OF_COLS; j++)
			System.out.print(m[i][j]+"  ");
	}

}
