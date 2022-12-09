package huffman;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Huffman {
	private Map<Character, String> dictionnaire;
	private NoeudAbstrait arbre;

	public Huffman(String texte) {
		if (texte == null)
			throw new IllegalArgumentException("null interdit");
		Map<Character, Integer> comptes = compteCaracteres(texte);
		if (comptes.size() < 2)
			throw new IllegalArgumentException("le texte de r�f�rence doit au moins contenir 2 caract�res diff�rents.");
		initArbre(comptes);
		initDictionnaire();
	}

	private Map<Character, Integer> compteCaracteres(String texte) {
		Map<Character, Integer> comptes = new TreeMap<Character, Integer>();
		for (int i = 0; i < texte.length(); i++) {
			char c = texte.charAt(i);
			if (comptes.containsKey(c))
				comptes.put(c, comptes.get(c) + 1);
			else
				comptes.put(c, 1);
		}
		return comptes;
	}

	private void initArbre(Map<Character, Integer> comptes) {
		ListeTriee l = new ListeTriee();
		for (Character c : comptes.keySet())
			l.add(new Feuille(c, comptes.get(c)));
		while (l.size() > 1) {
			NoeudAbstrait n1 = l.removeFirst();
			NoeudAbstrait n2 = l.removeFirst();
			l.add(new Noeud(n1.getPoids() + n2.getPoids(), n1, n2));
		}
		arbre = l.removeFirst();
	}

	private void initDictionnaire() {
		dictionnaire = new TreeMap<Character, String>();
		arbre.fournitCodes(dictionnaire, "");
	}

	public NoeudAbstrait getArbre() {
		return arbre;
	}

	public Map<Character, String> getDictionnaire() {
		return dictionnaire;
	}

	public String code(String texte) throws CaractereInconnuException {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < texte.length(); i ++) {
			char c = texte.charAt(i);
			if (! dictionnaire.containsKey(c))
				throw new CaractereInconnuException("" + c);
			sb.append(dictionnaire.get(c));
		}
		return sb.toString();
	}

	public String decode(String texte) throws FinDeTexteInattendueException {
		StringBuffer sb = new StringBuffer();
		while (texte.length() > 0) {
			Character c = arbre.getNextChar(texte);
			sb.append(c);
			texte = texte.substring(dictionnaire.get(c).length());
		}
		return sb.toString();
	}

	public String toString() {
		return "Codage Huffman de dictionnaire : " + dictionnaire;
	}

	public Huffman difference(Huffman h) throws RuntimeException{
		//TODO Question 1
		Map<Character, Integer> mapPoids1 = new TreeMap<Character, Integer>();
		getArbre().fournitPoids(mapPoids1);

		Map<Character, Integer> mapPoids2 = new TreeMap<Character, Integer>();
		h.getArbre().fournitPoids(mapPoids2);


		for(Character c : mapPoids1.keySet()) {
			if(mapPoids1.containsKey(c) && mapPoids2.containsKey(c)) {
				if(mapPoids1.get(c) < mapPoids2.get(c)) {
					throw new RuntimeException ("Le poids ne peut pas être négatif.");
				}
				if (mapPoids1.get(c) > mapPoids2.get(c)) {
					mapPoids1.put(c, mapPoids1.get(c) - mapPoids2.get(c));
				}
			}
		}

		Huffman newHuffman = new Huffman("20");
		newHuffman.initArbre(mapPoids1);
		newHuffman.initDictionnaire();
		return newHuffman;

	}

	public static void main(String[] args) {
		Huffman h1 = new Huffman("bonbon");
		Huffman h2 = new Huffman ("bon");
		System.out.println(h1);
 		System.out.println(h1.difference(h2));
 		System.out.println(h2);
		try {
			System.out.println(h1.code("abracadabra-baccara"));
			System.out.println(h1.decode("0101111011001001010111101000101011011001110"));
		} catch (CaractereInconnuException e) {
			e.printStackTrace();
		} catch (FinDeTexteInattendueException e) {
			e.printStackTrace();
		}

	}

}
