import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.spi.CharsetProvider;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Block3 {
  public static void main(String[] args) {
    // PP 5.2
    // CheckLeapYear check = new CheckLeapYear();
    // check.letUserCheckLeapYear();

    // PP 5.6
    // FlipRace race = new FlipRace();
    // race.doRace();

    // PP 5.10
    /*
     * Account account = new Account("😎😎", 123, 1_000);
     * account.depsoit(100); // should be ok
     * account.withdraw(500, 10); // should be ok
     * try {
     * account.withdraw(50_000, 10); // error
     * } catch (Error e) {
     * System.out.println(e);
     * }
     * try {
     * account.depsoit(-100); // error
     * } catch (Error e) {
     * System.out.println(e);
     * }
     */

    // PP 5.14
    // IntegersInTextFile counter = new IntegersInTextFile();
    // counter.readTextFile(true);

    // TODO:
    // PP 5.16
    // PP 5.17

    // PP 6.2
    // CharPerLine c = new CharPerLine();
    // c.readStringAndPrintOneCharPerLine();

    // PP 6.6
    // Coin coin = new Coin();
    // coin.getNHeadInARow(4);

    // PP 6.7
    // Stars stars = new Stars();
    // stars.printDefault();
    // System.out.println("a: ");
    // stars.printTopToBottomLeft();
    // System.out.println("b: ");
    // stars.printBottomToTopRight();
    // System.out.println("c: ");
    // stars.printTopToBottomRight();
    // System.out.println("d: ");
    // stars.printDiamond();

    // PP 6.10
    // ChristamsVerse verse = new ChristamsVerse();
    // verse.printVerse();

    // TODO:
    // PP 5.11
    // PP 6.14

    // PP 8.2
    // NumberRange range = new NumberRange();
    // range.readRange();

    // PP 8.3
    // NumberFrequency freq = new NumberFrequency();
    // freq.readFromTextFile();

    // PP 8.8
    CalculateMeanAndStandardDeviation calc = new CalculateMeanAndStandardDeviation();
    calc.calculate();

    // TODO:
    // PP 8.16
  }

}

// PP 5.2
class CheckLeapYear {
  private boolean isLeapYear(int year) {
    boolean result = false;
    if (year % 4 == 0) {
      result = true;
    }
    if (year % 100 == 0) {
      result = false;
    }
    if (year % 400 == 0) {
      result = true;
    }
    if (year < 1582) {
      throw new Error("Invalid Date (before Greogrian calendar)");
    }
    return result;
  }

  public void letUserCheckLeapYear() {
    Scanner scan = new Scanner(System.in);
    while (true) {
      System.out.println("Please enter a year you wish to check: ");
      int year = scan.nextInt();
      boolean isLeapYear = this.isLeapYear(year);
      System.out.println(isLeapYear ? "leap year" : "not leap year");
    }
    // scan.close();
  }
}

// PP 5.6
class Coin {
  private final int HEADS = 0;
  private final int TAILS = 1;

  private int face;

  public Coin() {
    flip();
  }

  public void flip() {
    face = (int) (Math.random() * 2);
  }

  public boolean isHeads() {
    return face == HEADS;
  }

  public String toString() {
    if (face == HEADS) {
      return "Heads";
    } else {
      return "Tails";
    }
  }

  public void getNHeadInARow(int n) {
    int counter = 0;
    int headsInARow = 0;
    while (headsInARow < n) {
      counter++;
      flip();
      if (isHeads()) {
        headsInARow++;
        System.out.println(toString());
      } else {
        headsInARow = 0;
        System.out.println(toString());
      }
    }
    System.out.println("Got " + n + " heads in a row. Took " + counter + " tries.");
  }
}

class FlipRace {
  public void doRace() {
    System.out.println("start race");
    Coin coinOne = new Coin();
    Coin coinTwo = new Coin();
    int coinOneHeadCount = 0;
    int coinTwoHeadCount = 0;
    int tries = 0;

    while (true) {
      tries++;
      coinOne.flip();
      coinTwo.flip();

      System.out.println(coinOne.toString() + " " + coinTwo.toString());

      if (coinOne.isHeads()) {
        coinOneHeadCount++;
      } else {
        coinOneHeadCount = 0;
      }
      if (coinTwo.isHeads()) {
        coinTwoHeadCount++;
      } else {
        coinTwoHeadCount = 0;
      }
      if (coinOneHeadCount == 3 && coinTwoHeadCount == 3) {
        System.out.println("both won!");
        break;
      }
      if (coinOneHeadCount == 3) {
        System.out.println("coin one won!");
        break;
      }
      if (coinTwoHeadCount == 3) {
        System.out.println("coin two won!");
        break;
      }
    }
    System.out.println("took " + tries + " tries");
  }
}

