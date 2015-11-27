package edt.textui.section;

import edt.core.Section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

/**
 * Command for adding a subsection to current section.
 */
public class InsertSection extends Command<Section> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public InsertSection(Section ent) {
        super(MenuEntry.INSERT_SECTION, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        // ask for the index and the title
        Form form = new Form();
        InputInteger indexIn = new InputInteger(form, Message.requestSectionId());
        InputString titleIn = new InputString(form, Message.requestSectionTitle());
        form.parse();

        //add the section
        entity().addSection(
            indexIn.value(),
            new Section(entity().getDocument(), titleIn.value())
        );
    }
}
