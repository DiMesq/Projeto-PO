package edt.textui;

import edt.core.Document;
import edt.core.DocManager;

import edt.textui.main.MainMenu;

import static pt.utl.ist.po.ui.UserInteraction.IO;
/**
 * The main class of the edt application.
 **/
public class Editor {

    public static void main(String[] args) {
        
        DocManager manager = new DocManager(new Document());

        MainMenu menu = new MainMenu(manager);

        menu.open();
        
        IO.close();
    }
}
