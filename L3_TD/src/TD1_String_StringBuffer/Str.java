package TD1_String_StringBuffer;

import java.util.Arrays;

public class Str extends Object {

private char[] lesCaracteres;
	
	// Question 1.1

	/*
	 * Permet d'obtenir la chaine vide
	 */
	public Str() {
		
		
		this.lesCaracteres = new char[1];
		this.lesCaracteres[0] = ' ';
		
		
		
		// Arrays.toString(this.lesCaracteres);
		
		
		//----    OU    -----
		/*
		String chString = "";
		this.lesCaracteres = new char[chString.length()];
		for (int i = 0; i < lesCaracteres.length; i++) {
			this.lesCaracteres[i] = ' ';
			//chString = chString + this.lesCaracteres[i];
		}
		*/
		
		
		//Arrays.toString(this.lesCaracteres);
		// CORRECTION
		this.lesCaracteres = new char[0];
	}
	
	/*
	 *  Permet d’obtenir une chaîne de caractères à partir d’une partie du tableau de caractères tab, 
	 *  commençant en d et finissant en f. Le caractère d’indice f est exclu.
	 */ 
	public Str(char[] tab, int d, int f) {
		
		this.lesCaracteres = Arrays.copyOfRange(tab, d, f);
	}
	
	
	public Str(Str ch) {
		
		if (ch == null)
			throw new NullPointerException("Pas de chaine");
		
		this.lesCaracteres = new char[ch.length()];
		for (int i = 0; i < ch.length(); i++) {
			this.lesCaracteres[i] = ch.charAt(i);
		}
	}
	
	
	public String toString() {
		//return this.lesCaracteres.toString();
		
		String chString = "";
		for (int i = 0; i < this.lesCaracteres.length; i++) {
			chString += this.lesCaracteres[i];
		}
		return chString;
		
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
	public Str substring(int d, int f) {
		return (new Str(lesCaracteres, d, f));
	}
	
	// Retourne la sous-chaîne depuis l’indice d jusqu’à la fin.
	public Str substring(int d) {
		return (new Str(lesCaracteres, d, lesCaracteres.length));
	}
	
	// Compare this à s. Renvoie une valeur négative, nulle ou positive. 
	// La comparaison est une comparaison lexicographique.
	public int compareTo(Str s) {
		int lim = Math.min(this.length(), s.length());
		for (int i = 0; i < lim; i++) {
			if (this.lesCaracteres[i] != s.lesCaracteres[i])
				return this.lesCaracteres[i] - s.lesCaracteres[i];
			/*
			if (this.charAt(i) > s.charAt(i))
				return 1;
			else if (this.charAt(i) < s.charAt(i));
				return -1;
			*/
		}
		return this.lesCaracteres.length - s.lesCaracteres.length;
	}
	
	// Compare la chaîne à un objet et retourne true en cas d’égalité, false sinon. --> à voir
	
	public boolean equals(Object obj) {
		
		return (obj instanceof Str) && this.compareTo((Str)obj) == 0;
		
		/*
		if (obj instanceof Str) {
			Str s = (Str)obj;
			if (lesCaracteres.length == s.length()) {
				for (int i = 0; i < s.length(); i++) {
					if (lesCaracteres[i] != s.charAt(i))
						return false;
				}
				return true;
			}
		}
		return false;
		*/
	}
	
	
	// Renvoie true si et seulement si prefixe est un préfixe de la chaîne.
	
	public boolean startsWith(Str prefixe) { // C'et bizarre !
		return prefixe.equals(this.substring(0, prefixe.length()));
		//return (prefixe.equals(new Str(lesCaracteres, 0, prefixe.length())));
	}
	
	
	// Question 1.3
	
	// Retourne la représentation en chaîne du booléen b.
	public static Str valueOf(boolean b) {
		
		if (b) {
			return new Str(new char[]{'t', 'r', 'u', 'e'}, 0, 4);
		}
		return new Str(new char[]{'f', 'a', 'l', 's', 'e'}, 0, 5);
		
			//return valueOf((char) b);
	
		 // récursivité infinie ! --> error stackoverflow
	}
	
	// Retourne la représentation en chaîne du caractère c.
	public static Str valueOf(char c) {
		return new Str(new char[]{c}, 0, 1);
		//return Character.toString(c);
		
	}
	
	// Retourne la représentation en chaîne de l’entier i. 
	public static Str valueOf(int i) {
		
		int q, r, cmpt = 0;
		char[] tab = new char[cmpt];
		while (i > 0) {
			 q = i/10;
			 r = i%10;
			 cmpt++;
			 tab = Arrays.copyOf(tab, cmpt);
			 tab[cmpt-1] = (char)(r + 48);
			 i = q; // i prend la valeur de q
		}
		// inverse le tableau
		for (int l = 0; l < tab.length/2; l++) {
        	char tmp = tab[l];
        	tab[l] = tab[tab.length-l-1];
        	tab[tab.length-l-1] = tmp;
        }
		return new Str(tab, 0, tab.length);
		
	}
}