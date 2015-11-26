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

    //TODO: mudar isto tudo - arranjar solucao melhor que as excecoes!!!
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

        try{    
            Section section = (Section) entity().getDocument().getTextElement(in.value());

            // There is no TextElement with such key
            if (section == null) display.addNewLine(Message.noSuchTextElement(in.value()))
                                        .display();

            //The TextElement retrieved is a Section
            else section.accept( new GetContentVisitor());  

        } catch (ClassCastException c){   // The TextElement retrieved is a Paragraph
            Paragraph paragraph = (Paragraph) entity().getDocument()
                                                      .getTextElement(in.value());

            display.addNewLine(paragraph.getContent())
                   .display();
        }
        
    }
}
