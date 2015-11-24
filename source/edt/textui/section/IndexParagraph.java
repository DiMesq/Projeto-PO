package edt.textui.section;

import edt.core.Section;
import edt.core.Paragraph;

import edt.core.exception.TextElementException;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

/**
 * Command for indexing a paragraph (nomear um parágrafo 2.2.9) of the current section.
 */
public class IndexParagraph extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public IndexParagraph(Section ent) {
        super(MenuEntry.NAME_PARAGRAPH, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        Display display = new Display();

        // get the paragraph and the id 
        Form form = new Form();
        InputInteger localIn = new InputInteger(form, Message.requestParagraphId());
        InputString idIn = new InputString(form, Message.requestUniqueId());
        form.parse();

        Paragraph paragraph = null;
        try {  //try getting the paragraph specified

            paragraph = entity().getParagraph(localIn.value());

            // if the paragraph already has a key, warn the user of the replacement
            if (paragraph.getKey() != "") display.addNewLine(Message.paragraphNameChanged());

            // set the new key
            paragraph.setKey(idIn.value());
            entity().getDocument().indexElement(idIn.value(), paragraph);

            display.display();

        } catch (TextElementException e) {
            ProcessError.processError(e, localIn.value());
        }
    }
}


