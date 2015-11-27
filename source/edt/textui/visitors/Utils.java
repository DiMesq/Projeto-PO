package edt.textui.visitors;

import edt.core.Paragraph;
import edt.core.Section;
import edt.core.Document;

import edt.textui.section.Message;

import java.util.List;


//  TODO review this and rename
class Utils {

  /**
   * Returns all of the content of a Document
   * @param  doc [description]
   * @return     [description]
   */
  static String getSections(Document doc){
    String content = "";
    content = "{" + doc.getTitle() + "}\n";

    content += getSections((Section) doc, false, false);

    return content;
  }

/**
   * Returns all of the content of a Section
   *
   * @param section the section to get all content from
   * @return String all of the content from every subsection of the current one
   */
  static String getSections(Section section, boolean currentTitle, boolean onlyTitles){

    String content = "";

    if(currentTitle)
      content = Message.sectionIndexEntry(section.getKey(),
                                                 section.getTitle()) +
                                                 "\n";

      List<Paragraph> paragraphs = section.getParagraphs();
      List<Section> subSections = section.getSubsections();

      if (!onlyTitles)
        for (Paragraph p: paragraphs) content += p.getContent() + "\n";

      for (Section s: subSections) content += getSections(s, true, onlyTitles);

      return content;
  }
}
