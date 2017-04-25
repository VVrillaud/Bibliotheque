package biblio.test;

import biblio.metier.EmpruntEnCours;
import biblio.metier.Utilisateur;
import java.util.Date;
import biblio.dao.ConnectionFactory;
import biblio.dao.ExemplaireDao;
import biblio.dao.UtilisateurDao;
import biblio.exception.BiblioException;

public class TestEmployeTroisEmprunts {

	public static void main(String[] args) throws BiblioException {
		
		ConnectionFactory cnxfct = new ConnectionFactory();
		UtilisateurDao utDao = new UtilisateurDao(cnxfct.getConnection());
		ExemplaireDao exDao = new ExemplaireDao(cnxfct.getConnection());
		
		Utilisateur ut2=utDao.findUtilisateurByKey(2);
		
		EmpruntEnCours empc1=new EmpruntEnCours(ut2,exDao.findExemplaireByKey(2),new Date());
		System.out.println("Emprûnt à l'heure :\n"+empc1+"\n");
		EmpruntEnCours empc2=new EmpruntEnCours(ut2,exDao.findExemplaireByKey(4),new Date());
		System.out.println("Emprûnt à l'heure :\n"+empc2+"\n");
		EmpruntEnCours empc3=new EmpruntEnCours(ut2,exDao.findExemplaireByKey(5),new Date());
		System.out.println("Emprûnt à l'heure :\n"+empc3+"\n");
		EmpruntEnCours empc4=new EmpruntEnCours(ut2,exDao.findExemplaireByKey(7),new Date());
		System.out.println("Emprûnt à l'heure :\n"+empc4+"\n");
	
	}

}
