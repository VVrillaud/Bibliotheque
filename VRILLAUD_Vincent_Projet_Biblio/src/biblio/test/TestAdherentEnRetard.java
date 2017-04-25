package biblio.test;

import static biblio.metier.Personne.sdf;
import java.text.ParseException;
import java.util.Date;
import biblio.exception.BiblioException;
import biblio.metier.EmpruntEnCours;
import biblio.metier.Utilisateur;
import biblio.metier.Adherent;
import biblio.dao.ConnectionFactory;
import biblio.dao.ExemplaireDao;
import biblio.dao.UtilisateurDao;

/**
 * @author V.Vrillaud
 *
 */
public class TestAdherentEnRetard {

	public static void main(String[] args) throws BiblioException, ParseException {

		ConnectionFactory cnxfct = new ConnectionFactory();
		UtilisateurDao utDao = new UtilisateurDao(cnxfct.getConnection());
		ExemplaireDao exDao = new ExemplaireDao(cnxfct.getConnection());

		Utilisateur adh1 = utDao.findUtilisateurByKey(1);

		EmpruntEnCours empc1 = new EmpruntEnCours(adh1, exDao.findExemplaireByKey(2), new Date());
		System.out.println("Emprûnt à l'heure:\n\t" + empc1);

		EmpruntEnCours empc2 = new EmpruntEnCours(adh1, exDao.findExemplaireByKey(4), sdf.parse("10/03/2017"));
		System.out.println("Emprûnt en retard:\n\t" + empc2);

		System.out.println("Emprûnt à l'heure:");
		try {
			new EmpruntEnCours(adh1, exDao.findExemplaireByKey(5), new Date());
		} catch (BiblioException e) {
			System.out.println("Emprûnt impossible: " + e.getMessage() + "\n");
		}

		System.out.println("Nombre d'emprûnts:\n\t" + adh1.getNbEmpruntsEnCours() + "\n");

		System.out.println("Nombre de retards:\n\t" + ((Adherent) (adh1)).getNbRetards() + "\n");

		System.out.println("Liste des emprûnts en cours:\n" + (adh1.getEmpruntEnCours()));

	}

}