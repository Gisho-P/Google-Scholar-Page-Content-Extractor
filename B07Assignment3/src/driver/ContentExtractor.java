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
      content.setAuthorName(matcherObject.group(1));
  }
  
}
