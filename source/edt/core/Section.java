package edt.core;

import java.util.List;
import java.util.ArrayList;

import edt.textui.exception.TextElementNotFoundException;

/**
 * This class implements a Section of a {@link Document}.
 * <p>A Section has a title represented as a String
 *
 * @author Daniel Reigada
 * @author Diogo Mesquita
 * @author Sebastião Araújo
 * @version 1.0
*/
public class Section extends TextElement {

	/**
	 * The title of the Section
	 */
	private String _title;

	/**
	 * The list of Paragraphs of the Section
	 */
	private List<Paragraph> _paragraphs;

	/**
	 * The list of sub-Sections of the Section
	 */
	private List<Section> _subSections;

	/**
	 * The Document to which the Section belongs
	 */
	private Document _document;


	/**
	 * The default Constructor. Associates document as the Document of the Section
	 * and sets its title.
	 *
	 * @param document The document to which this Section belongs
	 * @param String the title for the section 
	 */
	public Section(Document document, String title){
		_title = title;
		_paragraphs = new ArrayList<Paragraph>();
		_subSections = new ArrayList<Section>();
		_document = document;
	}

	/**
	 * Constructor. Associates document as the Document of the Section
	 *
	 * @param document The document to which this Section belongs
	 */
	public Section(Document document){
		this(document, "");
	}

	/**
	 * Constructor (does not associate a Document to the Section)
	 * TODO: protected de forma a que só possa ser usado no Document??
	*/
	protected Section(){
		this(null);
	}

	/**
	 * Sets the Document to which this Section belongs
	 * @param document The Document to which this Sections belongs
	 * TODO: protected de forma a que só possa ser usado no Document??
	 */
	protected void setDocument(Document document){
		_document = document;
	}

	/**
	 * Gets the Document to which this Section belongs
	 * @return document The Document to which this Sections belongs
	 * TODO: protected??
	 */
	public Document getDocument(){
		return _document;
	}

	/**
	 * Set/Changes the title of this Section
	 *
	 * @param title The new title to be set
	 */
	public void setTitle(String title){
		_title = title;
	}

	/**
	 * Returns the title of this Section
	 *
	 * @return string the title of this Section
	 */
	public String getTitle(){
		return _title;
	}

	public int getSize(){
		int size = getTitle().length();

		// Add the size of each sub-Section
		for(Section s: _subSections)
			size += s.getSize();
		// Add the size of each Paragraph of this Section
		for(Paragraph p : _paragraphs)
			size += p.getSize();

		return size;
	}

	/**
	 * Retuns a List with the sub-Section of this Section
	 *
	 * @return A List with the sub-Section of this Section
	 */
	public List<Section> getSubsections(){
		return _subSections;
	}

	/**
	 * Retuns the Subsection at the specified position in this Section
	 *
	 * @param index Index of the Subsection to return
	 * @return The Subsection at the specified position in this Section
	 * @throws IndexOutOfBoundsException - if the index is out of range
	 */
	public Section getSection(int index) throws TextElementNotFoundException{
		try{
			return _subSections.get(index);

		} catch (IndexOutOfBoundsException e){
			throw new TextElementNotFoundException(e.getMessage(), ErrorCode.SECTION_NOT_FOUND);
		}
	}

	/**
 	 * FIXME: I HAVE NO IDEA WHAT THIS IS
	 */
	public String getSubsectionIndex(){
		// FIXME
		return "";
	}

	/**
	 * Inserts the specified Subsection at the specified position in this Section.
	 * Shifts the Subsection currently at that position (if any) and any subsequent
	 * ones to the right (adds one to their indices).
	 * If the Index is invalid insert the Subsection at the end of all Subsections.
	 *
	 * @param index Index at which the specifie SubSection is to be inserted
	 * @param subsection - The SubSection to be inserted
	 */
	public void addSection(int index, Section subsection){
		try{
			_subSections.add(index, subsection);
		}
		catch (IndexOutOfBoundsException e) {
			_subSections.add(subsection);
		}
	}

	/**
	 * Removes the Subsection at the specified position in this Section.
	 * Shifts any subsequent Subsections to the left (subtracts one from their indices).
	 * Returns the Subsection that was removed from the Section.
	 *
	 * @param index - The index of the Subsection to be removed
	 * @return The Subsection at the specified position.
	 * @throws IndexOutOfBoundsException - if the index is out of range.
	 */
	public Section removeSection(int index) throws TextElementNotFoundException{
		
		try{
			Section section = _subSections.remove(index);
			_document.removeFromIndex(section);
			return section;

		} catch (IndexOutOfBoundsException e){
			throw new TextElementNotFoundException(e.getMessage(), "SECTION_NOT_FOUND");
		}
	}

	/**
	 * Inserts the specified Paragraph at the specified position in this Section.
	 * Shifts the Paragraph currently at that position (if any) and any subsequent
	 * ones to the right (adds one to their indices).
	 * If the Index is invalid insert the Paragraph at the end of all Paragraphs.
	 *
	 * @param index Index at which the specifie Paragraph is to be inserted
	 * @param paragraph - The Paragraph to be inserted
	 */
	 public void addParagraph(int index, Paragraph paragraph){

		 try{
			 _paragraphs.add(index, paragraph);
		 }
		 catch (IndexOutOfBoundsException e) {
			 _paragraphs.add(paragraph);
		 }
	 }

	/**
	 * Removes the Paragraph at the specified position in this Section.
	 * Shifts any subsequent Paragraphs to the left (subtracts one from their indices).
	 * Returns the Paragraph that was removed from the Section.
	 *
	 * @param index - The index of the Paragraph to be removed
	 * @return The Paragraph at the specified position.
	 * @throws IndexOutOfBoundsException - if the index is out of range.
	 */
	public Paragraph removeParagraph(int index) throws IndexOutOfBoundsException {

		Paragraph paragraph = _paragraphs.remove(index);
		try{
			_document.removeFromIndex(paragraph);
		}
		finally{
			return paragraph;
		}
	}

	/**
	 * Retuns the Paragraph at the specified position in this Section
	 *
	 * @param index Index of the Paragraph to return
	 * @return The Paragraph at the specified position in this Section
	 * @throws IndexOutOfBoundsException - if the index is out of range
	 */
	public Paragraph getParagraph(int index) throws IndexOutOfBoundsException {

		return _paragraphs.get(index);
	}

	/**
	 * Retuns the Paragraph at the specified position in this Section
	 *
	 * @return List<Paragraph> this section's paragraphs
	 */
	public List<Paragraph> getParagraphs() {

		return _paragraphs;
	}
}
