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
package driver;

import java.util.ArrayList;

/**
 * The Class RawContent is a data type used to store the raw extracted content
 * from an HTML web page.
 */
public class RawContent {
  private String authorName;
  private int numOfCitations;
  private int i10Index;
  private ArrayList<String> publications;
  private int totalPaperCitations;
  private int totalCoAuthors;
  public static ArrayList<String> coAuthors = new ArrayList<String>();

  /**
   * Gets the author name.
   *
   * @return the author name
   */
  public String getAuthorName() {
    return authorName;
  }

  /**
   * Sets the author name.
   *
   * @param authorName the new author name
   */
  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  /**
   * Gets the number of citations.
   *
   * @return the number of citations
   */
  public int getNumOfCitations() {
    return numOfCitations;
  }

  /**
   * Sets the number of citations.
   *
   * @param numOfCitations the new number of citations
   */
  public void setNumOfCitations(int numOfCitations) {
    this.numOfCitations = numOfCitations;
  }

  /**
   * Gets the i10 index after 2009.
   *
   * @return the i10 index after 2009
   */
  public int getI10Index() {
    return i10Index;
  }

  /**
   * Sets the i10 index after 2009.
   *
   * @param i10Index the new i10 index after 2009
   */
  public void setI10Index(int i10Index) {
    this.i10Index = i10Index;
  }

  /**
   * Gets the list of publications.
   *
   * @return the list of publications
   */
  public ArrayList<String> getPublications() {
    return publications;
  }

  /**
   * Sets the list of publications.
   *
   * @param publications the new list of publications
   */
  public void setPublications(ArrayList<String> publications) {
    this.publications = publications;
  }

  /**
   * Gets the total number of paper citations.
   *
   * @return the total number of paper citations
   */
  public int getTotalPaperCitations() {
    return totalPaperCitations;
  }

  /**
   * Sets the total number of paper citations.
   *
   * @param totalPaperCitations the new total number of paper citations
   */
  public void setTotalPaperCitations(int totalPaperCitations) {
    this.totalPaperCitations = totalPaperCitations;
  }

  /**
   * Gets the total number of co-authors.
   *
   * @return the total number of co-authors
   */
  public int getTotalCoAuthors() {
    return totalCoAuthors;
  }

  /**
   * Sets the total number of co-authors.
   *
   * @param totalCoAuthors the new total number of co-authors
   */
  public void setTotalCoAuthors(int totalCoAuthors) {
    this.totalCoAuthors = totalCoAuthors;
  }

  /**
   * Gets all the coAuthors from all RawContents-.
   *
   * @return the co authors
   */
  public static ArrayList<String> getCoAuthors() {
    return coAuthors;
  }

  /**
   * Adds the list of co-authors to the current list of co-authors (Doesn't add
   * duplicates).
   *
   * @param coAuthors the list of co-authors to add
   */
  public static void addCoAuthors(ArrayList<String> coAuthors) {
    for (String coAuthor : coAuthors) {
      if (!RawContent.coAuthors.contains(coAuthor))
        RawContent.coAuthors.add(coAuthor);
    }
  }

}
