package edt.visitor;

import edt.core.TextElement;

/**
 * This interface is used to implement the Visitor design pattern.
 * <p>Visitor is the interface which all element types must implement
 * 
 * @author Daniel Reigada
 * @author Diogo Mesquita
 * @author Sebastião Araújo
 * @version 1.0
*/
public interface Visitor {

	public void visit(TextElement e);

}


