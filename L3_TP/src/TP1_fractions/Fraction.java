package TP1_fractions;

import java.util.Arrays;

public class Fraction {
	
	// QUESTION 1
	
	//-------------ATTRIBUTES------------
	
	private int numerateur, denominateur;
	
	//-------------CONSTRUCTORS----------
	
	public Fraction() {
		this(0,1);
	}
	
	public Fraction(int n) {
		this(n,1);
	}
	
	public Fraction(int n, int d) {
		this.numerateur = n;
		this.denominateur = d;
		if (d == 0){
			throw new ArithmeticException("dénominateur nul interdit");
		} else if(d < 0) {
			this.numerateur = - this.numerateur;
			this.denominateur = - this.denominateur;
		}
	}
	// 45/67
	public Fraction(String ch) {
		int iBarre = ch.indexOf("/");
		String numerateur = ch.substring(0, iBarre); // "inclusif", "exclusif"
		String denominateur = ch.substring(iBarre + 1); 
		// until the end when single parameter with substring
		this.numerateur = Integer.parseInt(numerateur);
		this.denominateur = Integer.parseInt(denominateur);
	}

	//------------ACCESSORS--------------
	
	public int getNumerateur() {
		return numerateur;
	}

	public void setNumerateur(int numerateur) {
		this.numerateur = numerateur;
	}

	public int getDenominateur() {
		return denominateur;
	}

	public void setDenominateur(int denominateur) {
		this.denominateur = denominateur;
	}
	
	//------------METHODS----------------

	public String toString() {
		return this.numerateur + "/" + this.denominateur;
	}
	
	public static Fraction valueOf(String ch) {
		return new Fraction(ch);
	}
	
	public int compareTo(Fraction f) {
		if (this.numerateur/this.denominateur < f.numerateur/f.denominateur)
			return -1;
		else if (this.numerateur/this.denominateur == f.numerateur/f.denominateur) 
			return 0;
		
		return 1;
	}
	
	public boolean equals(Object obj) { // use getClass function otherwise
		if (obj instanceof Fraction) {
			Fraction f = (Fraction)obj;
			return (this.numerateur == f.numerateur && this.denominateur == f.denominateur);
		} 
		return false;
	}
	
	
	// Calcul PGCD
	public static int pgcd(int a, int b) {
		if (a % b == 0)
			return b;
		else
			return pgcd(b, a % b);
	}
	
	// Calcul PPCM
	public static int ppcm(int a, int b) {
		return a/pgcd(a, b)*b;
	}
	
	// Addition : n1/d1 + n2/d2 = n/d, où n = n1*p/d1 + n2*p/d2 et d=p, avec p le ppcm de d1et d2,
	public Fraction plus(Fraction f) { //Fraction f1 = new Fraction(); 
		
		int n = (this.numerateur*ppcm(this.denominateur, f.denominateur))/this.denominateur
				          + (f.numerateur*ppcm(this.denominateur, f.denominateur))/f.denominateur;
		int d = ppcm(this.denominateur, f.denominateur);
		
		return new Fraction(n/pgcd(n, d), d/pgcd(n, d));
		
	}
	 
	// Soustraction : n1/d1 − n2/d2 = n/d, où n = n1*p/d1 − n2*p/d2 et d = p, avec p le ppcm de d1 et d2,
	public Fraction moins(Fraction f) { 
		
		int n = (this.numerateur*ppcm(this.denominateur, f.denominateur))/this.denominateur
		          - (f.numerateur*ppcm(this.denominateur, f.denominateur))/f.denominateur;
		int d = ppcm(this.denominateur, f.denominateur);

		return new Fraction(n/pgcd(n, d), d/pgcd(n, d));
		
	  }
	  
	// Multiplication : n1/d1 * n2/d2 = n/d, où n = n1*n2 et d = d1*d2,
	public Fraction fois(Fraction f) {
		
		int n = this.numerateur * f.numerateur;
		int d = this.denominateur * f.denominateur;
	
		return new Fraction(n/pgcd(n, d), d/pgcd(n, d));
	}
	  
