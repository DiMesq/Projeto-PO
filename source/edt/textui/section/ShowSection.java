package edt.textui.section;

import edt.core.Section;
import pt.utl.ist.po.ui.Display;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

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

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Display display = new Display();

        //show all content from the current section and all its subsections
        display.add(entity().getContent(true)); 

        display.display();
     }
}
