package biblio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import biblio.control.MyArrayList;
import biblio.exception.BiblioException;
import biblio.metier.Adherent;
import biblio.metier.Employe;
import biblio.metier.EnumCategorieEmploye;
import biblio.metier.EnumCategorieUtilisateur;
import biblio.metier.Utilisateur;

public class UtilisateurDao {

	/**
	 * 
	 */
	public Connection cnx = null;
	public Statement stmt = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	private int p_idUtilisateur = 0;
	private String requeteSQL, p_nom, p_prenom, p_pwd, p_pseudonyme, p_codeMat, p_telephone = null;
	private EnumCategorieUtilisateur p_catUt = EnumCategorieUtilisateur.EMPLOYE;
	private EnumCategorieEmploye p_catEmp = EnumCategorieEmploye.BIBLIOTHECAIRE;
	private Date p_dateNaissance = null;
	private char p_sexe = ' ';
	public Utilisateur utilisateur = null;
	public MyArrayList<Utilisateur> listeUtilisateurs = new MyArrayList<Utilisateur>();

	/**
	 * @param cnx
	 */
	public UtilisateurDao(Connection cnx) {
		this.cnx = cnx;
	}

	/**
	 * @param p_cnx
	 * @return
	 */
	public Utilisateur createUtilisateur(Connection p_cnx) {
		requeteSQL = "INSERT INTO EXEMPLAIRE(idExemplaire,DateAchat,status,isbn) VALUES (?,?,?,?)";
		try {
			pstmt = p_cnx.prepareStatement(requeteSQL);
		} catch (SQLException e) {
			System.out.println("\t" + "---> Requête SQL défaillante - " + e.getMessage());
		}
		return utilisateur;
	}

	/**
	 * @param p_idExemplaire
	 * @return
	 * @throws BiblioException 
	 */
	public Utilisateur findUtilisateurByKey(int p_idUtilisateur) throws BiblioException {
		
		requeteSQL = "SELECT * FROM UTILISATEUR WHERE IDUTILISATEUR=" + p_idUtilisateur;
		
		try {
			
			stmt = this.cnx.createStatement();
			rs = stmt.executeQuery(requeteSQL);

			if (rs.next()) {
				p_idUtilisateur = rs.getInt("IDUTILISATEUR");
				p_nom = rs.getString("NOM");
				p_prenom = rs.getString("PRENOM");
				p_pwd = rs.getString("PWD");
				p_pseudonyme = rs.getString("PSEUDONYME");
				p_dateNaissance = rs.getDate("DATENAISSANCE");
				p_sexe = rs.getString("SEXE").charAt(0);
				p_catUt = EnumCategorieUtilisateur.valueOf(rs.getString("CATEGORIEUTILISATEUR"));

				if (p_catUt == EnumCategorieUtilisateur.EMPLOYE) {
					
					requeteSQL = "SELECT EMPLOYE.CODEMATRICULE,EMPLOYE.CATEGORIEEMPLOYE FROM "
							+ "UTILISATEUR NATURAL JOIN EMPLOYE WHERE IDUTILISATEUR=" + p_idUtilisateur;
					try {
						
						rs = stmt.executeQuery(requeteSQL);
						
						if (rs.next()) {
							p_codeMat = rs.getString("CODEMATRICULE");
							p_catEmp = EnumCategorieEmploye.valueOf(rs.getString("CATEGORIEEMPLOYE"));
							utilisateur = new Employe(p_nom, p_prenom, p_dateNaissance, p_sexe, p_idUtilisateur, p_pwd,
									p_pseudonyme, p_codeMat, p_catEmp);
						} else {
							throw new BiblioException("Employé inexistant");
						}
						
					} catch (SQLException e) {
						System.out.println("\t" + "---> Requête SQL défaillante - " + e.getMessage());
					}
					
				} else {
					
					requeteSQL = "SELECT ADHERENT.TELEPHONE FROM UTILISATEUR NATURAL JOIN ADHERENT WHERE IDUTILISATEUR=" + p_idUtilisateur;
					
					try {
						
						rs = stmt.executeQuery(requeteSQL);
						
						if (rs.next()) {
							p_telephone = rs.getString("TELEPHONE");
							utilisateur = new Adherent(p_nom, p_prenom, p_dateNaissance, p_sexe, p_idUtilisateur, p_pwd,
									p_pseudonyme, p_telephone);
						} else {
							throw new BiblioException("Adhérent inexistant");
						}
						
					} catch (SQLException e) {
						System.out.println("\t" + "---> Requête SQL défaillante - " + e.getMessage());
					}
				
				}
					
			} else {
				throw new BiblioException("Utilisateur inexistant");
			}
			
			stmt.close();
			rs.close();
			
		} catch (SQLException e) {
			System.out.println("\t" + "---> Requête SQL défaillante - " + e.getMessage());
		}
		
		return utilisateur;
	}

