package biblio.control;

import javax.swing.JFrame;

/**
 * @author Vinz
 *
 */
public class Fenetre extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String titre = null;
	String position = null;
	int hauteur = 0;
	int largeur = 0;
	boolean resize = false;

	public Fenetre(String titre, int hauteur, int largeur, boolean resize) {
		// Modification de son titre
		setTitle(titre);
		// Ajustement de sa taille
		setSize(hauteur, largeur);
		// Centrage de sa position
		setLocationRelativeTo(null);
		// Verouillage du redimensionnement
		setResizable(resize);
		// Fermeture par défaut
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// Constructeur par défaut
	public Fenetre() {
		this(null, 200, 150, false);
	}
}
