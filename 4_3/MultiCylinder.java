public class MultiCylinder {
  public static void main(String[] args) {
    Cylinder[] cylinders = { new Cylinder(10, 500), new Cylinder(20, 100), new Cylinder(30, 200) };

    for (Cylinder c : cylinders) {
      System.out.println(c);
      System.out.println(c.getSurfaceArea());
      System.out.println(c.getVolume());
    }
  }
}
