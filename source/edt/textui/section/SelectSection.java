package edt.textui.section;

import edt.core.Section;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import edt.textui.main.EditSection;

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

        try{
            Section section = entity().getSection(in.value());
            EditMenu menu = new EditMenu(section);

            Message.newActiveSection(in.value());
            menu.open();

        } catch (IndexOutOfBoundsException i){
            Message.noSuchSection(in.value());
        }
        
        
    }
}
