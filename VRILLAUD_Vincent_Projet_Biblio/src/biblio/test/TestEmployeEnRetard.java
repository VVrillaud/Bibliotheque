package biblio.test;

import static biblio.metier.Personne.sdf;

import java.text.ParseException;
import java.util.Date;
import biblio.metier.EmpruntEnCours;
import biblio.metier.Utilisateur;
import biblio.dao.ConnectionFactory;
import biblio.dao.ExemplaireDao;
import biblio.dao.UtilisateurDao;
import biblio.exception.BiblioException;

/**
 * @author V.Vrillaud
 *
 */
public class TestEmployeEnRetard {

	public static void main(String[] args) throws BiblioException, ParseException {

		ConnectionFactory cnxfct = new ConnectionFactory();
		UtilisateurDao utDao = new UtilisateurDao(cnxfct.getConnection());
		ExemplaireDao exDao = new ExemplaireDao(cnxfct.getConnection());

		Utilisateur empl2 = utDao.findUtilisateurByKey(2);

		EmpruntEnCours empc1 = new EmpruntEnCours(empl2, exDao.findExemplaireByKey(2), new Date());
		System.out.println("Emprûnt à l'heure:\n\t" + empc1);

		EmpruntEnCours empc2 = new EmpruntEnCours(empl2, exDao.findExemplaireByKey(4), sdf.parse("10/03/2017"));
		System.out.println("Emprûnt en retard:\n\t" + empc2);

		System.out.println("Emprûnt à l'heure:");
		EmpruntEnCours empc3 = null;
		try {
			empc3 = new EmpruntEnCours(empl2, exDao.findExemplaireByKey(5), new Date());
		} catch (BiblioException e) {
			System.out.println("Emprûnt impossible: " + e.getMessage() + "\n");
		}
		System.out.println(empc3);

		System.out.println("Nombre d'emprûnts:\n\t" + empl2.getNbEmpruntsEnCours() + "\n");

		System.out.println("Liste des emprûnts en cours:\n" + (empl2.getEmpruntEnCours()));

	}

}
