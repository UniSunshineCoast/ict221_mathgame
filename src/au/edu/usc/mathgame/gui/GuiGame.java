package au.edu.usc.mathgame.gui;

import au.edu.usc.mathgame.Main;
import au.edu.usc.mathgame.Question;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GuiGame extends Application {
    private Label qn;
    private Button nextButton;
    private TextField answer;
    private TextArea score; // right hand side
    private Label message; // bottom
    private Main engine = new Main();

    /* Version 1 event handler: use a separate class! */


    /* Version 2 event handler: use a full inner class
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

        qn = new Label("Welcome to Math Game.  Press Start");
        nextButton = new Button("Next");
        answer = new TextField("???");
        score = new TextArea("");
        message = new Label("");

        qn.setFont(font);
        nextButton.setFont(font);
        answer.setFont(font);
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

        // Version 4: set up event handler as a lambda expression
        answer.setOnAction(event -> handleAnswer());
        nextButton.setOnAction(ev -> handleNext());


        root.setTop(qn);
        root.setLeft(nextButton);
        root.setCenter(answer);
        root.setRight(score);
        root.setBottom(message);

        primaryStage.setTitle("Math Game");
        Scene scene = new Scene(root, 600, 400);
        // TODO: add CSS style sheet
        // StyleManager.getInstance().addUserAgentStylesheet(getClass().getResource("/style.css").toString());
        //primaryStage.
        primaryStage.setScene(scene);
        primaryStage.show();
        refresh(); // to show the first question etc.
    }

    private void handleNext() {
        engine.nextQuestion();
        refresh();
    }

    private void refresh() {
        qn.setText(engine.getQuestion().askQuestion());
        this.answer.setText("");
        // show all questions
        String allQns = "";
        for (Question q: engine.getAllQuestions()) {
            allQns += q.askQuestion() + "\n";
        }
        score.setText(allQns);
    }

    private void handleAnswer() {
        int num = Integer.parseInt(answer.getText());
        Question q = engine.getQuestion();
        if (q.checkAnswer(num)) {
            message.setText("Correct! \u263A");
        } else {
            message.setText("Nope");
        }
    }
}
