package biblio.test;

import java.text.ParseException;
import biblio.control.MyArrayList;
import biblio.dao.ConnectionFactory;
import biblio.dao.EmpruntEnCoursDao;
import biblio.dao.ExemplaireDao;
import biblio.dao.UtilisateurDao;
import biblio.exception.BiblioException;
import biblio.metier.EmpruntEnCours;
import biblio.metier.Exemplaire;
import biblio.metier.Utilisateur;

/**
 * @author V.Vrillaud
 *
 */
public class TestEmpruntEnCoursDao {

	public static void main(String[] args) throws BiblioException, ParseException {

		ConnectionFactory cnxfct = new ConnectionFactory();
		EmpruntEnCoursDao empcDao = new EmpruntEnCoursDao(cnxfct.getConnection());
		UtilisateurDao utDao = new UtilisateurDao(cnxfct.getConnection());
		ExemplaireDao exDao = new ExemplaireDao(cnxfct.getConnection());
		EmpruntEnCours empc = null;
		MyArrayList<EmpruntEnCours> listeEmpc;

		System.out.println("** Test d'insertion d'un emprûnt disponible (ex. n°2) **");
		
		try {

			Utilisateur emp1 = utDao.findUtilisateurByKey(1);
			System.out.println("\t" + emp1);

			Exemplaire ex2 = exDao.findExemplaireByKey(2);
			System.out.println("\t" + ex2);

			empcDao.insertEmpruntEnCours(emp1, ex2);
			
			System.out.println("\t" + "---> Emprûnt inséré");

		} catch (BiblioException e) {
			System.out.println("\t" + "---> Erreur de recherche: " + e.getMessage());
		}
		
		System.out.println("");
		System.out.println("** Test d'insertion d'un emprûnt avec un autre emprûnteur sur le même exemplaire **");
		empcDao = new EmpruntEnCoursDao(cnxfct.getConnection());
		
		try {

			Utilisateur emp2 = utDao.findUtilisateurByKey(2);
			System.out.println("\t" + emp2);

			Exemplaire ex2 = exDao.findExemplaireByKey(2);
			System.out.println("\t" + ex2);

			empcDao.insertEmpruntEnCours(emp2, ex2);

		} catch (BiblioException e) {
			System.out.println("\t" + "---> Erreur de recherche: " + e.getMessage());
		}
		
		System.out.println("");
		System.out.println("** Test d'insertion d'un emprûnt avec un exemplaire prêté (ex. n°3) **");
		
		try {

			Utilisateur emp2 = utDao.findUtilisateurByKey(2);
			System.out.println("\t" + emp2);

			Exemplaire ex3 = exDao.findExemplaireByKey(3);
			System.out.println("\t" + ex3);

			empcDao.insertEmpruntEnCours(emp2, ex3);

		} catch (BiblioException e) {
			System.out.println("\t" + "---> Erreur de recherche: " + e.getMessage());
		}
		
		System.out.println("");
		System.out.println("** Test d'insertion d'un emprûnt avec le même emprûnteur sur un exemplaire disponible (ex. n°4) **");
		
		try {

			Utilisateur emp2 = utDao.findUtilisateurByKey(2);
			System.out.println("\t" + emp2);

			Exemplaire ex4 = exDao.findExemplaireByKey(4);
			System.out.println("\t" + ex4);

			empcDao.insertEmpruntEnCours(emp2, ex4);
			
			System.out.println("\t" + "---> Emprûnt inséré");

		} catch (BiblioException e) {
			System.out.println("\t" + "---> Erreur de recherche: " + e.getMessage());
		}

		System.out.println("");
		System.out.println("** Test FindEmpruntEnCoursByKey **");
		System.out.println("dispo (ex. n°8)");
		empcDao = new EmpruntEnCoursDao(cnxfct.getConnection());
		
		try {

			empc = empcDao.findEmpruntEnCoursByKey(8);
			System.out.println("\t" + empc);

		} catch (BiblioException e) {
			System.out.println("\t" + "---> Erreur de recherche: " + e.getMessage());
		}
		
		System.out.println("prêté (ex. n°1)");
		
		try {

			empc = empcDao.findEmpruntEnCoursByKey(1);
			System.out.println(empc);

		} catch (BiblioException e) {
			System.out.println("\t" + "---> Erreur de recherche: " + e.getMessage());
		}
		
		System.out.println("hors BDD (ex. n°0)");
		
		try {

			empc = empcDao.findEmpruntEnCoursByKey(0);
			System.out.println(empc);

		} catch (BiblioException e) {
			System.out.println("\t" + "---> Erreur de recherche: " + e.getMessage());
		}
		
		System.out.println("");
		System.out.println("** Test FindAllEmpruntsEnCoursByUtilisateur **");
		empcDao = new EmpruntEnCoursDao(cnxfct.getConnection());
		Utilisateur emp1 = utDao.findUtilisateurByKey(1);
		Exemplaire ex5 = exDao.findExemplaireByKey(5);
		Exemplaire ex7 = exDao.findExemplaireByKey(7);
		
		try {

			empcDao.insertEmpruntEnCours(emp1, ex5);
			empcDao = new EmpruntEnCoursDao(cnxfct.getConnection());
			empcDao.insertEmpruntEnCours(emp1, ex7);
			empcDao = new EmpruntEnCoursDao(cnxfct.getConnection());
			listeEmpc = empcDao.findAllEmpruntsEnCoursByUtilisateur(utDao.findUtilisateurByKey(1));
			System.out.println(listeEmpc);

		} catch (BiblioException e) {
			System.out.println("\t" + "---> Erreur de recherche: " + e.getMessage());
		}
		
	}

}