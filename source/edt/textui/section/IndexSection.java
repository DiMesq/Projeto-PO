package edt.textui.section;

import edt.core.Section;

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

        Form form = new Form();
        InputInteger localIn = new InputInteger(form, Message.requestSectionId());
        InputString idIn = new InputString(form, Message.requestUniqueId());
        form.parse();

        try {
            entity().getSection(localIn.value());

        } catch (TextElementException e) {
            ProcessError.processError(e.getMessage(), localIn.value());
        }
        
        entity().setKey(idIn.value());
    }
}
