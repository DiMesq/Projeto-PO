package edt.textui.main;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;

import edt.core.Document;
import edt.core.DocManager;

import edt.core.exception.TextElementException;

/**
 * Command for opening an existing document in the editor.
 */
public class OpenDocument extends Command<DocManager> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public OpenDocument(DocManager ent) {
        super(MenuEntry.OPEN, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute(){

        // ask for the filename where the document is
        Form form = new Form();
        InputString in = new InputString(form, Message.openFile());
        form.parse();

        try{
            Document doc = entity().getDocument().loadDocument(in.value());
            doc.setFileName(in.value());
            entity().setDocument(doc);
            
        } catch (TextElementException i){ 
            ProcessError.processError(i, in.value());
        }
    }
}
