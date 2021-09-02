/*
Given an array of integers, find the first missing positive integer in linear time and constant space. 
In other words, find the lowest positive integer that does not exist in the array. 
The array can contain duplicates and negative numbers as well.
*/

import java.util.*;

class FindMissingNumber{
	public static void main(String[] args) {
		int[] nums = {3, 4, -1, 1};
		int minNum = findMissingNumber(nums);
		System.out.println(minNum); 
	}

	private static int findMissingNumber(int[] nums){
		Set<Integer> posNumbers = new HashSet<Integer>();
		int result = 0;
		for(int i : nums){
			if(i > 0) posNumbers.add(i);
		} 
		for(int i = 1; ; i++){
			if(!posNumbers.contains(i)){
				result = i;
				break;
			}
		}
		return result;
	}
}