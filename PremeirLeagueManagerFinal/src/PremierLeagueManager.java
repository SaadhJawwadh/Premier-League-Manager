import java.io.*;
import java.util.*;

public class PremierLeagueManager implements LeagueManager {

    private int noOfClubs;
    //Arraylist to store the details of football club
    private ArrayList<Playedmatch> playedMatches = new ArrayList<>();
    //Arraylist to store the details of added matches
    public ArrayList<FootballClub> clubList = new ArrayList<>();

    public final static int no_Slots= 20;

    //constructors
    public PremierLeagueManager(int noOfClubs) {
        this.noOfClubs = noOfClubs;
    }

    //getters and setters
    public int getNoOfClubs() {
        return noOfClubs;
    }
    public void setNoOfClubs(int noOfClubs) {
        this.noOfClubs = noOfClubs;
    }


    //add
    @Override
    public void addClub(FootballClub club) {

        //Reference: Case Study - Westminster car park

        for (FootballClub footballClub : clubList) {
            if (club.equals(footballClub)) {
                System.out.println(club.getClubName() + " is already added in the league");
                return;
            }
        }
        if (clubList.size() == no_Slots) {
            System.out.println("No free slots are available to add club");
        } else {
            clubList.add(club);
            System.out.println("No of free slots: " + (20 - clubList.size()));
            System.out.println(club.getClubName() + " is successfully added.");
        }
        saveData("Saved.txt");
        saveMatch("Match.txt");
    }

    //delete
    @Override
    public void deleteClub(String name) {
        //Reference: Case Study - Westminster car park
        if (clubList.isEmpty()) {
            System.out.println("No Clubs are added!");
        } else {

            boolean label = false;
            for (FootballClub club : clubList) {

                if (club.getClubName().equals(name)) {
                    label = true;
                    System.out.println(name + " Has been Successfully Deleted");
                    clubList.remove(club);
                    System.out.println("Remaining slots " + (20 - clubList.size()));
                    break;
                }
            }
            if (!label) {
                System.out.println("Invalid Club! Please Try Again!");
            }
        }
        saveData("Saved.txt");
        saveMatch("Match.txt");

    }

    //display
    @Override
    public void statics(String clubName) {

        if(clubList.isEmpty()) {
            System.out.println("No clubs are added at the moment!");
        }
        else {
            boolean found=false;

            for (FootballClub club:clubList){
                if (club.getClubName().equals(clubName)){ //checking for club
                    found=true; //if it exists, the following stats will be shown
                    System.out.println("|---CLUB DETAILS---|");
                    System.out.println("Club Name: "+club.getClubName());
                    System.out.println("Club Manager: "+club.getManager());
                    System.out.println("Played Matches["+club.getNoOfMatches()+"Wins: "+club.getWins()+" Loses: "+club.getLoses()+" Draws:"+club.getDraws()+"]");
                    System.out.println("Total Points    : "+club.getPoints());
                    System.out.println("Goals [Scored: "+club.getGoalsScored()+" Received: "+club.getGoalsReceived()+"]");
                    System.out.println("Goal Deference  : "+(club.getGoalsScored()-club.getGoalsReceived()));
                    System.out.println("----------------------");

                }
            }if(!found){ //if the club didnt exist, the message will be shown
                System.out.println("Please enter an existing club!");
            }
        }
    }


    //table
    @Override
    public void TableDisplay() {

        if (clubList.isEmpty()){
            System.out.println("No clubs are registered still to display the table");
        }else {
            System.out.printf("%15s  %4s  %5s  %5s  %5s  %5s  %5s  %5s  %5s  \n", "|Club Name|", "|M|", "|W|", "|L|", "|D|", "|P|", "|GS|", "|GR|", "|GD|");

            Collections.sort(clubList, new Compairing());//sorting
            for (FootballClub club : clubList) {
                System.out.printf("%13s  %5s  %5s  %5s  %5s  %5s  %5s  %5s  %5s  \n",
                        club.getClubName(), club.getNoOfMatches(), club.getWins(), club.getLoses(), club.getDraws(),
                        (club.getPoints()), club.getGoalsScored(), club.getGoalsReceived(), (club.getGoalsScored() - club.getGoalsReceived()));
            }
            System.out.println("M - Matches Played, W - Wins , L - Loses, D - Draws, P - Points, GS - Goals Scored, GR - Goals Received, GD - Goal Difference");
        }
    }

