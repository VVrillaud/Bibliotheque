package biblio.test;

import biblio.control.Fenetre;

public class TestFenetre {

	public static void main(String[] args) {
		// Instanciation d'une fenêtre par défaut
		Fenetre maFenetre2 = new Fenetre("Coucou", 400, 300, true);
		// Affichage de la fenêtre par défaut
		maFenetre2.setVisible(true);
		// Instanciation d'une fenêtre par défaut
		Fenetre maFenetre1 = new Fenetre();
		// Affichage de la fenêtre par défaut
		maFenetre1.setVisible(true);
	}
}