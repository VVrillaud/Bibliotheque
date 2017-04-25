package biblio.test;

import biblio.dao.ConnectionFactory;
import biblio.dao.UtilisateurDao;
import biblio.exception.BiblioException;
import biblio.metier.Utilisateur;

/**
 * @author V.Vrillaud
 *
 */
public class TestUtilisateurDao {

	public static void main(String[] args) {

		ConnectionFactory cnxfct = new ConnectionFactory();
		UtilisateurDao utDao = new UtilisateurDao(cnxfct.getConnection());

		/* Test sur idUtilisateur=1 */
		System.out.println("** Test sur idUtilisateur = 1 **");
		try {
			Utilisateur ut1 = utDao.findUtilisateurByKey(1);
			System.out.println("\t" + ut1);
		} catch (BiblioException e) {
			System.out.println("\t" + "---> Erreur de recherche: " + e.getMessage());
		}
		
		System.out.println("");
		
		/* Test sur idUtilisateur=2 */
		System.out.println("** Test sur idUtilisateur = 2 **");
		try {
			Utilisateur ut2 = utDao.findUtilisateurByKey(2);
			System.out.println("\t" + ut2);
		} catch (BiblioException e) {
			System.out.println("\t" + "---> Erreur de recherche: " + e.getMessage());
		}
		
		System.out.println("");

		/* Test sur idUtilisateur=0 */
		System.out.println("** Test sur idUtilisateur = 0 **");
		try {
			Utilisateur ut3 = utDao.findUtilisateurByKey(0);
			System.out.println("\t" + ut3);
		} catch (BiblioException e) {
			System.out.println("\t" + "---> Erreur de recherche: " + e.getMessage());
		}
		
		System.out.println("");
		
		/* Test FindAllUtilisateurs */
		System.out.println("** Test FindAllUtilisateurs **");
		System.out.println(utDao.findAllUtilisateurs());
	}
}
