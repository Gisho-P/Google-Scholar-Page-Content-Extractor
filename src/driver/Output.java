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

public class Output {
  public String output;
  
  public Output(ArrayList<RawContent> rawContents){
    OutputFormatter outFormatter = new OutputFormatter();
    output = outFormatter.formatAllRawContent(rawContents);
  }

}