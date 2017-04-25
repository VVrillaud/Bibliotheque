package biblio.metier;

import java.util.Date;
import biblio.exception.BiblioException;
import static biblio.metier.Personne.sdf;

/**
 * Concept de l'Emprûnt en cours
 * @author V.Vrillaud
 */
public class EmpruntEnCours {
	/**
	 * Attribut dateEmprunt: la date d'emprûnt
	 */
	private Date dateEmprunt;
	
	/**
	 * Accesseur getDateEmprunt: accesseur sur la date d'emprûnt
	 * 
	 * @return dateEmprunt: la date d'emprûnt
	 */
	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	/**
	 * Mutateur setDateEmprunt: mutateur sur la date d'emprûnt
	 * 
	 * @param dateEmprunt:
	 *            la date d'emprûnt
	 */
	public void setDateEmprunt(Date p_dateEmprunt) {
		this.dateEmprunt = p_dateEmprunt;
	}
	
	/**
	 * Attribut exemplaire: l'exemplaire
	 */
	private Exemplaire exemplaire = null;
	
	/**
	 * Accesseur getExemplaire: accesseur sur l'exemplaire
	 * 
	 * @return exemplaire: l'exemplaire
	 */
	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	/**
	 * Mutateur setExemplaire: mutateur sur l'exemplaire
	 * 
	 * @param exemplaire:
	 *            l'exemplaire à attribuer
	 * @throws BiblioException 
	 */
	public void setExemplaire(Exemplaire p_exemplaire) throws BiblioException {
		if (this.getExemplaire() == null & p_exemplaire.getStatus() == EnumStatusExemplaire.DISPONIBLE) {
			this.exemplaire = p_exemplaire;
			p_exemplaire.setStatus(EnumStatusExemplaire.PRETE);
			p_exemplaire.setEmpruntEnCours(this);
		} else {
			throw new BiblioException("Exemplaire indisponible");
		}
	}
	
	/**
	 * Attribut emprunteur: l'emprûnteur
	 */
	private Utilisateur emprunteur;
	
	/**
	 * Accesseur getEmprunteur: accesseur sur l'emprûnteur
	 * 
	 * @return emprunteur: l'emprûnteur
	 */
	public Utilisateur getEmprunteur() {
		return emprunteur;
	}

	/**
	 * Mutateur setEmprunteur: mutateur sur l'emprûnteur
	 * 
	 * @param emprunteur:
	 *            l'emprûnteur à attribuer
	 * @throws BiblioException 
	 */
	public void setEmprunteur(Utilisateur p_emprunteur) throws BiblioException {
		if (this.getEmprunteur() == null) {
			this.emprunteur = p_emprunteur;
			this.getEmprunteur().addEmpruntEnCours(this);
		} else {
			throw new BiblioException("Emprûnteur indisponible");
		}
	}

	/**
	 * Constructeur EmpruntEnCours à 3 paramètres
	 * 
	 * @param dateEmprunt:
	 *            la date d'emprûnt
	 * @param exemplaire:
	 *            l'exemplaire
	 * @param emprunteur:
	 *            l'emprûnteur
	 * @throws BiblioException 
	 */
	public EmpruntEnCours(Utilisateur p_emprunteur, Exemplaire p_exemplaire, Date p_dateEmprunt) throws BiblioException {
		setEmprunteur(p_emprunteur);
		setExemplaire(p_exemplaire);
		setDateEmprunt(p_dateEmprunt);
	}

	/**
	 * Constructeur EmpruntEnCours à 2 paramètres
	 * 
	 * @param dateEmprunt:
	 *            la date d'emprûnt
	 * @param exemplaire:
	 *            l'exemplaire
	 * @throws BiblioException 
	 */
	public EmpruntEnCours(Utilisateur p_emprunteur, Exemplaire p_exemplaire) throws BiblioException {
		this(p_emprunteur, p_exemplaire, new Date());
	}

	/**
	 * Constructeur EmpruntEnCours à 1 paramètre
	 * 
	 * @param dateEmprunt:
	 *            la date d'emprûnt
	 * @throws BiblioException 
	 */
	public EmpruntEnCours(Utilisateur p_emprunteur) throws BiblioException {
		this(p_emprunteur, null);
	}

	/**
	 * Constructeur EmpruntEnCours sans paramètres
	 * @throws BiblioException 
	 */
	public EmpruntEnCours() throws BiblioException {
		this(null);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return /*"... EmpruntEnCours ..."*/
								/*+ "\n" + "\t"+*/this.getExemplaire()
								+ "\n" + "\t" + "dateEmprunt: " + sdf.format(this.getDateEmprunt())
								/*+ "\n" + "\t" + "... emprûnté par ..." + "\n"
								+ "\t" + this.getEmprunteur() + "\n"*/;
	}
}