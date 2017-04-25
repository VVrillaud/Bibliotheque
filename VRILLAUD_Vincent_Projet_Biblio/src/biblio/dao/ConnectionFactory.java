package biblio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static String nomPilote = "oracle.jdbc.driver.OracleDriver";
	private static String urlBD = "jdbc:oracle:thin:@localhost:1521";
	//private static String urlBD = "jdbc:oracle:thin:@localhost:1521:orcl12c";
	private static String authorizationID = "biblio";
	//private static String authorizationID = "system";
	private static String password = "bibliovinz";
	//private static String password = "oracle";

	/**
	 * 
	 */
	public Connection cnx = null;

	/**
	 * Méthode getConnection (avec Autocommit)
	 * 
	 * @param p_nomPilote:
	 *            le nom du driver
	 * @param p_urlBD:
	 *            l'url de la connexion
	 * @param p_authorizationID:
	 *            le login de la connexion
	 * @param p_password:
	 *            le mot de passe de la connexion
	 * @return cnx: une connexion avec Autocommit
	 */
	public Connection getConnection() {
		try {
			Class.forName(nomPilote);
			cnx = DriverManager.getConnection(urlBD, authorizationID, password);
			cnx.setAutoCommit(true);
		} catch (ClassNotFoundException e) {
			System.out.println("---> Driver absent - " + e.getMessage());
			System.exit(0);
		} catch (SQLException e) {
			System.out.println("---> Connexion défaillante - " + e.getMessage());
			System.exit(0);
		}
		return cnx;
	}

	/**
	 * Méthode getConnection (sans Autocommit)
	 * 
	 * @param p_nomPilote:
	 *            le nom du driver
	 * @param p_urlBD:
	 *            l'url de la connexion
	 * @param p_authorizationID:
	 *            le login de la connexion
	 * @param p_password:
	 *            le mot de passe de la connexion
	 * @return cnx: une connexion sans Autocommit
	 */
	public Connection getConnectionSansAutoCommit() {
		try {
			Class.forName(nomPilote);
			cnx = DriverManager.getConnection(urlBD, authorizationID, password);
			cnx.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			System.out.println("---> Driver absent - " + e.getMessage());
			System.exit(0);
		} catch (SQLException e) {
			System.out.println("---> Connexion défaillante - " + e.getMessage());
			System.exit(0);
		}
		return cnx;
	}
}