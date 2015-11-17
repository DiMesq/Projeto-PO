package edt.textui.section;

import edt.core.Section;
import edt.core.Paragraph;

import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

import java.util.List;

/**
 * Command for listing all subsections of the current section.
 */
public class ListSections extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ListSections(Section ent) {
        super(MenuEntry.LIST_SECTIONS, ent);
    }

    //TODO: mudar isto tudo usando o padrão de desenho VISITOR
    /**
     * Returns the titles from every subsection of the current one
     *
     * @param Section the section to get the subsection's titles from 
     * @param boolean first_call indicates if a call to this function is the
     * first one (true) or a recursive one (false).
     *
     * @return String all titles from the subsections 
     */
    private String getSections(Section section, boolean firstCall){

        String content = Message.sectionIndexEntry(section.getKey(), 
                                                   section.getTitle()) + "\n";

        if (firstCall) content = "";
                    
        List<Paragraph> paragraphs = section.getParagraphs();
        List<Section> subSections = section.getSubsections();

        for (Section s: subSections) content += this.getSections(s, false);

        return content;
    }
    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();

        //show the current section subsection's titles
        display.add(this.getSections(entity(), true));

        display.display();
    }
}
