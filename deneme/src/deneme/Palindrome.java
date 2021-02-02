package deneme;

public class Palindrome {

	public static void main(String[] args) {
		//O(N) ile bunu cozmeye calisalim		
		isPalindrome("abba");
		isPalindrome("aba");
		isPalindrome("abcca");
			
	}
	

	private static boolean isPalindrome(String str) {
		
		char[] palindrome = str.toCharArray() ;
		
		int halfLengthArr = palindrome.length /2;
		int j = palindrome.length ;
		
		for(int i=0 ; i< halfLengthArr; i++) 
		{
			if(!( palindrome[i] == palindrome[j -1]) ) {
				System.out.println(str + " palindrome degil");
				return false;
			}
								
			j--;	
		}
		System.out.println(str + " palindrome");
		
		
		return true;
		
	}
}
