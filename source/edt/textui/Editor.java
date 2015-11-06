package edt.textui;

import edt.core.Document;

import edt.textui.main.MainMenu;

import static pt.utl.ist.po.ui.UserInteraction.IO;
/**
 * The main class of the edt application.
 **/
public class Editor {

    public static void main(String[] args) {
        
        Document doc = new Document();

        MainMenu menu = new MainMenu(doc);

        // make the commands specific to a particular document invisible
        for (int i = 2, last = menu.size(); i < last; i++){
        	menu.entry(i).invisible();
        }

        menu.open();
        
        IO.close();
    }
}
