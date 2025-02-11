package denemeExam2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Exam {

	public String getCompressed(String text)
	{
		
		String currChar ,nextChar;
		int currCharCount = 1;
		StringBuilder result = new StringBuilder();
		
		if(text== null) return null; // BUnu yazmak gerekiyomus
		for(int i =0 ; i < text.length() ; i++ )
		{
			
			currChar = text.substring(i ,i+1);
			if( (i+2 ) > text.length())
			{
				//currCharCount++;
				result.append(currChar).append(currCharCount);
				break;
			}
				
			 
			nextChar = text.substring(i+1 ,i+2);
			
			if(currChar.equals(nextChar) )
				currCharCount++;
			else
			{
				result.append(currChar).append(currCharCount);
				currCharCount = 1;
			}
		}
		
		//Tum bosluklari teke indiricez
		StringBuilder modifiedStr = new StringBuilder();
		
		String[] allItems = result.toString().split(" ");
		
		modifiedStr.append(  allItems[0] );
		
		for( int i=1 ; i <allItems.length ;i++) {
			
			modifiedStr.append( " " + allItems[i].substring(1) );
		}
		
		
		return modifiedStr.toString();

	}


	public void remoteTwoRedundantChars(String text,Integer repeats ) {
	    String expected0 = "koq x";
	    //String actual0 = Challenge.removeRedundant("aaba kouq bux",2);
	    //assertEquals(expected0, actual0);
	    
	    Map<String , Integer> hashMap = new LinkedHashMap<String , Integer>();
	    String currChar ="";  
	    Integer currValue;
	    
	    
	    for(int i =0 ; i < text.length() ; i++ )
		{			
			currChar = text.substring(i ,i+1);
			if(currChar.equals(" ")) 
			{
				hashMap.put("w" + i, 1) ;
				continue;
			}
				
			if( hashMap.containsKey( currChar ))
			{
				currValue = hashMap.get(currChar) ;
				hashMap.replace(currChar, ++currValue) ;
			}
			else
			{
				hashMap.put(currChar, 1) ;
			}	
		}
	    
	    //find occurences bigger than repeats
	    
	    Map<String ,Integer> resMap= hashMap.entrySet().stream().
	    		filter(i -> i.getValue() < repeats).
	    		collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue ,(o1,o2) ->o1 ,LinkedHashMap::new));
	    
	    resMap.entrySet().forEach(i -> System.out.println( i.getKey() + ":" + i.getValue().toString()));
		
	   		
	    
	    String res = resMap.entrySet().stream().map(item ->item.getKey()).reduce("" ,String::concat) ;
	    
	    String curChar;
	    StringBuilder modifiedStr = new StringBuilder();
	    
	    //Bosluk lari tutmamiz gerekiyor, sirayi kaybetmememek icin bi numara ile tutaiyoruz
	    for(int i =0; i< text.length() ; i++) {
	    	curChar = text.substring(i ,i+1);
	    	if(curChar.equals(" ")) curChar = "w" + i;
	    	
	    	if(resMap.containsKey(curChar))
	    		modifiedStr.append(curChar);
	    }
	    
	    System.out.println(modifiedStr);
	   
	    String resultStr = modifiedStr.toString();
	    resultStr= resultStr.replaceAll("\\d", ""); //Remove all digits  // non digits ->complexString.replaceAll("\\D", "")
	    resultStr= resultStr.replaceAll("(w)\\1+","$1"); //All whitespaces occurrences into single
	    
	    resultStr= resultStr.replaceAll("w", " ").trim();
	    
	    System.out.println(resultStr);
	  }
	
	
	public static void main(String[] args) {
		Exam e = new Exam();
		//System.out.println( e.getCompressed("a   b  "));
		e.remoteTwoRedundantChars("aaba kouq bux",4);
	}

}
