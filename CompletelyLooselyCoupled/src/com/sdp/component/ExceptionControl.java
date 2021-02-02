package com.sdp.component;

import java.util.Scanner;

class NotProperNameException extends Exception{
	NotProperNameException(String msg){
		super(msg);
	}
}
public class ExceptionControl {
	
	private String name;
	 
	public static boolean containsOnlyLetters(String name) {
		for (int i = 0; i < name.length(); i++) {
	         char ch = name.charAt(i);
	         if (!(ch >= 'a' && ch <= 'z')) {
	            return false;
	         }
	      }
	      return true;
	}
	public ExceptionControl(String name) throws NotProperNameException{
		if(containsOnlyLetters(name) && name!= null ) {
			NotProperNameException ex = new NotProperNameException("Only letters are allowed!");
			throw ex;
		}
		 this.name = name;
	}

	public static void main(String[] args) throws NotProperNameException {
		Scanner sc= new Scanner(System.in);
	    System.out.println("Enter the name of the person: ");
	    String name = sc.next();
	    ExceptionControl obj = new ExceptionControl(name);
	    System.out.println(obj.name);
	}
}
