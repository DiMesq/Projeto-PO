package edt.textui.main;

import edt.core.Document;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;

import edt.textui.section.EditMenu;

/* FIXME: import core classes here */

/**
 * Command for editing the current document in the editor.
 */
public class EditSection extends Command<Document> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public EditSection(Document ent) {
        super(MenuEntry.OPEN_DOCUMENT_EDITOR, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        EditMenu menu = new EditMenu(entity());
        menu.open();
        
    }
}

