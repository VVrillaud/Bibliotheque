/** VERIF LE 20-04-17 **/

package biblio.metier;

import static biblio.metier.Personne.sdf;
import java.util.*;

/**
 * Classe Exemplaire: le concept de l'Exemplaire
 * @author V.Vrillaud
 */
public class Exemplaire {

	/**
	 * 
	 */
	private int idExemplaire = 0;
	
	/**
	 * @return
	 */
	public int getIdExemplaire() {
		return idExemplaire;
	}

	/**
	 * @param idExemplaire
	 */
	public void setIdExemplaire(int p_idExemplaire) {
		this.idExemplaire = p_idExemplaire;
	}
	
	/**
	 * 
	 */
	private Date dateAchat = null;
	
	/**
	 * @return
	 */
	public Date getDateAchat() {
		return dateAchat;
	}

	/**
	 * @param dateAchat
	 */
	public void setDateAchat(Date p_dateAchat) {
		this.dateAchat = p_dateAchat;
	}
	
	/**
	 * 
	 */
	private EnumStatusExemplaire status = EnumStatusExemplaire.DISPONIBLE;
	
	/**
	 * @return
	 */
	public EnumStatusExemplaire getStatus() {
		return status;
	}

	/**
	 * @param status
	 */
	public void setStatus(EnumStatusExemplaire p_status) {
		this.status = p_status;
	}
	
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
	private Livre livre = null;
	
	/**
	 * @return
	 */
	public Livre getLivre() {
		return livre;
	}

	/**
	 * @param p_livre
	 */
	public void setLivre(Livre p_livre) {
		// if(this.getTheEmpruntEnCours()==null){
		this.livre = p_livre;
		// this.setStatus(EnumStatusExemplaire.PRETE);
		// this.theEmpruntEnCours = this.getTheEmpruntEnCours();
		// }
	}
	
	/**
	 * 
	 */
	private EmpruntEnCours empruntEnCours = null;
	
	/**
	 * @return
	 */
	public EmpruntEnCours getEmpruntEnCours() {
		return empruntEnCours;
	}
	
	/**
	 * @param p_empruntEnCours
	 */
	public void setEmpruntEnCours(EmpruntEnCours p_empruntEnCours) {
		this.empruntEnCours = p_empruntEnCours;
	}

	/**
	 * @param p_idExemplaire
	 * @param p_dateAchat
	 * @param p_status
	 * @param p_isbn
	 * @param p_livre
	 */
	public Exemplaire(int p_idExemplaire, Date p_dateAchat, EnumStatusExemplaire p_status, String p_isbn,
			Livre p_livre) {
		setIdExemplaire(p_idExemplaire);
		setDateAchat(p_dateAchat);
		setStatus(p_status);
		setIsbn(p_isbn);
		setLivre(p_livre);
	}

	/**
	 * @param p_idExemplaire
	 * @param p_dateAchat
	 * @param p_status
	 * @param p_isbn
	 */
	public Exemplaire(int p_idExemplaire, Date p_dateAchat, EnumStatusExemplaire p_status, String p_isbn) {
		this(p_idExemplaire, p_dateAchat, p_status, p_isbn, null);
	}

	/**
	 * @param p_idExemplaire
	 * @param p_dateAchat
	 * @param p_status
	 */
	public Exemplaire(int p_idExemplaire, Date p_dateAchat, EnumStatusExemplaire p_status) {
		this(p_idExemplaire, p_dateAchat, p_status, null);
	}

	/**
	 * @param p_idExemplaire
	 * @param p_dateAchat
	 */
	public Exemplaire(int p_idExemplaire, Date p_dateAchat) {
		this(p_idExemplaire, p_dateAchat, EnumStatusExemplaire.DISPONIBLE);
	}

	/**
	 * @param p_idExemplaire
	 */
	public Exemplaire(int p_idExemplaire) {
		this(p_idExemplaire, null);
	}

	/**
	 * 
	 */
	public Exemplaire() {
		this(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String sIdEx = (this.getIdExemplaire() == 0) ? "non renseigné" : String.valueOf(this.getIdExemplaire());
		String sDateAchat = this.getDateAchat() == null ? "non renseignée" : sdf.format(this.getDateAchat());
		String sIsbn = this.getIsbn() == null ? "non renseigné" : this.getIsbn();
		return "Exemplaire >> idEx: " + sIdEx + ", dateAchat: " + sDateAchat + ", status: "
				+ this.getStatus() + ", isbn: " + sIsbn + " <<";
	}
}