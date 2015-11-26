package edt.textui.main;

import edt.core.exception.TextElementException;
import edt.core.exception.ErrorCode;

import pt.utl.ist.po.ui.Display;

public class ProcessError{

	public static void processError(TextElementException exception, String name){

		Display display = new Display();

		switch (exception.getErrorCode()){
			case ErrorCode.DOCUMENT_NOT_FOUND:
				display.addNewLine(Message.fileNotFound(name));
				break;

			case ErrorCode.DOCUMENT_SERIALIZE_ERROR:
				display.addNewLine(Message.fileNotFound(name));
				break;

			case ErrorCode.DOCUMENT_DESERIALIZE_ERROR:
				display.addNewLine(Message.fileNotFound(name));
				break;

			case ErrorCode.FILE_CLOSE_ERROR:
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


