package edt.core.exception;

/**
 * This class implements an exception that extends form an {@link TextElementException}.
 * <p>It occurs when there is some problem with the IO of a text element.
 *
 * @author Daniel Reigada
 * @author Diogo Mesquita
 * @author Sebastião Araújo
 * @version 1.0
*/
public class TextElementIOException extends TextElementException{

	/**
	 * Constructor.
	 * @param message the message for the exception
	 * @param errorCode the error code for the exception
	 */
	public TextElementIOException(String message, String errorCode){
		super(message, errorCode);
	}

}
