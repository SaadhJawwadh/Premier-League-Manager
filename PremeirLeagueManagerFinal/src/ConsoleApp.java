
import java.io.IOException;
import java.util.Scanner;

import static javafx.application.Application.launch;

public class ConsoleApp {

    static PremierLeagueManager manager = new PremierLeagueManager(21);
    // Creating a static scanner variable to access every where
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        try {
            //Loading Previous Runs
            manager.getClubList();
            manager.getPlayedMatches();
            manager.loadMatch("Match.txt");
            manager.loadData("Saved.txt");

        } catch (Exception e) {
        }

        //menuloop
        menuLoop:
        while (true) {

            displayMenu();
            int choice = 0;

            try {
                choice=Integer.parseInt(input.next());

            }catch (Exception e ){
            }

            switch (choice){
                case 1:
                    addClub();
                    break;
                case 2:
                    deleteClub();
                    break;
                case 3:
                    statics();
                    break;
                case 4:
                    manager.TableDisplay();
                    break;
                case 5:
                    addPlayedMatch();
                    break;
                case 6:
                    launch(GUI.class);
                    break;

                    /*//Reference: http://www.instanceofjava.com/2016/08/how-to-open-webpage-using-java-code.html
                    try {

                        URI uri= new URI("http://localhost:4200");

                        java.awt.Desktop.getDesktop().browse(uri);
                        System.out.println("Web Application opened in browser");

                    } catch (Exception e) {

                        e.printStackTrace();
                    }*/

                case 7:
                    //Auto save and exit
                    manager.saveData("Saved.txt");
                    manager.saveMatch("Match.txt");
                    System.out.println("Thank You for using the System!");
                    break menuLoop;

                default:
                    System.out.println("You Selected an Invalid Option. Please Try Again!");
            }
        }

    }


    //Menu
    public static void displayMenu() {

        System.out.println("\n"+"|--- Welcome to Premiere League Manager By Saadh Jawwadh");
        System.out.println("|--- 1: Add a Club");
        System.out.println("|--- 2: Delete a Club");
        System.out.println("|--- 3: Display Club");
        System.out.println("|--- 4: Display League Statistics");
        System.out.println("|--- 5: Add a Play Match");
        System.out.println("|--- 6: RUN GUI");
        System.out.println("|--- 7: Quit & Save the Application");
        System.out.print("\n"+"Enter your selection: ");
    }


    //add club
    private static void addClub() {

        FootballClub club;
        System.out.print("Enter Club name: ");
        String name = input.next();

        //Reference: https://stackoverflow.com/questions/3732809/how-can-a-string-be-validated-in-java
        //Validation for Club name
        while (!name.matches("[a-zA-Z]+")){
            System.out.println("Invalid input!  Please try again.");
            System.out.print("Enter the Club name: ");
            name=input.next();
        }


        System.out.print("Enter Club Location: ");
        String location = input.next();

        //Validation for Location
        while (!location.matches("[a-zA-Z]+")){
            System.out.println("Invalid input!  Please try again.");
            System.out.print("Enter Club Location: ");
            location=input.next();
        }

        System.out.print("Enter name Of The Manager:  ");
        String clubManager = input.next();

        //Validation for Manager
        while (!clubManager.matches("[a-zA-Z]+")){
            System.out.println("Invalid input!  Please try again.");
            System.out.print("Enter name Of The Manager:  ");
            clubManager=input.next();
        }

        club = new FootballClub(name,location,0,0,0,0,0,0,0,0,clubManager);
        manager.addClub(club);

    }

    //delete
    private static void deleteClub() {
        System.out.print("Enter which club you wants to remove:");
        String club = input.next();
        manager.deleteClub(club);
    }


    //statics
    private static void statics() {
        System.out.print("Enter which club you wants to see statics:");
        String clubName = input.next();
        manager.statics(clubName);
    }

    //Add addPlayedMatch
    private static void addPlayedMatch() {

        System.out.print("Enter Home Team: ");
        String home = input.next();

        //Validation for home team
        while (!home.matches("[a-zA-Z]+")){
            System.out.println("Home Team Name Can not have any numbers! Please try again.");
            System.out.print("Enter Home Team: ");
            home=input.next();
        }


        System.out.print("Enter Away Team: ");
        String away = input.next();

        //Validation for away team
        while (!away.matches("[a-zA-Z]+")){
            System.out.println("Away Team Name Can not have any numbers! Please try again.");
            System.out.print("Enter Away Team: ");
            away=input.next();
        }

        //Reference: https://stackoverflow.com/questions/35936799/validation-so-input-is-only-integer-in-java
        //Validation for home goals
        int homeGoals;
        do {
            System.out.print("Enter Home Goals: ");
            while (!input.hasNextInt()) {
                System.out.println("Home goal should be a number!");
                System.out.print("Enter Home Goals: ");
                input.next();
            }
            homeGoals = input.nextInt();
        } while (homeGoals <= 0);


        //validation for away goals
        int awayGoals;
        do {
            System.out.print("Enter Away Goals: ");
            while (!input.hasNextInt()) {
                System.out.println("Away goal should be a number!");
                System.out.print("Enter Away Goals: ");
                input.next();
            }
            awayGoals = input.nextInt();
        } while (awayGoals <= 0);



        //Reference: https://en.wikipedia.org/wiki/Premier_League#:~:text=Seasons%20run%20from%20August%20to,teams%20both%20home%20and%20away).
        System.out.println("Enter the match Date"); //Seasons run from August to May with each team playing 38 matches.
        System.out.println("This season of Premier league 20/21 is happening between August - May");
        input = new Scanner(System.in);

        //Validating day
        int day;
        do {
            System.out.print("Enter Day: ");
            while (!input.hasNextInt()) {
                System.out.println("That's not a valid day!");
                System.out.print("Enter Day: ");
                input.next();
            }
            day = input.nextInt();
        } while (day > 31 || day < 0);


        //Validating month
        int month;
        do {
            System.out.print("Enter Month(Month should be between August(8/2020) - May(5/2021): ");
            while (!input.hasNextInt()) {
                System.out.println("That's not a valid month!");
                System.out.print("Enter Month(Month should be between August(8/2020) - May(5/2021)): ");
                input.next();
            }
            month = input.nextInt();
        } while (month < 5 || month > 8);


        int year;
        do {
            System.out.print("Enter Year(Year should be 2020/2021): ");
            while (!input.hasNextInt()) {
                System.out.println("Please enter a number!");
                System.out.print("Enter Year(Year should be 2020/2021): ");
                input.next();
            }
            year = input.nextInt();
        } while (year < 2020 || year > 2021);

        String date = (day+"/"+month+"/"+year);
        System.out.println("Date is: " + date);
        manager.addPlayedMatch(home,away,homeGoals,awayGoals,date);
    }

}
