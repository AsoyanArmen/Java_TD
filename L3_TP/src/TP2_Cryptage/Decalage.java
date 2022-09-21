package TP2_Cryptage;

public class Decalage extends Cryptage{

	/*
	 * Attributes
	 */
	final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789";
	private String alphabetDeCryptage;
	private String clef;
	
	/*
	 * Constructors
	 */
	public Decalage(String clef, String alphabetDeCryptage) {
		super(clef);
		this.alphabetDeCryptage = alphabetDeCryptage;
	}
	
	/*
	 * Methods
	 */
	public String cryptage(String s) {
		
		
		alphabetDeCryptage = s.concat(ALPHABET);
		
		/*
		for (int i = ALPHABET.length()-1; i > ALPHABET.charAt(0); i--) {
			alphabetDeCryptage += ALPHABET.charAt(i);
			if (i == ALPHABET.charAt(0)) {
				for (int j = 0; j < s.length(); j--) {
					alphabetDeCryptage.charAt(j) =s.charAt(j);
				for (int j = s.length(); j > ALPHABET.charAt(0); j--) {
					alphabetDeCryptage += s.charAt(j);
				}
			}
		}
		*/
		return null; // s =clef
		
		
	}
}
