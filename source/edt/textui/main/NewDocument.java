package edt.textui.main;

import edt.core.DocManager;
import edt.core.Document;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

/**
 * Command for creating a new document in the editor.
 */
public class NewDocument extends Command<DocManager> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public NewDocument(DocManager ent) {
        super(MenuEntry.NEW, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        entity().setDocument(new Document());

    }
}
