package edt.textui.main;

import edt.core.Document;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

/* FIXME: import core classes here */

/**
 * Command for adding an author to the current document in the editor.
 */
public class AddAuthor extends Command<Document> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public AddAuthor(Document ent) {
        super(MenuEntry.ADD_AUTHOR, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        /* FIXME: implement command */
    }
}
