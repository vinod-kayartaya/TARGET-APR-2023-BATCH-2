package com.targetindia.programs;

import java.util.HashSet;
import java.util.Set;

public class CollectionAsIterable {

	public static void main(String[] args) {
		Set<Integer> nums = new HashSet<>();
		// nums.add(100); // 100 is int, and int is not same as Integer
		nums.add(Integer.valueOf(100));
		
	}

}
