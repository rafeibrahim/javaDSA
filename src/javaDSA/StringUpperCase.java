package javaDSA;

public class StringUpperCase {
	
	public static void printUpperCase (String st) {
		StringBuilder outputStr = new StringBuilder("");
		outputStr.append(Character.toUpperCase(st.charAt(0)));
		for (int i=1; i < st.length(); i++) {
			if(st.charAt(i-1) == ' ') {
				outputStr.append(Character.toUpperCase(st.charAt(i)));
			}else {
				outputStr.append(st.charAt(i));		
			}
		}
		
		for(int i=0; i<outputStr.length(); i++) {
			System.out.print(outputStr.charAt(i));
		}
	}
	
	public static void main (String args[]) {
		String st = "Hello, i am shradha";
		printUpperCase(st);
	}
}
