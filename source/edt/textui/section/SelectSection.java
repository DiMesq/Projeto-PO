package edt.textui.section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;


import edt.core.exception.TextElementNotFoundException;

import edt.core.Section;

/**
 * Command for selecting a subsection of the current section and edit it.
 */
public class SelectSection extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public SelectSection(Section ent) {
        super(MenuEntry.SELECT_SECTION, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        Form form = new Form();
        InputInteger in = new InputInteger(form, Message.requestSectionId());
        form.parse();

        Display display = new Display();

        try{
            Section section = entity().getSection(in.value());
            EditMenu menu = new EditMenu(section);

            display.add(Message.newActiveSection(in.value())).display();
            menu.open();

        } catch (TextElementNotFoundException e){
            ProcessError.processError(e, in.value());
        } 
    }
}
