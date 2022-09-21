package TP1_fractions;

public class Main {
  
	
	public static void main(String[] args) {
		
		
		//System.out.println(new Fraction());
		
		
		
		Fraction f1 = new Fraction(9, 18);
		Fraction f2 = new Fraction("9/8");
		
		//System.out.println(f2.getNumerateur()); erreur dans 3e constructeur: le numérateur sort négatif aussi
		
		//System.out.println(f1.fois(f2));
		
		/*
		// Test comparedTo()
		System.out.println(f1.compareTo(f2));
		
		// Test equals()
		System.out.println(f1.equals(f2));
		
		// Test valueOf()
		System.out.println(Fraction.valueOf("97/76"));
		
		// Test PGCD
		System.out.println(f2.pgcd(9, 18));
		
		
		// Test operations
		System.out.println(f1.plus(f2));
		System.out.println(f1.moins(f2));
		System.out.println(f1.fois(f2));
		System.out.println(f1.diviseePar(f2));
		
		//Fraction f3 = null;
		
		*/
		
		
		// Test calcul()
		System.out.println(Fraction.calcul("14/34+123/321*5/6="));
		
		
		//String s = Fraction.egypFrac("1/198=");
		
		//System.out.println(Fraction.egypFrac("3/5="));
		
		//System.out.println(Fraction.elementaire("10/198"));
		
		
		
		
		
	
		
		

	}

}
