package edt.textui.main;

import edt.core.Author;
import edt.core.DocManager;
import edt.core.Document;
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

        // get the name and email of the author and create it
        Form form = new Form();
        InputString inName = new InputString(form, Message.requestAuthorName());
        InputString  inMail = new InputString(form, Message.requestEmail());
        form.parse();

        Author author = new Author(inName.value(), inMail.value());

        // the document to store the author
        Document doc = entity().getDocument();

        // if the author already existed warn the user
        if(!doc.addAuthor(author)){
          Display display = new Display();
          display.add(Message.duplicateAuthor(inName.value()));
          display.display();
        }
    }
}
