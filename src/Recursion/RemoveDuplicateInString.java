package Recursion;

public class RemoveDuplicateInString {
	
	public boolean map[] = new boolean[25];
	
	public String removeDupRightOrder(String str, int i) {
		if (i == str.length()) {
			return "";
		}
	
		if(this.map[str.charAt(i) - 'a'] == false) {
			this.map[str.charAt(i) - 'a'] = true;
			return str.charAt(i) + removeDupRightOrder(str, i+1);
		}
		return removeDupRightOrder(str, i+1);
		
	}
	
	//remove duplicate class logic
	
	public static void removeDuplicates (String str ,int idx, StringBuilder newStr, boolean map[]) {
		if (idx == str.length()) {
			System.out.println(newStr);
			return;
		}
		
		char currChar = str.charAt(idx);
		if (map[currChar - 'a'] == true) {
			removeDuplicates(str, idx+1, newStr, map);
		} else {
			map[currChar - 'a'] = true;
			removeDuplicates(str, idx+1, newStr.append(currChar), map);
		}
	}
	
	public static void removeDuplicatesClassLogic (String str, int idx, StringBuilder newStr, boolean map[]) {
		if (idx == str.length()) {
			System.out.println(newStr);
			return;
		}
		
		if (map[str.charAt(idx) - 'a'] == false) {
			map[str.charAt(idx) - 'a'] = true;
			newStr.append(str.charAt(idx));
			removeDuplicatesClassLogic(str, idx+1, newStr, map);
			return;
		}
		
		removeDuplicatesClassLogic(str, idx+1, newStr, map);
	}
	
	// in the following function you can recursively call the function for
	// the next index but you cannot check before hand whether to add 
	// current character to the return statement. if we try to check it before hand it makes 
	//recursive calls all the way to the base case and then on the way back from base case with return statements
	// it can check if the return statement already have that character or not and print it in reverse order. this 
	// is demonstrated in the function removeDuplicateReverseOrder()
	
	public static String removeDup(String str, int i) {
		if (i == str.length()) {
			return "";
		}
		
		return str.charAt(i) + removeDup(str, i+1);
	}
	
	
	
	// based on index first we go from i to n then on the way back we add
	// current character to returned string
	public static String removeDuplicatereverseOrder(String str, int i) {
		//base case
		if (i == str.length()-1){
			return "";
		}
		
		String result = removeDuplicatereverseOrder(str, i+1);

		if (result.indexOf(str.charAt(i)) == -1) {
			return result + str.charAt(i);
		}
		return result;	
	}
	
	
	public static String removeDuplicateWithLastIndex(String str, int n) {
		// base case
		if (n == -1) {
			return "";
		}
		
		String result = removeDuplicateWithLastIndex(str, n-1);
		if (result.indexOf(str.charAt(n)) == -1){
			return result + str.charAt(n);
		}
		return result;
	}
	
	public static String removeDulplicateWithLength(String str, int n) {
		if(n == 0) {
			return ""; 
		}
		
		String result = removeDulplicateWithLength(str, n-1);
		if (result.indexOf(str.charAt(n-1)) == -1) {
			return result + str.charAt(n-1);
		}
		return result;
	}
	
	
	
	
	public static void main (String args[]) {
		String str1 = "appnna";
		String str = "appnnacollege";
		//System.out.println(str.charAt(str.length() -1) + "");
		//System.out.println(removeDuplicatereverseOrder(str, 0));
		//System.out.println(removeDuplicateWithLastIndex(str, str.length()-1));
		//System.out.println(removeDulplicateWithLength(str, str.length()));
		
		//RemoveDuplicateInString rD  = new RemoveDuplicateInString();
		//System.out.println(rD.removeDupRightOrder(str, 0));
		//System.out.println(removeDup(str, 0));
		
		removeDuplicates(str, 0, new StringBuilder(), new boolean[26]);
	}
}
