package edt.textui.main;

import edt.core.*;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

import java.util.List;

/**
 * Command for showing the text element with a given identifier of the current document in the editor.
 */
public class ShowTextElement extends Command<DocManager> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowTextElement(DocManager ent) {
        super(MenuEntry.SHOW_TEXT_ELEMENT, ent);
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

        Form form = new Form();
        InputString in = new InputString(form, Message.requestElementId());
        form.parse();

        // TODO: para não ser preciso esta porcaria tambem precisamos do VISITOR: no textElement 
        // tem entao de estar definido o metodo getContent em abstract
        try{
            Section section = (Section) entity().getDocument().getTextElement(in.value());

            if (section == null) display.addNewLine(Message.noSuchTextElement(in.value()))
                                    .display();

            else display.addNewLine(getSections(section)).display();

        } catch (ClassCastException c){
            Paragraph paragraph = (Paragraph) entity().getDocument()
                                                      .getTextElement(in.value());

            display.addNewLine(paragraph.getContent()).display();
        }
        
    }
}
