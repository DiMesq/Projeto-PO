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

	private Document _currentDoc;

	public DocManager(Document d){
		_currentDoc = d;
	}

	public void setDocument(Document d){
		_currentDoc = d;
	}

	public Document getDocument(){
		return _currentDoc;
	}


}