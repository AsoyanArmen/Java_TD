package TP2_Cryptage;

public abstract class Cryptage {
	
	final static String ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789"; 
	protected String alphabetDeCryptage;
	protected String clef;

	
	public Cryptage(){
		this(ALPHABET);
	}
	
	public Cryptage(String clef) {
		this.clef = clef;
	}
	
	public String toString(){
		return alphabetDeCryptage;
		
	}
	
	
}
