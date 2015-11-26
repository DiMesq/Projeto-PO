package edt.core;

/**
 * This class implements a Document Manager.
 * <p>A Document manager is used to keep the document that is currenctly active
 *
 * @author Daniel Reigada
 * @author Diogo Mesquita
 * @author Sebastião Araújo
 * @version 1.0
*/
public class DocManager{

	/**
	 * The Current Document
	 */
	private Document _currentDoc;

	/**
	 * Constructor
	 * @param d the Document
	 */
	public DocManager(Document d){
		_currentDoc = d;
	}

	/**
	 * Sets the current Document
	 * @param d the document to be set
	 */
	public void setDocument(Document d){
		_currentDoc = d;
	}

	/**
	 * Gets the current Document
	 * @return The current Document
	 */
	public Document getDocument(){
		return _currentDoc;
	}


}
