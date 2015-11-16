package edt.textui.main;

import edt.textui.exception.TextElementException;

import pt.utl.ist.po.ui.Display;

public class ProcessError{

	public static void processError(TextElementException exception, int name){

		Display display = new Display();

		switch (exception.getErrorCode()){
			case SECTION_NOT_FOUND:
				display.addNewLine(Message.noSuchSection(name));
				break;

			case DOCUMENT_SERIALIZE_ERROR:
				display.addNewLine(Message.fileNotFound(name));
				break;

			case DOCUMENT_DESERIALIZE_ERROR:
				display.addNewLine(Message.fileNotFound(name));
				break;

			case FILE_CLOSE_ERROR:
				display.addNewLine(Message.fileNotFound(name));
				break;

			default:
				System.err.println("Unknown exception occurred: " + exception.getMessage());
				exception.printStackTrace();
				break;
		}

		display.display();
	}
}


