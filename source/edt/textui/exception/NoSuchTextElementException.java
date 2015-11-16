package edt.textui.exception;

import pt.utl.ist.po.ui.InvalidOperation;

/**
 * This class implements an exception that extends form an {@link InvalidOperation}.
 * <p>When trying to get an inexistent Section.
 *
 * @author Daniel Reigada
 * @author Diogo Mesquita
 * @author Sebastião Araújo
 * @version 1.0
*/
public class NoSuchTextElementException extends InvalidOperation{

	String _errorCode;
	/**
	 * Constructor.
	 */
	public NoSuchTextElementException(String message, String errorCode){
		super(message);
		_errorCode = errorCode;
	}

	/**
	 *	Gets the error code from this exception
	 *
	 *  @return String this exception's error code
	 */
	public String getErrorCode(){
		return _errorCode;
	}
}