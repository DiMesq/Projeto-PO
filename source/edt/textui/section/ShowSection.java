package edt.textui.section;

import edt.core.Section;

import edt.textui.visitors.GetContentVisitor;

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
        GetContentVisitor visitor = new GetContentVisitor();
        entity().accept(visitor);
        Display display = new Display();
        display.add(visitor.getContent()).display();
     }
}
