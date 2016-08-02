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

import java.io.IOException;

import org.junit.Test;
import driver.HTMLExtractor;


/**
 * The Class HTMLExtractorTest tests out the HTMLExtractor.
 */
public class HTMLExtractorTest {

  /**
   * Tests extracting an HTML object with no text.
   *
   * @throws IOException indicates the file path is not valid
   */
  @Test
  public void testExtractHTMLNoText() throws IOException {
    String expectedName = "<!DOCTYPE html><html><head></head></html>";
    String actualName = HTMLExtractor.getHTML("src\\tests\\test1.html");
    assertEquals(expectedName, actualName);
  }

  /**
   * Test extracting an HTML object with text.
   *
   * @throws IOException indicates the file path is not valid
   */
  @Test
  public void testExtractHTMLWithText() throws IOException {
    String expectedName =
        "<!DOCTYPE html><html><head></head><body><b>hi" + "</b></body></html>";
    String actualName = HTMLExtractor.getHTML("src\\tests\\test2.html");
    assertEquals(expectedName, actualName);
  }

}
