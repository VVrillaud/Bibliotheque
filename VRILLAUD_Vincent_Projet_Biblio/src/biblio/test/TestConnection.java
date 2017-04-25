package biblio.test;

import java.sql.Connection;
import java.sql.SQLException;

import biblio.dao.ConnectionFactory;

/**
 * @author V.Vrillaud
 *
 */
public class TestConnection {
	
	public static void main(String[] args) {
		
		ConnectionFactory cnxfct = new ConnectionFactory();
		Connection cnx1 = cnxfct.getConnection();
		System.out.println("Connexion n°1 (avec autocommit) à la BDD réussie - " + cnx1);
		try {
			cnx1.close();
		} catch (SQLException e) {
			System.out.println("Fermeture de connexion défaillante - " + e.getMessage());
		}
	
		Connection cnx2 = cnxfct.getConnectionSansAutoCommit();
		System.out.println("Connexion n°2 (sans autocommit) à la BDD réussie - " + cnx2);
		try {
			cnx2.close();
		} catch (SQLException e) {
			System.out.println("Fermeture de connexion défaillante - " + e.getMessage());
		}
	}
}