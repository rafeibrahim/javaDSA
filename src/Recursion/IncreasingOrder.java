package Recursion;

public class IncreasingOrder {
	
	static void printIncreasingOrder(int n) {
		
		if (n == 1) {
			System.out.print(n + " ");
			return;
		}
		printIncreasingOrder(n - 1);
		System.out.print(n + " ");
		if (n == 10) {
			System.out.println();
		}
		return;
	}
	
	public static void main(String args[]) {
		printIncreasingOrder(10);
	}

}
