package edt.textui.main;

import java.util.SortedSet;

import edt.core.Document;
import edt.core.DocManager;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;

/**
 * Command for showing the top sections of the current document in the editor.
 */
public class ListTopSections extends Command<DocManager> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ListTopSections(DocManager ent) {
        super(MenuEntry.SHOW_INDEX, ent);
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
