package au.edu.usc.mathgame.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GuiGameWithButtons extends Application {
    private Label message;
    //private TextField answer;
    private Label qn;
    private Label score;
    private FlowPane inner;

    /* Version 2: use a full inner class
    private class UserInputHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            Object src = event.getSource();
            TextField field = (TextField) src;
            int num = Integer.parseInt(field.getText());
            if (num == 5) {
                message.setText("Correct! \u263A");
            } else {
                message.setText("Nope");
            }
        }
    }
    */

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Font font = new Font(48);

        BorderPane root = new BorderPane();
        // root.setSpacing(10.0);

        qn = new Label("What is 2 + 3?");
        inner = new FlowPane();
        inner.setHgap(10.0);
        inner.setVgap(10.0);
        score = new Label("Score=3");
        message = new Label("You are correct. :-)");

        for (int i = 0; i < 6; i++) {
            Button b = new Button("" + i);
            b.setFont(font);
            b.setOnAction(ev -> {
                        int num = Integer.parseInt(b.getText());
                        if (num == 5) {
                            message.setText("Correct! \u263A");
                        } else {
                            message.setText("Nope");
                        }
                    }
            );
            inner.getChildren().add(b);
        }
        qn.setFont(font);
        score.setFont(font);
        message.setFont(font);

        /*
        // Version 3: set up event handler as an anonymous inner class
        answer.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Object src = event.getSource();
                TextField field = (TextField) src;
                int num = Integer.parseInt(field.getText());
                if (num == 5) {
                    message.setText("Correct! \u263A");
                } else {
                    message.setText("Nope");
                }
            }
        });
        */

        /*
        // Version 4: set up event handler as a lambda expression
        answer.setOnAction(event -> {
                int num = Integer.parseInt(answer.getText());
                if (num == 5) {
                    message.setText("Correct! \u263A");
                } else {
                    message.setText("Nope");
                }
            }
        );
        */

        root.setTop(qn);
        root.setCenter(inner);
        root.setRight(score);
        root.setBottom(message);

        primaryStage.setTitle("Math Game");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }
}
