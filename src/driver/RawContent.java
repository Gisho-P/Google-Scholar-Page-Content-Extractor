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

public class RawContent {
  private String authorName;
  private int numOfCitations;
  private int i10Index;
  private ArrayList<String> publications;
  private int totalPaperCitations;
  private int totalCoAuthors;
  public static ArrayList<String> coAuthors = new ArrayList<String>();
  
  public RawContent(){
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public int getNumOfCitations() {
    return numOfCitations;
  }

  public void setNumOfCitations(int numOfCitations) {
    this.numOfCitations = numOfCitations;
  }

  public int getI10Index() {
    return i10Index;
  }

  public void setI10Index(int i10Index) {
    this.i10Index = i10Index;
  }

  public ArrayList<String> getPublications() {
    return publications;
  }

  public void setPublications(ArrayList<String> publications) {
    this.publications = publications;
  }

  public int getTotalPaperCitations() {
    return totalPaperCitations;
  }

  public void setTotalPaperCitations(int totalPaperCitations) {
    this.totalPaperCitations = totalPaperCitations;
  }

  public int getTotalCoAuthors() {
    return totalCoAuthors;
  }

  public void setTotalCoAuthors(int totalCoAuthors) {
    this.totalCoAuthors = totalCoAuthors;
  }

  public static ArrayList<String> getCoAuthors() {
    return coAuthors;
  }

  public static void addCoAuthors(ArrayList<String> coAuthors) {
    RawContent.coAuthors.addAll(coAuthors);
  }
  
}
