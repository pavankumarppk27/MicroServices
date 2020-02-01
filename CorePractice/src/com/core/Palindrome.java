package com.core;

public class Palindrome {
	
	
	public static void main(String[] args) {
		
		String s="levels";
		
		boolean checkPalinDrome = checkPalinDrome(s);
		if(checkPalinDrome) {
			System.out.println("palindrome");
		}else {
			System.out.println(" not palindrome");
		}
	}
	
	public static boolean checkPalinDrome(String s) {
		
		String rev="";
		for(int i=s.length()-1;i>=0;i--) {	
			rev=rev+s.charAt(i);
		}
		
		if(rev.equals(s)){
			return true;
		}else {
			return false;
		}
		
	}

}

/*
 * StringBuffer sf=new StringBuffer(s); String s2=sf.reverse().toString();
 * 
 * if(s.equals(s2)) { return true; }
 * 
 * return false;
 */


