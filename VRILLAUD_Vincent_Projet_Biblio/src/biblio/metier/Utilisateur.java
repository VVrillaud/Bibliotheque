/** VERIF LE 20-04-17 **/

package biblio.metier;

import java.util.ArrayList;
import java.util.Date;
import biblio.exception.BiblioException;

/**
 * Classe Utilisateur: le concept de l'Utilisateur
 * @author V.Vrillaud
 */
public class Utilisateur extends Personne {
	/**
	 * Attribut idUtilisateur: l'identifiant de l'utilisateur
	 */
	private int idUtilisateur = 0;

	/**
	 * Accesseur getIdUtilisateur: accesseur sur l'identifiant de l'utilisateur
	 * 
	 * @return idUtilisateur: l'identifiant de l'utilisateur
	 */
	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	/**
	 * Mutateur getIdUtilisateur: mutateur sur l'identifiant de l'utilisateur
	 * 
	 * @param idUtilisateur:
	 *            l'identifiant à attribuer à l'utilisateur
	 */
	public void setIdUtilisateur(int p_idUtilisateur) {
		this.idUtilisateur = p_idUtilisateur;
	}

	/**
	 * Attribut pwd: le mot de passe de l'utilisateur
	 */
	private String pwd = null;

	/**
	 * Accesseur getPwd: accesseur sur l'identifiant de l'utilisateur
	 * 
	 * @return pwd: le mot de passe de l'utilisateur
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * Mutateur setPwd: mutateur sur le mot de passe de l'utilisateur
	 * 
	 * @param pwd:
	 *            le mot de passe à attribuer à l'utilisateur
	 */
	public void setPwd(String p_pwd) {
		this.pwd = p_pwd;
	}

	/**
	 * Attribut pseudonyme: le pseudonyme de l'utilisateur
	 */
	private String pseudonyme = null;

	/**
	 * Accesseur getPseudonyme: accesseur sur le pseudonyme de l'utilisateur
	 * 
	 * @return pseudonyme: le pseudonyme de l'utilisateur
	 */
	public String getPseudonyme() {
		return pseudonyme;
	}

	/**
	 * Mutateur setPseudonyme: mutateur sur le pseudonyme de l'utilisateur
	 * 
	 * @param pseudonyme:
	 *            le pseudonyme à attribuer à l'utilisateur
	 */
	public void setPseudonyme(String p_pseudonyme) {
		this.pseudonyme = p_pseudonyme;
	}

	/**
	 * Collection EmpruntEnCours: l'emprûnt (ou les emprûnts) en cours de
	 * l'utilisateur
	 */
	private ArrayList<EmpruntEnCours> empruntEnCours = new ArrayList<EmpruntEnCours>();

	/**
	 * Mutateur setEmpruntEnCours: mutateur sur l'emprûnt (ou les emprûnts) en
	 * cours de l'utilisateur
	 * 
	 * @param empruntEnCours:
	 *            l'emprûnt (ou les emprûnts) en cours de l'utilisateur
	 */
	public void setEmpruntEnCours(ArrayList<EmpruntEnCours> p_empruntEnCours) {
		this.empruntEnCours = p_empruntEnCours;
	}

	/**
	 * Constructeur Utilisateur à 7 paramètres
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
	public Utilisateur(String p_nom, String p_prenom, Date p_dateNaissance, char p_sexe, int p_idUtilisateur,
			String p_pwd, String p_pseudonyme) {
		super(p_nom, p_prenom, p_dateNaissance, p_sexe);
		this.setIdUtilisateur(p_idUtilisateur);
		this.setPwd(p_pwd);
		this.setPseudonyme(p_pseudonyme);
	}

	/**
	 * Constructeur Utilisateur à 6 paramètres
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
	 */
	public Utilisateur(String p_nom, String p_prenom, Date p_dateNaissance, char p_sexe, int p_idUtilisateur,
			String p_pwd) {
		this(p_nom, p_prenom, p_dateNaissance, p_sexe, p_idUtilisateur, p_pwd, null);
	}

	/**
	 * Constructeur Utilisateur à 5 paramètres
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
	 */
	public Utilisateur(String p_nom, String p_prenom, Date p_dateNaissance, char p_sexe, int p_idUtilisateur) {
		this(p_nom, p_prenom, p_dateNaissance, p_sexe, p_idUtilisateur, null);
	}

	/**
	 * Constructeur Utilisateur à 4 paramètres
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
	public Utilisateur(String p_nom, String p_prenom, Date p_dateNaissance, char p_sexe) {
		this(p_nom, p_prenom, p_dateNaissance, p_sexe, 0);
	}

	/**
	 * Constructeur Utilisateur sans paramètre
	 */
	public Utilisateur() {
		super();
	}

	/* (non-Javadoc)
	 * @see biblio.metier.Personne#toString()
	 */
	@Override
	public String toString() {
		String sIdUt = (this.getIdUtilisateur() == 0) ? "non renseigné" : String.valueOf(this.getIdUtilisateur());
		String sPwd = this.getPwd() == null ? "non renseigné" : this.getPwd();
		String sPseudo = this.getPseudonyme() == null ? "non renseigné" : this.getPseudonyme();
		return super.toString() + "\n\t - Utilisateur { idUt: " + sIdUt + " | pwd: " + sPwd + " | pseudo: " + sPseudo + " }";
	}

	/**
	 * Méthode addEmpruntEnCours: ajout d'un emprûnt en cours
	 * 
	 * @param ep:
	 *            l'emprûnt en cours
	 * @author V.Vrillaud
	 * @throws BiblioException 
	 */
	public void addEmpruntEnCours(EmpruntEnCours empc) throws BiblioException {
		if (!this.getEmpruntEnCours().contains(empc)) {
			empruntEnCours.add(empc);
		} else {
			throw new BiblioException("Emprûnt redondant");
		}

	}

	public void removeEmpruntEnCours(EmpruntEnCours empc) {
		empruntEnCours.remove(empc);
	}

	/**
	 * Méthode getEmpruntEnCours: le (ou les) emprûnt(s) en cours
	 * 
	 * @return le (ou les) emprûnt(s) en cours
	 * @author V.Vrillaud
	 */
	public ArrayList<EmpruntEnCours> getEmpruntEnCours() {
		return empruntEnCours;
	}

	/**
	 * Méthode getNbEmpruntsEnCours: le nombre d'emprûnt(s) en cours
	 * 
	 * @return le nombre d'emprûnt(s) en cours
	 * @author V.Vrillaud
	 */
	public int getNbEmpruntsEnCours() {
		return empruntEnCours.size();
	}
}