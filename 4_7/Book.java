import java.util.Date;

public class Book {
  String title, author, publisher;
  Date copyright;

  public Book(String title, String author, String publisher, Date date) {
    this.title = title;
    this.author = author;
    this.publisher = publisher;
    this.copyright = date;
  }

  @Override
  public String toString() {
    return String.format("%s, by %s, published by %s \n cc %tY", this.title, this.author, this.publisher,
        this.copyright);
  }
}
