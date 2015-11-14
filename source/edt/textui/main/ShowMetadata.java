package edt.textui.main;

import edt.core.Document;
import edt.core.DocManager;
import edt.core.Author;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

/* FIXME: import core classes here */

/**
 * Command for showing the metadata of the current document in the editor.
 */
public class ShowMetadata extends Command<DocManager> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public ShowMetadata(DocManager ent) {
        super(MenuEntry.SHOW_METADATA, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        //TODO: implementei so para testes. precisa de ser mudado

        Display display = new Display();
        Document doc = entity().getDocument();

        // add the title of the document
        display.addNewLine(Message.documentTitle(doc.getTitle()));
        // add the authors of the document
        for(Author a : doc.getAuthors())
          display.addNewLine(Message.author(a.getName(), a.getEmail()));
        // add the number of top Sections
        display.addNewLine(Message.documentSections(doc.getSubsections().size()));
        // add the size of the document
        display.addNewLine(Message.documentBytes(doc.getSize()));
        // add the number of unique identifiers
        display.addNewLine(Message.documentIdentifiers(0)); //FIXME : MUDAR ISTO


        display.display();
    }
}
