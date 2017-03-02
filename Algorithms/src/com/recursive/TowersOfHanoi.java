package com.recursive;

public class TowersOfHanoi {

	public static void towers(int n, char from, char to, char via) {
		if ( n== 1 )
			System.out.println("Move from "+from+" to "+to);
	    else {
	    	towers(n-1, from, via, to);
	    	towers(1, from, to , via);
	    	towers(n-1, via, to , from);
	    }
				
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		for (int i=10;i<=25;i=i+5) {
			long t1 = System.currentTimeMillis();
			towers(i,'A','B','C');
			long t2 = System.currentTimeMillis();
			System.out.println("time taken to place "+i+" disks is "+(t2-t1)/1000+" secs");
			Thread.sleep(10000);
		}
	}

}
