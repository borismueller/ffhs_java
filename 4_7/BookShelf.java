import java.util.Date;

public class BookShelf {
  public static void main(String[] args) {
    Book[] books = { new Book("woo", "j.,r.r.r.r.r.r. tolkine", "idk", new Date()) };

    for (Book b : books) {
      System.out.println(b);
    }
  }
}
