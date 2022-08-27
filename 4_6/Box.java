public class Box {
  int height, width, depth;
  boolean full;

  public Box(int height, int width, int depth) {
    this.full = false;
    this.height = height;
    this.width = width;
    this.depth = depth;
  }

  @Override
  public String toString() {
    return String.format("I AM A BOX WOO, height: %d width: %d, depth: %d, full: %b", this.height, this.width,
        this.depth, this.full);
  }
}
