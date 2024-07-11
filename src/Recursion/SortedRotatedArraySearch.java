package Recursion;

public class SortedRotatedArraySearch {
	
	public static int searchMyAttempt(int arr[], int si, int ei, int target) {
		if (si > ei) {
			return -1;
		}
		
		int mid = si + (ei-si)/2;
		
		if (arr[mid] == target) {
			return mid;
		}
		
		
		if (arr[mid] > arr[ei]) {
			//on first segment L1
			if (target >= arr[si] && target < arr[mid]) {
				return searchMyAttempt(arr, si, mid-1, target);
				
			} else {
				return searchMyAttempt(arr, mid+1, ei, target);
			}
		}else {
			// on second segment L2
			if (target <= arr[ei] && target > arr[mid]) {
				return searchMyAttempt(arr, mid+1, ei, target);
			} else {
				return searchMyAttempt(arr, si, mid-1, target);
			}
		}
	}
	
	

	public static void main (String args[]) {
		int arr[] = {11, 13, 17, 3, 5, 7, 9};
		int index = searchMyAttempt(arr, 0, arr.length-1, 3);
		System.out.println(index);
		
		int arr1[] = {4, 5, 6, 7, 0, 1, 2};
		int index1 = searchMyAttempt(arr1, 0, arr1.length-1, 0);
		System.out.println(index1);
		
		
	}
}
