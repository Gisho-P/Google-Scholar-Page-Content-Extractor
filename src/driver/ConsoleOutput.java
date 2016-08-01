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

public class ConsoleOutput extends Output {

  public ConsoleOutput(ArrayList<RawContent> rawContents) {
    super(rawContents);
  }

  public void sendOutput() {
    System.out.println(output);
  }
  
  public static void sendError(String error){
    System.out.println(error);
  }


}
