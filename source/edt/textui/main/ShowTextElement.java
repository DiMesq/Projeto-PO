package edt.textui.main;

import edt.core.*;

import edt.textui.visitors.GetContentVisitor;

import pt.utl.ist.po.ui.Command;
import pt.utl.ist.po.ui.Display;
import pt.utl.ist.po.ui.Form;
import pt.utl.ist.po.ui.InputString;


/**
 * Command for showing the text element with a given identifier of the current document in the editor.
 */
public class ShowTextElement extends Command<DocManager> {

    /**
     * Constructor.
     *
     * @param ent the target entity.
     */
    public ShowTextElement(DocManager ent) {
        super(MenuEntry.SHOW_TEXT_ELEMENT, ent);
    }

    /**
     * Execute the command.
     */
    @Override
    @SuppressWarnings("nls")
    public final void execute() {

        Display display = new Display();

        //get the key from the user
        Form form = new Form();
        InputString in = new InputString(form, Message.requestElementId());
        form.parse();

        TextElement elem = entity().getDocument().getTextElement(in.value());

        // If there is no TextElement with such key
        if (elem == null) display.addNewLine(Message.noSuchTextElement(in.value()))
                                    .display();
        else{
          GetContentVisitor visitor = new GetContentVisitor();
          elem.accept(visitor);
          display.add(visitor.getContent()).display();
        }
    }
}
