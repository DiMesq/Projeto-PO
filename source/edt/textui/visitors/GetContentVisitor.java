package edt.textui.visitors;

import edt.core.visitor.Visitor;

import edt.core.Paragraph;
import edt.core.Section;
import edt.core.Document;

import pt.utl.ist.po.ui.Display;


/**
 * GetContentVisitor implements the Visitor interface.
 * <p>GetContentVisitor performs the getContent operation on sections and paragraphs.
 *
 * @author Daniel Reigada
 * @author Diogo Mesquita
 * @author Sebastião Araújo
 * @version 1.0
*/
public class GetContentVisitor implements Visitor {

	/**
	 * The Visitor's visit method implementation for Section Element.
	 *
	 * @param sec the element to visit
	 */
	@Override
	public void visit(Section sec) {

		Display display = new Display();

		display.add(Utils.getSections(sec, true, false))
			   .display();
	}

	/**
	 * The Visitor's visit method implementation for Document Element.
	 *
	 * @param doc the element to visit
	 */
	@Override
	public void visit(Document doc) {

		Display display = new Display();
		display.add(Utils.getSections(doc))
				 .display();
	}

	/**
	 * The Visitor's visit method implementation for Paragraph Element.
	 *
	 * @param  par the element to visit
	 */
	@Override
	public void visit(Paragraph par) {

		Display display = new Display();

		display.addNewLine(par.getContent()).display();
	}
}
