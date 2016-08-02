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
 * The Class Output is a base class for output that deals with storing and
 * formatting the output.
 */
public class Output {

  /** The output string where the formatted output is stored. */
  public String output;

  /**
   * Instantiates a new output object and parses the rawContent.
   *
   * @param rawContents the raw contents
   */
  public Output(ArrayList<RawContent> rawContents) {
    OutputFormatter outFormatter = new OutputFormatter();
    output = outFormatter.formatAllRawContent(rawContents);
  }

}
