package Recursion;

public class QuickSort {
	
	public static void printArr (int arr[]) {
		for (int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void quickSort (int arr[], int si, int ei) {
		//Base Case
		if (si >= ei) {
			return;
		}
		
		int pIdx = partition(arr, si, ei);
		quickSort(arr, si, pIdx);
		quickSort(arr, pIdx+1, ei);
	}
	
	public static int partition (int arr[], int si, int ei) {
		int i = si - 1;
		int pivot = arr[ei];
		
		for (int j=si; j<=ei; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		return i;
	}
	
	
	public static void main (String args[]) {
		int arr[] = {6, 3, 9, 8, 2, 5};
		int pIdx = partition(arr, 3, arr.length-1);
		System.out.println(pIdx);
		printArr(arr);
		
	}

}
