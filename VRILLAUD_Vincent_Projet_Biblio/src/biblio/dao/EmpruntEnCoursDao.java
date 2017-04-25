package biblio.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import biblio.control.MyArrayList;
import biblio.exception.BiblioException;
import biblio.metier.EmpruntEnCours;
import biblio.metier.EnumStatusExemplaire;
import biblio.metier.Exemplaire;
import biblio.metier.Utilisateur;

public class EmpruntEnCoursDao {

	public Connection cnx = null;
	public PreparedStatement pstmt = null;
	public Statement stmt = null;
	public ResultSet rs = null;
	private String requeteSQL = null;
	public UtilisateurDao utDao = null;
	public Utilisateur p_emp = null;
	public ExemplaireDao exDao = null;
	public Exemplaire p_ex = null;
	public EmpruntEnCours empc = null;
	public MyArrayList<EmpruntEnCours> listeEmpruntsEnCours = new MyArrayList<EmpruntEnCours>();
	
	public EmpruntEnCoursDao(Connection cnx) {
		this.cnx = cnx;
	}

	public void insertEmpruntEnCours(Utilisateur p_emp, Exemplaire p_ex) throws BiblioException {

		int p_idExemplaire, p_idUtilisateur = 0;
		Date p_dateEmp = null;
		
		EmpruntEnCours empc = new EmpruntEnCours(p_emp, p_ex);
			
		p_idExemplaire = empc.getExemplaire().getIdExemplaire();
		p_idUtilisateur = empc.getEmprunteur().getIdUtilisateur();
		p_dateEmp = new Date(empc.getDateEmprunt().getTime());
			
		requeteSQL = "INSERT INTO EMPRUNTENCOURS(IDEXEMPLAIRE,IDUTILISATEUR,DATEEMPRUNT) VALUES (?,?,?)";
			
		try {
				
			pstmt = this.cnx.prepareStatement(requeteSQL);
			pstmt.setInt(1,p_idExemplaire);
			pstmt.setInt(2,p_idUtilisateur);
			pstmt.setDate(3,p_dateEmp);
				
			pstmt.executeQuery();
				
			stmt = this.cnx.createStatement();
			requeteSQL = "UPDATE EXEMPLAIRE SET STATUS='PRETE' WHERE IDEXEMPLAIRE=" + p_idExemplaire;
				
			stmt.executeUpdate(requeteSQL);
				
			pstmt.close();
			stmt.close();
			cnx.close();
				
		} catch (SQLException e) {
			System.out.println("\t" + "---> Requête SQL défaillante - " + e.getMessage());
		}

	}
	
	public EmpruntEnCours findEmpruntEnCoursByKey(int p_idEx) throws BiblioException {
		
		int p_idExemplaire, p_idUtilisateur = 0;
		Date p_dateEmp = null;
		
		requeteSQL = "SELECT * FROM EMPRUNTENCOURS WHERE IDEXEMPLAIRE=" + p_idEx;
		
		try {

			stmt = this.cnx.createStatement();
			rs = stmt.executeQuery(requeteSQL);
			
			if (rs.next()) {

				p_idExemplaire = rs.getInt("IDEXEMPLAIRE");
				p_idUtilisateur = rs.getInt("IDUTILISATEUR");
				p_dateEmp = rs.getDate("DATEEMPRUNT");

				UtilisateurDao utDao = new UtilisateurDao(this.cnx);
				p_emp = utDao.findUtilisateurByKey(p_idUtilisateur);
				ExemplaireDao exDao = new ExemplaireDao(this.cnx);
				p_ex = exDao.findExemplaireByKey(p_idExemplaire);
				
				empc = new EmpruntEnCours(p_emp,p_ex,p_dateEmp);
				
			} else {
				throw new BiblioException("Exemplaire inexistant");
			}

			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println("\t" + "---> Requête SQL défaillante - " + e.getMessage());
		}

		return empc;
	}
	
	public MyArrayList<EmpruntEnCours> findAllEmpruntsEnCoursByUtilisateur (Utilisateur p_ut) throws BiblioException {
		
		int p_idExemplaire, p_idUtilisateur = 0;
		Date p_dateEmp = null;
		int p_idUt = p_ut.getIdUtilisateur();
		
		requeteSQL = "SELECT * FROM EMPRUNTENCOURS WHERE IDUTILISATEUR=" + p_idUt;

		try {

			stmt = cnx.createStatement();
			rs = stmt.executeQuery(requeteSQL);

			while (rs.next()) {
				
				p_idExemplaire = rs.getInt("IDEXEMPLAIRE");
				p_idUtilisateur = rs.getInt("IDUTILISATEUR");
				p_dateEmp = rs.getDate("DATEEMPRUNT");

				UtilisateurDao utDao = new UtilisateurDao(this.cnx);
				p_emp = utDao.findUtilisateurByKey(p_idUtilisateur);
				ExemplaireDao exDao = new ExemplaireDao(this.cnx);
				p_ex = exDao.findExemplaireByKey(p_idExemplaire);
				
				p_ex.setStatus(EnumStatusExemplaire.DISPONIBLE);
				empc = new EmpruntEnCours(p_emp,p_ex,p_dateEmp);
				
				listeEmpruntsEnCours.add(empc);
			}
			
			stmt.close();
			rs.close();
			
		} catch (SQLException e) {
			System.out.println("\t" + "---> Requête SQL défaillante - " + e.getMessage());
		}
		
		return listeEmpruntsEnCours;
	}

}