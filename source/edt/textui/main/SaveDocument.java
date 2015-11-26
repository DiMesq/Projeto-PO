package edt.textui.main;

import edt.core.Document;
import edt.core.DocManager;

import edt.core.exception.TextElementException;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

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
    public final void execute(){

        Document doc = entity().getDocument();
        String filename = doc.getFileName();

        // If the document has no filename, ask for it and set it
        if (filename == ""){
            Form form = new Form();
            InputString in = new InputString(form, Message.newSaveAs());
            form.parse();

            filename = in.value();
            entity().getDocument().setFileName(filename);
        }

        try{
            entity().getDocument().saveDocument();

        } catch (TextElementException i){ 
            ProcessError.processError(i, filename);
        }
    }
}
