package edt.textui.visitors;

import edt.core.visitor.Visitor;

import edt.core.Section;
import edt.core.Paragraph;
import edt.core.Document;

import edt.textui.section.Message;

import pt.utl.ist.po.ui.Display;

import java.util.List;

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

		display.add(getSections(sec, true))
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
	 * @param par the element to visit
	 */
	@Override
	public void visit(Paragraph par){}

	/**
     * Returns the titles from every subsection of the current one
     *
     * @param Section the section to get the subsection's titles from
     * @param boolean firstCall indicates if a call to this function is the
     * first one (true) or a recursive one (false).
     *
     * @return String all titles from the subsections
     */
    private String getSections(Section section, boolean firstCall){

        String content = Message.sectionIndexEntry(section.getKey(),
                                                   section.getTitle()) + "\n";

        //we don't include the current section's title
        if (firstCall) content = "";

        List<Section> subSections = section.getSubsections();

        for (Section s: subSections) content += this.getSections(s, false);

        return content;
    }
}
