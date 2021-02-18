import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GUI extends Application {

    public static void main(String []args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GUI.GUI();
    }

    public static void GUI(){
        Stage stage = new Stage();
        stage.setTitle("Premier League");
        Pane pane = new Pane();
        pane.setStyle("-fx-background-color: black");
        Scene scene = new Scene(pane, 750,500);
        stage.setTitle("PREMIER LEAGUE TABLE BY SAADH JAWWADH");
        stage.setScene(scene);
        stage.show();

        Label lbl =new Label(" PREMIER LEAGUE  ");
        lbl.setLayoutX(220);
        lbl.setLayoutY(65);
        lbl.setStyle("-fx-font-size: 9mm; " +
                "-fx-text-fill: #000000; " +
                "-fx-font-weight: bold;"+
                "-fx-background-color:#09dbff");


        //References: https://docs.oracle.com/javafx/2/ui_controls/button.htm
        //buttons
        Button btn1 = new Button("League Table");
        btn1.setLayoutX(100);
        btn1.setLayoutY(300);

        //Adding CSS Styles
        btn1.setStyle("-fx-font-size: 5mm; " +
                "-fx-font-weight: bold;" +
                "-fx-text-fill: black");

        //match button
        Button btn2 = new Button(" Matches ");
        btn2.setLayoutX(320);
        btn2.setLayoutY(300);
        btn2.setStyle("-fx-font-size: 5mm; " +
                " -fx-font-weight: bold;" +
                "-fx-text-fill:black");


        //Exit button
        Button btn3 = new Button("Exit");
        btn3.setLayoutX(550);
        btn3.setLayoutY(300);
        btn3.setStyle("-fx-font-size: 5mm; " +
                " -fx-font-weight: bold;" +
                "-fx-text-fill: black");


        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage2=(Stage)btn1.getScene().getWindow();
                stage2.close();
                TableGUI.GUI();
            }
        });

        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage2=(Stage)btn2.getScene().getWindow();
                stage2.close();
                MatchGUI.GUI();
            }
        });

        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage2=(Stage)btn3.getScene().getWindow();
                stage2.close();
            }
        });

        pane.getChildren().add(btn1);
        pane.getChildren().add(btn2);
        pane.getChildren().add(btn3);
        pane.getChildren().add(lbl);

    }

}
