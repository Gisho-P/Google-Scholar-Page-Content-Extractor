//**********************************************************
//Assignment3:
//UTORID user_name: pushpa10
//
//Author: Girrshotan Pushparajah
//
//
//Honor Code: I pledge that this program represents my own
//program code and that I have coded on my own. I received
//help from no one in designing and debugging my program.
//*********************************************************
package driver;

import java.util.ArrayList;
import java.util.Collections;

public class OutputFormatter {
  public String formatOneRawContent(RawContent rContent){
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
    Integer pubNumber = 1;
    for(String publication: rContent.getPublications()){
      formattedContent += "          " + pubNumber + "- " + publication + "\n";
      pubNumber++;
    }
    formattedContent += "5. Total paper citation (first 5 papers):\n";
    formattedContent += "          " + rContent.getTotalPaperCitations() + "\n";
    formattedContent += "6. Total Co-Authors:\n";
    formattedContent += "          " + rContent.getTotalCoAuthors() + "\n";
    return formattedContent;
  }
  
  public String formatAllRawContent(ArrayList<RawContent> rContents){
    String formattedContent = "";
    for(RawContent rContent: rContents){
      formattedContent += formatOneRawContent(rContent);
    }
    formattedContent += "\n-------------------------------------------------"
        + "----------------------\n";
    formattedContent += "7. Co-Author list sorted (Total: "
    + RawContent.getCoAuthors().size() + "):\n";
    ArrayList<String> sortedCoAuthors = RawContent.getCoAuthors();
    Collections.sort(sortedCoAuthors, String.CASE_INSENSITIVE_ORDER);
    for(String coAuthor: sortedCoAuthors){
      formattedContent += coAuthor + "\n";
    }
    return formattedContent;
  }
}
