package au.edu.usc.mathgame;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class MathQuestionTest {

    @Test
    public void testAdd() {
        Question q = new MathQuestion(4, 6);

        /*
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));
        q.askQuestion();
        assertEquals("What is 4 + 6?", out.toString());
        assertTrue(q.checkAnswer(10));
        assertFalse(q.checkAnswer(9));
        System.setOut(original);
        */

        assertEquals("What is 4 + 6?", q.askQuestion());
    }
}
