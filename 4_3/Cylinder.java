public class Cylinder {
  int radius = 0;
  int height = 0;

  public Cylinder(int radius, int height) {
    this.radius = radius;
    this.height = height;
  }

  public double getVolume() {
    return Math.PI * Math.pow(this.radius, 2) * this.height;
  }

  public double getSurfaceArea() {
    return (2 * Math.PI * this.radius * this.height) + (2 * Math.PI * Math.pow(this.radius, 2));
  }

  @Override
  public String toString() {
    return "I AM A CYLINDER WOO HEIGHT: " + this.height + " RADIUS: " + this.radius;
  }
}
