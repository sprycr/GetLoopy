import java.sql.SQLOutput;
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
          System.out.println();
          System.out.println("Press enter to begin. You roll until you get a triple.");
          // message = "Rolling...";
          System.out.printf("%-5s%-5s%-5s%-5s%-5s", "Roll", "Die1", "Die2", "Die3", "Sum");
        } else {
          System.out.print(" ||  Roll again? [Y/n]");
          // message = "Rolling again...";
          // message = "";
        }
        if (in.hasNextLine()) {
          replay = in.nextLine();

          if (replay.equalsIgnoreCase("") || replay.equalsIgnoreCase("Y")) {
            valid = true;
            // System.out.print(message);

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
      if (!done) {
        int die1 = rand.nextInt(1, 7);
        int die2 = rand.nextInt(1, 7);
        int die3 = rand.nextInt(1, 7);
        if (iteration == 1) {
          System.out.println("-------------------------");
        }
        System.out.printf("%-5d%-5d%-5d%-5d%-5d", iteration, die1, die2, die3, (die1 + die2 + die3));
        if (die1 == die2 && die2 == die3) {// if triple
          done = true;
          System.out.print(" ||  You rolled a triple " + die1 + " in " + iteration + " rolls!\n");
          System.out.println("Thank you for playing!");
        }
      }
      iteration += 1;
    } while (!done);
  }
}
