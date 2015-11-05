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
public abstract class Document extends Section implements Serializable{

	/**
	 * The file name where the document is stored.
	 */
	private String _filename;

	/**
	 * The list of Authors of the Document.
	 */
	private List<Author> _authors;


	/**
	 * Constructor.
	 */
	public Document(){
		super();
		_filename = ""
		_authors = new ArrayList<Author>();
	}	

	/**
	 * Adds an Author to the Document's authors.
	 *
	 * @param author The new author to add.
	 */
	public void addAuthor(String author){
		_authors.add(author);
	}

	/**
	 * Returns the list of Authors of this Document.
	 *
	 * @return List list of the Authors of this document.
	 */
	public String getAuthors(){
		return _authors;
	}

	

