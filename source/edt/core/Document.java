package edt.core;

import edt.core.exception.*;
import edt.core.visitor.Visitor;

import java.util.TreeSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/**
 * This abstract class implements a Document.
 * <p>A Document has a filename where it is stored and a list of it's Authors
 *
 * @author Daniel Reigada
 * @author Diogo Mesquita
 * @author Sebastião Araújo
 * @version 1.0
*/
public class Document extends Section{

	/**
	 * The file name where the document is stored.
	 */
	private transient String _filename;

	/**
	 * The set of Authors of the Document.
	 */
	private Set<Author> _authors; //will use it as an TreeSet so we know it is serializable

	/**
	 * The map of the id key and the respective text element value
	 */
	private Map<String, TextElement> _map;

	/**
	 * Constructor.
	 */
	public Document(){
		_filename = "";
		_authors = new TreeSet<Author>();
		_map = new HashMap<String, TextElement>();
		this.setDocument(this);
	}

	/**
	 * Adds an Author to the Document's authors.
	 *
	 * @param author the new author to add.
	 * @return true if this Document did not already contain the specified Author
	 */
	public boolean addAuthor(Author author){
		return _authors.add(author);
	}

	/**
	 * Returns an array containing all of the Authors in this Document.
	 * @return An array containing all of the Authors in this Document.
	 */
	public Author[] getAuthors(){
		Author[] array = new Author[0];	// create an auxiliary array
		return _authors.toArray(array);
	}

	/**
	 * Returns the TextElement in this document that has a given ID
	 * @param  id The ID of the TextElement to be returned
	 * @return TextElement  The TextElement in this document that has a given ID
	 */
	public TextElement getTextElement(String id) {
		return _map.get(id);
	}

	/**
	 * Associates the given TextElement to an ID
	 * @param  id The id for the TextElement
	 * @param  element The TextElement to associate the given ID
	 */
	public void indexElement(String id, TextElement element) {

		// remove any older association that the element had
		if (element.getKey() != "")
			_map.remove(element.getKey());

		// set the key of the element and adds it
		element.setKey(id);
		TextElement retrievedElement = _map.put(id, element);

		if (retrievedElement != null) retrievedElement.unsetKey();
	}

	/**
	 * Removes the association of a TextElement to its ID
	 * @param element The TextElement to remove the association
	 */
	public void removeFromIndex(TextElement element){
		_map.remove(element.getKey());
		element.unsetKey();
	}

	/**
	 * Returns the number of TextElements in this document that have an ID
	 * @return The number of TextElements in this document that have an ID
	 */
	public int getNumberOfIndex() {
		return _map.size();
	}

	/**
	 * Saves (serializes) the Document in the file with name _filename.
	 */
	public void saveDocument() throws TextElementIOException{
		FileOutputStream fileOut = null;
		ObjectOutputStream out = null;

		try{
			// serialize object
			fileOut = new FileOutputStream(_filename);
			out = new ObjectOutputStream(fileOut);
			out.writeObject(this);

		} catch (IOException i){
			throw new TextElementIOException(i.getMessage(), ErrorCode.DOCUMENT_SERIALIZE_ERROR);
		}

		try{
			out.close();
			fileOut.close();

		} catch (IOException i){
			throw new TextElementIOException(i.getMessage(), ErrorCode.FILE_CLOSE_ERROR);
		}
	}

	/**
	 * Loads (deserializes) the Document from the file with name filename.
	 *
	 * @param filename the file name where the Document is saved (serialized).
	 * @return the Document that is saved in the file
	 */
	public static Document loadDocument(String filename) throws TextElementNotFoundException, TextElementIOException{

		Document doc = null;
		FileInputStream fileIn = null;
		ObjectInputStream objIn = null;

		try{
			// desserialize the object
			fileIn = new FileInputStream(filename);
			objIn = new ObjectInputStream(fileIn);
			doc = (Document) objIn.readObject();

		} catch (ClassNotFoundException c){
			throw new TextElementNotFoundException(c.getMessage(), ErrorCode.DOCUMENT_NOT_FOUND);

		} catch (IOException i){
			throw new TextElementIOException(i.getMessage(), ErrorCode.DOCUMENT_DESERIALIZE_ERROR);

		}

		try{
			// close the open resources
			objIn.close();
			fileIn.close();
			return doc;

		} catch (IOException i){
			throw new TextElementIOException(i.getMessage(), ErrorCode.FILE_CLOSE_ERROR);
		}


	}

	/**
	 * Set/change the name of the file where to save and load this Document.
	 *
	 * @param filename The new file name to set.
	 */
	public void setFileName(String filename){
		_filename = filename;
	}

	/**
	 * Returns the name of the file where this Document is saved.
	 *
	 * @return String the name of the file where this Document is saved.
	 */
	public String getFileName(){
		return _filename;
	}

	/**
	 * The Section Element accept method - implementation
	 *
	 * @param v the visitor to accept
	 */
	@Override
	public void accept(Visitor v) {
		v.visit(this);
	}

}
