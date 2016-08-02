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
 * The Class ConsoleOutput deals with sending output or errors to the console.
 */
public class ConsoleOutput extends Output {

  public ConsoleOutput(ArrayList<RawContent> rawContents) {
    super(rawContents);
  }

  /**
   * Simply prints the output to the console.
   */
  public void sendOutput() {
    System.out.println(output);
  }

  /**
   * Sends the error message to the console
   *
   * @param error the error message
   */
  public static void sendError(String error) {
    System.out.println(error);
  }


}
