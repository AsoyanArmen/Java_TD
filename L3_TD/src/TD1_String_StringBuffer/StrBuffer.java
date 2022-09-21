package TD1_String_StringBuffer;


public class StrBuffer extends Object {
	
	private char[] lesCaracteres;
	private int n;
	
	// Question 2.1
	
	// Permet d’obtenir une instance représentant la chaîne vide, avec un tampon de l caractères.
	public StrBuffer(int l) {
		this.n = l;
		this.lesCaracteres = new char[n];
		//this.lesCaracteres = Arrays.copyOf(lesCaracteres, n);
	}
	
	/*
	 * Permet d’obtenir une instance représentant la chaîne vide,
	 * avec un tampon de 16 caractères.
	 */
	public StrBuffer() {
		this.n = 16;
		this.lesCaracteres = new char[n];
	}
	
	/*
	 * Permet d’obtenir une instance représentant la chaîne str,
	 * avec un tampon de str.length()+16 caractères.
	 */
	public StrBuffer(Str str) {
		this.n = str.length()+16;
		this.lesCaracteres = new char[n];
	}
	
	
	// Question 2.2
	
	/*
	 * Retourne le nombre de caractères de la chaîne.
	 */
	public int length() {
		return this.lesCaracteres.length;
	}
	
	/*
	 * Retourne la capacité du tampon.
	 */
	public int capacity() {
		return this.n;
	}
	
	/*
	 * Assure que le tableau lesCaracteres a une taille
	 * d’au moins capaciteMin éléments.
	 */
	public void ensureCapacity(int capaciteMin) {
		
		this.lesCaracteres = new char[capaciteMin + this.n];
	}
	
	/*
	 * Modifie la chaîne en lui concaténant la chaîne de
	 * caractères s.
	 * 
	*/
	 
	public StrBuffer append(Str s) {
		
		this.lesCaracteres = new char[lesCaracteres.length + s.length()];
		for (int i = lesCaracteres.length - s.length(); i < lesCaracteres.length; i++) {
			lesCaracteres[i] = s.charAt(i);
		}
		
		return new StrBuffer(lesCaracteres.length);
	}
	
	/*
	 * Remplace les caractères de d à f exclu par la chaîne s.
	 */
	public StrBuffer replace(int d, int f, Str s) {
		
		for (int i = d; i < f; i++) 
			lesCaracteres[i] = s.charAt(i);
		
		return new StrBuffer(lesCaracteres.length);
	}
	
	
	public StrBuffer delete(int d, int f) {
		char[] newArray = new char[lesCaracteres.length+(f-d)];
		for (int i = 0, k = 0; i < f; i++) {
			if (i < d && i > f) {
				newArray[k] = lesCaracteres[i];
				k++;
			}
		}
		return new StrBuffer(newArray.length);
	}
	
	
	public StrBuffer insert(int d, String s) {
		char[] newArray = new char[lesCaracteres.length + s.length()];
		for (int i = 0, k = 0; i < lesCaracteres.length; i++) {
			if (i != d) {
				newArray[k] = lesCaracteres[i];
				k++;
			} else {
				newArray[k] = s.charAt(i);
				k++;
			}
		}
		return new StrBuffer(newArray.length);
	}
	
}
