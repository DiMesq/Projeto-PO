package edt.textui.visitors;

import edt.core.visitor.Visitor;

import edt.core.Paragraph;
import edt.core.Section;
import edt.core.Document;

import edt.textui.main.Message;

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
	 * The content stored in the visitor
	 */
	private String _content;

	/**
	 * Constructor
 	*/
	public GetContentVisitor(){
		_content = "";
	}

	/**
	 * Returns the stored content in this visitor
	 * @return the stored content in this visitor
	 */
	public String getContent(){
		return _content;
	}

	/**
	 * The Visitor's visit method implementation for Section Element.
	 *
	 * @param sec the element to visit
	 */
	@Override
	public void visit(Section sec) {

		_content += Message.sectionIndexEntry(sec.getKey(),
		                                      sec.getTitle()) +
		                                      "\n";
		iterateOverContent(sec);
	}

	/**
	 * The Visitor's visit method implementation for Document Element.
	 *
	 * @param doc the element to visit
	 */
	@Override
	public void visit(Document doc) {
		_content += "{" + doc.getTitle() + "}\n";
		iterateOverContent(doc);
	}

	/**
	 * Helper method to add the content of a section's TextElements
	 * @param sec the Section to iterate over
	 */
	private void iterateOverContent(Section sec){
		for (Paragraph p: sec.getParagraphs())
			p.accept(this);

		for (Section s : sec.getSubsections())
			s.accept(this);
	}

	/**
	 * The Visitor's visit method implementation for Paragraph Element.
	 *
	 * @param  par the element to visit
	 */
	@Override
	public void visit(Paragraph par) {
		_content += par.getContent() + "\n";
	}
}
