package edt.textui.section;

import edt.core.Section;
import edt.core.Paragraph;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;

/**
 * Command for adding a paragraph to the current section.
 */
public class InsertParagraph extends Command<Section> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public InsertParagraph(Section ent) {
        super(MenuEntry.INSERT_PARAGRAPH, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        // ask for the index and the title
        Form form = new Form();
        InputInteger indexIn = new InputInteger(form, Message.requestParagraphId());
        InputString contentIn = new InputString(form, Message.requestParagraphContent());
        form.parse();

        //add the section
        entity().addParagraph(
            indexIn.value(),
            new Paragraph(contentIn.value())
        );
    }
}
