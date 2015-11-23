package edt.textui.section;

import edt.core.Section;

import edt.textui.visitors.GetContentVisitor;

import pt.utl.ist.po.ui.Command;

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

        entity().accept( new GetContentVisitor());

     }
}
