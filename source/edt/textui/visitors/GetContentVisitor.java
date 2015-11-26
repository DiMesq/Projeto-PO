package edt.textui.visitors;

import edt.core.visitor.Visitor;

import edt.core.Paragraph;
import edt.core.Section;

import edt.textui.section.Message;

import pt.utl.ist.po.ui.Display;

import java.util.List;

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
	 * @param Section s - the element to visit
	 * @Override
	 */
	public void visit(Section s) {

		Display display = new Display();

		display.add(getSections(s))
			   .display();
	}

	/**
     * Returns all of the Section section content
     *
     * @param Section the section to get all content from
     *
     * @return String all of the content from every subsection of the current one
     */
    private String getSections(Section section){

        String content = Message.sectionIndexEntry(section.getKey(),
                                                   section.getTitle()) +
                                                   "\n";

        List<Paragraph> paragraphs = section.getParagraphs();
        List<Section> subSections = section.getSubsections();

        for (Paragraph p: paragraphs) content += p.getContent() + "\n";

        for (Section s: subSections) content += this.getSections(s);

        return content;
    }
}
