package biblio.exception;

/**
 * @author V.Vrillaud
 *
 */
public class BiblioException extends Exception {

	/**
	 * Serial ID par défaut proposé par Eclipse
	 */
	private static final long serialVersionUID = 1L;

	public BiblioException() {
		super("Problème générique sur l'application bibliothèque");
	}

	public BiblioException(String message) {
		super(message);
	}
}
