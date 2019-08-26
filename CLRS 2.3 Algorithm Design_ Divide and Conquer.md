2.3 Designing algorithms
2.3.1 The divide-and-conquer approach

Divide the problem into a number of sub problems 

Conquer solve the subproblems recursively. If the subproblem size is trivial, solve it directly.

Combine the solutions of the subproblems into solution for the original problem 

Merge-Sort:

Divide: Divide the array of n elements into two sub arrays of n/2 each

Conquer: Recursively sort each of the sub arrays using merge sort

Combine: Merge the sorted subarrays to produce the final sorted array.


// Merge with a new array for output

MERGE(A, p, q, r)  // A[p..q] and A[q+1..r] are sorted
{
   
   left = p 
   right = q+1
   
   while left <= q and right <= r 
   do
     if (A[left] < A[right])
	   add A[left] to result 
	   left++
	 else
	   add A[right] to result 
	   right++
   done

    if (left <= q) {
	  for i:=left to q 
	    add A[i] to result
	}
	
	if (right <= r) {
	   for i:=right to r 
	    add A[i] to result
	}
    
	return result
} 

// In Place Merging Algorithm with two new arrays to store sorted arrays with sentinels

MERGE(A, p, q, r)  // A[p..q] and A[q+1..r] are sorted
{
  leftSize = q-p+1;
  L1 = new int[leftSize+1];
  
  rightSize = r-q;
  L2 = new int[rightSize+1];
  
  for i:=1 to leftSize 
    L1[i] = A[p+i-1]
  for i:=1 to rightSize 
    L2[i] = A[q+i]
	
  L1[leftSize+1] = Infinity 
  L2[rightSize+1] = Infinity 
  
  i := 1
  j := 1
  for k:p to r 
  do
    if L1[i] > L2[j]
	  A[k] := L2[j]
	  j++
	else 
	  A[k] := L1[i]
	  i++
}

// Merge without sentinels 

MERGE(A, p, q, r)  // A[p..q] and A[q+1..r] are sorted
{
  leftSize = q-p+1;
  L1 = new int[leftSize+1];
  
  rightSize = r-q;
  L2 = new int[rightSize+1];
  
  for i:=1 to leftSize 
    L1[i] = A[p+i-1]
  for i:=1 to rightSize 
    L2[i] = A[q+i]
  
  i := 1;
  j := 1;
  k = p;
  while i <= leftSize && j <= rightSize 
  {
    if (L1[i] <= L2[j]) {
	  A[k++] = L1[i];
	  i++
	} else {
	  A[k++] = L2[j]
	  j++
	}
  }
  while ( i <= leftSize ) {
    A[k++] = L1[i++];
  }
  
  while ( j <= rightSize ) {
    A[k++] = L2[j++];
  }
}



Merge-sort 


Merge-Sort(A, int i, int j) {

  if (i < j) {
   mid = (i + j)/2;
  
   Merge-sort(A, i , mid);
  
   Merge-Sort(A, mid+1, j);
  
   Merge(A, i, mid, j);
  }
}

