import java.util.Random;
import java.util.Scanner;

public class Exercises {
  public static void main(String[] args) {
    // sum_of_cubes();
    // distance();
    // Snowman snowman = new Snowman();
    // snowman.start();
  }

  // PP 3.2
  public static void sum_of_cubes() {
    int first, second;

    Scanner scan = new Scanner(System.in);

    System.out.println("Enter the first number");
    first = scan.nextInt();

    System.out.println("Enter the second number");
    second = scan.nextInt();

    System.out.println("res: " + (Math.pow(first, 3) + Math.pow(second, 3)));

    scan.close();
  }

  // PP 3.5
  public static void distance() {
    int x1, y1, x2, y2;

    Scanner scan = new Scanner(System.in);

    System.out.println("Enter x, y for first cords");
    x1 = scan.nextInt();
    y1 = scan.nextInt();

    System.out.println("Enter x, y for second cords");
    x2 = scan.nextInt();
    y2 = scan.nextInt();

    int distanceX = x2 - x1;
    int distanceY = y2 - y1;
    double x = Math.pow(distanceX, 2) - Math.pow(distanceY, 2);

    System.out.println("distanceX " + distanceX + " distanceY " + distanceY + " x: " + x);

    System.out.println("res: " + (Math.sqrt(x)));

    scan.close();
  }
}
