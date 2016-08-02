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
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import driver.ContentExtractor;
import driver.HTMLExtractor;
import driver.RawContent;


/**
 * The Class ContentExtractorTest tests out the contentExtractor class.
 */
public class ContentExtractorTest {

  RawContent htmlCont;

  /**
   * Gets the raw contents of an HTML web page.
   *
   * @throws IOException Signals that the file path is invalid.
   */
  @Before
  public void setUp() throws IOException {
    String htmlContent = HTMLExtractor.getHTML("sample1.html");
    ContentExtractor contExtractor = new ContentExtractor(htmlContent);
    htmlCont = contExtractor.extractAndGetAllContent();
  }

  /**
   * Tests that the correct author name is extracted.
   */
  @Test
  public void testAuthorName() {
    String expectedName = "Ola Spjuth";
    String actualName = htmlCont.getAuthorName();
    assertEquals(expectedName, actualName);
  }

  /**
   * Tests that the correct number of citations is extracted.
   */
  @Test
  public void testNumberCitations() {
    Integer expectedCitations = 437;
    Integer actualCitations = htmlCont.getNumOfCitations();
    assertEquals(expectedCitations, actualCitations);
  }

  /**
   * Tests that the correct i10 Index after 2009 is extracted.
   */
  @Test
  public void testi10Index() {
    Integer expectedi10Index = 12;
    Integer actuali10Index = htmlCont.getI10Index();
    assertEquals(expectedi10Index, actuali10Index);
  }

  /**
   * Tests that the correct first three publications is extracted.
   */
  @Test
  public void testFirst3Pub() {
    ArrayList<String> expectedFirst3Pub = new ArrayList<String>();
    expectedFirst3Pub
        .addAll(Arrays.asList(
            "Bioclipse: an open source workbench"
                + " for chemo-and bioinformatics",
            "The LCB data warehouse",
            "XMPP for cloud computing in bioinformatics supporting discovery and"
                + " invocation of asynchronous web services"));
    ArrayList<String> actualFirst3Pub = htmlCont.getPublications();
    assertEquals(expectedFirst3Pub, actualFirst3Pub);
  }

  /**
   * Tests that the correct paper citations is extracted.
   */
  @Test
  public void testPaperCitations() {
    Integer expectedPaperCitations = 239;
    Integer actualPaperCitations = htmlCont.getTotalPaperCitations();
    assertEquals(expectedPaperCitations, actualPaperCitations);
  }

  /**
   * Tests that the correct number of coAuthors is extracted.
   */
  @Test
  public void testCoAuthors() {
    Integer expectedCoAuthors = 15;
    Integer actualCoAuthors = htmlCont.getTotalCoAuthors();
    assertEquals(expectedCoAuthors, actualCoAuthors);
  }

  /**
   * Tests that the correct number of coAuthors is extracted with multiple HTML
   * web pages.
   * 
   * @throws IOException indicates the file path is not valid
   */
  @Test
  public void testCoAuthorsTwoHTML() throws IOException {
    String htmlContent = HTMLExtractor.getHTML("sample2.html");
    ContentExtractor contExtractor = new ContentExtractor(htmlContent);
    htmlCont = contExtractor.extractAndGetAllContent();
    Integer expectedCoAuthors = 29;
    Integer actualCoAuthors = RawContent.getCoAuthors().size();
    assertEquals(expectedCoAuthors, actualCoAuthors);
  }

}
