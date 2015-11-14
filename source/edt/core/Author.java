package edt.core;

/**
 * This class implements an Author of a {@link Document}.
 * <p>An Author has a name and an email.
 *
 * @author Daniel Reigada
 * @author Diogo Mesquita
 * @author Sebastião Araújo
 * @version 1.0
*/

public class Author implements java.io.Serializable, Comparable<Author>{

	/**
	 * The name of the Author
	 */
	private String _name;

	/**
	 * The email of the Author
	 */
	private String _email;

	/**
	 * The default constructor
	 *
	 * @param name The name of the Author
	 * @param email The email of the Author
	 */
	public Author(String name, String email){
		_name = name;
		_email = email;
	}

	/**
	 * Returns the name of this Author
	 *
	 * @return The name of this Author
	 */
	public String getName(){
		return _name;
	}

	/**
	 * Returns the email of this Author
	 *
	 * @return The email of this Author
	 */
	public String getEmail(){
		return _email;
	}

	/**
	 * Compares two Authors lexicographically by their names, ignoring case differences
	 * @param  author the Author to be compared
	 * @return a negative integer, zero, or a positive integer as the specified
	 * Author is greater than, equal to, or less than this Author,
	 * ignoring case considerations.
	 */
	@Override
	public int compareTo(Author author){
		return _name.compareToIgnoreCase(author.getName());
	}

	@Override
	public boolean equals(Object obj){
		return (obj != null &&
						obj instanceof Author &&
						compareTo((Author) obj) == 0);
	}
}
