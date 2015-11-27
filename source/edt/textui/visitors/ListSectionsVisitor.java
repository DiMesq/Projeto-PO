package edt.textui.visitors;

import edt.core.visitor.Visitor;

import edt.core.Section;
import edt.core.Paragraph;
import edt.core.Document;

import pt.utl.ist.po.ui.Display;

/**
 * ListSectionsVisitor implements the Visitor interface.
 * <p>ListSectionsVisitor performs the listSections operation on sections.
 *
 * @author Daniel Reigada
 * @author Diogo Mesquita
 * @author Sebastião Araújo
 * @version 1.0
*/
public class ListSectionsVisitor implements Visitor {

	/**
	 * The Visitor's visit method implementation for Section Element.
	 *
	 * @param sec the element to visit
	 */
	@Override
	public void visit(Section sec) {

		Display display = new Display();

		display.add(Utils.getSections(sec, false, true))
			   .display();
	}

	/**
	 * The Visitor's visit method implementation for Document Element.
	 *
	 * @param doc the element to visit
	 */
	@Override
	public void visit(Document doc){
		visit((Section) doc);
	}

	/**
	 * The Visitor's visit method implementation for Document Element.
	 * Does not have an implementation because Paragraphs have no Sections
	 * @param par the element to visit
	 */
	@Override
	public void visit(Paragraph par){}
}
