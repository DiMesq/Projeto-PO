package edt.textui.section;

import edt.core.Section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

import edt.textui.visitors.ListSectionsVisitor;

/**
 * Command for listing all subsections of the current section.
 */
public class ListSections extends Command<Section> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public ListSections(Section ent) {
        super(MenuEntry.LIST_SECTIONS, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        ListSectionsVisitor visitor = new ListSectionsVisitor();
        entity().accept(visitor);

        Display display = new Display();
        display.add(visitor.getContent()).display();

    }
}
