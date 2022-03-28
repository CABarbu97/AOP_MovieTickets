import controller.MovieController;
import database.Configuration;
import service.MovieService;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.createDBs();
        MovieController movieController = new MovieController();
        boolean isActive = true;
        System.out.println("What is your action?");
        while (isActive)
        {
            Scanner scanner = new Scanner(System.in);
            String response = scanner.nextLine();
            switch(response){
                case "c":
                    isActive = false;
                    break;
                case "addMovie":
                    movieController.AddMovie();
                default:
                    break;
            }
        }
    }
}