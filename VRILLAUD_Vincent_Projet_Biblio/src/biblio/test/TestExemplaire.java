package biblio.test;

import static biblio.metier.Personne.sdf;
import java.text.ParseException;
import biblio.metier.EnumStatusExemplaire;
import biblio.metier.Exemplaire;

/**
 * Classe de tests Exemplaire
 * @author V. Vrillaud
 */
public class TestExemplaire {

	public static void main(String[] args) throws ParseException {

		Exemplaire ex1 = new Exemplaire();
		System.out.println("** Test Exemplaire sans paramètre **\n" + "\t" + ex1);
		
		Exemplaire ex2 = new Exemplaire(1);
		System.out.println("** Test Exemplaire à 1 paramètre **\n" + "\t" + ex2);
		
		Exemplaire ex3 = new Exemplaire(1, sdf.parse("25/12/1984"));
		System.out.println("** Test Exemplaire à 2 paramètres **\n" + "\t" + ex3);
		
		Exemplaire ex4 = new Exemplaire(1, sdf.parse("25/12/1984"), EnumStatusExemplaire.SUPPRIME);
		System.out.println("** Test Exemplaire à 3 paramètres **\n" + "\t" + ex4);
		
		Exemplaire ex5 = new Exemplaire(1, sdf.parse("25/12/1984"), EnumStatusExemplaire.SUPPRIME, "105004");
		System.out.println("** Test Exemplaire à 4 paramètres **\n" + "\t" + ex5);
	
	}
	
}