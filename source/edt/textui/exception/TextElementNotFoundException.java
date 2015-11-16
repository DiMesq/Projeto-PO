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
public class TextElementNotFoundException extends TextElementException{

	/**
	 * Constructor.
	 */
	public TextElementNotFoundException(String message, String errorCode){
		super(message, errorCode);
	}

}