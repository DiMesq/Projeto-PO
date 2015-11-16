package edt.textui.main;

import edt.textui.exception.TextElementException;

import pt.utl.ist.po.ui.Display;

public class ProcessError{

	public static void processError(TextElementException exception, String value){

		Display display = new Display();

		switch (exception.getErrorCode()){
			case "DOCUMENT_NOT_FOUND":
				display.add(Message.fileNotFound(value));
		}
	}
}