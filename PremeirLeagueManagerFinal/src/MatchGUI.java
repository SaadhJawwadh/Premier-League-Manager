import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class MatchGUI extends Application {

    private final static PremierLeagueManager manager = new PremierLeagueManager(21);

    public static void main(String []args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        MatchGUI.GUI();

    }

    public static void GUI(){
        Stage stage = new Stage();
        stage.setTitle("Premier League");
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color:white");
        Scene scene = new Scene(pane, 500,600);
        stage.setTitle("PREMIER LEAGUE TABLE");
        stage.setScene(scene);
        stage.show();


        //References: https://docs.oracle.com/javafx/2/ui_controls/table-view.htm
        //Creating a table
        TableView<Playedmatch> tableView = new TableView<Playedmatch>();
        ObservableList<Playedmatch> observableList =FXCollections.observableArrayList(manager.getPlayedMatches());

        TableColumn <Playedmatch, String> home = new TableColumn<>("Home");
        home.setCellValueFactory(new PropertyValueFactory<>("home"));
        TableColumn <Playedmatch, String> homeScore = new TableColumn<>("Home Team Score");
        homeScore.setCellValueFactory(new PropertyValueFactory<>("homeScore"));

        TableColumn <Playedmatch, String> away = new TableColumn<>("Away");
        away.setCellValueFactory(new PropertyValueFactory<>("away"));
        TableColumn <Playedmatch, String> awayScore = new TableColumn<>("Away Team Score");
        awayScore.setCellValueFactory(new PropertyValueFactory<>("awayScore"));

        TableColumn <Playedmatch, String> date = new TableColumn<>("Date");
        date.setCellValueFactory(new PropertyValueFactory<>("date"));

        tableView.getColumns().addAll(home,away,homeScore,awayScore,date);
        tableView.setPrefSize(400,400);
        tableView.setLayoutX(50);
        tableView.setLayoutY(55);


        for (Playedmatch newMatch :observableList ) {
            Playedmatch addRecord = new Playedmatch(
                    newMatch.getHome(),
                    newMatch.getHome(),
                    newMatch.getHomeScore(),
                    newMatch.getAwayScore(),
                    newMatch.getDate());

            tableView.getItems().addAll(addRecord);

        }

        pane.getChildren().addAll(tableView);


        Button back = new Button("Back");
        back.setLayoutY(480);
        back.setLayoutX(400);
        back.setStyle("-fx-font-size: 3mm; " +
                " -fx-font-weight: bold;" +
                "-fx-text-fill:black");
        pane.getChildren().add(back);
        back.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage2=(Stage)back.getScene().getWindow();
                stage2.close();
                GUI.GUI();
            }
        });


        final Label lb = new Label("SEARCH");
        lb.setFont(new Font("Times New Romans", 20));
        lb.setStyle("-fx-text-fill: black; -fx-font-weight: bold;");
        lb.setLayoutX(52);
        lb.setLayoutY(15);

        final TextField filter = new TextField("");//tx= text field
        filter.setFont(new Font("Times New Romans", 15));
        filter.setLayoutX(140);
        filter.setLayoutY(15);
        pane.getChildren().addAll(filter,lb);


        FilteredList<Playedmatch> filteredList = new FilteredList<>(observableList, b -> true);
        SortedList<Playedmatch> sortedList = new SortedList<>(filteredList);

        sortedList.comparatorProperty().bind(tableView.comparatorProperty());
        tableView.setItems(sortedList);

    }
}


