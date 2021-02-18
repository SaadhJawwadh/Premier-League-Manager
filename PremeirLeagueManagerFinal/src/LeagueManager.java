import java.io.IOException;
import java.util.ArrayList;

public interface LeagueManager {

    //methods in menu order
    void addClub(FootballClub club) throws IOException;
    void deleteClub(String club) throws IOException;
    void statics(String clubName);
    void saveData(String save) throws IOException;
    void saveMatch(String fileName) throws IOException;
    void loadData(String load) throws IOException;
    void loadMatch(String load) throws IOException;
    void addPlayedMatch (String home, String away, int homeScore, int awayscore, String date) throws IOException;
    void TableDisplay();

    //
    ArrayList<FootballClub> getClubList();
    ArrayList<Playedmatch> getPlayedMatches();

}
