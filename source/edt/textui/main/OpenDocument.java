package edt.textui.main;

import java.io.IOException;

import edt.core.Document;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;
import pt.utl.ist.po.ui.InvalidOperation;

import edt.core.Document;
import edt.core.DocManager;

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
    public final void execute() throws InvalidOperation {
        Message m = new Message();

        // ask for the filename where the document is
        Form form = new Form();
        InputString in = new InputString(form, m.openFile());
        form.parse();

        try{
            Document doc = entity().getDocument().loadDocument(in.value());
            entity().setDocument(doc);
        } catch (IOException i){ //TODO: nao sei se faz muito sentido lancar esta exception, mas como o comando save
            //tambem lanca uma exception a unica que vejo fazer sentido é esta. A outra opcao era apanhar esta excepcao IOException logo no metodo load e save do Document
            throw new InvalidOperation(m.fileNotFound(in.value()));
        } catch (ClassNotFoundException c){
            throw new InvalidOperation(m.fileNotFound(in.value()));
        }

    }
}
