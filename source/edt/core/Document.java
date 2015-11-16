package edt.core;

import java.util.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import edt.textui.exception.TextElementNotFoundException;
import edt.textui.exception.TextElementIOException;

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
	 * Constructor.
	 */
	public Document(){
		_filename = "";
		_authors = new TreeSet<Author>();
		this.setDocument(this);
	}

	/**
	 * Adds an Author to the Document's authors.
	 *
	 * @param author the new author to add.
	 */
	public void addAuthor(Author author){
		_authors.add(author);
	}

	/**
	 * Returns an array containing all of the Authors in this Document.
	 * @return An array containing all of the Authors in this Document.
	 */
	public Author[] getAuthors(){
		Author[] array = new Author[0];	// create an auxiliary array
		return _authors.toArray(array);
	}

	// TODO: implement this
	public TextElement getTextElement(String id){return null;}

	//TODO: implement this
	public void indexElement(String id, TextElement element){}

	//TODO: implement this
	public void removeFromIndex(TextElement element){}

	// TODO: implement this
	public int getNumberOfIndex(){return 0;}

	/**
	 * Returns the Headline of this Document in the following format:
	 * {Document title}
	 *
	 * @return string the Headline of this Document. {Document title}
	 */
	public String getHeadline(){
		return String.format("{%s}", getTitle());
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
			throw new TextElementIOException(i.getMessage(), "DOCUMENT_SERIALIZE_EXCEPTION");

		} finally{
			try{
				out.close();
				fileOut.close();

			} catch (IOException i){
				throw new TextElementIOException(i.getMessage(), "FILE_CLOSE_EXCEPTION");
			}
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
			throw new TextElementNotFoundException(c.getMessage(), "DOCUMENT_NOT_FOUND_EXCEPTION");

		} catch (IOException i){
			throw new TextElementIOException(i.getMessage(), "DOCUMENT_DESERIALIZE_EXCEPTION");

		} finally{
			try{
				// close the open resources
				objIn.close();
				fileIn.close();
				return doc;
			
			} catch (IOException i){
				throw new TextElementIOException(i.getMessage(), "FILE_CLOSE_EXCEPTION");
			}
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

}
