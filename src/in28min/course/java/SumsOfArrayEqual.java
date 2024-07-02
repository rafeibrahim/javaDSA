package in28min.course.java;

public class SumsOfArrayEqual {
	
	public static int calculateSum(int[] array) {
		int sum = 0;
		for (int e: array) {
			sum += e;
		}
		return sum;
	}
	
	
	public static void main (String args[]) {
		System.out.println(calculateSum(new int[] {1 , 2, 4}));
	}
}
