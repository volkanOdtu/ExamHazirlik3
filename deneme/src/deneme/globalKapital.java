package deneme;

public class globalKapital {

	 static void staircase(int n) {

		 printGraph( n -1 ,1) ;
	    }
	    
	    static void printGraph(int whiteSpaceCount ,int symbolCount){
	    	if(whiteSpaceCount== 0) return;
	    	
	        for(int i=0 ;i <whiteSpaceCount ; i++)
	        	System.out.print(" ");
	        
	        for(int i=0 ;i <symbolCount ; i++)
	            System.out.print("#");
	        
	        System.out.println();
	        printGraph(--whiteSpaceCount ,++symbolCount);
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		staircase(6);
	}

}
