package edt.textui.exception;

public abstract class TextElementException extends InvalidOperation{

	private _errorCode;
	
	/**
	 * Constructor.
	 */
	public TextElementException(String message, String errorCode){
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