package au.edu.usc.mathgame;

public class MathQuestion implements Question {
    private int val1;
    private int val2;

    public MathQuestion(int a, int b) {
        val1 = a;
        val2 = b;
    }

    @Override
    public boolean checkAnswer(int fromUser) {
        return fromUser == val1 + val2;
    }

    @Override
    public String askQuestion() {
        return String.format("What is %d + %d?", val1, val2);
    }

    @Override
    public int correctAnswer() {
        return val1 + val2;
    }
}
