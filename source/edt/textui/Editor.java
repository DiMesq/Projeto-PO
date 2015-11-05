package edt.textui;

/**
 * The main class of the edt application.
 **/
public class Editor {

    public static void main(String[] args) {
        
        Document doc = new Document();

        MainMenu menu = MainMenu(doc);
        menu.open();
        
        IO.close();
    }
}
