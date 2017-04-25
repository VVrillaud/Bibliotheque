/** VERIF LE 20-04-17 **/

package biblio.metier;

/**
 * Classe Livre: le concept du Livre
 * @author V.Vrillaud
 */
public class Livre {

	/**
	 * 
	 */
	private String isbn = null;
	
	/**
	 * @return
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param p_isbn
	 */
	public void setIsbn(String p_isbn) {
		this.isbn = p_isbn;
	}
	
	/**
	 * 
	 */
	private String titre = null; 
	
	/**
	 * @return
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param p_titre
	 */
	public void setTitre(String p_titre) {
		this.titre = p_titre;
	}
	
	/**
	 * 
	 */
	private String codeTheme = null;
	
	/**
	 * @return
	 */
	public String getCodeTheme() {
		return codeTheme;
	}

	/**
	 * @param p_codeTheme
	 */
	public void setCodeTheme(String p_codeTheme) {
		this.codeTheme = p_codeTheme;
	}
	
	/**
	 * 
	 */
	private int anneeParution = 0;
	
	/**
	 * @return
	 */
	public int getAnneeParution() {
		return anneeParution;
	}

	/**
	 * @param p_anneeParution
	 */
	public void setAnneeParution(int p_anneeParution) {
		this.anneeParution = p_anneeParution;
	}
	
	/**
	 * 
	 */
	private int nbPages = 0;
	
	/**
	 * @return
	 */
	public int getNbPages() {
		return nbPages;
	}

	/**
	 * @param p_nbPages
	 */
	public void setNbPages(int p_nbPages) {
		this.nbPages = p_nbPages;
	}
	
	/**
	 * 
	 */
	private int idEditeur = 0;
	
	/**
	 * @return
	 */
	public int getIdEditeur() {
		return idEditeur;
	}

	/**
	 * @param p_idEditeur
	 */
	public void setIdEditeur(int p_idEditeur) {
		this.idEditeur = p_idEditeur;
	}

	/**
	 * @param p_isbn
	 * @param p_titre
	 * @param p_codeTheme
	 * @param p_anneeParution
	 * @param p_nbPages
	 * @param p_idEditeur
	 */
	public Livre(String p_isbn, String p_titre, String p_codeTheme, int p_anneeParution, int p_nbPages,
			int p_idEditeur) {
		setIsbn(p_isbn);
		setTitre(p_titre);
		setCodeTheme(p_codeTheme);
		setAnneeParution(p_anneeParution);
		setNbPages(p_nbPages);
		setIdEditeur(p_idEditeur);
	}

	/**
	 * @param p_isbn
	 * @param p_titre
	 * @param p_codeTheme
	 * @param p_anneeParution
	 * @param p_nbPages
	 */
	public Livre(String p_isbn, String p_titre, String p_codeTheme, int p_anneeParution, int p_nbPages) {
		this(p_isbn, p_titre, p_codeTheme, p_anneeParution, p_nbPages, 0);
	}

	/**
	 * @param p_isbn
	 * @param p_titre
	 * @param p_codeTheme
	 * @param p_anneeParution
	 */
	public Livre(String p_isbn, String p_titre, String p_codeTheme, int p_anneeParution) {
		this(p_isbn, p_titre, p_codeTheme, p_anneeParution, 0);
	}

	/**
	 * @param p_isbn
	 * @param p_titre
	 * @param p_codeTheme
	 */
	public Livre(String p_isbn, String p_titre, String p_codeTheme) {
		this(p_isbn, p_titre, p_codeTheme, 0);
	}

	/**
	 * @param p_isbn
	 * @param p_titre
	 */
	public Livre(String p_isbn, String p_titre) {
		this(p_isbn, p_titre, null);
	}

	/**
	 * @param p_isbn
	 */
	public Livre(String p_isbn) {
		this(p_isbn, null);
	}

	/**
	 * 
	 */
	public Livre() {
		this(null);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Livre __ isbn: " + this.getIsbn() + " - titre: " + this.getTitre() + " - codeTheme: " + this.getCodeTheme()
		+ " - anneeParution: " + this.getAnneeParution() + " - nbPages: " + this.getNbPages() + " - idEditeur: " + this.getIdEditeur() + " __";
	}
}