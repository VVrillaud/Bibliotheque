package biblio.test;

import biblio.dao.ConnectionFactory;
import biblio.dao.ExemplaireDao;
import biblio.exception.BiblioException;
import biblio.metier.Exemplaire;

/**
 * @author V.Vrillaud
 *
 */
public class TestExemplaireDao {
	
	public static void main(String[] args) {
		
		ConnectionFactory cnxfct = new ConnectionFactory();
		ExemplaireDao exDao = new ExemplaireDao(cnxfct.getConnection());
		
		/* Test sur idExemplaire=1 */
		System.out.println("** Test sur idExemplaire = 1 **");
		try {
			Exemplaire ex1 = exDao.findExemplaireByKey(1);
			System.out.println("\t" + ex1);
		} catch (BiblioException e) {
			System.out.println("\t" + "---> Erreur de recherche: " + e.getMessage());
		}
		
		System.out.println("");
		
		/* Test sur idExemplaire=0 */
		System.out.println("** Test sur idExemplaire = 0 **");
		try {
			Exemplaire ex2 = exDao.findExemplaireByKey(0);
			System.out.println("\t" + ex2);
		} catch (BiblioException e) {
			System.out.println("\t" + "---> Erreur de recherche: " + e.getMessage());
		}
		
		System.out.println("");
		
		/* Test FindAllExemplaires */
		System.out.println("** Test FindAllExemplaires **");
		System.out.println(exDao.findAllExemplaires());
		
	}
}