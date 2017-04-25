/** VERIF LE 20-04-17 **/

package biblio.metier;

import java.util.Date;

/**
 * Classe Employé: le concept de l'Employé
 * @author V.Vrillaud
 */
public class Employe extends Utilisateur {
	/**
	 * Attribut codeMatricule: le code matricule de l'employé
	 */
	private String codeMatricule = null;

	/**
	 * Accesseur getCodeMatricule: accesseur sur le code matricule de l'employé
	 * 
	 * @return codeMatricule: le code matricule de l'employé
	 */
	public String getCodeMatricule() {
		return codeMatricule;
	}

	/**
	 * Mutateur setCodeMatricule: mutateur sur le code matricule de l'employé
	 * 
	 * @param codeMatricule:
	 *            le code matricule à attribuer à l'employé
	 */
	public void setCodeMatricule(String p_codeMatricule) {
		this.codeMatricule = p_codeMatricule;
	}

	/**
	 * Enumération categorieEmploye: la catégorie de l'employé
	 */
	private EnumCategorieEmploye categorieEmploye = null;

	/**
	 * Accesseur getCategorieEmploye: accesseur sur la catégorie de l'employé
	 * 
	 * @return categorieEmploye: la catégorie de l'employé
	 */
	public EnumCategorieEmploye getCategorieEmploye() {
		return categorieEmploye;
	}

	/**
	 * Mutateur setCategorieEmploye: mutateur sur la catégorie de l'employé
	 * 
	 * @param categorieEmploye:
	 *            la catégorie à attribuer à l'employé
	 */
	public void setCategorieEmploye(EnumCategorieEmploye p_categorieEmploye) {
		this.categorieEmploye = p_categorieEmploye;
	}

	/**
	 * Constructeur Employe à 9 paramètres
	 * 
	 * @param nom:
	 *            le nom à attribuer à la personne
	 * @param prenom:
	 *            le prénom à attribuer à la personne
	 * @param dateNaissance:
	 *            la date de naissance à attribuer à la personne
	 * @param sexe:
	 *            le sexe à attribuer à la personne
	 * @param idUtilisateur:
	 *            l'identifiant de l'utilisateur
	 * @param pwd:
	 *            le mot de passe de l'utilisateur
	 * @param pseudonyme:
	 *            le pseudonyme de l'utilisateur
	 * @param codeMatricule:
	 *            le code matricule de l'employé
	 * @param categorieEmploye:
	 *            la catégorie de l'employé
	 */
	public Employe(String p_nom, String p_prenom, Date p_dateNaissance, char p_sexe, int p_idUtilisateur, String p_pwd,
			String p_pseudonyme, String p_codeMatricule, EnumCategorieEmploye p_categorieEmploye) {
		super(p_nom, p_prenom, p_dateNaissance, p_sexe, p_idUtilisateur, p_pwd, p_pseudonyme);
		this.setCodeMatricule(p_codeMatricule);
		this.setCategorieEmploye(p_categorieEmploye);
	}

	/**
	 * Constructeur Employe à 8 paramètres
	 * 
	 * @param nom:
	 *            le nom à attribuer à la personne
	 * @param prenom:
	 *            le prénom à attribuer à la personne
	 * @param dateNaissance:
	 *            la date de naissance à attribuer à la personne
	 * @param sexe:
	 *            le sexe à attribuer à la personne
	 * @param idUtilisateur:
	 *            l'identifiant de l'utilisateur
	 * @param pwd:
	 *            le mot de passe de l'utilisateur
	 * @param pseudonyme:
	 *            le pseudonyme de l'utilisateur
	 * @param codeMatricule:
	 *            le code matricule de l'employé
	 */
	public Employe(String p_nom, String p_prenom, Date p_dateNaissance, char p_sexe, int p_idUtilisateur, String p_pwd,
			String p_pseudonyme, String p_codeMatricule) {
		this(p_nom, p_prenom, p_dateNaissance, p_sexe, p_idUtilisateur, p_pwd, p_pseudonyme, p_codeMatricule, null);
	}

	/**
	 * Constructeur Employe à 7 paramètres
	 * 
	 * @param nom:
	 *            le nom à attribuer à la personne
	 * @param prenom:
	 *            le prénom à attribuer à la personne
	 * @param dateNaissance:
	 *            la date de naissance à attribuer à la personne
	 * @param sexe:
	 *            le sexe à attribuer à la personne
	 * @param idUtilisateur:
	 *            l'identifiant de l'utilisateur
	 * @param pwd:
	 *            le mot de passe de l'utilisateur
	 * @param pseudonyme:
	 *            le pseudonyme de l'utilisateur
	 */
	public Employe(String p_nom, String p_prenom, Date p_dateNaissance, char p_sexe, int p_idUtilisateur, String p_pwd,
			String p_pseudonyme) {
		this(p_nom, p_prenom, p_dateNaissance, p_sexe, p_idUtilisateur, p_pwd, p_pseudonyme, null, null);
	}

	/**
	 * Constructeur Employe sans paramètre
	 */
	public Employe() {
		super();
	}

	/* (non-Javadoc)
	 * @see biblio.metier.Utilisateur#toString()
	 */
	@Override
	public String toString() {
		String sCodeMat = this.getCodeMatricule() == null ? "non renseigné" : this.getCodeMatricule();
		String sCatEmp = this.getCategorieEmploye() == null ? "non renseignée" : String.valueOf(this.getCategorieEmploye());
		return super.toString() + "\n\t - Employé < codeMat: " + sCodeMat + " . categorieEmploye: " + sCatEmp + " >";
	}
}