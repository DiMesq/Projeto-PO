package edt.textui;

import edt.core.Document;
import edt.core.DocManager;

import edt.parser.Parser;
import java.io.IOException;

import edt.textui.main.MainMenu;

import static pt.utl.ist.po.ui.UserInteraction.IO;
/**
 * The main class of the edt application.
 **/
public class Editor {

    public static void main(String[] args) {

        DocManager manager = new DocManager(new Document());

        if (System.getProperty("import") != null) {
          Parser parser = new Parser();
          try{
            manager.setDocument(parser.parse(System.getProperty("import")));
          }
          catch (IOException e) {}
        }

        MainMenu menu = new MainMenu(manager);

        menu.open();

        IO.close();
    }
}
