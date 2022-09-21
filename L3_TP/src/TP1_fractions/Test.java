package TP1_fractions;

public class Test {

	public static void main(String[] args) {
		
		
		int j = (123+98948)/2;
		System.out.println("dfjkj" + String.valueOf(j));
		//String.valueOf(j);
		
		String s = "a1b2c";
		char tabLettre[] = new char[s.length()];
		char tabChiffre[] = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			
			if (s.charAt(i) == 'a' || s.charAt(i) == 'b' || s.charAt(i) == 'c') {
				tabLettre[i] = s.charAt(i);
				
			} else {
				tabChiffre[i] = s.charAt(i);
			}
		}
		
		/*
		System.out.println(tabLettre);
		System.out.println(tabChiffre);
		
		System.out.println("+++++" + s.substring(0, s.length()-1));
		*/
		System.out.println(tot("ABC"));
		

	}
	
	public static int tot(String ch) {
		System.out.println(ch.charAt(ch.length()-1)); // extracts the last caracter
		for (int i = 0; i < ch.length(); i++) {
			if (i == ch.length()-1) {
				
				return 1;
			}	
		}
		return 0;
	}
}
