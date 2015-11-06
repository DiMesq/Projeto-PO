package edt.core;

import java.util.*;

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
	private String _filename;

	/**
	 * The list of Authors of the Document.
	 */
	private List<Author> _authors; //will use it as an ArrayList so we know it is serializable


	/**
	 * Constructor.
	 */
	public Document(){
		super();
		_filename = "";
		_authors = new ArrayList<Author>();
	}	

	/**
	 * Adds an Author to the Document's authors.
	 *
	 * @param Author the new author to add.
	 */
	public void addAuthor(Author author){
		_authors.add(author);
	}

	/**
	 * Returns the list of Authors of this Document.
	 *
	 * @return List<Author> list of the Authors of this document.
	 */
	public List<Author> getAuthors(){
		return _authors;
	}

	/**
	 * Saves (serializes) the Document in the file with name _filename.
	 */
	public void saveDocument() throws IOException{
		
		FileOutputStream fileOut = new FileOutputStream(_filename);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(this);	
		out.close();
		fileOut.close();

	}

	/**
	 * Loads (deserializes) the Document from the file with name filename.
	 *
	 * @param string the file name where the Document is saved (serialized).
	 */
	public Document loadDocument(String filename) throws ClassNotFoundException, IOException{

		FileInputStream fileIn = new FileInputStream(filename);
		ObjectInputStream in = new ObjectInputStream(fileIn);

		Document doc = (Document) in.readObject();
		in.close();
		fileIn.close();

		return doc;
	}

	/**
	 * Set/change the name of the file where to save and load this Document.
	 *
	 * @param Author The new author to add.
	 */
	public void setFileName(String filename){

		_filename = filename;
		System.out.println("ISTO FOI O FICHEIRO: " + _filename);
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

