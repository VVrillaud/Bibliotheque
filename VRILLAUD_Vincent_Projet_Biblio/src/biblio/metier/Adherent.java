/** VERIF LE 20-04-17 **/

package biblio.metier;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import biblio.exception.BiblioException;
import biblio.metier.EmpruntEnCours;
import biblio.metier.Utilisateur;

/**
 * Classe Adherent: le concept de l'Adherent
 * @author V.Vrillaud
 */
public class Adherent extends Utilisateur {
	/**
	 * Attribut telephone: le numéro de téléphone de l'adhérent
	 */
	private String telephone = null;

	/**
	 * Accesseur getTelephone: accesseur sur le numéro de téléphone de
	 * l'adhérent
	 * 
	 * @return telephone: le numéro de téléphone de l'adhérent
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Mutateur setTelephone: mutateur sur le numéro de téléphone de l'adhérent
	 * 
	 * @param telephone:
	 *            le numéro de téléphone à attribuer à l'adhérent
	 */
	public void setTelephone(String p_telephone) {
		this.telephone = p_telephone;
	}

	/**
	 * Attribut statique nbMaxPrets: le nombre maximal de prêts autorisé par
	 * adhérent
	 */
	private static int nbMaxPrets = 3;
	/**
	 * Attribut statique dureeMaxPrets: la durée maximale d'un prêt autorisée
	 * (en jours)
	 */
	private static int dureeMaxPrets = 15;
	/**
	 * Attribut nbRetards: le nombre de retards de l'adhérent
	 */
	private int nbRetards = 0;

	/**
	 * Accesseur getNbRetard: accesseur sur le nombre de retard de l'adhérent
	 * 
	 * @return nbRetards: le nombre de retards de l'adhérent
	 */
	public int getNbRetards() {
		GregorianCalendar gc = new GregorianCalendar();
		gc.add(Calendar.DAY_OF_YEAR, -dureeMaxPrets);
		Date dateMinSansRetard = gc.getTime();
		nbRetards = 0;
		for (EmpruntEnCours empc : this.getEmpruntEnCours()) {
			boolean test = false;
			test = (dateMinSansRetard.after(empc.getDateEmprunt()));
			if (test) {
				nbRetards++;
			}
		}

		return this.nbRetards;
	}

	/**
	 * Constructeur Adherent à 8 paramètres
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
	 * @param telephone:
	 *            le numéro de téléphone de l'adhérent
	 */
	public Adherent(String p_nom, String p_prenom, Date p_dateNaissance, char p_sexe, int p_idUtilisateur, String p_pwd,
			String p_pseudonyme, String p_telephone) {
		super(p_nom, p_prenom, p_dateNaissance, p_sexe, p_idUtilisateur, p_pwd, p_pseudonyme);
		this.setTelephone(p_telephone);
	}

	/**
	 * Constructeur Adherent à 7 paramètres
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
	public Adherent(String p_nom, String p_prenom, Date p_dateNaissance, char p_sexe, int p_idUtilisateur, String p_pwd,
			String p_pseudonyme) {
		this(p_nom, p_prenom, p_dateNaissance, p_sexe, p_idUtilisateur, p_pwd, p_pseudonyme, null);
	}

	/**
	 * Constructeur Adherent sans paramètre
	 */
	public Adherent() {
		super();
	}

	/* (non-Javadoc)
	 * @see biblio.metier.Utilisateur#toString()
	 */
	@Override
	public String toString() {
		String sTel = this.getTelephone() == null ? "non renseigné" : this.getTelephone();
		return super.toString() + "\n\t - Adhérent < téléphone: " + sTel + " . nbMaxPrêts: " + nbMaxPrets
				+ " . duréeMaxPrêt: " + dureeMaxPrets + " jours >";
	}

	/**
	 * Méthode isConditionsPretAcceptees: vérification des conditions de prêt
	 * 
	 * @return boolean: si les conditions de prêt sont acceptées ou non
	 * @throws BiblioException 
	 */
	public boolean isConditionsPretAcceptees() throws BiblioException {
		if (this.getNbRetards() == 0 && this.getNbEmpruntsEnCours() < 3) {
			return true;
		} else {
			throw new BiblioException("conditions de prêt non remplies");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see biblioFR.metier.Utilisateur#addEmpruntEnCours(biblioFR.metier.
	 * EmpruntEnCours)
	 */
	@Override
	public void addEmpruntEnCours(EmpruntEnCours empc) throws BiblioException {
		if (isConditionsPretAcceptees()) {
			this.getEmpruntEnCours().add(empc);
		} else {
			this.getEmpruntEnCours().add(null);
		}
	}
}