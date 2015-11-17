package edt.textui.section;

import edt.core.Section;
import edt.core.Paragraph;

import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

import java.util.List;
/**
 * Command for showing the content of current section.
 */
public class ShowSection extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowSection(Section ent) {
        super(MenuEntry.SHOW_CONTENT, ent);
    }

    //TODO: mudar isto tudo usando o padrão de desenho VISITOR
    /**
     * Returns all of the current section's content
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

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();

        //show all content from the current section and all its subsections
        display.add(this.getSections(entity())); 

        display.display();
     }
}
