package biblio.test;

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
public class TestAdherentTroisEmprunts {

	public static void main(String[] args) throws BiblioException {
		
		ConnectionFactory cnxfct = new ConnectionFactory();
		UtilisateurDao utDao = new UtilisateurDao(cnxfct.getConnection());
		ExemplaireDao exDao = new ExemplaireDao(cnxfct.getConnection());
		
		Utilisateur ut1=utDao.findUtilisateurByKey(1);
		
		EmpruntEnCours empc1=new EmpruntEnCours(ut1,exDao.findExemplaireByKey(2),new Date());
		System.out.println("Emprûnt à l'heure:\n\t"+empc1+"\n");
		
		EmpruntEnCours empc2=new EmpruntEnCours(ut1,exDao.findExemplaireByKey(4),new Date());
		System.out.println("Emprûnt à l'heure:\n\t"+empc2+"\n");
		
		EmpruntEnCours empc3=new EmpruntEnCours(ut1,exDao.findExemplaireByKey(5),new Date());
		System.out.println("Emprûnt à l'heure:\n\t"+empc3+"\n");
		
		System.out.println("Emprûnt à l'heure:");
		try {
		new EmpruntEnCours(ut1,exDao.findExemplaireByKey(7),new Date());
		} catch (BiblioException e) {
			System.out.println("Emprûnt impossible: " + e.getMessage());
		}
	
	}
	
}