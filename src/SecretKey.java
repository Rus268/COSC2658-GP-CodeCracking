class SecretKeyGuesser {
    private String initSecretKey = "RRRRRRRRRMITRMIT";
    
    public void start() {
        SecretKey secret = new SecretKey(initSecretKey);
        String allRString = "R".repeat(16);
        String allMString = "M".repeat(16);
        String allIString = "I".repeat(16);
        String allTString = "T".repeat(16);
        String correctGuess = allRString;

        // Total number of R
        int rAccuracy = secret.guess(allRString);
        if (rAccuracy == 16) {
            System.out.println("Secret key: " + allRString);
            return;
        }
        // Total number of M
        int mAccuracy = secret.guess(allMString);
        if (mAccuracy == 16) {
            System.out.println("Secret key: " + allMString);
            return;
        }
        // Total number of I
        int iAccuracy = secret.guess(allIString);
        if (iAccuracy == 16) {
            System.out.println("Secret key: " + allIString);
            return;
        }
        // Total number of T
        int tAccuracy = 16 - rAccuracy - mAccuracy - iAccuracy;
        if (tAccuracy == 16) {
            System.out.println("Secret key: " + allTString);
            return;
        }

        int mostAccuracy = rAccuracy;

        if (mAccuracy > mostAccuracy) {
            mostAccuracy = mAccuracy;
            correctGuess = allMString;
        }
        if (iAccuracy > mostAccuracy) {
            mostAccuracy = iAccuracy;
            correctGuess = allIString;
        }
        if (tAccuracy > mostAccuracy) {
            mostAccuracy = tAccuracy;
            correctGuess = allTString;
        }
        return;
    }
}
public class SecretKey {
    private String correctKey;
    private int counter;

    public SecretKey(String inputCorrectKey) {
        // for the real test, your program will not know this
        correctKey = inputCorrectKey;
        counter = 0;
    }

    public int guess(String guessedKey) {
        if (counter >= 16) {
            System.out.println("Number of guesses: " + counter);
            return -1;
        }
        counter++;
        // validation
        if (guessedKey.length() != correctKey.length()) {
            return -1;
        }
        int matched = 0;
        for (int i = 0; i < guessedKey.length(); i++) {
            char c = guessedKey.charAt(i);
            if (c != 'R' && c != 'M' && c != 'I' && c != 'T') {
                return -1;
            }
            if (c == correctKey.charAt(i)) {
                matched++;
            }
        }
        if (matched == correctKey.length()) {
            System.out.println("Number of guesses: " + counter);
        }
        return matched;
    }

    public static void main(String[] args) {
        new SecretKeyGuesser().start();
    }
}