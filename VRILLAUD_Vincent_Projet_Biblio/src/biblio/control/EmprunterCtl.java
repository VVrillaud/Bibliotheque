package biblio.control;

import javax.swing.*;
import biblio.dao.ConnectionFactory;
import biblio.dao.EmpruntEnCoursDao;
import biblio.dao.ExemplaireDao;
import biblio.dao.UtilisateurDao;
import biblio.exception.BiblioException;
import biblio.metier.EmpruntEnCours;
import biblio.metier.Exemplaire;
import biblio.metier.Utilisateur;

public class EmprunterCtl {

	public static void main(String[] args) throws BiblioException {

		String saisie = null;
		Utilisateur ut = null;
		int idUt = 0;
		Exemplaire ex = null;
		int idEx = 0;
		int nbempc = 0;
		String rep = null;

		/*********************************/
		/******* BOUCLE PRINCIPALE *******/
		/*********************************/
		do
		{
		
		/******* SAISIE DE L'IDUTILISATEUR *******/
		saisie = JOptionPane.showInputDialog(null, "Entrez l'identifiant Utilisateur :", "\u25cf CU EMPRÛNTER \u25cf",
				JOptionPane.QUESTION_MESSAGE);
		if (saisie == null || saisie.isEmpty() == true) {
			JOptionPane.showMessageDialog(null, "Au revoir.");
			System.exit(0);
		} else {
			try {
				idUt = Integer.parseInt(saisie);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Entrez un nombre positif, svp !", null,
						JOptionPane.WARNING_MESSAGE);
			}
		}

		/******* OUVERTURE D'UNE CONNECTION *******/
		ConnectionFactory cnxfct = new ConnectionFactory();

		/******* RECHERCHE DANS LA BDD UTILISATEUR *******/
		UtilisateurDao utDao = new UtilisateurDao(cnxfct.getConnection());
		try {
			ut = utDao.findUtilisateurByKey(idUt);
			JOptionPane.showMessageDialog(null, ut, "\u25cf CU EMPRÛNTER \u25cf IdUtilisateur n°" + idUt + " \u25cf",
					JOptionPane.PLAIN_MESSAGE);
		} catch (BiblioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "\u25cf CU EMPRÛNTER \u25cf",
					JOptionPane.WARNING_MESSAGE);
		}

		/******* RECHERCHE DANS LA BDD EMPRUNTENCOURS *******/
		EmpruntEnCoursDao empcDao = new EmpruntEnCoursDao(cnxfct.getConnection());
		MyArrayList<EmpruntEnCours> listeEmpc = null;
		try {
			listeEmpc = empcDao.findAllEmpruntsEnCoursByUtilisateur(ut);
		} catch (BiblioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "\u25cf CU EMPRÛNTER \u25cf",
					JOptionPane.WARNING_MESSAGE);
		}
		
		ut.setEmpruntEnCours(listeEmpc);
		
		nbempc = ut.getNbEmpruntsEnCours();
		
		JOptionPane.showMessageDialog(null, "Nombre d'emprûnts en cours: " + nbempc,
				"\u25cf CU EMPRÛNTER \u25cf IdUt n°" + idUt + " \u25cf", JOptionPane.PLAIN_MESSAGE);
		if (nbempc != 0)
			JOptionPane.showMessageDialog(null, "Liste des emprûnts:\n" + listeEmpc);

		/******* SAISIE DE L'IDEXEMPLAIRE *******/
		saisie = JOptionPane.showInputDialog(null, "Entrez l'identifiant Exemplaire :", "\u25cf CU EMPRÛNTER \u25cf",
				JOptionPane.QUESTION_MESSAGE);
		if (saisie == null || saisie.isEmpty() == true) {
			JOptionPane.showMessageDialog(null, "Au revoir.");
			System.exit(0);
		} else {
			try {
				idEx = Integer.parseInt(saisie);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Entrez un nombre positif, svp !", null,
						JOptionPane.WARNING_MESSAGE);
			}
		}

		/******* RECHERCHE DANS LA BDD EXEMPLAIRE *******/
		ExemplaireDao exDao = new ExemplaireDao(cnxfct.getConnection());
		try {
			ex = exDao.findExemplaireByKey(idEx);
			JOptionPane.showMessageDialog(null, ex, "\u25cf CU EMPRÛNTER \u25cf IdUtilisateur n°" + idEx + " \u25cf",
					JOptionPane.PLAIN_MESSAGE);
		} catch (BiblioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "\u25cf CU EMPRÛNTER \u25cf",
					JOptionPane.WARNING_MESSAGE);
		}

		/******* REALISATION D'UN EMPRÛNT *******/
		try {
		empcDao.insertEmpruntEnCours(ut, ex);
		JOptionPane.showMessageDialog(null, "Emprûnt réalisé", "\u25cf CU EMPRÛNTER \u25cf IdUtilisateur n°" + idEx + " \u25cf",
					JOptionPane.PLAIN_MESSAGE);
		} catch (BiblioException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "\u25cf CU EMPRÛNTER \u25cf",
					JOptionPane.WARNING_MESSAGE);
		}
		
		finally
		{
		rep = JOptionPane.showInputDialog(null, "Voulez-vous effectuer un autre emprûnt ?", "\u25cf CU EMPRÛNTER \u25cf",
				JOptionPane.QUESTION_MESSAGE);
		}
		
		}
		while (rep.toUpperCase().charAt(0) == 'O');
		
		/*********************************/
		/**** BOUCLE PRINCIPALE (FIN) ****/
		/*********************************/
		
		JOptionPane.showMessageDialog(null, "Au revoir.");
		System.exit(0);
		
	}
}