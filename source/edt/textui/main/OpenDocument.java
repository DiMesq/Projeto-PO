package edt.textui.main;

import java.io.IOException;

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
public class OpenDocument extends Command</* FIXME: core class */> {

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
        // ask for the filename where the document is 
        Form form = new Form();
        InputString in = new InputString(form, "Nome do ficheiro onde se encontra o documento: ");
        form.parse();

        try{
            // TODO: DANGER!!!! Isto e um bug, precisamos de um setter para a entidade com que estamos a trabalhar ou
            // uma solucao diferente que nao estou a ver 
            entity() = entity().loadDocument(in.value());

        } catch (IOException){ //TODO: nao sei se faz muito sentido lancar esta exception, mas como o comando save 
            //tambem lanca uma exception a unica que vejo fazer sentido é esta. A outra opcao era apanhar esta excepcao IOException logo no metodo load e save do Document
            throw new InvalidOperation("Erro de I/O ao tentar fazer load do Document.")
        } catch (ClassNotFoundException){
            throw new InvalidOperation("Classe Document não foi encontrada.")
        }

        // TODO: isto aparece bastantes vezes - secalhar fazia sentido abstrair numa classe
        // make the commands specific to a particular document visible
        for (int i = 2, int max = menu().size(); i < max; i++)
            menu().entry().visible();

        // hide the options of creating a new document and of opening an existing one
        menu().entry(0).invisible();
        this.invisible();
    }
}
