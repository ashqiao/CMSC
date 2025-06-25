import java.util.Scanner;

public class MovieDriver_Task2 
 {
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        String continueInput;

        do 
        {
            Movie movie = new Movie();

            System.out.println("Enter the name of a movie:");
            String title = scanner.nextLine();
            movie.setTitle(title);

            System.out.println("Enter the rating of the movie:");
            String rating = scanner.nextLine();
            movie.setRating(rating);

            int soldTickets = 0;
            boolean validInput = false;
            while (!validInput) 
            {
                System.out.println("Enter the number of tickets sold for this movie:");
                if (scanner.hasNextInt()) 
                {
                    soldTickets = scanner.nextInt();
                    validInput = true;
                } else 
                {
                    System.out.println("❌ Invalid input! Please enter a number.");
                    scanner.nextLine();
                }
            }
            movie.setSoldTickets(soldTickets);

            scanner.nextLine();

            System.out.println(movie.toString());

            System.out.println("Do you want to enter another? (y or n)");
            continueInput = scanner.nextLine();

        } while (continueInput.equalsIgnoreCase("y"));

        scanner.close();
    }
}
