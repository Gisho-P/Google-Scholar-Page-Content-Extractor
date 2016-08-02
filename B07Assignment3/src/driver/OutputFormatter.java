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
import java.util.Collections;

/**
 * The Class OutputFormatter deals with formatting the extracted raw HTML
 * content and storing it in a string.
 */
public class OutputFormatter {

  /**
   * Formats the content of one RawContent object which contains the raw HTML
   * content of one HTML google scholar web page.
   *
   * @param rContent the extracted raw content of an HTML web page
   * @return a formatted string of the HTML content
   */
  public String formatOneRawContent(RawContent rContent) {
    String formattedContent = "";
    formattedContent += "-------------------------------------------------"
        + "----------------------\n";
    formattedContent += "1. Name of Author:\n";
    formattedContent += "          " + rContent.getAuthorName() + "\n";
    formattedContent += "2. Number of All Citations:\n";
    formattedContent += "          " + rContent.getNumOfCitations() + "\n";
    formattedContent += "3. Number of i10-index after 2009:\n";
    formattedContent += "          " + rContent.getI10Index() + "\n";
    formattedContent += "4. Title of the first 3 publications:\n";
    // Go through each publication and add it's number and name to the string
    Integer pubNumber = 1;
    for (String publication : rContent.getPublications()) {
      formattedContent += "          " + pubNumber + "- " + publication + "\n";
      pubNumber++;
    }
    formattedContent += "5. Total paper citation (first 5 papers):\n";
    formattedContent += "          " + rContent.getTotalPaperCitations() + "\n";
    formattedContent += "6. Total Co-Authors:\n";
    formattedContent += "          " + rContent.getTotalCoAuthors() + "\n";
    return formattedContent;
  }

  /**
   * Formats the raw content of multiple HTML pages including the coAuthors.
   *
   * @param rContents the raw contents of multiple HTML pages
   * @return the string
   */
  public String formatAllRawContent(ArrayList<RawContent> rContents) {
    String formattedContent = "";
    // Get the formatted contents of each HTML page
    for (RawContent rContent : rContents) {
      formattedContent += formatOneRawContent(rContent);
    }
    // Get the total number of coAuthors for all HTML pages, and print all
    // of the given coAuthors
    formattedContent += "\n-------------------------------------------------"
        + "----------------------\n";
    formattedContent += "7. Co-Author list sorted (Total: "
        + RawContent.getCoAuthors().size() + "):\n";
    ArrayList<String> sortedCoAuthors = RawContent.getCoAuthors();
    Collections.sort(sortedCoAuthors, String.CASE_INSENSITIVE_ORDER);
    for (String coAuthor : sortedCoAuthors) {
      formattedContent += coAuthor + "\n";
    }
    return formattedContent;
  }
}
