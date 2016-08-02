// **********************************************************
// Assignment3:
// UTORID user_name: pushpa10
//
// Author: Girrshotan Pushparajah
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// *********************************************************
package driver;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The Class ContentExtractor deals with extracting the content from the HTML
 * string.
 */
public class ContentExtractor {

  /** The HTML string which contains the google scholar page's contents. */
  public String HTMLContent;

  /** The data type used to store the raw HTML content that's extracted. */
  public RawContent content;

  /**
   * Instantiates a new content extractor with the given HTML content and
   * initialize the rawContent data type.
   *
   * @param HTMLContent the HTML content from the google scholar page
   */
  public ContentExtractor(String HTMLContent) {
    this.HTMLContent = HTMLContent;
    this.content = new RawContent();
  }

  /**
   * Extracts and gets all the required content from the HTML string and returns
   * a RawContent object containing all the extracted content.
   *
   * @return the raw content containing all the extracted HTML information
   */
  public RawContent extractAndGetAllContent() {
    extractAuthorName();
    extractNumberOfCitations();
    extracti10IndexSince2009();
    extractFirst3Publications();
    extractTotalPaperCitations();
    extractCoAuthors();
    return this.content;
  }

  /**
   * Extracts the author's name from the HTML.
   */
  private void extractAuthorName() {
    String reForAuthorExtraction = "<span id=\"cit-name-display\" "
        + "class=\"cit-in-place-nohover\">(.*?)</span>";
    Pattern patternObject = Pattern.compile(reForAuthorExtraction);
    Matcher matcherObject = patternObject.matcher(HTMLContent);
    if (matcherObject.find())
      content.setAuthorName(matcherObject.group(1));
  }

  /**
   * Extracts number of citations from the HTML.
   */
  private void extractNumberOfCitations() {
    String reForCitationsExtraction =
        "<td class=\"cit-borderleft cit-data\">" + "(.*?)</td>";
    Pattern patternObject = Pattern.compile(reForCitationsExtraction);
    Matcher matcherObject = patternObject.matcher(HTMLContent);
    if (matcherObject.find())
      content.setNumOfCitations(Integer.parseInt(matcherObject.group(1)));
  }

  /**
   * Extracts the i10 index since 2009 from the HTML.
   */
  private void extracti10IndexSince2009() {
    String reForCitationsExtraction =
        "<td class=\"cit-borderleft cit-data\">" + "(.*?)</td>";
    Pattern patternObject = Pattern.compile(reForCitationsExtraction);
    Matcher matcherObject = patternObject.matcher(HTMLContent);
    // It's the 6th instance of the element so call find 6 times
    for (int i = 0; i < 6; i++)
      matcherObject.find();
    content.setI10Index(Integer.parseInt(matcherObject.group(1)));
  }

  /**
   * Extracts the first 3( publications from the HTML.
   */
  private void extractFirst3Publications() {
    String reForCitationsExtraction = "class=\"cit-dark-large-link\">(.*?)</a>";
    Pattern patternObject = Pattern.compile(reForCitationsExtraction);
    Matcher matcherObject = patternObject.matcher(HTMLContent);
    ArrayList<String> publications = new ArrayList<String>();
    // Get the first three publications, if there is less gets what's there
    for (int i = 0; i < 3; i++) {
      if (matcherObject.find())
        publications.add(matcherObject.group(1));
      else
        break;
    }
    content.setPublications(publications);
  }

  /**
   * Extracts the total paper citations from the HTML.
   */
  private void extractTotalPaperCitations() {
    String reForCitationsExtraction = "<a class=\\\"cit-dark-link\\\" "
        + "href=\"http://scholar.google.ca/scholar(.*?)</a>";
    Pattern patternObject = Pattern.compile(reForCitationsExtraction);
    Matcher matcherObject = patternObject.matcher(HTMLContent);
    Integer totalCitations = 0;
    // Get the first five publications citations,
    // if there is less gets what's there
    for (int i = 0; i < 5; i++) {
      if (matcherObject.find()) {
        String numCitations = matcherObject.group(1)
            .substring(matcherObject.group(1).indexOf(">") + 1);
        totalCitations += Integer.parseInt(numCitations);
      } else {
        break;
      }
    }
    content.setTotalPaperCitations(totalCitations);
  }

  /**
   * Extracts the coAuthors names from the HTML, and the total number of
   * CoAuthors.
   */
  private void extractCoAuthors() {
    String reForCitationsExtraction = "<a class=\"cit-dark-link\" href=\"http:"
        + "//scholar.google.ca/citations[?]user(.*?)</a>";
    Pattern patternObject = Pattern.compile(reForCitationsExtraction);
    Matcher matcherObject = patternObject.matcher(HTMLContent);
    ArrayList<String> coAuthors = new ArrayList<String>();
    // Get all of the coauthor names and store them
    while (matcherObject.find()) {
      String coAuthorName = matcherObject.group(1)
          .substring(matcherObject.group(1).indexOf(">") + 1);
      coAuthors.add(coAuthorName);
    }
    content.setTotalCoAuthors(coAuthors.size());
    RawContent.addCoAuthors(coAuthors);
  }

}
