package edt.textui.visitors;

import edt.core.Paragraph;
import edt.core.Section;
import edt.core.Document;

import edt.textui.section.Message;

import java.util.List;

class Utils {

  /**
   * Auxiliary method that returns the content of a Document formated
   * @param  doc the Document to get the content from
   * @return  all of the content from every subsection of the given Document
   */
  static String getContent(Document doc){
    String content = "";
    content = "{" + doc.getTitle() + "}\n";

    content += getContent((Section) doc, false, false);

    return content;
  }

/**
   * Auxiliary method that returns the content of a Section formated
   *
   * @param section the section to get content from
   * @param currentTitle if the method should return the given section title
   * @param onlyTitles if the method should return only titles of the subsections
   * @return all of the content from every subsection of the current one
   */
  static String getContent(Section section, boolean currentTitle, boolean onlyTitles){

    String content = "";

    if(currentTitle)
      content = Message.sectionIndexEntry(section.getKey(),
                                                 section.getTitle()) +
                                                 "\n";

      List<Paragraph> paragraphs = section.getParagraphs();
      List<Section> subSections = section.getSubsections();

      if (!onlyTitles)
        for (Paragraph p: paragraphs) content += p.getContent() + "\n";

      for (Section s: subSections) content += getContent(s, true, onlyTitles);

      return content;
  }
}
