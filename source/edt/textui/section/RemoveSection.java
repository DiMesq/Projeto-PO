package edt.textui.section;

import edt.core.Section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;

import edt.core.exception.TextElementNotFoundException;

/**
 * Command for removing a subsection of the current section.
 */
public class RemoveSection extends Command<Section> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public RemoveSection(Section ent) {
        super(MenuEntry.REMOVE_SECTION, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
      Form form = new Form();
      InputInteger sectionId = new InputInteger(form, Message.requestSectionId());
      form.parse();

      try{
        entity().removeSection(sectionId.value());
      }
      catch(TextElementNotFoundException e){
        // do nothing
      }
    }
}
