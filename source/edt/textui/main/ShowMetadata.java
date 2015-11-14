package edt.textui.main;

import edt.core.Document;
import edt.core.DocManager;
import edt.core.Author;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

/* FIXME: import core classes here */

/**
 * Command for showing the metadata of the current document in the editor.
 */
public class ShowMetadata extends Command<DocManager> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public ShowMetadata(DocManager ent) {
        super(MenuEntry.SHOW_METADATA, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        //TODO: implementei so para testes. precisa de ser mudado

        Message m = new Message();
        Display display = new Display();


        for(Author a : entity().getDocument().getAuthors())
          display.addNewLine(m.author(a.getName(), a.getEmail()));

        display.display();
    }
}
