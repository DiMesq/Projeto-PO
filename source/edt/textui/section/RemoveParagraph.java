package edt.textui.section;

import edt.core.Section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import edt.core.exception.TextElementNotFoundException;

/**
 * Command for removing a paragraph of the current section.
 */
public class RemoveParagraph extends Command<Section> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public RemoveParagraph(Section ent) {
        super(MenuEntry.REMOVE_PARAGRAPH, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
      Form form = new Form();
      InputInteger paragraphId = new InputInteger(form, Message.requestParagraphId());
      form.parse();

      try{
        entity().removeParagraph(paragraphId.value());
      }
      catch(TextElementNotFoundException e){
        ProcessError.processError(e, paragraphId.value());
      }
    }
}
