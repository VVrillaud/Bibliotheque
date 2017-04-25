package biblio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import biblio.control.MyArrayList;
import biblio.exception.BiblioException;
import biblio.metier.EnumStatusExemplaire;
import biblio.metier.Exemplaire;
import biblio.metier.Livre;

public class ExemplaireDao {

	/**
	 * 
	 */
	public Connection cnx = null;
	public Statement stmt = null;
	public PreparedStatement pstmt = null;
	public ResultSet rs = null;
	private String requeteSQL = null;
	public Exemplaire exemplaire = null;
	public MyArrayList<Exemplaire> listeExemplaires = new MyArrayList<Exemplaire>();

	/**
	 * @param cnx
	 */
	public ExemplaireDao(Connection cnx) {
		this.cnx = cnx;
	}

	/**
	 * @param p_cnx
	 * @return
	 */
	public Exemplaire createExemplaire(Connection p_cnx) {

		requeteSQL = "INSERT INTO EXEMPLAIRE(idExemplaire,DateAchat,status,isbn) VALUES (?,?,?,?)";
		try {
			pstmt = p_cnx.prepareStatement(requeteSQL);
		} catch (SQLException e) {
			System.out.println("\t" + "---> Requête SQL défaillante - " + e.getMessage());
		}
		return exemplaire;
	}

	/**
	 * @param p_idExemplaire
	 * @return
	 * @throws BiblioException
	 */
	public Exemplaire findExemplaireByKey(int p_idEx) throws BiblioException {

		int p_idExemplaire = 0;
		String p_isbn = null;
		EnumStatusExemplaire p_status = EnumStatusExemplaire.DISPONIBLE;
		Date p_dateAchat = null;
		Livre livre = null;
		
		requeteSQL = "SELECT * FROM EXEMPLAIRE WHERE IDEXEMPLAIRE=" + p_idEx;

		try {

			stmt = this.cnx.createStatement();
			rs = stmt.executeQuery(requeteSQL);

			if (rs.next()) {
				
				p_idExemplaire = rs.getInt("IDEXEMPLAIRE");
				p_dateAchat = rs.getDate("DATEACHAT");
				p_status = EnumStatusExemplaire.valueOf(rs.getString("STATUS"));
				p_isbn = rs.getString("ISBN");
				livre = null;

				exemplaire = new Exemplaire(p_idExemplaire, p_dateAchat, p_status, p_isbn, livre);
			
			} else {
				throw new BiblioException("Exemplaire inexistant");
			}

			stmt.close();
			rs.close();

		} catch (SQLException e) {
			System.out.println("\t" + "---> Requête SQL défaillante - " + e.getMessage());
		}

		return exemplaire;
	}

	/**
	 * @return
	 */
	public MyArrayList<Exemplaire> findAllExemplaires() {

		int p_idExemplaire = 0;
		String p_isbn = null;
		EnumStatusExemplaire p_status = EnumStatusExemplaire.DISPONIBLE;
		Date p_dateAchat = null;
		Livre livre = null;
		
		requeteSQL = "SELECT * FROM EXEMPLAIRE";

		try {

			stmt = cnx.createStatement();
			rs = stmt.executeQuery(requeteSQL);

			while (rs.next()) {
				
				p_idExemplaire = rs.getInt("IDEXEMPLAIRE");
				p_dateAchat = rs.getDate("DATEACHAT");
				p_status = EnumStatusExemplaire.valueOf(rs.getString("STATUS"));
				p_isbn = rs.getString("ISBN");
				livre = null;

				exemplaire = new Exemplaire(p_idExemplaire, p_dateAchat, p_status, p_isbn, livre);
				listeExemplaires.add(exemplaire);
			}
			
			stmt.close();
			rs.close();
			
		} catch (SQLException e) {
			System.out.println("\t" + "---> Requête SQL défaillante - " + e.getMessage());
		}

		return listeExemplaires;
	}
}