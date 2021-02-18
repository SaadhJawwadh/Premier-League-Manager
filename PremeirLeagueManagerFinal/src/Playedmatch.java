import java.io.Serializable;

public class Playedmatch implements Serializable {

    private FootballClub home;
    private FootballClub away;
    private int homeScore;
    private int awayScore;
    private String Date;


    //constructor
    public Playedmatch(FootballClub home, FootballClub away, int homeScore, int awayScore, String date) {
        this.home = home;
        this.away = away;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        Date = date;
    }

    //getters and setters

    public FootballClub getHome() {
        return home;
    }

    public void setHome(FootballClub home) {
        this.home = home;
    }

    public FootballClub getAway() {
        return away;
    }

    public void setAway(FootballClub away) {
        this.away = away;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }



    //toString

    @Override
    public String toString() {
        return "Playedmatch{" +
                "home=" + home +
                ", away=" + away +
                ", homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                ", Date='" + Date + '\'' +
                '}';
    }
}