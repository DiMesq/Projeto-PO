package edt.core.visitor;

import edt.core.Section;
import edt.core.Paragraph;
import edt.core.Document;

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
	 * @param Section the Section to visit.
	 */
	public void visit(Section s);

	/**
	 * The visit method for the Paragraph Element.
	 * @param Paragraph the Paragraph to visit.
	 */
	public void visit(Paragraph s);

	/**
	 * The visit method for the Document Element.
	 * @param Document the Document to visit.
	 */
	public void visit(Document s);

}
