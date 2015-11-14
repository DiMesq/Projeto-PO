package edt.textui.main;

import edt.core.Document;
import edt.core.DocManager;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import java.io.IOException;

/**
 * Command for saving the current document in the editor.
 */
public class SaveDocument extends Command<DocManager> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public SaveDocument(DocManager ent) {
        super(MenuEntry.SAVE, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {

        Document doc = entity().getDocument();

        // If the document has no filename, ask for it
        if (doc.getFileName() == ""){
            Form form = new Form();
            InputString in = new InputString(form, Message.newSaveAs());
            form.parse();

            entity().getDocument().setFileName(in.value());
        }
        try{
            entity().getDocument().saveDocument();
        } catch (IOException i){ //TODO: ver a explicacao que dei no comando OpenDocument no catch desta mesma excepcao
            throw new InvalidOperation(Message.fileNotFound(doc.getFileName()));
        }
    }
}
