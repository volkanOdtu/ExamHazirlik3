package deneme;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ExamPrep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] allChars = "Mr Boris Johnson".toCharArray();
		
		System.out.println("a value " + ((int)'a'));
		System.out.println("a value " + ((int)'A'));
		
		System.out.println("z value " + ((int)'z'));		
		System.out.println("Z value " + ((int)'Z'));
		
		
		for(int i =0 ;i < allChars.length  ;i++ ) {
			if(allChars[i] > 0) {
				System.out.println("Char :" + allChars[i] );
			}
			
		}
		
		//boolean[] letters = new boolean[128];
		char[] letters = new char[128];
				
		for(char c: allChars) {
			 letters[(int)c] = c;
			 System.out.println((int)c + ":" + letters[(int)c]  );
		}
			
		
			
		
	}

}
