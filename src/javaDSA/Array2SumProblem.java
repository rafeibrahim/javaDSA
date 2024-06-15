package javaDSA;

import java.util.*;

public class Array2SumProblem {
	
	public static int[] twoSumOnePassHashTable(int[] nums, int target) {
		Map<Integer, Integer> numMap = new HashMap<>();
		
		for (int i=0; i<nums.length; i++) {
			int complement = target - nums[i];
			if(numMap.containsKey(complement)) {
				return new int[]{numMap.get(complement), i};
			}
			numMap.put(nums[i], i);
		}
		
		return new int[] {};
	}
	
    public static int[] twoSumBruteForce(int[] nums, int target) {
    	for (int i=0; i<nums.length; i++) {
    		for(int j= i+1; j<nums.length; j++){
    			if (target == nums[i] + nums[j]) {
    				return new int[] {i, j};
    			}
    		}
    	}
    	return new int[]{};

    }
    
    
    public static void printArr (int[] arr) {
    	for (int i=0; i<arr.length; i++) {
    		System.out.print(arr[i] + " ");
    	}
    	System.out.println();
    }
	
	public static void main (String args[]) {
		int[] nums1 = new int[] {2, 7, 11, 15};
		int[] nums2 = new int[] {3, 2, 4};
		int[] nums3 = new int[] {7, 3, 8, 3};
		
		printArr(twoSumBruteForce(nums1, 9));
		//printArr(twoSumOnePassHashTable(nums1, 9));

		
	}
}
