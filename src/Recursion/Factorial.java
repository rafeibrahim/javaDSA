package Recursion;

public class Factorial {
	
	public static int fact(int n) {
		if (n == 0) {
			return 1;
		}
		int fn = n * fact(n-1);
		return fn;
	}
	
	public static void main (String args[]) {
		System.out.println(fact(2));
	}

}
