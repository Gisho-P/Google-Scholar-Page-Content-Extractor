package driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import org.apache.commons.lang3.StringEscapeUtils;

/**
 * The Class HTMLExtractor deals with extracting the raw HTML from an HTML file
 * and storing it in a string.
 */
public class HTMLExtractor {

  /**
   * Gets the HTML content from an HTML file.
   *
   * @param urlString the url string with path to the HTML
   * @return the HTML content in a string
   * @throws IOException Signals that the HTML file doesn't exist
   */
  public static String getHTML(String urlString) throws IOException {
    // create object to store HTML source text as it is being collected
    StringBuilder HTML = new StringBuilder();
    // open connection to given url
    URL url = new File(urlString).toURI().toURL();
    // create BufferedReader to buffer the given url's HTML source
    BufferedReader HTMLbr =
        new BufferedReader(new InputStreamReader(url.openStream()));
    String line;
    // read each line of HTML code and store in StringBuilder
    while ((line = HTMLbr.readLine()) != null) {
      HTML.append(line);
    }
    HTMLbr.close();
    // convert StringBuilder into a String and return it
    return StringEscapeUtils.unescapeHtml3(HTML.toString());
  }
}
