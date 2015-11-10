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
        
        Message m = new Message();

        // If the document has no filename, ask for it
        if (entity().getFileName() == ""){
            Form form = new Form();
            InputString in = new InputString(form, m.saveAs());
            form.parse();

            entity().setFileName(in.value());
        }
        try{ 
            entity().saveDocument();
        } catch (IOException i){ //TODO: ver a explicacao que dei no comando OpenDocument no catch desta mesma excepcao
            throw new InvalidOperation(m.fileNotFound(entity().getFileName()));
        }
    }
}
