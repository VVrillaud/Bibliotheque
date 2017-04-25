package biblio.test;

import static biblio.metier.Personne.sdf;
import java.text.ParseException;
import biblio.exception.BiblioException;
import biblio.metier.EmpruntEnCours;
import biblio.metier.EnumStatusExemplaire;
import biblio.metier.Exemplaire;
import biblio.metier.Utilisateur;

/**
 * @author V.Vrillaud
 *
 */
public class TestEmpruntEnCours {
	
	public static void main(String[] args) throws ParseException {
		
		Utilisateur u6 = new Utilisateur("A","A",null,'H');
		System.out.println("** Utilisateur emprûnteur n°1 **");
		System.out.println("\t" + u6 + "\n");
		
		Exemplaire ex1 = new Exemplaire(1,sdf.parse("12/07/2015"),EnumStatusExemplaire.DISPONIBLE,"125");
		System.out.println("** Exemplaire avant emprûnt **");
		System.out.println("\t" + ex1 + "\n");
		
		EmpruntEnCours empc1;
		System.out.println("** Simulation d'un emprûnt de cet exemplaire disponible par cet emprûnteur n°1 **");
		
		try {
			empc1 = new EmpruntEnCours(u6, ex1, sdf.parse("25/01/2016"));
			System.out.println("\t" + empc1 + "\n");
			System.out.println("** EmprûntEnCours ---> Exemplaire **");
			System.out.println("\t" + empc1.getExemplaire() + "\n");
		} catch (BiblioException e) {
			System.out.println("\t" + "Emprûnt impossible: " + e.getMessage() + "\n");
		}
		
		System.out.println("** Exemplaire ---> EmprûntEnCours **");
		System.out.println("\t" + ex1.getEmpruntEnCours() + "\n");
		
		EmpruntEnCours empc2;
		System.out.println("** Simulation d'un emprûnt avec cet exemplaire prêté et cet emprûnteur n°1 **");
		
		try {
			empc2 = new EmpruntEnCours(u6, ex1, sdf.parse("25/01/2016"));
			System.out.println("\t" + empc2 + "\n");
		} catch (BiblioException e) {
			System.out.println("\t" + "Emprûnt impossible: " + e.getMessage() + "\n");
		}
		
		Utilisateur u7 = new Utilisateur("B","B",null,'F');
		System.out.println("** Utilisateur emprûnteur n°2 **");
		System.out.println("\t" + u7 + "\n");
		
		EmpruntEnCours empc3;
		System.out.println("** Simulation d'un emprûnt avec cet exemplaire prêté et cet emprûnteur n°2 **");
		
		try {
			empc3 = new EmpruntEnCours(u7, ex1, sdf.parse("25/01/2016"));
			System.out.println("\t" + empc3 + "\n");
		} catch (BiblioException e) {
			System.out.println("\t" + "Emprûnt impossible: " + e.getMessage() + "\n");
		}
	
	}

}