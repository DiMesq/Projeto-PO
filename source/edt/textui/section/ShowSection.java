package edt.textui.section;

import edt.core.Section;
import edt.core.Paragraph;
import edt.core.Document;

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
    private String getSections(Section section, boolean type){

        String content;

        if(type)
          content = "{" + section.getTitle() + "}\n";
        else
          content = Message.sectionIndexEntry(section.getKey(),
                                                     section.getTitle()) +
                                                     "\n";

        List<Paragraph> paragraphs = section.getParagraphs();
        List<Section> subSections = section.getSubsections();

        for (Paragraph p: paragraphs) content += p.getContent() + "\n";

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

        //show all content from the current section and all its subsections
        if(entity() instanceof Document)
          display.add(this.getSections(entity(), true));
        else
          display.add(this.getSections(entity(), false));

        display.display();
     }
}
