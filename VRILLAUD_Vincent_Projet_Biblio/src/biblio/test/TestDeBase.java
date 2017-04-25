package biblio.test;

import java.util.Date;
import biblio.metier.EmpruntEnCours;
import biblio.dao.ConnectionFactory;
import biblio.dao.ExemplaireDao;
import biblio.dao.UtilisateurDao;
import biblio.exception.BiblioException;

/**
 * @author V.Vrillaud
 *
 */
public class TestDeBase {

	public static void main(String[] args) throws BiblioException {
		
		ConnectionFactory cnxfct = new ConnectionFactory();
		
		ExemplaireDao exDao1 = new ExemplaireDao(cnxfct.getConnection());
		System.out.println("test1: "+exDao1.findExemplaireByKey(1)+"\n");
		System.out.println("test2: "+exDao1.findExemplaireByKey(2)+"\n");
		
		UtilisateurDao utDao1 = new UtilisateurDao(cnxfct.getConnection());
		System.out.println("test3: "+utDao1.findUtilisateurByKey(5)+"\n");
		System.out.println("test4: "+utDao1.findUtilisateurByKey(3)+"\n");
		
		EmpruntEnCours empc1=new EmpruntEnCours (utDao1.findUtilisateurByKey(5),exDao1.findExemplaireByKey(2),new Date());
		System.out.println("test5: "+empc1);
		
		System.out.println("test6: ");
		try {
			new EmpruntEnCours (utDao1.findUtilisateurByKey(3),exDao1.findExemplaireByKey(1),new Date());
		}
		catch (BiblioException e)
		{
			System.out.println("Emprûnt impossible: "+e.getMessage());
		}
	
	}

}