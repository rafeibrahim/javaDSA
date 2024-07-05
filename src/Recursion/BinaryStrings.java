package Recursion;

public class BinaryStrings {
	
	//class Solution
	public static void printBinaryStrings(int n, int lastPlace, String str) {
		
		if (n == 0) {
			System.out.println(str);
			return;
		}
	
		//printing with 0
		printBinaryStrings(n-1, 0, str + "0");
		
		//printing in case last digit was 0
		if (lastPlace == 0) {
			printBinaryStrings(n-1, 1, str+"1");
		}
	}
	
	
	
	
	//this is my solution for printing binary strings without using
	//last place binary number
	public static void pbs(int n, String str) {
		//Base Case
		if (n == 0){
			System.out.println(str);
			return;
		}
		if ( n==1) {
			System.out.println(str + "0");
			System.out.println(str +  "1");
			return;
		}
		
		// choice 0
		pbs(n-1, str + "0");
		// choice 1
		pbs(n-2, str + "10");
	}
	
	public static void main (String args[]) {
		//pbs(2, "");
		printBinaryStrings(3, 0, "");
		
	}
}
