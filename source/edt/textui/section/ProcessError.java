package edt.textui.section;

import edt.core.exception.TextElementException;
import edt.core.exception.ErrorCode;

import pt.utl.ist.po.ui.Display;

public class ProcessError{

	public static void processError(TextElementException exception, int name){

		Display display = new Display();

		switch (exception.getErrorCode()){
			case ErrorCode.SECTION_NOT_FOUND:
				display.addNewLine(Message.noSuchSection(name));
				break;

			case ErrorCode.PARAGRAPH_NOT_FOUND:
				display.addNewLine(Message.noSuchParagraph(name));
				break;

			default:
				System.err.println("Unknown exception occurred: " + exception.getMessage());
				exception.printStackTrace();
				break;
		}

		display.display();
	}
}