    //addPlayedMatch
    @Override
    public void addPlayedMatch (String home, String away, int homeScore, int awayscore,String date) {


        if (clubList.isEmpty()) { //Checking list is empty
            System.out.println("No sports clubs are added");
        } else {
            FootballClub homeClub = null;

            for (FootballClub club : clubList) {
                if (club.getClubName().equals(home)) {
                    homeClub = club;
                }
            }

            if (homeClub == null) {
                System.out.printf("%s is not available in the premier league", home);
                System.out.println(" ");
                return;
            }

            FootballClub awayClub = null;

            for (FootballClub club : clubList) {
                if (club.getClubName().equals(away)) {
                    awayClub = club;
                }
            }

            if (awayClub == null) {
                System.out.printf("%s is not available in the premier league", away);
                System.out.println(" ");
                return;
            }

            if (homeScore <= -1) {
                System.out.println("You have to enter number of goals(number of goals always positive)");
                return;
            }

            if (awayscore <= -1) {
                System.out.println("You have to enter number of goals(number of goals always positive)");
                return;
            }


            Playedmatch newMatch = new Playedmatch(homeClub,awayClub,homeScore,awayscore,date);
            newMatch.setHome(homeClub);
            newMatch.setAway(awayClub);
            newMatch.setHomeScore(homeScore);
            newMatch.setAwayScore(awayscore);
            playedMatches.add(newMatch);
            System.out.println("Match added");

            homeClub.setGoalsScored(homeClub.getGoalsScored() + homeScore);
            awayClub.setGoalsScored(awayClub.getGoalsScored() + awayscore);
            homeClub.setGoalsReceived(homeClub.getGoalsReceived() + awayscore);
            awayClub.setGoalsReceived(awayClub.getGoalsReceived() + homeScore);
            homeClub.setNoOfMatches(homeClub.getNoOfMatches() + 1);
            awayClub.setNoOfMatches(awayClub.getNoOfMatches() + 1);


            if (homeScore > awayscore) {
                homeClub.setPoints(homeClub.getPoints() + 3);
                homeClub.setWins(homeClub.getWins() + 1);
                awayClub.setLoses(awayClub.getLoses() + 1);
            }

            else if (homeScore < awayscore) {
                awayClub.setPoints(awayClub.getPoints() + 3);
                awayClub.setWins(awayClub.getWins() + 1);
                homeClub.setLoses(homeClub.getLoses() + 1);
            }

            else {
                homeClub.setPoints(homeClub.getPoints() + 1);
                awayClub.setPoints(awayClub.getPoints() + 1);
                homeClub.setDraws(homeClub.getDraws() + 1);
                awayClub.setDraws(awayClub.getDraws() + 1);
            }
            saveData("Saved.txt");
            saveMatch("Match.txt");
        }
    }

    //Saving and loading

    public ArrayList<FootballClub> getClubList() {
        File saveData = new File("Saved.txt");

        try {
            FileInputStream fis = new FileInputStream(saveData);
            ObjectInputStream ois = new ObjectInputStream(fis);
            //Reference:https://stackoverflow.com/questions/52791259/java-how-to-make-objectinputstream-read-all-objects-from-file
            clubList=(ArrayList<FootballClub>)ois.readObject();
            ois.close();
            return clubList;

        } catch (Exception e) {
            return clubList;
        }

    }

    public ArrayList<Playedmatch> getPlayedMatches() {
        File saveMatch = new File("Match.txt");

        try {
            FileInputStream fis = new FileInputStream(saveMatch);
            ObjectInputStream ois = new ObjectInputStream(fis);

            playedMatches=(ArrayList<Playedmatch>)ois.readObject();
            ois.close();
            return playedMatches;

        } catch (Exception e) {
            return playedMatches;
        }
    }

    //Saving and loading
    public void saveData(String save) {

        //Reference: Case Study - Westminster car park
        try {
            FileOutputStream fis = new FileOutputStream(save);
            ObjectOutputStream ois = new ObjectOutputStream(fis);
            ois.writeObject(clubList);
            ois.flush();
            fis.close();
            ois.close();
            System.out.println("File has been Saved");

        }catch (IOException e){
            System.out.println("error");
        }

    }

    public void saveMatch(String save){

        try {
            FileOutputStream fis = new FileOutputStream(save);
            ObjectOutputStream ois = new ObjectOutputStream(fis);
            ois.writeObject(playedMatches);
            ois.flush();
            fis.close();
            ois.close();
            System.out.println("File has been Saved");

        }catch (IOException e){
            System.out.println("!!!!");
        }

    }

    public void loadData(String load) throws IOException {

        //Reference: Case Study - Westminster car park
        FileInputStream fis = new FileInputStream(load);
        ObjectInputStream ois = new ObjectInputStream(fis);

        for(;;) {
            try {
                FootballClub club = (FootballClub) ois.readObject();
                clubList.add(club);
                fis.close();
                ois.close();
                System.out.println("LoadedData!");

            } catch (EOFException | ClassNotFoundException e) {
                System.out.println("!!!!!");
                break;
            }
        }


    }
    public void loadMatch(String load) throws IOException {

        FileInputStream fis = new FileInputStream(load);
        ObjectInputStream ois = new ObjectInputStream(fis);

        for(;;) {
            try {
                Playedmatch match = (Playedmatch) ois.readObject();
                playedMatches.add(match);
                fis.close();
                ois.close();
                System.out.println("Match loaded");
            }
            catch (EOFException | ClassNotFoundException e) {
                System.out.println("!!!!");
                break;
            }
        }

    }
}