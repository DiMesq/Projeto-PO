package edt.textui.section;

import edt.core.Section;

import pt.utl.ist.po.ui.Command;

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

        entity().accept( new ListSectionsVisitor());

    }
}
