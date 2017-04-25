package biblio.test;

import biblio.metier.Livre;

/**
 * @author V.Vrillaud
 *
 */
public class TestLivre {

	public static void main(String[] args) {
		
		Livre l1 = new Livre();
		System.out.println("Test Livre sans paramètre:\n" + "\t" + l1);
		
		Livre l2 = new Livre("105104");
		System.out.println("Test Livre à 1 paramètre:\n" + "\t" + l2);
		
		Livre l3 = new Livre("105104", "Le Horla");
		System.out.println("Test Livre à 2 paramètres:\n" + "\t" + l3);
		
		Livre l4 = new Livre("105104", "Le Horla", "10");
		System.out.println("Test Livre à 3 paramètres:\n" + "\t" + l4);
		
		Livre l5 = new Livre("105104", "Le Horla", "10", 1852);
		System.out.println("Test Livre à 4 paramètres:\n" + "\t" + l5);
		
		Livre l6 = new Livre("105104", "Le Horla", "10", 1852, 250);
		System.out.println("Test Livre à 5 paramètres:\n" + "\t" + l6);
		
		Livre l7 = new Livre("105104", "Le Horla", "10", 1852, 250, 20010);
		System.out.println("Test Livre à 6 paramètres:\n" + "\t" + l7);
	
	}

}