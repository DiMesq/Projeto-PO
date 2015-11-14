package edt.textui.main;

import edt.core.Document;
import edt.core.DocManager;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;


/**
 * Command for showing the text element with a given identifier of the current document in the editor.
 */
public class ShowTextElement extends Command<DocManager> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowTextElement(DocManager ent) {
        super(MenuEntry.SHOW_TEXT_ELEMENT, ent);
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
