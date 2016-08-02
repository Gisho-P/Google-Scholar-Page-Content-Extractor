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
package tests;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import driver.ContentExtractor;
import driver.FileOutput;
import driver.HTMLExtractor;
import driver.RawContent;

/**
 * The Class FileOutputTest tests out the functionality of the FileOutput class.
 */
public class FileOutputTest {
  FileOutput fileOut;

  // Initialize FileOutput with HTML Output
  @Before
  public void setup() throws Exception {
    String htmlContent = HTMLExtractor.getHTML("sample1.html");
    ContentExtractor contExtractor = new ContentExtractor(htmlContent);
    RawContent htmlCont = contExtractor.extractAndGetAllContent();
    ArrayList<RawContent> rawConts = new ArrayList<RawContent>();
    rawConts.add(htmlCont);
    fileOut = new FileOutput(rawConts);
  }

  // Delete the file if it exists after the test
  @After
  public void tearDown() {
    File f = new File("src\\tests\\testFile");
    if (f.exists()) {
      f.delete();
    }
  }


  /**
   * Tests that the file is created when sendOutputToFile is called.
   *
   * @throws IOException Signals that the file path is invalid.
   */
  @Test
  public void testFileOutput() throws IOException {
    fileOut.sendOutputToFile("src\\tests\\testFile");
    File f = new File("src\\tests\\testFile");
    assertTrue(f.exists());
  }

  /**
   * Tests that the contents of the file is overwritten when sendOutputToFile is
   * called.
   *
   * @throws IOException Signals that the file path is invalid.
   */
  @Test
  public void testFileOverWrite() throws Exception {
    List<String> fileLines = Arrays.asList("The first line", "The second line");
    Path file = Paths.get("src\\tests\\testFile");
    Files.write(file, fileLines, Charset.forName("UTF-8"));
    fileOut.sendOutputToFile("src\\tests\\testFile");
    assertEquals(
        String.join("\n",
            Files.readAllLines(Paths.get("src\\tests\\testFile"))),
        fileOut.output);
  }

  /**
   * Tests that the file isn't created when an invalid path is given.
   *
   * @throws IOException Signals that the file path is invalid.
   */
  @Test
  public void testInvalidFilePath() throws Exception {
    fileOut.sendOutputToFile("src\\tests\\nonExist\\testFile");
    File f = new File("src\\tests\\nonExist\\testFile");
    assertTrue(!f.exists());
  }

}
