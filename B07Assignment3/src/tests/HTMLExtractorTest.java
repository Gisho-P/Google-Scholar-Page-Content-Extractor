package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import driver.HTMLExtractor;

public class HTMLExtractorTest {

  @Test
  public void testExtractHTMLNoText() throws Exception {
    String expectedName = "<!DOCTYPE html><html><head></head></html>";
    String actualName = HTMLExtractor.getHTML("src\\tests\\test1.html");
    assertEquals(expectedName, actualName);
  }
  
  @Test
  public void testExtractHTMLWithText() throws Exception {
    String expectedName = "<!DOCTYPE html><html><head></head><body><b>hi"
        + "</b></body></html>";
    String actualName = HTMLExtractor.getHTML("src\\tests\\test2.html");
    assertEquals(expectedName, actualName);
  }

}
