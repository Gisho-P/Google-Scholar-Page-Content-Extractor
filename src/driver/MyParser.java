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

/**
 * The Class MyParser deals with validating the input arguments and parsing the
 * HTML file to the desired output.
 */
public class MyParser {

  /**
   * The main method which calls appropriate classes and their method to get the
   * HTML files' contents extracted and outputted.
   *
   * @param args the arguments which include a list of HTML files separated by
   *        commas and optionally a file which output would be redirected to
   */
  public static void main(String[] args) {
    if (validateArgs(args)) {
      String inputFiles[] = args[0].split(",");
      ArrayList<RawContent> htmlContents = new ArrayList<RawContent>();
      String htmlContent = "";
      // For each input HTML file extract the content and store the extracted
      // content in a collection
      for (String inputFile : inputFiles) {
        try {
          htmlContent = HTMLExtractor.getHTML(inputFile);
        } catch (Exception e) {
          ConsoleOutput.sendError(
              "The given url/path is not a valid google scholar profile");
          return;
        }
        ContentExtractor contExtract = new ContentExtractor(htmlContent);
        htmlContents.add(contExtract.extractAndGetAllContent());
      }
      // If the file is provided write the output to it, otherwise write to
      // console
      if (args.length == 2) {
        FileOutput fileOut = new FileOutput(htmlContents);
        fileOut.sendOutputToFile(args[1]);
      } else {
        ConsoleOutput consoleOut = new ConsoleOutput(htmlContents);
        consoleOut.sendOutput();
      }
    }
  }

  /**
   * Validates whether the correct number of input arguments are provided.
   *
   * @param args the given arguments to the program
   * @return true, iff the arguments are valid
   */
  public static boolean validateArgs(String[] args) {
    if (args.length < 1 || args.length > 2) {
      ConsoleOutput
          .sendError("These arguments are invalid, the first argument should"
              + " be a list of urls seperated by commas,"
              + "and the optional second argument should be a file name.");
      return false;
    }
    return true;
  }

}