// PP 5.10
class Account {
  private final double RATE = 0.035;

  private long acctNumber;
  private double balance;
  private String name;

  public Account(String owner, long account, double initial) {
    name = owner;
    acctNumber = account;
    balance = initial;
  }

  public double depsoit(double amount) {
    if (amount <= 0) {
      throw new Error("Negative deposit is not allowed!");
    }
    balance = balance + amount;
    return balance;
  }

  public double withdraw(double amount, double fee) {
    if ((amount + fee) > balance) {
      throw new Error("Not allowed to withdraw more than current balance of: " + balance);
    }
    balance = balance - amount - fee;
    return balance;
  }

  public double addInterest() {
    balance += (balance * RATE);
    return balance;
  }

  public double getBalance() {
    return balance;
  }

  public String toString() {
    NumberFormat fmt = NumberFormat.getCurrencyInstance();
    return acctNumber + "\t" + name + "\t" + fmt.format(balance);
  }
}

// PP 5.14
class IntegersInTextFile {
  public ArrayList<Integer> readTextFile(boolean debugInfo) {
    File file = new File("files/integers.txt");
    Scanner scan;
    try {
      scan = new Scanner(file);
      ArrayList<Integer> ints = new ArrayList<Integer>();
      while (scan.hasNextLine()) {
        String value = scan.nextLine();
        try {
          int i = Integer.parseInt(value);
          ints.add(i);
        } catch (Exception e) {
          // ignore
        }
      }
      scan.close();
      if (debugInfo) {
        System.out.println("got " + ints.size() + " integers");
        for (int i : ints) {
          System.out.println(i);
        }
      }
      return ints;
    } catch (FileNotFoundException e) {
      System.out.println("file not found!");
      e.printStackTrace();
      return new ArrayList<Integer>();
    }
  }
}

class CharPerLine {
  public void readStringAndPrintOneCharPerLine() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Please enter the string: ");
    String input = scan.nextLine();
    for (Character c : input.toCharArray()) {
      System.out.println(c);
    }
    scan.close();
  }
}

class Stars {
  final int MAX_ROWS = 10;

