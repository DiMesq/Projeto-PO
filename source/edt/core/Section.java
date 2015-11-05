package edt.core;

/**
 * This class implements a Section of a {@link Document}.
 * <p>A Section has a title represented as a String
 *
 * @author Daniel Reigada
 * @author Diogo Mesquita
 * @author Sebastião Araújo
 * @version 1.0
*/
class Section extends TextElement {

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
	 * Constructor
	 */
	public Section(){
		super();
		_title = "";
		_paragraphs = new ArrayList<Paragraph>();
		_subSections = new ArrayList<Section>();
	}
	
	/**
	 * Returns the Headline of this Section in the following format:
	 * 	[Section id] {Section Title}
	 *
	 * @return string the Headline of this Section. [Section id] {Section Title}
	 */
	public String getHeadline(){
		String id = getKey(),
			   title = getTitle();
		if(id == null)
			id = "";
		if(title == null)
			title = "";
		return "[" + id + "] {" + title + "}";
	}

	/**
	 * Set/Changes the title of this Section
	 *
	 * @param title The new title to be set
	 */
	public void setTitle(String title){
		_title = title
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
}
