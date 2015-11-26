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
	 * @param sec the Section to visit.
	 */
	public void visit(Section sec);

	/**
	 * The visit method for the Paragraph Element.
	 * @param par the Paragraph to visit.
	 */
	public void visit(Paragraph par);

	/**
	 * The visit method for the Document Element.
	 * @param doc the Document to visit.
	 */
	public void visit(Document doc);

}
