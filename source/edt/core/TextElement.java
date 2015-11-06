package edt.core;

/**
 * This abstract class implements a TextElement of a {@link Document}.
 * <p>A TextElement has an id and some content that can be represented as Strings
 * 
 * @author Daniel Reigada
 * @author Diogo Mesquita
 * @author Sebastião Araújo
 * @version 1.0
*/
public abstract class TextElement implements java.io.Serializable{
	
	/**
	 * The key of the TextElement
	 */
	private String _key;	

	/**
	 * Constructor
	 */
	public TextElement(){
		_key = null;
	}

	/**
	 * Returns the key of this TextElement
	 *
	 * @return string the key of this TextElement (null if it is not indexed)
	 */
	public String getKey(){
		return _key;
	}

	/**
	 * Sets/Changes the key of this TextElement
	 *
	 * @param key The new key to be set
	 */
	public void setKey(String key){
		_key = key;
	}

	/**
	 * Returns true if this TextElement is indexed
	 *
	 * @return boolean true if this TextElement is indexed
	 */
	protected boolean isIndexed(){
		return _key == null;
	}

	/**
	 * Returns the size of this TextElement
	 *
	 * @return int the size of this TextElement
	 */
	public abstract int getSize();

}
