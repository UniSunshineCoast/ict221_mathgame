package au.edu.usc.mathgame;

public interface Question {
    /**
     * Check to see if the answer from the user is correct.
     *
     * @param fromUser the number entered by the user.
     * @return true if fromUser is the correct answer.
     */
    boolean checkAnswer(int fromUser);

    /**
     * Returns this question.
     */
    String askQuestion();

    int correctAnswer();
}
