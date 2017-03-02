package com.mtech.tamassia;

import java.util.LinkedList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		List<Integer> a = new LinkedList<Integer>();
		a.add(1);
		System.out.println(a.size());
		a.add(10);
		System.out.println(a.size());
		System.out.println(a.get(1));
		a.remove(10);
		
	}

}
