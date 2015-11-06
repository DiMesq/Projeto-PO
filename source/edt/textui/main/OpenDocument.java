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

/**
 * Command for opening an existing document in the editor.
 */
public class OpenDocument extends Command<Document> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public OpenDocument(Document ent) {
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
            Document doc = entity().loadDocument(in.value());

            // TODO: precisamos de mudar a entity de todos os comandos deste menu para este doc, mas nao estou a ver como
            
            

        } catch (IOException i){ //TODO: nao sei se faz muito sentido lancar esta exception, mas como o comando save 
            //tambem lanca uma exception a unica que vejo fazer sentido é esta. A outra opcao era apanhar esta excepcao IOException logo no metodo load e save do Document
            throw new InvalidOperation(m.fileNotFound(in.value()));
        } catch (ClassNotFoundException c){
            throw new InvalidOperation(m.fileNotFound(in.value()));
        }

        // TODO: isto aparece bastantes vezes - secalhar fazia sentido abstrair numa classe
        // make the commands specific to a particular document visible
        for (int i = 2, max = menu().size(); i < max; i++)
            menu().entry(i).visible();

        // hide the options of creating a new document and of opening an existing one
        menu().entry(0).invisible();
        this.invisible();
    }
}
