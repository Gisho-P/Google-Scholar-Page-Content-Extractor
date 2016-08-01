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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContentExtractor {
  public String htmlContent;
  public RawContent content;
  
  public ContentExtractor(String htmlContent){
    this.htmlContent = htmlContent;
    this.content = new RawContent();
  }
  public RawContent extractAndGetAllContent(){
    extractAuthorName();
    extractNumberOfCitations();
    extracti10IndexSince2009();
    extractFirst3Publications();
    extractTotalPaperCitations();
    extractCoAuthors();
    return this.content;
  }
  
  private void extractAuthorName(){
    String reForAuthorExtraction =
        "<span id=\"cit-name-display\" "
            + "class=\"cit-in-place-nohover\">(.*?)</span>";
    Pattern patternObject = Pattern.compile(reForAuthorExtraction);
    Matcher matcherObject = patternObject.matcher(htmlContent);
    if(matcherObject.find())
      content.setAuthorName(matcherObject.group(1));
  }
  
  private void extractNumberOfCitations(){
    String reForCitationsExtraction = "<td class=\"cit-borderleft cit-data\">"
        + "(.*?)</td>";
    Pattern patternObject = Pattern.compile(reForCitationsExtraction);
    Matcher matcherObject = patternObject.matcher(htmlContent);
    if(matcherObject.find())
      content.setNumOfCitations(Integer.parseInt(matcherObject.group(1)));
  }
  
  private void extracti10IndexSince2009(){
    String reForCitationsExtraction = "<td class=\"cit-borderleft cit-data\">"
        + "(.*?)</td>";
    Pattern patternObject = Pattern.compile(reForCitationsExtraction);
    Matcher matcherObject = patternObject.matcher(htmlContent);
    // It's the 6th instance of the element so call find 6 times
    for (int i = 0; i < 6; i++)
      matcherObject.find();
    content.setI10Index(Integer.parseInt(matcherObject.group(1)));
  }
  
  private void extractFirst3Publications(){
    String reForCitationsExtraction = 
        "class=\"cit-dark-large-link\">(.*?)</a>";
    Pattern patternObject = Pattern.compile(reForCitationsExtraction);
    Matcher matcherObject = patternObject.matcher(htmlContent);
    ArrayList<String> publications = new ArrayList<String>();
    // Get the first three publications
    for (int i = 0; i < 3; i++){
      if(matcherObject.find())
        publications.add(matcherObject.group(1));
      else
        break;
    }
    content.setPublications(publications);
  }
  
  private void extractTotalPaperCitations(){
    String reForCitationsExtraction = "<a class=\\\"cit-dark-link\\\" "
        + "href=\"http://scholar.google.ca/scholar(.*?)</a>";
    Pattern patternObject = Pattern.compile(reForCitationsExtraction);
    Matcher matcherObject = patternObject.matcher(htmlContent);
    Integer totalCitations = 0;
    // Get the first five publications citations
    for (int i = 0; i < 5; i++){
      if(matcherObject.find()){
      String numCitations = matcherObject.group(1).substring(
          matcherObject.group(1).indexOf(">") + 1);
      totalCitations += Integer.parseInt(numCitations);
      } else {
        break;
      }
    }
    content.setTotalPaperCitations(totalCitations);
  }
  
  private void extractCoAuthors(){
    String reForCitationsExtraction = "<a class=\"cit-dark-link\" href=\"http:"
        + "//scholar.google.ca/citations[?]user(.*?)</a>";
    Pattern patternObject = Pattern.compile(reForCitationsExtraction);
    Matcher matcherObject = patternObject.matcher(htmlContent);
    ArrayList<String> coAuthors = new ArrayList<String>();
    // Get all of the coauthor names and store them
    while(matcherObject.find()){
      String coAuthorName = matcherObject.group(1).substring(
          matcherObject.group(1).indexOf(">") + 1);
      coAuthors.add(coAuthorName);
    }
    content.setTotalCoAuthors(coAuthors.size());
    RawContent.addCoAuthors(coAuthors);
  }
  
}
