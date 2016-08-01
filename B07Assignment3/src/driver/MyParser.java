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

public class MyParser {

/**
* @param args
*/
public static void main(String[] args) {
 if(validateArgs(args)){
   String inputFiles[] = args[0].split(",");
   ArrayList<RawContent> fileContents = new ArrayList<RawContent>();
   String htmlContent = "";
   for (String inputFile : inputFiles) {
     try {
      htmlContent = HTMLExtractor.getHTML(inputFile);
    } catch (Exception e) {
      System.out.println("malformed URL or cannot open connection to "
          + "given URL");
      return;
    }
     ContentExtractor contExtract = new ContentExtractor(htmlContent);
     fileContents.add(contExtract.extractAndGetAllContent());
 }
   if (args.length == 2)
     // call file output
     System.out.println("");
   else
     // call console output
     System.out.println("");
 }
}

public static boolean validateArgs(String [] args){
  if(args.length < 0 || args.length > 2){
    System.out.println("These arguments are invalid, the first argument should"
        + "be a list of urls seperated by commas,"
        + "and the optional second argument should be a file name");
    return false;
  }
  return true;
}
/*
* This is a debug/helper method to help you get started. Once you understand
* how this method is being used, you are free to refactor it, modify it, or
* change it, or remove it entirely in any way you like.
*/
private static void DEBUGStarterCode(String[] args) {
 try {
   System.out.println("DEBUG: URLS are " + args[0]);
   System.out.println("DEBUG: FileName is " + args[1]);
 } catch (Exception e) {
   System.out.println("Did you change the run configuration in"
       + "Eclipse for argument0 and argument 1?");
 }


 // TODO Auto-generated method stub
 String inputFiles[] = args[0].split(",");
 for (String inputFile : inputFiles) {
   DEBUGextractAuthorsName(inputFile);
 }
}


/*
* This is a debug/helper method to help you get started. Once you understand
* how this method is being used i.e. the String re, Pattern, Matcher and how
* the authors name is being extracted, feel free to remove this method or
* refactor it in any way you like.
*/
private static void DEBUGextractAuthorsName(String googleScholarURL) {
 try {
   String rawHTMLString = HTMLExtractor.getHTML(googleScholarURL);

   String reForAuthorExtraction =
       "<span id=\"cit-name-display\" "
           + "class=\"cit-in-place-nohover\">(.*?)</span>";
   Pattern patternObject = Pattern.compile(reForAuthorExtraction);
   Matcher matcherObject = patternObject.matcher(rawHTMLString);
   while (matcherObject.find()) {
     System.out.println("DEBUG: Authors Name is " + matcherObject.group(1));
   }

 } catch (Exception e) {
   System.out.println("malformed URL or cannot open connection to "
       + "given URL");
 }
}

}
