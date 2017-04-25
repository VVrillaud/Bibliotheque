/** VERIF LE 20-04-17 **/

package biblio.metier;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe Personne: le concept de la Personne
 * @author V.Vrillaud
 */
public class Personne {

	/**
	 * Attribut nom: le nom de la personne
	 */
	private String nom = null;

	/**
	 * Accesseur getNom: accesseur sur le nom de la personne
	 * 
	 * @return nom: le nom de la personne
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Mutateur setNom: mutateur sur le nom de la personne
	 * 
	 * @param nom:
	 *            le nom à attribuer à la personne
	 */
	public void setNom(String p_nom) {
		this.nom = p_nom;
	}

	/**
	 * Attribut prenom: le prénom de la personne
	 */
	private String prenom = null;

	/**
	 * Accesseur getPrenom: accesseur sur le prénom de la personne
	 * 
	 * @return prenom: le prénom de la personne
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Mutateur setPrenom: mutateur sur le prénom de la personne
	 * 
	 * @param prenom:
	 *            le prénom à attribuer à la personne
	 */
	public void setPrenom(String p_prenom) {
		this.prenom = p_prenom;
	}

	/**
	 * Attribut dateNaissance: la date de naissance de la personne
	 */
	private Date dateNaissance = null;

	/**
	 * Accesseur getDateNaissance: accesseur sur la date de naissance de la
	 * personne
	 * 
	 * @return dateNaissance: la date de naissance de la personne
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * Mutateur setDateNaissance: mutateur sur la date de naissance de la
	 * personne
	 * 
	 * @param dateNaissance:
	 *            la date de naissance à attribuer à la personne
	 */
	public void setDateNaissance(Date p_dateNaissance) {
		this.dateNaissance = p_dateNaissance;
	}

	/**
	 * Attribut sexe: le sexe de la personne
	 */
	private char sexe = ' ';

	/**
	 * Accesseur getSexe: accesseur sur le sexe de la personne
	 * 
	 * @return sexe: le sexe de la personne
	 */
	public char getSexe() {
		return sexe;
	}

	/**
	 * Mutateur setSexe: mutateur sur le sexe de la personne
	 * 
	 * @param sexe:
	 *            le sexe à attribuer à la personne
	 */
	public void setSexe(char p_sexe) {
		this.sexe = p_sexe;
	}

	/**
	 * SimpleDateFormat: gestion de la date au format "DD/MM/YYYY"
	 */
	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	/**
	 * Constructeur Personne à 4 paramètres
	 * 
	 * @param nom:
	 *            le nom à attribuer à la personne
	 * @param prenom:
	 *            le prénom à attribuer à la personne
	 * @param dateNaissance:
	 *            la date de naissance à attribuer à la personne
	 * @param sexe:
	 *            le sexe à attribuer à la personne
	 */
	public Personne(String p_nom, String p_prenom, Date p_dateNaissance, char p_sexe) {
		this.setNom(p_nom);
		this.setPrenom(p_prenom);
		this.setDateNaissance(p_dateNaissance);
		this.setSexe(p_sexe);
	};

	/**
	 * Constructeur Personne à 3 paramètres
	 * 
	 * @param nom:
	 *            le nom à attribuer à la personne
	 * @param prenom:
	 *            le prénom à attribuer à la personne
	 * @param dateNaissance:
	 *            la date de naissance à attribuer à la personne
	 */
	public Personne(String p_nom, String p_prenom, Date p_dateNaissance) {
		this(p_nom, p_prenom, p_dateNaissance, ' ');
	};

	/**
	 * Constructeur Personne à 2 paramètres
	 * 
	 * @param nom:
	 *            le nom à attribuer à la personne
	 * @param prenom:
	 *            le prénom à attribuer à la personne
	 */
	public Personne(String p_nom, String p_prenom) {
		this(p_nom, p_prenom, null);
	};

	/**
	 * @param nom:
	 *            le nom à attribuer à la personne
	 */
	public Personne(String p_nom) {
		this(p_nom, null);
	}

	/**
	 * Constructeur Personne sans parametre
	 */
	public Personne() {
		this(null, null);
	}

	/**
	 * toString redéfinie (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String sNom = (this.getNom() == null) ? "non renseigné" : this.getNom().toUpperCase();
		String sPrenom = this.getPrenom() == null ? "non renseigné" : this.getPrenom();
		String sDateNaissance = this.getDateNaissance() == null ? "non renseignée"
				: sdf.format(this.getDateNaissance());
		String sSexe = this.getSexe() == ' ' ? "non renseigné" : String.valueOf(this.getSexe());
		return "Personne [ nom: " + sNom + " * prénom: " + sPrenom + " * date de naissance: " + sDateNaissance
				+ " * sexe: " + sSexe + " ]";
	};
}