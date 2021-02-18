public class FootballClub extends SportsClub {
    private int wins;
    private int loses;
    private int draws;
    private int seasons;
    private int goalsReceived;
    private int goalsScored;
    private int points;
    private int noOfMatches;
    private String manager;

    //constructors
    public FootballClub(){}

    public FootballClub(String clubName, String clubLocation, int wins, int loses, int draws, int seasons, int goalsReceived, int goalsScored, int points, int noOfMatches, String manager) {
        super(clubName, clubLocation);
        this.wins = wins;
        this.loses = loses;
        this.draws = draws;
        this.seasons = seasons;
        this.goalsReceived = goalsReceived;
        this.goalsScored = goalsScored;
        this.points = points;
        this.noOfMatches = noOfMatches;
        this.manager = manager;
    }

    //getters and setters
    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getSeasons() {
        return seasons;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public int getGoalsScored() {
        return goalsScored;
    }

    public void setGoalsScored(int goalsScored) {
        this.goalsScored = goalsScored;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getNoOfMatches() {
        return noOfMatches;
    }

    public void setNoOfMatches(int noOfMatches) {
        this.noOfMatches = noOfMatches;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public void setGoalsReceived(int goalsReceived) {
        this.goalsReceived = goalsReceived;
    }



    //toString
    @Override
    public String toString() {
        return getClubName();
    }

}