	// Division : n1/d1 : n2/d2 = n/d, où n = n1*d2 et d = d1*n2
	public Fraction diviseePar(Fraction f) { 
		
	    if (this.denominateur == 0 || f.denominateur == 0) { 
		    throw new ArithmeticException("denominator == 0"); 
	    } else {
	    	int n = this.numerateur * f.denominateur;
	    	int d = this.denominateur * f.numerateur;
	    	
			return new Fraction(n/pgcd(n, d), d/pgcd(n, d));
	    }
	}
	
	// QUESTION 2
	// 1/2+3/4+5/6=
	
	public static Fraction calcul(String ch) {
		
		// Stocking in Array
		Fraction[] tabFrac = new Fraction[ch.length()];
		char op[] = new char[ch.length()];
		int indFr = 0;
		int indOp = 0;
		int iD = 0;
		int iF = 0;
		while (iF < ch.length()) {
			if (ch.charAt(iF) == '+' || ch.charAt(iF) == '-' || ch.charAt(iF) == '*' || ch.charAt(iF) == ':' || ch.charAt(iF) == '=') {
				tabFrac[indFr] = Fraction.valueOf(ch.substring(iD, iF));
				indFr++;
				iD = iF + 1; // attention on prend à partir de l'indice suivant.
				if (ch.charAt(iF) != '=') {
				op[indOp] = ch.charAt(iF);
				indOp++;
				}
			}
			iF++;
		}
		tabFrac = Arrays.copyOfRange(tabFrac, 0, indFr);
		op = Arrays.copyOfRange(op, 0, indOp);
		//System.out.println("tab Fraction: " + Arrays.toString(tabFrac));
		//System.out.println("tab Operateurs:" + Arrays.toString(op));
		
		// Calculating
		for (int i = 0, j = 0; i < tabFrac.length && j < op.length; i++, j++) {
			if (op[j] == '+') {
				tabFrac[i+1] = tabFrac[i].plus(tabFrac[i+1]);		
			}
			else if(op[j] == '-') {
				tabFrac[i+1] = tabFrac[i].moins(tabFrac[i+1]);	
			}
			else if(op[j] == '*') {
				tabFrac[i+1] = tabFrac[i].fois(tabFrac[i+1]);	
			}
			else if(op[j] == ':') {
				tabFrac[i+1] = tabFrac[i].diviseePar(tabFrac[i+1]);	
			}
		}
		//System.out.println(Arrays.toString(tabFrac)); // accumulated table
		//System.out.println(tabFrac[tabFrac.length-1]);
		return tabFrac[tabFrac.length-1];
	}
	
	// QUESTION 3
	
	// Notation égyptienne: https://fr.wikipedia.org/wiki/Fraction_égyptienne
	
	public static String elementaire(String ch) { // mettre les fractions / en print
		
		Fraction f = new Fraction(ch);
		int a = f.numerateur;
		int b = f.denominateur;
		
		if (f.numerateur == 1) {
			return String.valueOf(f);
		}
		return String.valueOf(new Fraction(1, b)) + 
				'+' + elementaire(String.valueOf(new Fraction(a - 1, b + 1))) +
				'+' + elementaire(String.valueOf(new Fraction(a - 1, b * (b + 1))));
		//--OR--
		/*
		return new Fraction(1, b).toString() + '+' 
				+ elementaire(new Fraction(a - 1, b + 1).toString()) + '+'
				+ elementaire(new Fraction(a - 1, b * (b + 1)).toString());
		*/
		
	}

	
	// There's the '=' sign in the end
	public static String egypFrac(String ch) {
		
		// extracting the String excepted the last caracter
		String ch2 = "";
		for (int i = 0; i < ch.length()-1; i++) {
			ch2 = ch2 + ch.charAt(i);
		}

		return elementaire(ch2);
	}
	
}
