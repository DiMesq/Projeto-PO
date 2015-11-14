package edt.textui.main;

import java.util.Arrays;

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

        // get the name and email of the author and create it
        Form form = new Form();
        InputString inName = new InputString(form, m.requestAuthorName());
        InputString  inMail = new InputString(form, m.requestEmail());
        form.parse();

        Author author = new Author(inName.value(), inMail.value());

        // the document to store the author
        Document doc = entity().getDocument();

        // if the author already existed warn the user
        if(Arrays.asList(doc.getAuthors()).contains(author)){
          Display display = new Display();
          display.add(m.duplicateAuthor(inName.value()));
          display.display();
        }
        else
          doc.addAuthor(author);

    }
}
