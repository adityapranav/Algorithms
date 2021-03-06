# Chapter 2 from CLRS: Getting Started 

## Insertion Sort 

Input: a1,a2......,an  =>  A sequence of n numbers 
Output:  a permutation of the sequence such that (a1',a2'......., an') , a1' <= a2'.....<= an'

An efficient algorithm for sorting small number of elements

Works in same way as playing cards. 

start with empty hand. Remove each card from pile and insert into the right position in left hand.

for choosing the right position, compare the picked card with all the cards in hand from right to left.

```

for i:=2 to n {
   int key = a[i];
   rightposition = getRightPosition(i-1, a, key);
   a[rightposition] = key;
}

getRightPosition(int x, int[] a, int key) {
   for i:=x to 1 {
     if (a[i] > key) {
	    a[i+1] = a[i];
	 }else {
	    return i+1;
	 }
   }
   return i+1;
}
```

# Exercises 2.2-2 in CLRS 

```
// All Indices start with 1. If you are using this code for actual program, change the index to be starting
from zero.
sort(int[] A) {
   for i:=1 to N-1
     smallestIndex = findSmallest(A, i)
	 swap(A, i, smallestIndex)
}

int findSmallest(int[] A, int i) {
  smallest = A[i]
  index = i;
  for x:=i+1 to A.length {
     if (A[x] < smallest) {
	    smallest = A[x];
	    index = x;
	 }
  }
  return index;
}

```

## code without Method call 
```
sort(int[] A, int n) {

  for i:=1 to N-1
  do 
	minIndex := i
	for j:=i+1 to N 
	do
	  if A[j] < A[minIndex] 
	    minIndex := j
	done
	swap(A, i, minIndex)	
}
```
## Loop Invariant for Selection Sort 

Base Condition ( Before the loop ) :-> The Array is Not sorted.

Loop Invariant :-> for each value of i, the smallest element from i to N is computed. the smallest item then is placed at A[i]

Termination :-> Once the loop is done with i:= N-1, the smallest element from N-1 to N is stored at A[N-1]. A[N] will contains the smallest element from i:=N to N which is it self.
