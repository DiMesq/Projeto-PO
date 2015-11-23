package edt.textui.section;

import edt.core.Section;

import edt.core.exception.TextElementException;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InputInteger;

/**
 * Command for indexing ia subsection (nomear secção 2.2.6) the current section .
 */
public class IndexSection extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public IndexSection(Section ent) {
        super(MenuEntry.NAME_SECTION, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        Display display = new Display();

        // get the subsection and the id 
        Form form = new Form();
        InputInteger localIn = new InputInteger(form, Message.requestSectionId());
        InputString idIn = new InputString(form, Message.requestUniqueId());
        form.parse();

        Section section = null;
        try {  //try getting the subsection specified
            section = entity().getSection(localIn.value());
            
            // if the section already has a key, warn the user of the replacement
            if (section.getKey() != "") display.addNewLine(Message.sectionNameChanged());

            // set the new key
            section.setKey(idIn.value());
            entity().getDocument().indexElement(idIn.value(), section);

            display.display();
            
        } catch (TextElementException e) {
            ProcessError.processError(e, localIn.value());
        }
    }
}
