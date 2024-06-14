package javaDSA;

public class StringShortestPath {
	
	public static float getShortestPath (String str) {
		
		int x = 0;
		int y = 0;
		
		for (int i=0; i<str.length(); i++) {
			if (str.charAt(i) == 'N') {
				y++;
			} else if (str.charAt(i) == 'S') {
				y--;
			} else if (str.charAt(i) == 'E') {
				x++;
			} else if (str.charAt(i) == 'W') {
				x--;
			}
		} 
		
		return (float)Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));	
	}
	
	public static void main(String args[]) {
		String s1 = "WNEENESENNN";
		String s2 = "NS";
		System.out.println(getShortestPath(s1));
		System.out.println(getShortestPath(s2));
	}
}
