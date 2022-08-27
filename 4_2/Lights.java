public class Lights {
  public static void main(String[] args) {
    Bulb[] bulbs = { new Bulb(false), new Bulb(true), new Bulb(true) };

    for (Bulb b : bulbs) {
      System.out.println(b);
    }
  }
}
