import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class TableGUI extends Application {

    private final static PremierLeagueManager manager = new PremierLeagueManager(21);

    public static void main(String []args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        TableGUI.GUI();

    }

    public static void GUI(){
        Stage stage = new Stage();
        stage.setTitle("Premier League");
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color:white ");
        Scene scene = new Scene(pane, 540,550);
        stage.setTitle("PREMIER LEAGUE TABLE");
        stage.setScene(scene);
        stage.show();


        //Creating a table
        TableView<FootballClub> tableView = new TableView<FootballClub>();
        ObservableList<FootballClub> observableList =FXCollections.observableArrayList(manager.getClubList());

        //creating column for names
        TableColumn <FootballClub, String> clubName = new TableColumn<>("Club\nName");
        clubName.setCellValueFactory(new PropertyValueFactory<>("clubName"));

        //creating column for points
        TableColumn <FootballClub, Integer>points = new TableColumn<>("Points");
        points.setCellValueFactory(new PropertyValueFactory<>("points"));

        //creating column for matchesPlayed
        TableColumn<FootballClub, Integer> NoOfMatches = new TableColumn<>("Matches\nPlayed");
        NoOfMatches.setCellValueFactory(new PropertyValueFactory<>("NoOfMatches"));

        //creating column for wins
        TableColumn<FootballClub, Integer> wins = new TableColumn<>("Won");
        wins.setCellValueFactory(new PropertyValueFactory<>("wins"));

        //creating column for loses
        TableColumn<FootballClub, Integer> loses = new TableColumn<>("Loss");
        loses.setCellValueFactory(new PropertyValueFactory<>("loses"));

        //creating column for draws
        TableColumn<FootballClub, Integer> draws = new TableColumn<>("Draw");
        draws.setCellValueFactory(new PropertyValueFactory<>("draws"));

        //creating column for goalScored
        TableColumn<FootballClub, Integer> goalsScored = new TableColumn<>("Goal\nScored");
        goalsScored.setCellValueFactory(new PropertyValueFactory<>("goalsScored"));

        //creating column for goalReceived
        TableColumn<FootballClub, Integer> goalsReceived = new TableColumn<>("Goal\nReceived");
        goalsReceived.setCellValueFactory(new PropertyValueFactory<>("goalsReceived"));

        //getting all the columns to the table
        tableView.getColumns().addAll(clubName,points,NoOfMatches,wins,loses,draws,goalsScored,goalsReceived);

        //setting the place of the table
        tableView.setPrefSize(435,400);
        tableView.setLayoutX(50);
        tableView.setLayoutY(25);


        for (FootballClub club :observableList ) {
            FootballClub addRecord = new FootballClub(
                    club.getClubName(),
                    club.getClubLocation(),
                    club.getWins(),
                    club.getLoses(),
                    club.getDraws(),
                    club.getSeasons(),
                    club.getGoalsScored(),
                    club.getGoalsReceived(),
                    club.getNoOfMatches(),
                    club.getPoints(),
                    club.getManager());
            tableView.getItems().addAll(addRecord);

        }

        //adding the table to pane
        pane.getChildren().addAll(tableView);


        //Creating button to sorting the points in the table
        Button MyPointsButton = new Button("Points Sort");
        //setting the place for the button
        MyPointsButton.setLayoutY(450);
        MyPointsButton.setLayoutX(55);
        //adding a colour to the button
        MyPointsButton.setStyle("-fx-font-size: 3mm; " +
                " -fx-font-weight: bold;" +
                "-fx-text-fill:black");
        //adding the button to the pane
        pane.getChildren().addAll(MyPointsButton);
        //sorting method and action for the points button
        MyPointsButton.setOnAction(event -> {
            points.setSortType(TableColumn.SortType.DESCENDING);
            tableView.getSortOrder().setAll(points);
        });


        //Creating button to sorting with Goals scored in the table
        Button GoalSButton = new Button("Sort Goal_Scored");
        //setting the place of the button
        GoalSButton.setLayoutY(450);
        GoalSButton.setLayoutX(175);
        //adding a colour to the button
        GoalSButton.setStyle("-fx-font-size: 3mm; " +
                " -fx-font-weight: bold;" +
                "-fx-text-fill:black");
        //adding the button to pane
        pane.getChildren().addAll(GoalSButton);
        //sorting method and action for the Goals scored button
        GoalSButton.setOnAction(event -> {
            goalsScored.setSortType(TableColumn.SortType.DESCENDING);
            tableView.getSortOrder().setAll(goalsScored);
        });


        //Creating button to sorting with Goals scored in the table
        Button drawButton = new Button("Sort Wins");
        drawButton.setLayoutY(450);
        drawButton.setLayoutX(325);
        drawButton.setStyle("-fx-font-size: 3mm; " +
                " -fx-font-weight: bold;" +
                "-fx-text-fill:black");
        pane.getChildren().addAll(drawButton);
        drawButton.setOnAction(event -> {
            wins.setSortType(TableColumn.SortType.DESCENDING);
            tableView.getSortOrder().setAll(wins);
        });


        Button back = new Button("Back");
        back.setLayoutY(450);
        back.setLayoutX(425);
        back.setStyle("-fx-font-size: 3mm; " +
                " -fx-font-weight: bold;" +
                "-fx-text-fill:black");
        pane.getChildren().addAll(back);
        back.setOnAction(event -> {
            Stage stage2=(Stage)back.getScene().getWindow();
            stage2.close();
            GUI.GUI();
        });

    }
}


