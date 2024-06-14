package javaDSA;

public class StringUpperCase {
	
	//code used in the class
	public static String printUpperCaseClassLogic (String st) {
		StringBuilder sb = new StringBuilder("");
		sb.append(Character.toUpperCase(st.charAt(0)));
		
		for (int i=1; i<st.length(); i++) {
			if (st.charAt(i) == ' ' && i < st.length() - 1) {
				sb.append(st.charAt(i));
				i++;
				sb.append(Character.toUpperCase(st.charAt(i)));
			} else {
				sb.append(st.charAt(i));
			}
			
		}
		return sb.toString();
	}
	
	
	// my approach
	public static void printUpperCase (String st) {
		StringBuilder sb = new StringBuilder("");
		sb.append(Character.toUpperCase(st.charAt(0)));
		for (int i=1; i < st.length(); i++) {
			if(st.charAt(i-1) == ' ') {
				sb.append(Character.toUpperCase(st.charAt(i)));
			}else {
				sb.append(st.charAt(i));		
			}
		}
		
		for(int i=0; i<sb.length(); i++) {
			System.out.print(sb.charAt(i));
		}
	}
	
	public static void main (String args[]) {
		String st = "Hello, i am shradha ";
		printUpperCase(st);
		System.out.println();
		System.out.println(printUpperCaseClassLogic(st));
	}
}
