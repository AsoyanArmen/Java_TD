package TD1_String_StringBuffer;


public class StrBufferCorr extends Object{

	private char[] lesCaracteres;
	private int n; // nb de caractères de la chaine représentée (chaine peut être longue p
	// n = stock, lesCaracteres.length = entrepot
	
	
	public StrBufferCorr(int l) {
		lesCaracteres = new char[l];
		n = 0;
	}
	
	public StrBufferCorr() {
		this(16);
	}
	
	public StrBufferCorr(String s) {
		this(16 + s.length());
		for (int i = 0; i < s.length(); i++) {
			lesCaracteres[i] = s.charAt(i);
			
		}
		n = s.length(); // la longeur effective
	}
	
	public int length() {
		return n;
	}
	
	public int capacity() {
		return lesCaracteres.length;
	}
	
	/*
	 * Assure que le tableau lesCaracteres a une taille d’au moins capaciteMin éléments.
	 */
	public void ensureCapacity(int capaciteMin) {
		
		if (lesCaracteres.length >= capaciteMin)
			return;
		
		char[] newCar = new char[capaciteMin];
		for(int i = 0; i < n; i++) {
			newCar[i] = lesCaracteres[i];
		}
		lesCaracteres = newCar;
	}
	
	/*
	 * Modifie la chaîne en lui concaténant la chaîne de caractères s.
	 */
	public StrBufferCorr append(Str_corr s) {
		
		ensureCapacity(n + s.length());
		for (int i = n; i < s.length()+n; i++) {
			lesCaracteres[i] = s.charAt(i - n);
		}
		n = n + s.length();
		return this;
	}
	
	/*
	 * Remplace les caractères de d à f exclu par la chaîne s.
	 */
	public StrBufferCorr replace(int d, int f, String s) {
		int accr = s.length()-f+d;
		ensureCapacity(n + accr);
		
	}
	
	public static void Main() {
		
	}
	
	
}
