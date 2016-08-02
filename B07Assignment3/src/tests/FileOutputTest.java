package tests;

import static org.junit.Assert.*;

import java.io.File;
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

public class FileOutputTest {
  RawContent htmlCont;
  FileOutput fileOut;

  @Before
  public void setup() throws Exception {
    String htmlContent = HTMLExtractor.getHTML("sample1.html");
    ContentExtractor contExtractor = new ContentExtractor(htmlContent);
    htmlCont = contExtractor.extractAndGetAllContent();
    ArrayList<RawContent> rawConts = new ArrayList<RawContent>();
    rawConts.add(htmlCont);
    fileOut = new FileOutput(rawConts);
  }

  @After
  public void tearDown() {
    File f = new File("src\\tests\\testFile");
    if (f.exists()) {
      f.delete();
    }
  }


  @Test
  public void testFileOutput() throws Exception {
    fileOut.sendOutputToFile("src\\tests\\testFile");
    File f = new File("src\\tests\\testFile");
    assertTrue(f.exists());
  }

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
  
  @Test
  public void testInvalidFilePath() throws Exception {
    fileOut.sendOutputToFile("src\\tests\\nonExist\\testFile");
    File f = new File("src\\tests\\nonExist\\testFile");
    assertTrue(!f.exists());
  }

}
