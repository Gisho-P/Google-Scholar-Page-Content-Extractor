package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import driver.ContentExtractor;
import driver.HTMLExtractor;
import driver.RawContent;


public class ContentExtractorTest {

  RawContent htmlCont;
  
  @Before
  public void setUp() throws Exception {
    String htmlContent = HTMLExtractor.getHTML("sample1.html");
    ContentExtractor contExtractor = new ContentExtractor(htmlContent);
    htmlCont = contExtractor.extractAndGetAllContent();
  }
  
  @Test
  public void testAuthorName() {
    String expectedName = "Ola Spjuth";
    String actualName = htmlCont.getAuthorName();
    assertEquals(expectedName, actualName);
  }
  
  @Test
  public void testNumberCitations() {
    Integer expectedCitations = 437;
    Integer actualCitations = htmlCont.getNumOfCitations();
    assertEquals(expectedCitations, actualCitations);
  }
  
  @Test
  public void testi10Index() {
    Integer expectedi10Index = 12;
    Integer actuali10Index = htmlCont.getI10Index();
    assertEquals(expectedi10Index, actuali10Index);
  }
  
  @Test
  public void testFirst3Pub() {
    ArrayList<String> expectedFirst3Pub = new ArrayList<String>();
    expectedFirst3Pub.addAll(Arrays.asList("Bioclipse: an open source workbench"
        + " for chemo-and bioinformatics", "The LCB data warehouse",
        "XMPP for cloud computing in bioinformatics supporting discovery and"
        + " invocation of asynchronous web services"));
    ArrayList<String> actualFirst3Pub = htmlCont.getPublications();
    assertEquals(expectedFirst3Pub, actualFirst3Pub);
  }
  
  @Test
  public void testPaperCitations() {
    Integer expectedPaperCitations = 239;
    Integer actualPaperCitations = htmlCont.getTotalPaperCitations();
    assertEquals(expectedPaperCitations, actualPaperCitations);
  }
  
  @Test
  public void testCoAuthors() {
    Integer expectedCoAuthors = 15;
    Integer actualCoAuthors = htmlCont.getTotalCoAuthors();
    assertEquals(expectedCoAuthors, actualCoAuthors);
  }

}
