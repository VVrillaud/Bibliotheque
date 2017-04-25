package biblio.metier;

import java.util.Date;

//import metier.Exemplaire;

/**
 * @author V.Vrillaud
 *
 */
public class EmpruntArchive {
	
	private Date dateRestitutionEff;
	private Date dateEmprunt;
	private Utilisateur emprunteur;
	private Exemplaire exemplaire;

	/**
	 * @param dateRestitutionEff
	 * @param dateEmprunt
	 * @param emprunteur
	 * @param exemplaire
	 */
	public EmpruntArchive(Date dateRestitutionEff, Date dateEmprunt, Utilisateur emprunteur, Exemplaire exemplaire) {
		setDateRestitutionEff(dateRestitutionEff);
		setDateEmprunt(dateEmprunt);
		setEmprunteur(emprunteur);
		setExemplaire(exemplaire);
	}

	/**
	 * @param dateRestitutionEff
	 * @param dateEmprunt
	 * @param emprunteur
	 */
	public EmpruntArchive(Date dateRestitutionEff, Date dateEmprunt, Utilisateur emprunteur) {
		this(dateRestitutionEff, dateEmprunt, emprunteur, null);
	}

	/**
	 * @param dateRestitutionEff
	 * @param dateEmprunt
	 */
	public EmpruntArchive(Date dateRestitutionEff, Date dateEmprunt) {
		this(dateRestitutionEff, dateEmprunt, null);
	}

	/**
	 * @param dateRestitutionEff
	 */
	public EmpruntArchive(Date dateRestitutionEff) {
		this(dateRestitutionEff, null);
	}

	/**
	 * @roseuid 5241490A0196
	 */
	public EmpruntArchive() {
		this(null);
	}

	/**
	 * @return the dateRestitutionEff
	 */
	public Date getDateRestitutionEff() {
		return dateRestitutionEff;
	}

	/**
	 * @param dateRestitutionEff
	 *            the dateRestitutionEff to set
	 */
	public void setDateRestitutionEff(Date dateRestitutionEff) {
		this.dateRestitutionEff = dateRestitutionEff;
	}

	/**
	 * @return the dateEmprunt
	 */
	public Date getDateEmprunt() {
		return dateEmprunt;
	}

	/**
	 * @param dateEmprunt
	 *            the dateEmprunt to set
	 */
	public void setDateEmprunt(Date dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	/**
	 * @return the emprunteur
	 */
	public Utilisateur getEmprunteur() {
		return emprunteur;
	}

	/**
	 * @param emprunteur
	 *            the emprunteur to set
	 */
	public void setEmprunteur(Utilisateur emprunteur) {
		this.emprunteur = emprunteur;
	}

	/**
	 * @return the exemplaire
	 */
	public Exemplaire getExemplaire() {
		return exemplaire;
	}

	/**
	 * @param exemplaire
	 *            the exemplaire to set
	 */
	public void setExemplaire(Exemplaire exemplaire) {
		this.exemplaire = exemplaire;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmpruntArchive [dateRestitutionEff=" + getDateRestitutionEff() + ", dateEmprunt=" + getDateEmprunt()
				+ ", emprunteur=" + getEmprunteur() + ", exemplaire=" + getExemplaire() + "]";
	}
}
