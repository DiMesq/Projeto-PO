package edt.core.visitor;

import edt.core.Section;

/**
 * This interface is used to implement the Visitor design pattern.
 * <p>Visitor is the interface which all element types must implement
 *
 * @author Daniel Reigada
 * @author Diogo Mesquita
 * @author Sebastião Araújo
 * @version 1.0
*/
public interface Visitor {

	/**
	 * The visit method for the Section Element.
	 * @param Section s.
	 */
	public void visit(Section s);

}
