package edt.textui.main;

import edt.core.Document;
import edt.core.DocManager;
import edt.core.Author;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;


/**
 * Command for adding an author to the current document in the editor.
 */
public class AddAuthor extends Command<DocManager> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public AddAuthor(DocManager ent) {
        super(MenuEntry.ADD_AUTHOR, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        Message m = new Message();

        Form form = new Form();
        InputString inName = new InputString(form, m.requestAuthorName());
        InputString  inMail = new InputString(form, m.requestEmail());
        form.parse();

        Author author = new Author(inName.value(), inMail.value());
        entity().getDocument().addAuthor(author);

    }
}
