package biblio.test;

import static biblio.metier.Personne.sdf;
import java.text.ParseException;
import biblio.metier.Adherent;

/**
 * Classe de tests Adherent
 * @author V.Vrillaud
 */
public class TestAdherent {
	
	public static void main(String[] args) throws ParseException {
		
		Adherent a1 = new Adherent();
		System.out.println("Test Adhérent sans paramètre(+2):\n" + "\t" + a1);
		
		Adherent a2 = new Adherent("Salin", "Samuel", sdf.parse("25/12/1984"), 'H', 800100, "zouzou", "ss");
		System.out.println("Test Adhérent à 7(+2) paramètres:\n" + "\t" + a2);
		
		Adherent a3 = new Adherent("Brûlé", "Valentin", sdf.parse("18/11/1981"), 'H', 514871, "truc", "vb",
				"0650725410");
		System.out.println("Test Adhérent à 8(+2) paramètres:\n" + "\t" + a3);
	}
}