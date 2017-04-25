package biblio.test;

import static biblio.metier.Personne.sdf;
import java.text.ParseException;
import biblio.metier.Utilisateur;

/**
 * Classe de tests Utilisateur
 * @author V.Vrillaud
 */
public class TestUtilisateur {
	
	public static void main(String[] args) throws ParseException {
	
		Utilisateur u1 = new Utilisateur();
		System.out.println("Test Utilisateur sans paramètre:\n" + "\t" + u1);
		
		Utilisateur u2 = new Utilisateur("Her", "Xavier", sdf.parse("18/10/1969"), 'H');
		System.out.println("Test Utilisateur à 4 paramètres:\n" + "\t" + u2);
		
		Utilisateur u3 = new Utilisateur("Plumain", "Vincent", sdf.parse("28/09/1980"), 'H', 514871);
		System.out.println("Test Utilisateur à 5 paramètres:\n" + "\t" + u3);
		
		Utilisateur u4 = new Utilisateur("Gandon", "Sylvie", sdf.parse("01/01/1974"), 'F', 125014, "bibi");
		System.out.println("Test Utilisateur à 6 paramètres:\n" + "\t" + u4);
		
		Utilisateur u5 = new Utilisateur("Salin", "Samuel", sdf.parse("25/12/1984"), 'H', 800100, "zouzou", "ss");
		System.out.println("Test Utilisateur à 7 paramètres:\n" + "\t" + u5);
	
	}

}