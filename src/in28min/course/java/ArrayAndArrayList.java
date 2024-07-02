package in28min.course.java;

public class ArrayAndArrayList {
	
	public static boolean doesHaveElementGreaterThan(int[] array, int number) {
		for (int value : array) {
			if (value > number) {
				return true;
			}
		}
		return false;
	}
	
	public static int findSecondLargestNumber(int[] array) {
		
		if (array.length == 1) {
			return -1;
		}
		
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		
		for (int element: array) {
			if (element > largest) {
				secondLargest = largest;
				largest = element;
			} else if (element > secondLargest && element != largest) {
				secondLargest = element;
			}
		}
		return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
	}
	
	public static boolean areSumsEqual (int[] arr1, int[] arr2) {
		int sum1 = calculateSum(arr1);
		int sum2 = calculateSum(arr2);	
		return sum1 == sum2;		
	}
	
	public static int calculateSum (int[] arr) {
		int sum = 0;
		for (int e : arr) {
			sum += e;
		}
		return sum;
	}
	
	public static void main (String args[]) {
		System.out.println(doesHaveElementGreaterThan(new int[] {1, 2, 3, 4, 5}, 3));
		System.out.println(doesHaveElementGreaterThan(new int[] {1, 2, 3}, 4));
		System.out.println(findSecondLargestNumber(new int[] {5, 7, 9, 2, 4, 9}));
		System.out.println(findSecondLargestNumber(new int[] {1, 1, 1, 1}));
		System.out.println(findSecondLargestNumber(new int[] {7}));
		System.out.println(findSecondLargestNumber(new int[] {5, 5, 5, 4, 4}));
		System.out.println(areSumsEqual(new int[] {1,2}, new int[] {4, -2, 1}));
	}
}
