package edt.textui;

/**
 * The main class of the edt application.
 **/
public class Editor {

    public static void main(String[] args) {
        
        Document doc = new Document();

        MainMenu menu = MainMenu(doc);

        // make the commands specific to a particular document invisible
        for (int i = 2, last = menu.size(); i < last; i++){
        	menu.entry(i).invisible();
        }

        menu.open();
        
        IO.close();
    }
}
