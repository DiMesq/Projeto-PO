package edt.visitor;

/**
 * This interface is used to implement the Visitor design pattern.
 * <p>Element is the interface which all element types must implement
 * 
 * @author Daniel Reigada
 * @author Diogo Mesquita
 * @author Sebastião Araújo
 * @version 1.0
*/
public interface Element {

	/**
	 * The accept method for the Element
	 * @param Visitor the visitor to accept
	 */
	public void accept(Visitor v);

}