	/**
	 * @return
	 * @throws BiblioException 
	 */
	public MyArrayList<Utilisateur> findAllUtilisateurs() {

		requeteSQL = "SELECT * FROM UTILISATEUR NATURAL JOIN EMPLOYE";

		try {

			stmt = cnx.createStatement();
			rs = stmt.executeQuery(requeteSQL);

			while (rs.next()) {
				
				p_idUtilisateur = rs.getInt("IDUTILISATEUR");
				p_nom = rs.getString("NOM");
				p_prenom = rs.getString("PRENOM");
				p_pwd = rs.getString("PWD");
				p_pseudonyme = rs.getString("PSEUDONYME");
				p_dateNaissance = rs.getDate("DATENAISSANCE");
				p_sexe = rs.getString("SEXE").charAt(0);
				p_catUt = EnumCategorieUtilisateur.valueOf(rs.getString("CATEGORIEUTILISATEUR"));
				p_codeMat = rs.getString("CODEMATRICULE");
				p_catEmp = EnumCategorieEmploye.valueOf(rs.getString("CATEGORIEEMPLOYE"));
				utilisateur = new Employe(p_nom, p_prenom, p_dateNaissance, p_sexe, p_idUtilisateur, p_pwd,
									p_pseudonyme, p_codeMat, p_catEmp);
				listeUtilisateurs.add(utilisateur);
				}
				
			stmt.close();
			rs.close();
			
			} catch (SQLException e) {
				System.out.println("\t" + "---> Requête SQL défaillante - " + e.getMessage());
			}
								
			requeteSQL = "SELECT * FROM UTILISATEUR NATURAL JOIN ADHERENT";
					
			try {
					
				stmt = cnx.createStatement();
				rs = stmt.executeQuery(requeteSQL);
						
				while (rs.next()) {
					
					p_idUtilisateur = rs.getInt("IDUTILISATEUR");
					p_nom = rs.getString("NOM");
					p_prenom = rs.getString("PRENOM");
					p_pwd = rs.getString("PWD");
					p_pseudonyme = rs.getString("PSEUDONYME");
					p_dateNaissance = rs.getDate("DATENAISSANCE");
					p_sexe = rs.getString("SEXE").charAt(0);
					p_catUt = EnumCategorieUtilisateur.valueOf(rs.getString("CATEGORIEUTILISATEUR"));
					p_telephone = rs.getString("TELEPHONE");
					utilisateur = new Adherent(p_nom, p_prenom, p_dateNaissance, p_sexe, p_idUtilisateur, p_pwd,
									p_pseudonyme, p_telephone);
					listeUtilisateurs.add(utilisateur);
				}
				
			stmt.close();
			rs.close();
						
			} catch (SQLException e) {
				System.out.println("\t" + "---> Requête SQL défaillante - " + e.getMessage());
			}

		return listeUtilisateurs;
	}
}