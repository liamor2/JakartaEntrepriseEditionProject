package net.efrei.start.dto;

public class CreateMovie {

  private String title;
  private int year;
  private String directorID;
  private String[] actorsIDs;
  private String genre;

  public CreateMovie() {}

  public CreateMovie(String title, int year, String directorID, String[] actorsIDs, String genre) {
    this.title = title;
    this.year = year;
    this.directorID = directorID;
    this.actorsIDs = actorsIDs;
    this.genre = genre;
  }

  public String getTitle() {
    return title;
  }

  public int getYear() {
    return year;
  }

  public String getDirectorID() {
    return directorID;
  }

  public String getGenre() {
    return genre;
  }

  public String[] getActorsIDs() {
    return actorsIDs;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public void setDirectorID(String directorID) {
    this.directorID = directorID;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  public void setActorsIDs(String[] actorsIDs) {
    this.actorsIDs = actorsIDs;
  }
}