  public void printDefault() {
    for (int row = 0; row < MAX_ROWS; row++) {
      for (int star = 0; star < row; star++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public void printTopToBottomLeft() {
    for (int row = MAX_ROWS; row > 0; row--) {
      for (int star = 0; star < row; star++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public void printBottomToTopRight() {
    for (int row = 0; row < MAX_ROWS; row++) {
      for (int spaces = 0; spaces < MAX_ROWS - (row + 1); spaces++) {
        System.out.print(" ");
      }
      for (int star = 0; star < (row + 1); star++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }

  public void printTopToBottomRight() {
    for (int row = MAX_ROWS; row > 0; row--) {
      for (int space = 0; space < (MAX_ROWS - row); space++) {
        System.out.print(" ");
      }
      for (int star = 0; star < row; star++) {
        System.out.print("*");
      }
      System.out.println();
    }

  }

  public void printDiamond() {
    int starCount = 1;
    for (int row = 0; row < MAX_ROWS; row++) {
      for (int spaceLeft = 0; spaceLeft < (MAX_ROWS - starCount) / 2; spaceLeft++) {
        System.out.print(" ");
      }
      for (int star = 0; star < starCount; star++) {
        System.out.print("*");
      }
      if (row < (MAX_ROWS / 2) - 1) {
        starCount = starCount + 2;
      } else {
        starCount = starCount - 2;
      }
      System.out.println();
    }
  }
}

// PP 6.10
class ChristamsVerse {
  public void printVerse() {
    String verse = "";
    for (int verseNumber = 1; verseNumber <= 12; verseNumber++) {
      String dayNumber = "";
      switch (verseNumber) {
        case 1: {
          dayNumber = "1st";
          break;
        }
        case 2: {
          dayNumber = "2nd";
          break;
        }
        case 3: {
          dayNumber = "3rd";
          break;
        }
        // 4th, 5th, 6th, 7th, 8th, 9th, 10th, 11th, 12th
        default: {
          dayNumber = verseNumber + "th";
          break;
        }
      }
      System.out.println("\nOn the " + dayNumber + " day of Christmas my true love gave to me");
      switch (verseNumber) {
        case 1: {
          verse += "A partridge in a pear tree.";
          break;
        }
        case 2: {
          verse += "\nTwo turtle doves, and";
          break;
        }
        case 3: {
          verse += "\nThree French hens,";
          break;
        }
        case 4: {
          verse += "\nFour calling birds,";
          break;
        }
        case 5: {
          verse += "\nFive golden rings,";
          break;
        }
        case 6: {
          verse += "\nSix gees a-laying,";
          break;
        }
        case 7: {
          verse += "\nSeven swans a-swimming,";
          break;
        }
        case 8: {
          verse += "\nEight maids a-milking,";
          break;
        }
        case 9: {
          verse += "\nNine ladies dancing,";
          break;
        }
        case 10: {
          verse += "\nTen lords a-leaping,";
          break;
        }
        case 11: {
          verse += "\nEleven pipers piping,";
          break;
        }
        case 12: {
          verse += "\nTwelve drummers drumming,";
          break;
        }
      }
      System.out.println(verse);
    }
  }
}

// PP 8.2
class NumberRange {
  private final int MAX = 25;
  private final int MIN = -25;

  public void readRange() {
    Scanner scan = new Scanner(System.in);
    // ArrayList<Integer> ints = new ArrayList<Integer>();
    HashMap<Integer, Integer> ints = new HashMap<Integer, Integer>();
    boolean readInput = true;

    while (readInput) {
      System.out.println("Please enter a number between " + MIN + " and " + MAX + ": ");
      int userNumber = scan.nextInt();
      if (userNumber > MIN && userNumber < MAX) {
        if (ints.containsKey(userNumber)) {
          int count = ints.get(userNumber);
          ints.put(userNumber, count + 1);
        } else {
          ints.put(userNumber, 1);
        }
      } else {
        System.out.println("Input outside of range! Exiting.");
        readInput = false;
      }
    }

    for (int key : ints.keySet()) {
      System.out.println(key + " enterd " + ints.get(key) + " times");
    }
    scan.close();
  }
}

// PP 8.3
class NumberFrequency {
  private final int MAX = 100;
  private final int MIN = 1;
  private final int RANGE_SIZE = 10;

  public void readFromTextFile() {
    ArrayList<Integer> ranges = new ArrayList<Integer>();
    for (int i = MIN; i < MAX; i += RANGE_SIZE) {
      ranges.add(i);
    }

    HashMap<Integer, Integer> rangeFrequency = new HashMap<Integer, Integer>();

    ArrayList<Integer> intsFromTextFile = new IntegersInTextFile().readTextFile(false);
    for (int nextInt : intsFromTextFile) {
      if (nextInt < MAX && nextInt > MIN) {
        for (int range : ranges) {
          if (nextInt > range && nextInt < range + RANGE_SIZE) {
            if (rangeFrequency.containsKey(range)) {
              int count = rangeFrequency.get(range);
              rangeFrequency.put(range, count + 1);
            } else {
              rangeFrequency.put(range, 1);
            }
          }
        }
      }
    }

    for (int range : ranges) {
      System.out.print("\n" + range + "\t - " + (range + RANGE_SIZE) + "\t | ");
      if (rangeFrequency.containsKey(range)) {
        for (int frequency = 0; frequency < rangeFrequency.get(range); frequency++) {
          System.out.print("*");
        }
      }
    }
    System.out.println("\n--------------------------------------");
  }
}

// PP 8.8
class CalculateMeanAndStandardDeviation {
  private float calculateMean(int[] ints) {
    if (ints.length == 0) {
      return 0f;
    }
    int sum = 0;
    for (int i : ints) {
      sum += i;
    }
    return sum / (float) ints.length;
  }

  // not sure if this is correct, wikpedia uses different formula
  private float calculateStandardDeviation(int[] ints) {
    if (ints.length == 0) {
      return 0f;
    }
    float sum = 0f;
    float mean = calculateMean(ints);
    for (int i : ints) {
      sum += Math.pow(((float) i - mean), 2);
    }
    System.out.println(sum);
    return (float) Math.sqrt(sum);
  }

  public void calculate() {
    int[] ints = { 10, 2, 5, 7, 9, 8, 4, 7 };
    float mean = calculateMean(ints);
    float standardDeviation = calculateStandardDeviation(ints);
    System.out.println("mean: " + mean + " standardDeviation " + standardDeviation);
  }
}