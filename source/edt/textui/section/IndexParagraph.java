package edt.textui.section;

import edt.core.Section;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputInteger;
import pt.utl.ist.po.ui.InputString;

/**
 * Command for indexing a paragraph (nomear um parágrafo 2.2.9) of the current section.
 */
public class IndexParagraph extends Command<Section> {

    /**
     * Constructor.
     * 
     * @param ent the target entity.
     */
    public IndexParagraph(Section ent) {
        super(MenuEntry.NAME_PARAGRAPH, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {
        /* FIXME: implement command */
    }
}
