import java.util.*;


class LinearSearch {
    public static void main(String args[] ) throws Exception {
    
        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int []a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = s.nextInt();
        }
        int queriesLength = s.nextInt();
        int []q = new int[queriesLength];
        for(int i=0;i<queriesLength;i++) {
        	q[i]  = s.nextInt();
        }
        boolean asc = true;
        if (a[0] > a[1])
        	asc = false;
        for (int query: q) {
        	System.out.println(1+binarySearch(a, 0, a.length, query, asc));
        }
    }

	private static int binarySearch(int[] a, int low, int high, int query, boolean asc) {
		if (low > high)
			return -1;
		int mid = (low + high) /2;
		if (a[mid] == query)
			return mid;
		else if (query < a[mid]) {
		    if (asc)	
		    	return binarySearch(a, low, mid, query, asc);
		    else
		    	return binarySearch(a, mid+1, high, query, asc);
		}	
		else {
			if (asc)
				return binarySearch(a, mid+1, high, query, asc);
			else
				return binarySearch(a, low, mid, query, asc);
		}
		
	}
}
