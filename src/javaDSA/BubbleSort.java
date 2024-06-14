package javaDSA;

public class BubbleSort {
	
	public static void bubbleSort(int arr[]) {
		
		for (int i=0; i<arr.length-1; i++) {
			for(int j=0; j<arr.length-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void bubbleSortGeek(int arr[]) {
		for (int i=0; i<arr.length-1; i++) {
			boolean swapped = false;
			for(int j=0; j<arr.length-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swapped = true;
				}
			}			
			//if no elements were swapped
			//by inner loop, then break
			if(swapped == false) {
				break;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main (String args[]) {
		int numbers[] = {5, 4, 3, 2, 1};
		int numbers2[] = { 64, 34, 25, 12, 22, 11, 90 };
		//bubbleSort(numbers);
		bubbleSortGeek(numbers);
	}
}
