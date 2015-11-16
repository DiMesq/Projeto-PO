package edt.core;

/**
 * This class implements a Paragraph.
 * <p>A Paragraph has some content represented as a String.
 * 
 * @author Daniel Reigada
 * @author Diogo Mesquita
 * @author Sebastião Araújo
 * @version 1.0
*/
public class Paragraph extends TextElement {
	/**
	 * The Content of the Paragraph
	 */
	private String _text;

	/**
	 * Constructor
	 */
	public Paragraph() {
		super();
		_text = "";
	}
	
	/**
	 * Sets/changes the content of this Paragraph
	 *
	 * @param text The new content to be set
	 */
	public void setText(String text) {
		_text = text;
	}

	/**
	 * Returns the content of this Paragraph
	 *
	 * @return The content of this Paragraph
	*/
	public String getContent() {
		return _text;
	}

	/**
	 * Returns the size of this Paragraph
	 *
	 * @return The size of this Paragraph
	 */
	public int getSize() {
		return _text.length();
	}
}