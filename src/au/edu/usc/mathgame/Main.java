package au.edu.usc.mathgame;

import java.util.*;

/**
 * A simple console-based maths quiz for primary school children.
 *
 * @author Author1
 * @author Author2
 */
public class Main {
    private Random rand = new Random();
    private Scanner input = new Scanner(System.in);
    private List<Question> questions;
    private int currentQuestion;

    public static void main(String[] args) {
        Main game = new Main();
        game.play();
    }

    public Main() {
        newGame();
    }

    /**
     * Creates a new MathGame engine, with 10 questions.
     */
    public void newGame() {
        questions = new ArrayList<>();
        currentQuestion = 0;
        for (int i = 0; i < 10; i++) {
            int a = rand.nextInt(20);
            int b = rand.nextInt(20);
            questions.add(new MathQuestion(a, b));
        }
    }

    // TODO: handle end of game.
    public void nextQuestion() {
        currentQuestion++;
    }

    public Question getQuestion() {
        return questions.get(currentQuestion);
    }

    /**
     * A text UI for one quiz.
     */
    public void play() {
        // now ask some random addition questions.
        for (int i = 0; i < 10; i++) {
            Question q = questions.get(i);
            String question = q.askQuestion();
            int response = getInt(question);
            if (q.checkAnswer(response)) {
                System.out.printf("  Yes!\n");
            } else {
                System.out.printf("  No, the answer is %d.\n", q.correctAnswer());
            }
        }
    }

    /**
     * Reads an integer from input scanner and repeats until valid input.
     *
     * @param question
     * @return
     */
    private int getInt(String question) {
        int response = 0;
        boolean got_input = false;
        while (!got_input){
            try {
                System.out.print(question + " ");
                response = input.nextInt();
                got_input = true;
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a number.");
                input.nextLine();
            }
        }
        return response;
    }

    public List<Question> getAllQuestions() {
        return questions;
    }
}
