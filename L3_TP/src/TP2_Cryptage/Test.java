package TP2_Cryptage;

public class Test {

	public static void main(String[] args) {
		
		/*
		String ch1 = "1234";
		String ch2 = "";
		char p = ch1.charAt(0); // premier caractère
		char f = ch1.charAt(ch1.length()-1); // dernier caractère
		for (int i = 0; i < ch1.length(); i++) {
			char tmp = ch1.charAt(0);
			p = ch1.charAt(ch1.length()-1);
			f = tmp;
		}
		*/
		
		String ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789";
		String cle = "decalage";
		String alphabetDeCryptage = ALPHABET.replace(ALPHABET.substring(0, cle.length()), cle);
		// System.out.println(alphabetDeCryptage); // decalageijklmnopqrstuvwxyz0123456789
		
		//substring FIN
		String sFin = alphabetDeCryptage.substring
									  (alphabetDeCryptage.length()-cle.length(), alphabetDeCryptage.length());
		//System.out.println(sFin);
		String newAlphabetDeCryptage = sFin.concat(alphabetDeCryptage);
		//System.out.println(newAlphabetDeCryptage);// 23456789decalageijklmnopqrstuvwxyz0123456789
		//delete FIN
		newAlphabetDeCryptage = newAlphabetDeCryptage.substring(0, newAlphabetDeCryptage.length()-sFin.length());
		//System.out.println(newAlphabetDeCryptage); // 23456789decalageijklmnopqrstuvwxyz01
		alphabetDeCryptage = newAlphabetDeCryptage;
		System.out.println(alphabetDeCryptage);

		
		
		
		
		//concat
		//delete
		
		for (int i = 0; i < cle.length(); i++) {
			char tmp = alphabetDeCryptage.charAt(0);
			char d = alphabetDeCryptage.charAt(0);
			d = alphabetDeCryptage.charAt(alphabetDeCryptage.length()-1);
			char f = alphabetDeCryptage.charAt(alphabetDeCryptage.length()-1);
			f = tmp;
		}
		
		
		
		
		
		
		
		/*
		for (int i = ch1.length()-1; i > ch1.charAt(0); i--) {
		
			System.out.println(ch1.charAt(i));
		}
		*/	
		
		/*
		for (int i = ch1.length()-1; i<ch1.charAt(0); i--) {
			ch3 += ch1;
			if (i == ch1.charAt(0)) {
				for (int j = 0; j < ch2.length(); j++) {
					ch3
				}
			}
		}
		*/

	}

}
