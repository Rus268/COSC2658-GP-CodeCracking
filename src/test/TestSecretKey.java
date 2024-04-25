package test;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestSecretKey {
    @Test
    void testGuess() {
        SecretKey secretKey = new SecretKey();

        // Test with a correct guess
        int result = secretKey.guess("RRRRRRRRRMITRMIT");
        assertEquals(16, result, "Correct guess should return 16");

        // Test with an incorrect guess
        result = secretKey.guess("RRRRRRRRRMITRMI");
        assertEquals(-1, result, "Incorrect guess should return -1");

        // Test with a partially correct guess
        result = secretKey.guess("RRRRRRRRRMITRMIX");
        assertEquals(-1, result, "Partially correct guess should return -1");

        // Test with a guess of the wrong length
        result = secretKey.guess("RRRRRRRRRMITRMITRMIT");
        assertEquals(-1, result, "Guess of wrong length should return -1");
    }
}
