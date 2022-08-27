public class BoxTest {
  public static void main(String[] args) {
    Box[] boxes = { new Box(10, 20, 30), new Box(20, 40, 30), new Box(10, 20, 30) };

    for (Box b : boxes) {
      System.out.println(b);
    }
  }
}
