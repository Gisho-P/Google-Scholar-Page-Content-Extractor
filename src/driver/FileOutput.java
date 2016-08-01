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

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class FileOutput extends Output {

  public FileOutput(ArrayList<RawContent> rawContents) {
    super(rawContents);
  }

  public void sendOutput(String fileName) {
    PrintWriter filewriter;
    try {
      filewriter = new PrintWriter(fileName, "UTF-8");
      filewriter.println(output);
      filewriter.close();
    } catch (FileNotFoundException e) {
      ConsoleOutput.sendError(fileName + " is not a valid file path");
    } catch (UnsupportedEncodingException e) {
      ConsoleOutput.sendError("UTF-8 not supported");
    }
  }

}
