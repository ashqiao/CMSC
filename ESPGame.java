/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Reads a list of colors from a file, displays a 
 * determined set to the user, then runs three rounds where 
 * the program picks a random color and the user tries to guess 
 * it. Finally, writes the game's results to EspGameResults.txt.
 * Due: 06/17/2025
 * Platform/compiler: Eclipse IDE 2023-06 (Java 17), JavaFX 23
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or 
 * any source. I have not given my code to any student.
 * Print your Name here: Ashley Qiao
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class ESPGame 
{
    public static void main(String[] args) 
    {
        final int FULL = 16;
        final int TEN = 10;
        final int FIVE = 5;
        final int ROUNDS = 3;
        final String COLORS_FILE = "colors.txt";
        final String OUTPUT_FILE = "EspGameResults.txt";

        Scanner input = new Scanner(System.in);
        Random random = new Random();
        boolean play = true;
        int lastCorrect = 0;

        while (play) 
        {
        	// shows initial menu
            System.out.println("\nCMSC203 Assignment1: Test your ESP skills!");
            System.out.println("\n1- Display first 16 colors");
            System.out.println("2- Display first 10 colors");
            System.out.println("3- Display first 5 colors");
            System.out.println("4- Exit the program");
            System.out.print("Enter option: ");
            int option = input.nextInt();
            input.nextLine();

            int limit;
            if (option == 1)       limit = FULL;
            else if (option == 2)  limit = TEN;
            else if (option == 3)  limit = FIVE;
            else if (option == 4)  break;
            else 
            {
                System.out.println("Invalid choice, please enter 1-4.");
                continue;
            }

            System.out.println("\nHere are the colors:");
            try 
            {
                Scanner fileIn = new Scanner(new File(COLORS_FILE));
                for (int i = 1; i <= limit; i++) 
                {
                    if (!fileIn.hasNextLine()) break;
                    System.out.println(i + " " + fileIn.nextLine());
                }
                fileIn.close();
            } 
            catch (FileNotFoundException e) 
            {
                System.out.println("Error: colors.txt not found.");
                continue;
            }

            int correct = 0;
            for (int round = 1; round <= ROUNDS; round++) {
                System.out.print("\nGuess (round " + round + "): ");
                String guess = input.nextLine().trim();

                int pick = random.nextInt(FULL) + 1;
                String answer = "";
                try 
                {
                    Scanner fileIn2 = new Scanner(new File(COLORS_FILE));
                    for (int i = 1; i <= pick; i++) 
                    {
                        if (!fileIn2.hasNextLine()) break;
                        answer = fileIn2.nextLine();
                    }
                    fileIn2.close();
                } 
                catch (FileNotFoundException e) 
                {

                }

                System.out.println("I was thinking of: " + answer);
                if (guess.equalsIgnoreCase(answer)) 
                {
                    System.out.println("Correct!");
                    correct++;
                } 
                else 
                {
                    System.out.println("Wrong!");
                }
            }

            System.out.println("\nYou guessed " + correct + " out of " + ROUNDS + " correctly.");
            lastCorrect = correct;

            // asks whether to play again
            System.out.print("Play again? (Yes/No): ");
            String reply = input.nextLine();
            if (!reply.equalsIgnoreCase("Yes")) 
            {
                play = false;
            }
        }
        System.out.print("\nEnter your name: ");
        String name = input.nextLine();
        System.out.print("Describe yourself: ");
        String desc = input.nextLine();
        System.out.print("Due Date (MM/DD/YY): ");
        String due = input.nextLine();

        String summary =
            "Game Over\n" +
            "You guessed " + lastCorrect + " out of " + ROUNDS + " correctly.\n" +
            "Due Date: " + due + "\n" +
            "Username: " + name + "\n" +
            "User Description: " + desc + "\n" +
            "Date: " + due + "\n";

        // prints and sves
        System.out.println("\n" + summary);
        try 
        {
            PrintWriter out = new PrintWriter(OUTPUT_FILE);
            out.print(summary);
            out.close();
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Error: could not write results file.");
        }

        input.close();
    }
}
