package TD1_String_StringBuffer;

import java.util.Arrays;


public class Test {

	public static void main(String[] args) {
		
		String ch1;
		char[] carac1 = {'1', '2', '3', '4'};
		/*
		for (int i = 0; i < carac1.length; i++) {
			carac1[i] = ' ';
			ch1 += carac1[i];
			//System.out.println(carac[i]);
		}
		*/
		
		ch1 = Arrays.toString(carac1);
		
		
		System.out.println("ICI C'EST " + ch1.substring(ch1.length()-1) + " VIDE");
		//System.err.println("ICI C'EST" + ch1 + "STRING VIDE ");
		
		String ch2 = "ABCD";
		char [] carac2 = new char[ch2.length()];
		for (int i = 0; i < ch2.length(); i++) {
			carac2[i] = ch2.charAt(i); 
		}
		System.out.println("Tableau de la chaine " + ch2 + " : " + Arrays.toString(carac2));
		
		String ch3 = "TUTU";
		String ch4 = "TUTUE";
		if (ch3.equals(ch4.substring(0, ch3.length())))
// 		return (prefixe.equals(this.substring(0, prefixe.length())));
			
			System.out.println(true);
		else 
			System.out.println(false);
		
		boolean b = true;
		String c5 = "";
		String c6 = c5+b;
		//System.out.println(c5+b);
		System.out.println("Concaténation bool et chaine : " + c6);
		
		int n = 1234;
		int unite, dizaine, centaine, millier;
		
		unite = n%10;
		dizaine = n/10%10;
		centaine = n/100%10;
		millier = n/1000%10;
		System.out.println("This is char unity:" + unite);
		System.out.println((char)dizaine);
		System.out.println(centaine);
		System.out.println(millier);
		System.out.println();
		System.out.println(8 + ' ');

		char[] ch7 = {'1', '2', '3'};
		char[] ch8 = {'4', '5', '6'};
		 
		


        int[] arr = new int[]{1,2,3,4,5,6,7,8};
        int[] arr_new = new int[arr.length-1];
        int j=3;
        for(int i=0, k=0;i<arr.length;i++){
            if(i != j){
                arr_new[k]=arr[i];
                k++;
            }
        }
        System.out.println("Before deletion :" + Arrays.toString(arr));
        System.out.println("After deletion :" + Arrays.toString(arr_new));

        
        int cmt=0;
        
        int n1 = 128;
        int i=0;
        System.out.println("1/10 : " + 1/10);
        while (n1 > 0) {
            int d = n1 / 10;
            int k = n1 % 10; // k = n1 - d * 10
            cmt++;
            n1 = d;
        }
        n1 = 128;
        char[]tab = new char[cmt];
        while (n1 > 0) {
            int d = n1 / 10;
            int k = n1 % 10; // k = n1 - d * 10
            cmt++;
            n1 = d;
            
           	tab[i] = (char)(k + '0');//Character.forDigit(k, 10); // 
           	System.out.println("LALA : " + Arrays.toString(tab));
           	System.out.println("Test");
         	i++;
        }
             
            System.out.println(Arrays.toString(tab));
             //System.out.println(k);
           
    }
        
        
        
        
        /*
        n1 = 128;
        char[]tab = new char[cmt];
        while (n1 > 0) {
          int d = n1 / 10;
          int k = n1 % 10; // k = n1 - d * 10
          n1 = d;
          System.out.println("JE COMPTE : " + cmt);
          System.out.println(n1+"TEST N1");
          System.out.println(tab.length);
          for (int i=0; i<cmt; i++) {
        	 tab[i] = (char)(k + '0');//Character.forDigit(k, 10); // 
        	 System.out.println("LALA : " + Arrays.toString(tab));
        	 System.out.println("Test");
      		
          }
          
         
          System.out.println(k);
        }
        */
        

        
	

}
