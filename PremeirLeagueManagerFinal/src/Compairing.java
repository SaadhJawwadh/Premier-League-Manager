import java.util.Comparator;

public class Compairing implements Comparator<FootballClub> {

    //Reference: https://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html

    @Override
    public int compare(FootballClub t, FootballClub t1) {

        if (t.getPoints() > t1.getPoints())
            return -1;
        else if (t.getPoints() < t1.getPoints())
            return 1;
        else {
            int goaldifference = t.getGoalsScored() - t.getGoalsReceived();
            int goaldifference1 = t1.getGoalsScored() - t1.getGoalsReceived();
            if (goaldifference > goaldifference1)
                return -1;
            else if (goaldifference < goaldifference1)
                return 1;
            else return 0;
        }
    }
}
