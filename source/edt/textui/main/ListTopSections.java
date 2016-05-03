package edt.textui.main;

import edt.core.DocManager;
import edt.core.Document;
import edt.core.Section;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;

/**
 * Command for showing the top sections of the current document in the editor.
 */
public class ListTopSections extends Command<DocManager> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public ListTopSections(DocManager ent) {
        super(MenuEntry.SHOW_INDEX, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

      Display display = new Display();
      Document doc = entity().getDocument();

      // add the Document Headline
      String headline = Message.sectionIndexEntry("", doc.getTitle());
      display.addNewLine(headline.replace("[] ", ""));

      // add the top subsections' Headlines
      for(Section sec : doc.getSubsections())
        display.addNewLine(Message.sectionIndexEntry(sec.getKey(), sec.getTitle()));

      display.display();
    }
}
