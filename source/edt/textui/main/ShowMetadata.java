package edt.textui.main;

import edt.core.Document;
import edt.core.Author;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

/* FIXME: import core classes here */

/**
 * Command for showing the metadata of the current document in the editor.
 */
public class ShowMetadata extends Command<Document> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public ShowMetadata(Document ent) {
        super(MenuEntry.SHOW_METADATA, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        //TODO: implementei so para testes. precisa de ser mudado
        // da exception se nao se tiver adicionado autor primeiro
        Message m = new Message();
        Display display = new Display();

        Author a = entity().getAuthors().get(0);

        display.add(m.author(a.getName(), a.getEmail()));
        display.display();
    }
}
