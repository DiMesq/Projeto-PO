package edt.textui.main;

import pt.utl.ist.po.ui.Menu;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import edt.core.Document;

/**
 * Command for creating a new document in the editor.
 */
public class NewDocument extends Command<Document> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public NewDocument(Document ent) {
        super(MenuEntry.NEW, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        
        // hide the options of creating a new document and of opening an existing one
        this.invisible();
        menu().entry(1).invisible();

        // make the commands specific to a particular document visible    
        for (int i = 2, max = menu().size(); i < max; i++)
            menu().entry(i).visible();

        Display display = new Display();
        display.add("Novo documento criado.");
        display.display();
    }
}
