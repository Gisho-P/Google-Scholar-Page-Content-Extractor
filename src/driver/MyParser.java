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

public class MyParser {

  /**
   * @param args
   */
  public static void main(String[] args) {
    if (validateArgs(args)) {
      String inputFiles[] = args[0].split(",");
      ArrayList<RawContent> htmlContents = new ArrayList<RawContent>();
      String htmlContent = "";
      for (String inputFile : inputFiles) {
        try {
          htmlContent = HTMLExtractor.getHTML(inputFile);
        } catch (Exception e) {
          ConsoleOutput.sendError(
              "malformed URL or cannot open connection to " + "given URL");
          return;
        }
        ContentExtractor contExtract = new ContentExtractor(htmlContent);
        htmlContents.add(contExtract.extractAndGetAllContent());
      }
      if (args.length == 2) {
        FileOutput fileOut = new FileOutput(htmlContents);
        fileOut.sendOutput(args[1]);
      } else {
        ConsoleOutput consoleOut = new ConsoleOutput(htmlContents);
        consoleOut.sendOutput();
      }
    }
  }

  public static boolean validateArgs(String[] args) {
    if (args.length < 0 || args.length > 2) {
      ConsoleOutput
          .sendError("These arguments are invalid, the first argument should"
              + "be a list of urls seperated by commas,"
              + "and the optional second argument should be a file name");
      return false;
    }
    return true;
  }

}
