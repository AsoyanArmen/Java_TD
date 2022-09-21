package TD1_String_StringBuffer;

import java.util.Arrays;

public class Str_corr extends Object{

	private char[]lesCaracteres;
	private static final String CHAINE_TRUE = new Str_corr(new char[]{'t', 'r', 'u', 'e'}, 0, 4);
	private static final  String TAB_VIDE = new char[0];
	
	// Permet d’obtenir la chaîne vide.
	public Str_corr() {
		lesCaracteres = new char[0];
	}
	
	/*
	 *  Permet d’obtenir une chaîne de caractères à partir d’une partie du
	 *  tableau de caractères tab, commençant en d et finissant en f. Le
	 *  caractère d’indice f est exclu.
	 */
	public Str_corr(char[]tab, int d, int f) {
		lesCaracteres = Arrays.copyOfRange(tab, d, f);
		
		// OU
		
		if (d < 0 || d > f || f > tab.length){
			throw new ArrayIndexOutOfBoundsException();
		}
		lesCaracteres = new char[f-d];
		for (int i = d; i < f; i++) {
			lesCaracteres[i-d]= tab[i]; // on commence à l'indice 0 du tableau
		}
	}
	
	
	public Str_corr(Str_corr s) {
		/*
		lesCaracteres = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			lesCaracteres[i] = s.lesCaracteres[i];
		}
		*/
		
		// OU
		
		this.lesCaracteres = s.lesCaracteres; // les caractères de String sont immuables
	}
	
	// Question 1.2
	
		// Retourne le caractère d’indice i
	public char charAt(int i) {
		if (i < 0 || i >= lesCaracteres.length) {
			throw new StringIndexOutOfBoundsException(i);
		}
		return lesCaracteres[i];
	}
	
	// Retourne la longueur de la chaîne (nombre de caractères).
	public int length() {
		return lesCaracteres.length;
	}
	
	// Retourne la sous-chaîne depuis d jusqu’à f exclu.
	public Str_corr substring(int d, int f) {
		return (new Str_corr(lesCaracteres, d, f));
	}
	
	// Retourne la sous-chaîne depuis l’indice d jusqu’à la fin.
	public Str_corr substring(int d) {
		return (new Str_corr(lesCaracteres, d, lesCaracteres.length));
	}
	
	public int compareTo(Str_corr s) {
		int lMin = length() < s.length() ? length(): s.length();
		for (int i = 0; i < lMin; i++){
			if (lesCaracteres[i] != s.lesCaracteres[i]) {
				return lesCaracteres[i] - s.lesCaracteres[i];
			}
		}
		return lesCaracteres.length - s.lesCaracteres.length; // la longueur
	}
	
	public boolean equals(Object obj) {
		return (obj instanceof Str_corr) && this.compareTo((Str_corr)obj) == 0;
	}
	
	
	// Renvoie true si et seulement si prefixe est un préfixe de la chaîne.
	
		public boolean startsWith(Str_corr prefixe) { // C'et bizarre !
			if (prefixe.lesCaracteres.length > lesCaracteres.length)
				return false;
			for (int i = 0; i < prefixe.lesCaracteres.length; i++) {
				if (lesCaracteres[i] != prefixe.lesCaracteres[i])
					return false;
			}
			return true;//return (prefixe.equals(new Str(lesCaracteres, 0, prefixe.length())));
		}
	
	// Question 1.3
	
	// Retourne la représentation en chaîne du booléen b.
	public static Str valueOf(boolean b) {
		/*
		if (b) {
			return new Str(new char[]{'t', 'r', 'u', 'e'}, 0, 4);
		}
		return new Str(new char[]{'f', 'a', 'l', 's', 'e'}, 0, 5);
		*/
		return b? CHAINE_TRUE: CHAINE_FALSE;
	}
	
	
	public static Str valueOf(char c) {
		
	}

}
