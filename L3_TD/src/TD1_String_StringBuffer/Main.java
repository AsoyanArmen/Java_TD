package TD1_String_StringBuffer;


public class Main {

	public static void main(String[] args) {
		
		
		char[] tab1 = {'A', 'A', 'A', 'A', 'e', 'f'}; 
		char[] tab2 = {'A', 'B', 'A', 'A', 'e', 'f'}; 
		
		
		// test 1er constructeur 
		Str s1 = new Str();
		System.out.println(s1);

		// test 2e constructeur 
		
		//Str s2 = new Str(tab1, 0, 4);
		//System.out.println(s2);
		
		
		// test 3e constructeur 
		Str s4 = new Str(new Str(new char[] {'R'},0,1));
		System.out.println(s4);
		
		
		/*
		 *  test METHODES:
		 */
		
		Str s2 = new Str(tab1, 0, 4);
		Str s3 = new Str(tab2, 0, 4);
		
		System.out.println("Sur " + s2 + " : ");
		
		// test charAt()
		System.out.println("Test charAt() : " + s2.charAt(s2.length()-1));
		
		// test length()
		System.out.println("Test length() : " + s2.length());
		
		// test substring(int d, int f)
		System.out.println("Test substring(int d, int f) : " + s2.substring(0, 1));
		
		// test substring(int d)
		System.out.println("Test substring(int d) : " + s2.substring(1));
		
		// test compareTo(String s)
		System.out.println("Test compareTo(String s) : " + s3.compareTo(s4));
		
		// test equals(object obj)
		// System.out.println(s2.equals(s4)); --> Error Stack Overflow
		
		// test startswith(String prefixe)
		System.out.println("Test startsWith(String s) : " + s2.startsWith(s3)); // --> c'est bizarre , pourquoi false ?
		
		
		//test valueOf(boolean b)
		System.out.println("Value of():" + Str.valueOf(true) + "+");
		
		//test valueOf(char c)
		System.out.println("Value of():" + Str.valueOf('c') + "+");
		
		//test valueOf(int i)
		System.out.println("Value of():" + Str.valueOf(9) + "+");
		
		
		
		
		
		
		
		//Str s2 = new Str(tab, 0, 1);
		//System.out.println(s2);
		//s.valueOf(false)
		//System.out.println(s);
		//char[] tab = {'a', 'b', 'c'};
		
		


		


	}

}
