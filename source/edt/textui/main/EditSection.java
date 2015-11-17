package edt.textui.main;

import edt.core.Document;
import edt.core.DocManager;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;

import edt.textui.section.EditMenu;

/**
 * Command for editing the current document in the editor.
 */
public class EditSection extends Command<DocManager> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public EditSection(DocManager ent) {
        super(MenuEntry.OPEN_DOCUMENT_EDITOR, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        EditMenu menu = new EditMenu(entity().getDocument());
        menu.open();

    }
}
