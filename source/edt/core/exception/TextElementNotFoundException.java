package edt.core.exception;

/**
 * This class implements an exception that extends form an {@link TextElementException}.
 * <p>It occurs when the text element that is requested was not found.
 *
 * @author Daniel Reigada
 * @author Diogo Mesquita
 * @author Sebastião Araújo
 * @version 1.0
*/
public class TextElementNotFoundException extends TextElementException{

	/**
	 * Constructor.
	 */
	public TextElementNotFoundException(String message, String errorCode){
		super(message, errorCode);
	}

}