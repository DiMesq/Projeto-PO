package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import java.io.IOException;

/* FIXME: import core classes here */

/**
 * Command for saving the current document in the editor.
 */
public class SaveDocument extends Command<Document> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public SaveDocument(Document ent) {
        super(MenuEntry.SAVE, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() throws InvalidOperation {
        
        // If the document has no filename, ask for it
        if (entity().getFileName == ""){
            Form form = new Form();
            InputString in = new InputString(form, "Nome do ficheiro onde guardar o documento: ");
            form.parse();

            entity().setFileName(in.value());
        }
        try{ 
            entity().saveDocument();
        } catch (IOException i){ //TODO: ver a explicacao que dei no comando OpenDocument no catch desta mesma excepcao
            throw new InvalidOperation("Erro de I/O ao tentar guardar Document.");
        }
    }
}
