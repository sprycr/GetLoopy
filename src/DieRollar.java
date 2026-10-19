import java.util.Random;
import java.util.Scanner;

public class DieRollar {
  public static void main(String[] args) {
    Random rand = new Random();
    Scanner in = new Scanner(System.in);
    boolean done = false;
    int iteration = 1;
    boolean valid = false;
    String message;
    String replay;

    do {
      do {// get input
        if (iteration == 1) {
          System.out.println("Press enter to begin. You roll until you get a triple.");
          message = "Rolling...";
        } else {
          System.out.println("Roll again? [Y/n]");
          message = "Rolling again...";
        }
        if (in.hasNextLine()) {
          replay = in.nextLine();

          if (replay.equalsIgnoreCase("") || replay.equalsIgnoreCase("Y")) {
            valid = true;
            System.out.println(message);

          } else if (replay.equalsIgnoreCase("N")) {
            valid = true;
            done = true;
            System.out.println("Thank you for playing!");
          } else {
            System.out.println("Please input a valid response. You entered: " + replay);
          }
        }
      } while (!valid);
      // rolling logic
      int die1 = rand.nextInt(1, 7);
      int die2 = rand.nextInt(1, 7);
      int die3 = rand.nextInt(1, 7);
      if (die1 == die2 && die2 == die3) {// if triple
        System.out.printf("");
      }

      iteration += 1;
    } while (!done);
  }
}
