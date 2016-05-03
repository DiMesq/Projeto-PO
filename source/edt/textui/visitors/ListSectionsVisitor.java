package edt.textui.visitors;

import edt.core.Document;
import edt.core.Paragraph;
import edt.core.Section;
import edt.core.visitor.Visitor;
import edt.textui.section.Message;

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
	 * The content stored in the visitor
	 */
	private String _content;

	/**
	 * Constructor
 	*/
	public ListSectionsVisitor(){
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
		for (Section s : sec.getSubsections()){
			_content += Message.sectionIndexEntry(s.getKey(),
																							s.getTitle()) +
																							"\n";
			s.accept(this);
		}
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
