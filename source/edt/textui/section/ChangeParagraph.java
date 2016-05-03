package edt.textui.section;

import edt.core.Paragraph;
import edt.core.Section;
import edt.core.exception.TextElementNotFoundException;
import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

/**
 * Command for changing the content of a paragraph of the current section.
 */
public class ChangeParagraph extends Command<Section> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public ChangeParagraph(Section ent) {
        super(MenuEntry.EDIT_PARAGRAPH, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

      Form form = new Form();
      InputInteger ind = new InputInteger(form, Message.requestParagraphId());
      InputString text = new InputString(form, Message.requestParagraphContent());
      form.parse();

      try{
        Paragraph paragraph = entity().getParagraph(ind.value());
        paragraph.setText(text.value());
      }
      catch(TextElementNotFoundException e){
        ProcessError.processError(e, ind.value());
      }

   }
}
